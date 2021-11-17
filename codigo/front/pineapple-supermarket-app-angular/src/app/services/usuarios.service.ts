import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsuariosService {

  private urlWsCatalogos = environment.ws.url + 'users/'

  constructor(private _http:HttpClient) { }

  getUsuarios():Observable<any[]>{
    return this._http.get<any[]>(`${this.urlWsCatalogos}usuarios`);
  }

}
