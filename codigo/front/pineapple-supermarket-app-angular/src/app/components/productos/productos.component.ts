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
  public cargando : boolean = true;

  constructor(private _productoService:ProductoService) { }

  ngOnInit(): void {
    this.cargarProductos();   
  }

  cargarProductos(){
    this.cargando= true;

    this._productoService.getListaProductos()
    .subscribe((data:any[]) => {
      this.listaProductos=data;
      this.cargando = false;
    });
  }

}
