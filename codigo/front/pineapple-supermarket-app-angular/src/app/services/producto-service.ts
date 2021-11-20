import { HttpClient, HttpEvent, HttpHeaders, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
//environment
import { environment } from '../../environments/environment';
import { Producto } from '../model/productos/producto';


@Injectable({
    providedIn: 'root'
  })
export class ProductoService {
  
  post(arg0: string, formularioDeDatos: FormData) {
    throw new Error('Method not implemented.');
  }

private urlWsProducto = environment.ws.url+'prod/';

  constructor(private _http:HttpClient) { }

  uploadFile(file:File):Observable<HttpEvent<any>>{
    const formData: FormData = new FormData();
    formData.append('file', file);
   
    const req = new HttpRequest('POST', `${this.urlWsProducto}upload/`, formData);
    return this._http.request(req);
  }

  guardaProduc(producto:Producto):Observable<Producto>{
      return this._http.post<any>(`${this.urlWsProducto}guardar`, producto);;
  }
}
