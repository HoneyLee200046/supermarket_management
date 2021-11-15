import jwt_decode from 'jwt-decode';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, Validators } from '@angular/forms';
//model && interface
import { Usuario } from '../../../model/seguridad/usuario';
import { Usuariorespuesta } from '../../../model/helpers/usuariorespuesta';
//Servicios
import { SeguridadService } from '../../../services/seguridad.service';
import { StorageService } from '../../../services/storage.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{

  public formSubmitted = false;
  public loginForm = this.fb.group({
    usuario: ['', [Validators.required]],
    password: ['', Validators.required],
  });
  private usuario:Usuario = new Usuario();

  constructor(private _router: Router,
              private fb: FormBuilder,
              private _seguridadService:SeguridadService,
              private _storageService:StorageService) { }

  ngOnInit():void{
    this._storageService.removeCurrentSession();
  }

  entrar() {
    this.formSubmitted = true;
    if (this.loginForm.valid) {
      const {usuario, password} = this.loginForm.value;
      this.usuario.nombreUsuario =  usuario;
      this.usuario.pwdUsuario = password;
      this._seguridadService.getUsuarioSistema(this.usuario)
      .subscribe((data:any)=>{
        if(data.mensaje === 'success'){
          let decoded:any = jwt_decode(data.token);
          let perfil = decoded.authorities;
          this._storageService.setCurrentSession(data);
          this._storageService.setAnyItemSession("perfil", perfil);
          this._router.navigate(["/index"]);
        }else{
          console.log("data");
          console.log(data);
        }
      });
    } else {
      console.log('formulario invalido');
    }
  }

  campoNoValido(campo: string): boolean {
    return (this.loginForm.get(campo) ?.invalid && this.formSubmitted ? true : false);

  }
}
