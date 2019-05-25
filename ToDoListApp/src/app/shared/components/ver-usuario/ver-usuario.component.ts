import { Component, OnInit } from '@angular/core';
import { NavParams, ModalController, Events } from '@ionic/angular';
import { UsuarioModel } from 'src/app/models/usuario.model';

@Component({
  selector: 'app-ver-usuario',
  templateUrl: './ver-usuario.component.html',
  styleUrls: ['./ver-usuario.component.scss'],
})
export class VerUsuarioComponent implements OnInit {

  usuario: UsuarioModel;

  constructor(private navParams: NavParams, private modalCtrl: ModalController, private event: Events) {
    this.usuario = navParams.get('usuario');
  }

  ngOnInit() { }

  cerrarModal() {
    this.modalCtrl.dismiss();
  }

  editar() {
    this.event.publish('actualizarUsuario', { userEditar: this.usuario });
  }

  eliminar() {
    this.event.publish('eliminarUsuario', { userEliminar: this.usuario });
  }


}
