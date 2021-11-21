export class Producto {

        idProducto : number;
		nombreProducto : string;
        serialProducto : string;
		descripcionProducto : string;
	    cantidadProducto : number;
		precioUnitario : number;
		urlImagen : string;
		idCategoria : any;
		idUnidadMedida : any;

        constructor(){
            this.idProducto = 0;
            this.nombreProducto = "";
            this.serialProducto = "";
            this.descripcionProducto = "";
            this.cantidadProducto = 0;
            this.precioUnitario = 0;
            this.urlImagen = "";
            this.idCategoria = "";
            this.idUnidadMedida = "";
        }
}
