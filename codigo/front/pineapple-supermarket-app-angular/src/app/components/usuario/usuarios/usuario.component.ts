import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/model/seguridad/usuario';
import { UsuariosService } from '../../../services/usuarios.service';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css']
})
export class UsuarioComponent implements OnInit {

  
  listaUsuarios:any[] = [];
  categoriaTmp:Usuario = new Usuario();

  constructor(private _usuariosService: UsuariosService) { }

  ngOnInit(): void {

    this._usuariosService.getUsuarios()
    .subscribe((data:any[]) => {     
      data.forEach(element => {
        this.categoriaTmp = element;
        this.listaUsuarios.push(this.categoriaTmp);
      });
    });
    console.log('-------------------------------------------------');
    
    console.log(this.listaUsuarios ); 
  }

}
