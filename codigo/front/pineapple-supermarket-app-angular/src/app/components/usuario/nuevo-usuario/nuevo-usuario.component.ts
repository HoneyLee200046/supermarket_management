import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Usuario } from 'src/app/model/seguridad/usuario';
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

  private usuario:Usuario = new Usuario();

  public titulo: string = "Nuevo usuario";
 

  public usersForm = this.fb.group({
    usuario : ['', Validators.required],
    nombre : ['', [Validators.required, Validators.minLength(3)]],
    apellidos:['', Validators.required],
    email:['',[Validators.email, Validators.required]],
    password: ['' , [Validators.required,Validators.minLength(8)]],
    rol:['', Validators.required ]   
  });

  constructor( private fb : FormBuilder,
               private _usuariosService: UsuariosService,
              ) { 

             
               }

  ngOnInit(): void {

    this.cargarUsuario();

    this._usuariosService.getRoles()
        .subscribe( (data:any ) => {
         
          data.forEach((element:Roles) => {
            this.rolTemp = element;
            this.listaRoles.push(this.rolTemp);
          }) 
        });     
        
  }

  cargarUsuario():void{    
        //this._usuariosService.getUsuario(id);           // .subscribe( (usuario => this.usuario = usuario));
    
  }

   crearUsuario(){
    this.formSubmitted = true; 

    let rol = this.usersForm.get('rol')?.valueChanges
              .subscribe( region => {
                console.log(region);
                
              });
    
    if( this.usersForm.invalid){ return; }     
      //Realzar el posteo del formulario 
      this._usuariosService.crearUsuario( this.usersForm.value );
        
   }

  
   campoNoValido( campo: string ): boolean { 
     return ( this.usersForm.get(campo)?.invalid && this.formSubmitted ? true : false);
   }

   
   compararRoles(o1:Roles, o2:Roles){
    return o1 == null || o2 === null  || o1 == undefined || o2 === undefined ? false : o1.idGrupo=== o2.idGrupo
  }


}
