import { Component, OnInit } from '@angular/core';
import { Validators, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
//Service
import { CatalogosService } from '../../services/catalogos.service';
import { SeguridadService } from '../../services/seguridad.service';
import { StorageService } from '../../services/storage.service';
//Models
import { Categoria } from '../../model/catalogos/categoria';
import { Unidadmedida } from 'src/app/model/catalogos/unidadmedida';
import { Producto } from 'src/app/model/productos/producto';
import { DomSanitizer } from '@angular/platform-browser';
import { ProductoService } from 'src/app/services/producto-service';

@Component({
  selector: 'app-edita-producto',
  templateUrl: './edita-producto.component.html',
  styleUrls: ['./edita-producto.component.css']
})
export class EditaProductoComponent implements OnInit {

  private categoriaSeleccionada:Categoria= new Categoria();
  private unidadSeleccionada:Unidadmedida= new Unidadmedida();
  public previsualizacion: string="";
  public archivos: any = [];
  public loading: boolean = false;
  public formSubmitted = false;
  public productoForm = this.fb.group({
    archivo: ['', [Validators.required]],
    nombre: ['', Validators.required],
    serial: ['', Validators.required],
    catCategorias: [this.categoriaSeleccionada, Validators.required],
    descripcion: ['', Validators.required],
    cantidad: [0, Validators.required],
    catUnidadMedida: [this.unidadSeleccionada, Validators.required],
    precio: [0, Validators.required]
  });
  private producto:Producto = new Producto();

  listaCategorias:Categoria[] = [];
  categoriaTmp:Categoria = new Categoria();
  listaUnidadMedida:Unidadmedida[] = [];
  unidadMedidaTmp:Unidadmedida = new Unidadmedida();

  constructor(private _catalogosService:CatalogosService, private _router: Router,
    private fb: FormBuilder,
    private _seguridadService:SeguridadService,
    private _storageService:StorageService,
    private sanitizer: DomSanitizer,
    private rest: ProductoService
    ) { }
  

  ngOnInit(): void {

    this._catalogosService.getCategoriasProductos()
    .subscribe((data:any[]) => {
      this.categoriaTmp.nombreCategoria = "Selecciona una opción";
      this.listaCategorias.push(this.categoriaTmp);
      data.forEach(element => {
        this.categoriaTmp = element;
        this.listaCategorias.push(this.categoriaTmp);
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
    });
  }

  compararCategoria(cat1:Categoria, cat2:Categoria){
    if(cat1==null || cat2==null){
      return false;
    }
    return cat1.idCategoria===cat2.idCategoria;
  }

  compararUnidad(cat1:Unidadmedida, cat2:Unidadmedida){
    if(cat1==null || cat2==null){
      return false;
    }
    return cat1.idUnidadMedida===cat2.idUnidadMedida;
  }

  capturarFile(event:any) {
    const archivoCapturado = event.target.files[0]
    this.extraerBase64(archivoCapturado).then((imagen: any) => {
      this.previsualizacion = imagen.base;
      console.log(imagen);

    })
    this.archivos.push(archivoCapturado)
    // 
    // console.log(event.target.files);

  }

  extraerBase64 = async ($event: any) => new Promise((resolve, reject) => {
    try {
      const unsafeImg = window.URL.createObjectURL($event);
      const image = this.sanitizer.bypassSecurityTrustUrl(unsafeImg);
      const reader = new FileReader();
      reader.readAsDataURL($event);
      reader.onload = () => {
        resolve({
          base: reader.result
        });
      };
      reader.onerror = error => {
        resolve({
          base: null
        });
      };
      return;

    } catch (e) {
      return null;
    }
  })


  /**
   * Limpiar imagen
   */

  clearImage(): any {
    this.previsualizacion = '';
    this.archivos = [];
  }



  /**
   * Subir archivo
   */

  subirArchivo(): any {
    try {
      this.loading = true;
      const formularioDeDatos = new FormData();
      this.archivos.forEach((archivo: string) => {
        formularioDeDatos.append('files', archivo)
      })
      // formularioDeDatos.append('_id', 'MY_ID_123')
      this.rest.uploadFile(formularioDeDatos)
        .subscribe(res => {
          this.loading = false;
          console.log('Respuesta del servidor', res);

        }, () => {
          this.loading = false;
          alert('Error');
        })
    } catch (e) {
      this.loading = false;
      console.log('ERROR', e);

    }
  }
  

  guardar() {
  }
}
