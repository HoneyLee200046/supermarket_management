import { GrupoDTO } from './grupodto';
import { Usuario } from './usuario';
export class miembrosGrupo {

    idMiembroGrupo: number;
    idGrupo: GrupoDTO;
    idUsuario:Usuario;
    estatusMiembroGrupo:boolean;
  
  constructor(){
      this.idMiembroGrupo = 0;
      this.estatusMiembroGrupo =false;
      this.idUsuario = new Usuario();  
      this.idGrupo = new GrupoDTO();   
  }

}