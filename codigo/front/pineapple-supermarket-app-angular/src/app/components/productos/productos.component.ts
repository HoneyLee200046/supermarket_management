import { Component, OnInit } from '@angular/core';
<<<<<<< Updated upstream
=======
import jwt_decode from 'jwt-decode';
import { Router } from '@angular/router';
//model && interface
>>>>>>> Stashed changes
import { Producto } from 'src/app/model/productos/producto';
import { ProductoService } from 'src/app/services/producto-service';

@Component({
  selector: 'app-productos',
  templateUrl: './productos.component.html',
  styleUrls: ['./productos.component.css']
})
export class ProductosComponent implements OnInit {

  listaProductos:Producto[] = [];
<<<<<<< Updated upstream
=======
  public cargando : boolean = true;
  public ordenDesc:boolean = true;
  public isAdmin:boolean = true;
  public token:string = "";
  public perfiles:string[] = [];
>>>>>>> Stashed changes

  constructor(private _productoService:ProductoService) { }

  ngOnInit(): void {
<<<<<<< Updated upstream
=======
    this._storageService.removeAnyItemSession("producto");
    this.token = this._storageService.getCurrentToken();
    let decoded: any = jwt_decode(this.token);
    this.perfiles = decoded.authorities;
    this.isAdmin = this.perfiles.includes('admin');
    this.cargarProductos();
  }

  cargarProductos(){
    this.cargando= true;
>>>>>>> Stashed changes

    this._productoService.getListaProductos()
    .subscribe((data:any[]) => {
      this.listaProductos=data;
    });
  }

}
