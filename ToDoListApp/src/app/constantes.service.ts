import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ConstantesService {

  // Nombre de métodos CRUD
  public static METHOD_POST = 'POST';
  public static METHOD_GET = 'GET';
  public static METHOD_PUT = 'PUT';

  // Nombre de parametro servicio
  public static USER_SERVICE = 'User';

  // Mensajes de respuesta para servicios
  public static GET_USER_SUCCESS = 'Se consutaron los usuarios exitosamente';

  constructor() { }
}
