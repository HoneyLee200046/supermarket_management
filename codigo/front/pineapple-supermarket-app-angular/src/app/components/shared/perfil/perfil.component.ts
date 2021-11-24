import jwt_decode from 'jwt-decode';
import { Component, OnInit } from '@angular/core';
//Model & inteface
import { UsuarioDetalle } from '../../../model/seguridad/usuario-detalle';
import { Usuario } from '../../../model/seguridad/usuario';
//Services
import { StorageService } from '../../../services/storage.service';

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.css']
})
export class PerfilComponent implements OnInit {

  public token:string = "";
  public perfiles:string[] = [];
  public infoUsuarioLogueado:UsuarioDetalle = new UsuarioDetalle();
  public usuario:Usuario = new Usuario();

  constructor(private _storageService: StorageService) { }

  ngOnInit(): void {
    this.token = this._storageService.getCurrentToken();
    let decoded: any = jwt_decode(this.token);
    this.perfiles = decoded.authorities;
    let obj:any = JSON.parse(decoded.sub)
    this.usuario.nombreUsuario = obj.nombreUsuario;
    this.infoUsuarioLogueado = obj.idUsuarioDetalle;
  }

}
