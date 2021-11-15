import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
//environment
import { environment } from '../../environments/environment';
//model & interfaces
import { Usuario } from '../model/seguridad/usuario';
import { Usuariorespuesta } from '../model/helpers/usuariorespuesta';

@Injectable({
  providedIn: 'root'
})
export class SeguridadService {

  private urlWsSeguridad = environment.ws.url+'auth/';

  constructor(private _http:HttpClient) { }

  getUsuarioSistema(usuario:Usuario):Observable<Usuariorespuesta>{
    return this._http.post<any>(`${this.urlWsSeguridad}login`, usuario);
  }
}
