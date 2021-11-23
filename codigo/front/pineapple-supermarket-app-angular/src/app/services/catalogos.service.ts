import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
//environment
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CatalogosService {

  private urlWsCatalogos = environment.ws.url + 'cat/'

  constructor(private _http:HttpClient) { }

  getCategoriasProductos():Observable<any[]>{
    return this._http.get<any[]>(`${this.urlWsCatalogos}categorias`);
  }

  getUnidadMedidaProductos():Observable<any[]>{
    return this._http.get<any[]>(`${this.urlWsCatalogos}unidadMedida`);
  }


}
