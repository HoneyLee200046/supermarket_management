
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UsuarioForm } from '../interfaces/usuario.interface';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor( private http: HttpClient) { }

  crearUsuario ( formData: UsuarioForm ) {
    console.log('Crear usuario service');
    
     console.log( formData);    

  }
}
