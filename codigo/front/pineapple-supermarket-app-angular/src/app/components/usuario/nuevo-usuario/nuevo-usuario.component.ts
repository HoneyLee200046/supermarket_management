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
    usuario : ['', Validators.required],
    nombre : ['', [Validators.required, Validators.minLength(3)]],
    apellidos:['', Validators.required],
    email:['',[Validators.email, Validators.required]],
    password: ['' , [Validators.required,Validators.minLength(8)]],
    rol: ['' , Validators.required]      
  });

  constructor( private fb : FormBuilder,
               private usuarioService: UsuarioService) { }

   crearUsuario(){
    this.formSubmitted = true;
    console.log(this.usersForm.value);

    
    if( this.usersForm.invalid){ 

      console.log('formulario invalido');
      return;
      
     }else{
       console.log('posteando formulario');
       
     }

    //Realizar el posteo del formulario
    
   }

  
   campoNoValido( campo: string ): boolean {
     return ( this.usersForm.get(campo)?.invalid && this.formSubmitted ? true : false);
   }

}
