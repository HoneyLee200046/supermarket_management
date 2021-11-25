import { Component, OnInit } from '@angular/core';
import jwt_decode from 'jwt-decode';
import { Router } from '@angular/router';
//model && interface
import { Router } from '@angular/router';
//model && interface
import { Producto } from 'src/app/model/productos/producto';
//service
import { ProductoService } from 'src/app/services/producto-service';
import { ExportarService } from '../../services/exportar.service';
import { StorageService } from '../../services/storage.service';

@Component({
  selector: 'app-productos',
  templateUrl: './productos.component.html',
  styleUrls: ['./productos.component.css']
})
export class ProductosComponent implements OnInit {

  listaProductos:Producto[] = [];

  public cargando : boolean = true;
  public ordenDesc:boolean = true;
  public isAdmin:boolean = true;
  public token:string = "";
  public perfiles:string[] = [];
  public cargando : boolean = true;
  public ordenDesc:boolean = true;

  constructor(private _router: Router,
              private _storageService:StorageService,
              private _productoService:ProductoService,
              private _exportarService: ExportarService) { }

  ngOnInit(): void {
    this._storageService.removeAnyItemSession("producto");
    this.token = this._storageService.getCurrentToken();
    let decoded: any = jwt_decode(this.token);
    this.perfiles = decoded.authorities;
    this.isAdmin = this.perfiles.includes('admin');
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

  sortDesc(colName:string){
    this.ordenDesc = false;
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

  sortAsc(colName:string){
    this.ordenDesc = true;
    switch (colName) {
      case 'nombreCategoria':
        this.listaProductos.sort((a, b) => b['idCategoria'][colName] > a['idCategoria'][colName] ? 1 : b['idCategoria'][colName] < a['idCategoria'][colName] ? -1 : 0);
        break;
      case 'nombreUnidadMedida':
        this.listaProductos.sort((a, b) => b['idUnidadMedida'][colName] > a['idUnidadMedida'][colName] ? 1 : b['idUnidadMedida'][colName] < a['idUnidadMedida'][colName] ? -1 : 0);
        break;

      default:
        this.listaProductos.sort((a, b) => b[colName] > a[colName] ? 1 : b[colName] < a[colName] ? -1 : 0);
        break;
    }
  }

  buscarProductos(termBusqueda:string){
    let listaProductosTmp:Producto[] = [];
    this.cargando = true;
    if(termBusqueda !== ''){
      let termino = termBusqueda.toLowerCase();
      for(let i = 0; i< this.listaProductos.length; i ++){
        let producto = this.listaProductos[i];
        let nombre = producto.nombreProducto.toLowerCase();
        if(nombre.indexOf( termino ) >= 0){
          listaProductosTmp.push( producto );
        }
      }
      this.listaProductos = listaProductosTmp;
      this.cargando = false;
    }else{
      this.cargarProductos();
    }
  }

  nuevoProducto(){
    this._storageService.setAnyItemSession("producto",new Producto());
    this._router.navigate(['/editaProducto']);
  }

  editarProducto(currentProducto:Producto){
    this._storageService.setAnyItemSession("producto", currentProducto);
    this._router.navigate(['/editaProducto']);
  }
}
