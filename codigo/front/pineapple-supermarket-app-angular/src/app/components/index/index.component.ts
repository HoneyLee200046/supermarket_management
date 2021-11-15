import { Component, OnInit } from '@angular/core';
//Service
import { CatalogosService } from '../../services/catalogos.service';
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

  constructor(private _catalogosService:CatalogosService) { }

  ngOnInit(): void {

    this._catalogosService.getCategoriasProductos()
    .subscribe((data:any[]) => {
      this.categoriaTmp.nombreCategoria = "Selecciona una opción";
      this.listaCategorias.push(this.categoriaTmp);
      data.forEach(element => {
        this.categoriaTmp = element;
        this.listaCategorias.push(this.categoriaTmp);
      });
    });
  }

}
