import { Component, OnInit } from '@angular/core';
//Models
import { Categoria } from '../../model/catalogos/categoria';


@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {

  listaCategorias:Categoria[] = [];
  categoriaTmp:Categoria = new Categoria();

  constructor() { }

  ngOnInit(): void {

  }

}
