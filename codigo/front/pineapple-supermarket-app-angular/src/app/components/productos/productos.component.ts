import { Component, OnInit } from '@angular/core';
import { Producto } from 'src/app/model/productos/producto';
import { ProductoService } from 'src/app/services/producto-service';

@Component({
  selector: 'app-productos',
  templateUrl: './productos.component.html',
  styleUrls: ['./productos.component.css']
})
export class ProductosComponent implements OnInit {

  listaProductos:Producto[] = [];

  constructor(private _productoService:ProductoService) { }

  ngOnInit(): void {

    this._productoService.getListaProductos()
    .subscribe((data:any[]) => {
      this.listaProductos=data;
    });
  }

}
