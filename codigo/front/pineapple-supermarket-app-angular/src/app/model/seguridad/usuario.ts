import { UsuarioDetalle } from './usuario-detalle';
export class Usuario {
  idUsuario: number;
  nombreUsuario: String;
  pwdUsuario: String;
  estatusUsuario: boolean;
  idUsuarioDetalle: UsuarioDetalle;

  constructor(){
    this.idUsuario = 0;
    this.nombreUsuario = "";
    this.pwdUsuario = "";
    this.estatusUsuario = false;
    this.idUsuarioDetalle = new UsuarioDetalle();
  }

}
