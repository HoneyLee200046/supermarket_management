import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { UsuarioService } from '../../../services/usuario.service';

@Component({
  selector: 'app-nuevo-usuario',
  templateUrl: './nuevo-usuario.component.html',
  styleUrls: ['./nuevo-usuario.component.css']
})
export class NuevoUsuarioComponent {

  public formSubmitted = false;

  public usersForm = this.fb.group({
    usuario : ['Gala', Validators.required],
    nombre : ['Gala Karina', [Validators.required, Validators.minLength(3)]],
    apellidos:['Reyes Peña', Validators.required],
    email:['gala@gmail.com',[Validators.email, Validators.required]],
    password: ['gala123456' , [Validators.required,Validators.minLength(8)]],
    rol:['',  ]   
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

 
onChange(deviceValue:any) {
  console.log(deviceValue);
}

}
