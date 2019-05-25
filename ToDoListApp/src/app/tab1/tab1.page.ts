import { Component, OnInit, OnDestroy } from '@angular/core';
import { LoadingService } from '../shared/services/loading-service';
import { GlobalService } from '../global.service';
import { UsuarioModel } from '../models/usuario.model';
import { Subscription } from 'rxjs';
import { ToastService } from '../shared/services/toast.service';
import { AlertController, ModalController, Events } from '@ionic/angular';
import { EditarUsuarioModalComponent } from '../shared/components/editar-usuario-modal/editar-usuario-modal.component';
import { VerUsuarioComponent } from '../shared/components/ver-usuario/ver-usuario.component';

@Component({
  selector: 'app-tab1',
  templateUrl: 'tab1.page.html',
  styleUrls: ['tab1.page.scss']
})
export class Tab1Page implements OnInit, OnDestroy {

  subscriptionService: Subscription;
  users: UsuarioModel[] = [];

  constructor(private loadService: LoadingService, private toastService: ToastService,
    private globalService: GlobalService, private alertCtrl: AlertController,
    private modalCtrl: ModalController, private event: Events) {
    this.loadService.loadingShow();

    this.event.subscribe('actualizarUsuario', (user) => {
      this.update(user.userEditar);
    });

    this.event.subscribe('eliminarUsuario', (user) => {
      this.presentAlertConfirm(user.userEliminar);
    });
  }

  ngOnInit() {
  }

  ionViewDidEnter() {
    setTimeout(() => {
      this.obtenerListaUsuarios();
    }, 1000);
  }

  async obtenerListaUsuarios() {
    this.modalCtrl.dismiss();
    this.subscriptionService = await this.globalService.getUserList()
      .subscribe(dataUser => {
        this.users = dataUser;
        this.loadService.loadingHide();
      }, error => {
        this.loadService.loadingHide();
        this.toastService.toastErrorShowWithMessage('Fallo el cargue de los usuarios');
      });
  }

  ngOnDestroy(): void {
    this.subscriptionService.unsubscribe();
  }

  async delete(user: UsuarioModel) {
    this.modalCtrl.dismiss();
    this.loadService.loadingShow();
    await this.globalService.deleteUser(user.usuarioPK)
      .subscribe(() => {
        this.loadService.loadingHide();
        this.toastService.toastSuccessShowWithMessage('Se eliminó al usuario: ' + user.primerNombre);
        this.obtenerListaUsuarios();
      }, error => {
        this.loadService.loadingHide();
        this.toastService.toastErrorShowWithMessage('No se pudó eliminar al usuario: ' + user.primerNombre);
      });
  }

  async update(user: UsuarioModel) {
    const modal = await this.modalCtrl.create({
      component: EditarUsuarioModalComponent,
      componentProps: {
        usuario: user
      }
    });

    modal.onDidDismiss().then(() => {
      this.obtenerListaUsuarios();
    });

    return await modal.present();
  }

  async presentAlertConfirm(user: UsuarioModel) {
    const alert = await this.alertCtrl.create({
      header: 'Eliminar usuario',
      message: 'Está seguro de eliminar este usuario?',
      buttons: [
        {
          text: 'No',
          role: 'cancel',
          cssClass: 'secondary',
        }, {
          text: 'Si',
          handler: () => {
            this.delete(user);
          }
        }
      ]
    });

    await alert.present();
  }

  async verDetalleUsario(user: UsuarioModel) {
    const modal = await this.modalCtrl.create({
      component: VerUsuarioComponent,
      componentProps: {
        usuario: user
      }
    });

    return await modal.present();
  }
}
