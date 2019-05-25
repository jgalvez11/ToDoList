import { Component, OnInit, Input, OnChanges } from '@angular/core';
import { UsuarioModel } from '../../../models/usuario.model';
import { LoadingService } from '../../services/loading-service';
import { UsuarioPKModel } from 'src/app/models/usuarioPK.model';
import { GlobalService } from 'src/app/global.service';
import { ToastService } from '../../services/toast.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { DatePipe } from '@angular/common';
import { ModalController } from '@ionic/angular';

@Component({
  selector: 'app-formulario-nuevo-usuario',
  templateUrl: './formulario-nuevo-usuario.component.html',
  styleUrls: ['./formulario-nuevo-usuario.component.scss']
})
export class FormularioNuevoUsuarioComponent implements OnInit, OnChanges {

  @Input() usuario: UsuarioModel;
  formUsuario: FormGroup;
  metodoREST: boolean;

  tipoId: any[] = [
    { id: 'CC', valor: 'Cédula de ciudadanía' },
    { id: 'CE', valor: 'Cédula de extranjería' },
    { id: 'PAS', valor: 'Pasaporte' },
    { id: 'CC', valor: 'Cédula de ciudadanía' },
    { id: 'OTRO', valor: 'Otro' }
  ];

  genero: any[] = [
    { id: 'F', valor: 'Feménino' },
    { id: 'M', valor: 'Mascúlino' },
    { id: 'O', valor: 'Otro' }
  ];

  estadoCivil: any[] = [
    { id: 'CAS', valor: 'Casado' },
    { id: 'SOL', valor: 'Soltero' },
    { id: 'UNI', valor: 'Unión libre' },
    { id: 'VIU', valor: 'Viudo' },
    { id: 'OTRO', valor: 'Otro' },
  ];

  constructor(private loadService: LoadingService, private globalService: GlobalService,
    private toastService: ToastService, private formBuilder: FormBuilder,
    private datePipe: DatePipe, private modalCtrl: ModalController) {
    this.buildForm();
  }

  buildForm() {
    this.formUsuario = this.formBuilder.group({
      tipoId: ['', Validators.required],
      numeroId: ['', Validators.required],
      primerNombre: ['', Validators.required],
      segundoNombre: ['', Validators.required],
      primerApellido: ['', Validators.required],
      segundoApellido: ['', Validators.required],
      genero: ['', Validators.required],
      ciudad: ['', Validators.required],
      estadoCivil: ['', Validators.required],
      telefonoCelular: ['', Validators.required],
      fechaNacimiento: ['', Validators.required],
    });
  }

  ngOnInit() {
    if (this.usuario) {
      this.setearDatosusuario();
    }
  }

  submitForm() {
    this.loadService.loadingShowWithMessage('Registrando usuario');
    const user = new UsuarioModel();
    const userPK = new UsuarioPKModel();
    userPK.tipoDocumento = this.formUsuario.controls.tipoId.value;
    userPK.numeroDocumento = this.formUsuario.controls.numeroId.value;
    user.usuarioPK = userPK;
    user.primerNombre = this.formUsuario.controls.primerNombre.value;
    user.segundoNombre = this.formUsuario.controls.segundoNombre.value;
    user.primerApellido = this.formUsuario.controls.primerApellido.value;
    user.segundoApellido = this.formUsuario.controls.segundoApellido.value;
    user.genero = this.formUsuario.controls.genero.value;
    user.ciudadResidencia = this.formUsuario.controls.ciudad.value;
    user.estadoCivil = this.formUsuario.controls.estadoCivil.value;
    user.telefonoCelular = this.formUsuario.controls.telefonoCelular.value;
    user.fechaNacimiento = this.convertirFecha(this.formUsuario.controls.fechaNacimiento.value);
    setTimeout(() => {
      if (this.metodoREST) {
        this.actualizarUsuario(user);
      } else {
        this.agregarUsuario(user);
      }
    }, 1000);
  }

  async agregarUsuario(user: UsuarioModel) {
    await this.globalService.createUser(user)
      .subscribe(() => {
        this.loadService.loadingHide();
        this.toastService.toastSuccessShowWithMessage('Usuario creado');
      }, error => {
        this.loadService.loadingHide();
        this.toastService.toastErrorShowWithMessage('No se ha podido crear el usuario, por favor intente de nuevo');
      });
  }

  async actualizarUsuario(user: UsuarioModel) {
    await this.globalService.updateUser(user)
      .subscribe(() => {
        this.loadService.loadingHide();
        this.toastService.toastSuccessShowWithMessage('Usuario actualizado');
        this.modalCtrl.dismiss();
      }, error => {
        this.loadService.loadingHide();
        this.toastService.toastErrorShowWithMessage('No se ha podido actualizar el usuario, por favor intente de nuevo');
      });
  }

  convertirFecha(fecha: string): Date {
    const fechaN = new Date(fecha);
    return fechaN;
  }

  convertirFechaCalendario(fecha: Date): string {
    const fechaC = this.datePipe.transform(fecha, 'yyyy-MM-dd');
    return fechaC;
  }

  setearDatosusuario() {
    this.metodoREST = true;
    this.formUsuario.controls.tipoId.setValue(this.usuario.usuarioPK.tipoDocumento);
    this.formUsuario.controls.numeroId.setValue(this.usuario.usuarioPK.numeroDocumento);
    this.formUsuario.controls.primerNombre.setValue(this.usuario.primerNombre);
    this.formUsuario.controls.segundoNombre.setValue(this.usuario.segundoNombre);
    this.formUsuario.controls.primerApellido.setValue(this.usuario.primerApellido);
    this.formUsuario.controls.segundoApellido.setValue(this.usuario.segundoApellido);
    this.formUsuario.controls.genero.setValue(this.usuario.genero);
    this.formUsuario.controls.ciudad.setValue(this.usuario.ciudadResidencia);
    this.formUsuario.controls.estadoCivil.setValue(this.usuario.estadoCivil);
    this.formUsuario.controls.telefonoCelular.setValue(this.usuario.telefonoCelular);
    this.formUsuario.controls.fechaNacimiento.setValue(this.convertirFechaCalendario(this.usuario.fechaNacimiento));
  }

  ngOnChanges() {
    console.log(this.usuario);

  }

}
