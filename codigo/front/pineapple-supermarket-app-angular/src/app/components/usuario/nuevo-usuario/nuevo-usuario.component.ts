import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UsuarioService } from '../../../services/usuario.service';

@Component({
  selector: 'app-nuevo-usuario',
  templateUrl: './nuevo-usuario.component.html',
  styleUrls: ['./nuevo-usuario.component.css']
})
export class NuevoUsuarioComponent {

  public formSubmitted = false;

  public usersForm = this.fb.group({
    usuario : ['324', Validators.required],
    nombre : ['243423', [Validators.required, Validators.minLength(3)]],
    apellidos:['4234243', Validators.required],
    email:['234@dd.com',[Validators.email, Validators.required]],
    password: ['322ewrwe332' , [Validators.required,Validators.minLength(8)]],
    rol: ['' , Validators.required]      
  });

  constructor( private fb : FormBuilder,
               private usuarioService: UsuarioService) { }

   crearUsuario(){
    this.formSubmitted = true; 
    
    if( this.usersForm.invalid){ 
      console.log('formulario invalido');
      return;      
     }

      //Realzar el posteo del formulario
    this.usuarioService.crearUsuario( this.usersForm.value );
    
   }

  
   campoNoValido( campo: string ): boolean { 
     return ( this.usersForm.get(campo)?.invalid && this.formSubmitted ? true : false);
   }

}
