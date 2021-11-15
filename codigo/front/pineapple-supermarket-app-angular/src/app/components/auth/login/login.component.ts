import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent  {

  public formSubmitted = false;

  public loginForm = this.fb.group({   
    email: ['',[Validators.email, Validators.required]],
    password: ['' , Validators.required], 
  });

  constructor(private _router:Router,
              private fb: FormBuilder) { }

 
  entrar() {
    this.formSubmitted = true; 

    
    if( this.loginForm.invalid){ 
      console.log('formulario invalido');
      return;      
     }

      //Realzar el posteo del formulario
   // this.loginForm.login( this.loginForm.value );
    this._router.navigate(['/index']);
  }

  campoNoValido( campo: string ): boolean { 
    return ( this.loginForm.get(campo)?.invalid && this.formSubmitted ? true : false);
    
  }
}
