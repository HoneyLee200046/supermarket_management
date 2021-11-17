export class Usuarios {

    idUsuario:number;
    nombreUsuario:string;
    pwdUsuario:string;
    fechaRegistroUsuario:string;
    fechaBajaUsuario:string;
    estatusUsuario:string;
    idUsuarioDetalle:number;

    constructor(){
        this.idUsuario = 0;
        this.nombreUsuario = '';
        this.pwdUsuario = '';
        this.fechaBajaUsuario='';
        this.fechaRegistroUsuario='';
        this.estatusUsuario='';
        this.idUsuarioDetalle = 0;

    }
}


