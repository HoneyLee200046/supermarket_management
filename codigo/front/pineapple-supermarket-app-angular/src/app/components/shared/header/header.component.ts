import jwt_decode from 'jwt-decode';
import { Component, OnInit } from '@angular/core';
//Model & inteface
import { UsuarioDetalle } from '../../../model/seguridad/usuario-detalle';
//Services
import { StorageService } from '../../../services/storage.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  public logueado:boolean = false;
  public isAdmin:boolean = false;
  public token:string = "";
  public perfiles:string[] = [];
  public infoUsuarioLogueado:UsuarioDetalle = new UsuarioDetalle();

  constructor(private _storageService: StorageService) { }

  ngOnInit(): void {
    this.revisarAuth();
  }

  revisarAuth(){
    this.logueado = this._storageService.isAuthenticated();
    if(this.logueado){
      this.token = this._storageService.getCurrentToken();
      let decoded: any = jwt_decode(this.token);
      this.perfiles = decoded.authorities;
      this.isAdmin = this.perfiles.includes('admin');
      let obj:any = JSON.parse(decoded.sub)
      this.infoUsuarioLogueado = obj.idUsuarioDetalle;
    }
  }

  onLogout():void{
    this._storageService.logout();
    this.revisarAuth();
  }

}
