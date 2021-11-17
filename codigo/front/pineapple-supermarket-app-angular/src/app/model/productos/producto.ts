export class Producto {

        idProducto : number;
		nombreProducto : string;
		descripcionProducto : string;
	    cantidadProducto : number;
		precioUnitario : number;
		urlImagen : string;
		idCategoria : number;
		idUnidadMedida : number;

        constructor(){
            this.idProducto = 0;
            this.nombreProducto = "";
            this.descripcionProducto = "";
            this.cantidadProducto = 0;
            this.precioUnitario = 0;
            this.urlImagen = "";
            this.idCategoria = 0;
            this.idUnidadMedida = 0;
        }
}
