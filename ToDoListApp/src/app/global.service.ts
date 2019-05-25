import { Injectable } from '@angular/core';
import { AppSettings } from './app.settings';
import { UsuarioModel } from './models/usuario.model';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ConstantesService } from './constantes.service';
import { UsuarioPKModel } from './models/usuarioPK.model';

@Injectable({
  providedIn: 'root'
})
export class GlobalService {

  url: string;
  headers: HttpHeaders;

  constructor(private http: HttpClient) {
    this.url = AppSettings.API_ENDPOINT;
    this.headers = new HttpHeaders();
  }

  /**
   * Método que arma los Headers para las peticiones REST
   * @param method, Nombre del método CRUD
   */
  getHeaders(method: string): HttpHeaders {

    this.headers.append('Content-Type', 'application/json');

    switch (method) {
      case 'POST':
        this.headers.append('Media-Type', 'application/json');
        break;

      case 'PUT':
        this.headers.append('Media-Type', 'application/json');
        break;
    }
    return this.headers;
  }

  getUrl(param: string): string {
    let url: string = '';
    switch (param) {
      case 'User':
        url = this.url + 'servicios/usuario';
        break;
    }
    return url;
  }

  getParam(user: UsuarioPKModel): string {
    let tipoDoc: string;
    let numDoc: string;
    tipoDoc = `?tipoDocumento=usuarioPK.tipoDocumento=${user.tipoDocumento}`;
    numDoc = `&numeroDocumento=usuarioPK.numeroDocumento=${user.numeroDocumento}`;

    return `${tipoDoc}${numDoc}`;
  }
  /**
   * Método de consulta que trae todos los usuarios
   */
  getUserList(): Observable<UsuarioModel[]> {
    return this.http.get<UsuarioModel[]>(this.getUrl(ConstantesService.USER_SERVICE));
  }

  /**
   * Método de creación de usuario
   * @param user, Modelo del usuario a crear
   */
  createUser(user: UsuarioModel) {
    return this.http.post(this.getUrl(ConstantesService.USER_SERVICE), user, { headers: this.getHeaders(ConstantesService.METHOD_POST) });
  }

  /**
   * Método para la actualización de un usuario
   * @param user, Modelo de usuario a crear
   */
  updateUser(user: UsuarioModel) {
    return this.http.put(this.getUrl(ConstantesService.USER_SERVICE), user, { headers: this.getHeaders(ConstantesService.METHOD_PUT) });
  }

  /**
   * Método para la eliminación de un usuario
   * @param userPK, Llave primaria del usuario para ser eliminado
   */
  deleteUser(userPK: UsuarioPKModel) {
    const options = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      }),
      body: {
        tipoDocumento: userPK.tipoDocumento,
        numeroDocumento: userPK.numeroDocumento
      },
    };
    return this.http.delete(`${this.getUrl(ConstantesService.USER_SERVICE)}`, options);
  }
}
