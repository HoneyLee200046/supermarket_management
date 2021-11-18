import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Roles } from 'src/app/model/usuarios/roles';
import { UsuariosService } from '../../../services/usuarios.service';

@Component({
  selector: 'app-nuevo-usuario',
  templateUrl: './nuevo-usuario.component.html',
  styleUrls: ['./nuevo-usuario.component.css']
})
export class NuevoUsuarioComponent implements OnInit {

 
  public formSubmitted = false;
  listaRoles:Roles[] = [];
  rolTemp:Roles = new Roles();
 

  public usersForm = this.fb.group({
    usuario : ['Gala', Validators.required],
    nombre : ['Gala Karina', [Validators.required, Validators.minLength(3)]],
    apellidos:['Reyes Peña', Validators.required],
    email:['gala@gmail.com',[Validators.email, Validators.required]],
    password: ['gala123456' , [Validators.required,Validators.minLength(8)]],
    rol:['', Validators.required ]   
  });

  constructor( private fb : FormBuilder,
               private _usuariosService: UsuariosService) { 

             
               }

  ngOnInit(): void {

    this._usuariosService.getRoles()
        .subscribe( (data:any ) => {
         
          data.forEach((element:Roles) => {
            this.rolTemp = element;
            this.listaRoles.push(this.rolTemp);
          }) 
        });

       
        
  }

   crearUsuario(){
    this.formSubmitted = true; 
    
    if( this.usersForm.invalid){ 
      console.log('formulario invalido');
      return;      
     }

     console.log(this.usersForm.value);
     
      //Realzar el posteo del formulario
        
   }

  
   campoNoValido( campo: string ): boolean { 
     return ( this.usersForm.get(campo)?.invalid && this.formSubmitted ? true : false);
   }

 
onChange(deviceValue:any) {
  console.log(deviceValue.value);
}

}
