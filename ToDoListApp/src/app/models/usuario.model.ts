import { UsuarioPKModel } from './usuarioPK.model';

export class UsuarioModel {
    usuarioPK: UsuarioPKModel;
    ciudadResidencia: string;
    estadoCivil: string;
    fechaNacimiento: Date;
    genero: string;
    primerApellido: string;
    primerNombre: string;
    segundoApellido: string;
    segundoNombre: string;
    telefonoCelular: string;

    constructor(){}
}
