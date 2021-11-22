import { Component, OnInit } from '@angular/core';

import { Usuario } from 'src/app/model/seguridad/usuario';
import { UsuariosService } from '../../../services/usuarios.service';



@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css']
})
export class UsuarioComponent implements OnInit {

  
  listaUsuarios:Usuario[] = [];
  usuarioTemp:Usuario = new Usuario();
  public cargando : boolean = true;

  constructor(private _usuariosService: UsuariosService) { }

  ngOnInit(): void {

    this.cargarUsuarios();
 
  }

  cargarUsuarios(){
    this.cargando = true;
    this._usuariosService.getUsuarios()
    .subscribe((data:any[]) => {     
      data.forEach(element => {
        this.usuarioTemp = element;
        this.listaUsuarios.push(this.usuarioTemp);
        this.cargando = false;
      });
    });
  }

}
