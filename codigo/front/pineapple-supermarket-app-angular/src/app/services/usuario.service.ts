
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { UsuarioForm } from '../interfaces/usuario.interface';
import { Usuario } from '../model/seguridad/usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  private urlWsSeguridad = environment.ws.url+'users/';

  constructor( private http: HttpClient) { }

  crearUsuario ( formData: UsuarioForm ) {
    console.log('Crear usuario service');    
     console.log( formData);   
  }

  
 
}
