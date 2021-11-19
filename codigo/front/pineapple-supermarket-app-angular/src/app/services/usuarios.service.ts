import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UsuarioForm } from '../interfaces/usuario.interface';

@Injectable({
  providedIn: 'root'
})
export class UsuariosService {

  private urlWsUsuarios = environment.ws.url + 'users/';
  private urlWsRoles = environment.ws.url + 'rol/' ;

  constructor(private _http:HttpClient) { }

  getUsuarios():Observable<any[]>{
    return this._http.get<any[]>(`${this.urlWsUsuarios}usuarios`);
  }

  getRoles():Observable<any[]>{
    return this._http.get<any[]>(`${this.urlWsRoles}roles`);
  }

  crearUsuario( formData: UsuarioForm){

    console.log('creando usuario');
    console.log();
    
    


  }

}
