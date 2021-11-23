import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
//model && interface
import { Producto } from 'src/app/model/productos/producto';
//service
import { ProductoService } from 'src/app/services/producto-service';
import { ExportarService } from '../../services/exportar.service';

@Component({
  selector: 'app-productos',
  templateUrl: './productos.component.html',
  styleUrls: ['./productos.component.css']
})
export class ProductosComponent implements OnInit {

  public formProdSubmitted = false;
  public busqProdForm = this.fb.group({
    termBusqueda: ['', Validators.required],
  });
  listaProductos:Producto[] = [];
  public cargando : boolean = true;

  constructor(private fb: FormBuilder,
              private _productoService:ProductoService,
              private _exportarService: ExportarService) { }

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
  exportAsXLSX():void{
    this._exportarService.exportToExcel(this.listaProductos, 'Productos');
  }

  sort(colName:string){
    switch (colName) {
      case 'nombreCategoria':
        this.listaProductos.sort((a, b) => a['idCategoria'][colName] > b['idCategoria'][colName] ? 1 : a['idCategoria'][colName] < b['idCategoria'][colName] ? -1 : 0);
        break;
      case 'nombreUnidadMedida':
        this.listaProductos.sort((a, b) => a['idUnidadMedida'][colName] > b['idUnidadMedida'][colName] ? 1 : a['idUnidadMedida'][colName] < b['idUnidadMedida'][colName] ? -1 : 0);
        break;

      default:
        this.listaProductos.sort((a, b) => a[colName] > b[colName] ? 1 : a[colName] < b[colName] ? -1 : 0);
        break;
    }
  }

  buscarProductos(){
    this.cargando = true;
    const {termBusqueda} = this.busqProdForm.value;
    if(termBusqueda !== ''){
      let listaProductosTmp:Producto[] = [];
      let termino = termBusqueda.toLowerCase();

      for(let i = 0; i< this.listaProductos.length; i ++){
        let producto = this.listaProductos[i];
        let nombre = producto.nombreProducto.toLowerCase();
        if(nombre.indexOf( termino ) >= 0){
          listaProductosTmp.push( producto );
        }
        this.listaProductos = listaProductosTmp;
        this.cargando = false;
      }
    }else{
      this.cargarProductos();
    }
  }
}
