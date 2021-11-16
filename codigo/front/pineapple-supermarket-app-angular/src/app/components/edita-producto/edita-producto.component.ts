import { Component, OnInit } from '@angular/core';
//Service
import { CatalogosService } from '../../services/catalogos.service';
//Models
import { Categoria } from '../../model/catalogos/categoria';
import { Unidadmedida } from 'src/app/model/catalogos/unidadmedida';

@Component({
  selector: 'app-edita-producto',
  templateUrl: './edita-producto.component.html',
  styleUrls: ['./edita-producto.component.css']
})
export class EditaProductoComponent implements OnInit {

  listaCategorias:Categoria[] = [];
  categoriaTmp:Categoria = new Categoria();
  listaUnidadMedida:Unidadmedida[] = [];
  unidadMedidaTmp:Unidadmedida = new Unidadmedida();

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

    this._catalogosService.getUnidadMedidaProductos()
    .subscribe((data:any[]) => {
      this.unidadMedidaTmp.nombreUnidadMedida = "Selecciona una opción";
      this.listaUnidadMedida.push(this.unidadMedidaTmp);
      data.forEach(element => {
        this.unidadMedidaTmp = element;
        this.listaUnidadMedida.push(this.unidadMedidaTmp);
      });
    });
  }
}
