import { HttpClient } from '@angular/common/http';
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

  uploadFile(producto:Producto, file:File):Observable<Producto>{
    return this._http.post<any>(`${this.urlWsProducto}nuevo/{file}`,producto);
  }
}
