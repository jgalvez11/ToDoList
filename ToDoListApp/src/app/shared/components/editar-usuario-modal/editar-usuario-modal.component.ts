import { Component, OnInit } from '@angular/core';
import { ModalController, NavParams } from '@ionic/angular';
import { UsuarioModel } from '../../../models/usuario.model';

@Component({
  selector: 'app-editar-usuario-modal',
  templateUrl: './editar-usuario-modal.component.html',
  styleUrls: ['./editar-usuario-modal.component.scss'],
})
export class EditarUsuarioModalComponent implements OnInit {

  usuario: UsuarioModel;

  constructor(private modalCtrl: ModalController, private navParams: NavParams) {
    this.usuario = navParams.get('usuario');
  }

  ngOnInit() { }

  cerrarModal() {
    this.modalCtrl.dismiss();
  }

}
