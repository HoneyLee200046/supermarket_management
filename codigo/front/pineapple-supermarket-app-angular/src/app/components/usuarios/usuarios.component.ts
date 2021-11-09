import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.css']
})
export class UsuariosComponent implements OnInit {

  constructor(private _router:Router) {  
  }

  ngOnInit(): void {
  }

  entrar() {
    this._router.navigate(['/index']);
  }

}

