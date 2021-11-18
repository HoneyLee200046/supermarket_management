package com.ibm.grupo2.model.productos;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
*
* @author Nora Alvarez
*/

@Entity
@Table(name = "producto")
@XmlRootElement
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idProducto", scope = Producto.class)
public class Producto implements Serializable {

	private static final long serialVersionUID = 1L;

	public Producto() {

	}
	
	public Producto(Integer idProducto, String nombreProducto, String descripcionProducto, BigDecimal cantidadProducto,
			BigDecimal precioUnitario, String urlImagen, Categoria idCategoria, UnidadMedida idUnidadMedida) {
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.descripcionProducto = descripcionProducto;
		this.cantidadProducto = cantidadProducto;
		this.precioUnitario = precioUnitario;
		this.urlImagen = urlImagen;
		this.idCategoria = idCategoria;
		this.idUnidadMedida = idUnidadMedida;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_producto")
	private Integer idProducto;

	@Basic(optional = false)
	@Column(name = "nombre")
	@Size(max=60)
	private String nombreProducto;

	@Basic(optional = false)
	@Column(name = "descripcion")
	@Size(max=80)
	private String descripcionProducto;

	@Basic(optional = false)
	@Column(name = "cantidad")
	private BigDecimal cantidadProducto;

	@Basic(optional = false)
	@Column(name = "precio_unitario")
	private BigDecimal precioUnitario;

	@Basic(optional = false)
	@Column(name = "url_imagen")
	@Size(max=180)
	private String urlImagen;

	@JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
	@ManyToOne(optional = false)
	private Categoria idCategoria;

	@JoinColumn(name = "id_unidad_medida", referencedColumnName = "id_unidad_medida")
	@ManyToOne(optional = false)
	private UnidadMedida idUnidadMedida;

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getDescripcionProducto() {
		return descripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	public BigDecimal getCantidadProducto() {
		return cantidadProducto;
	}

	public void setCantidadProducto(BigDecimal cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}

	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	public Categoria getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Categoria idCategoria) {
		this.idCategoria = idCategoria;
	}

	public UnidadMedida getIdUnidadMedida() {
		return idUnidadMedida;
	}

	public void setIdUnidadMedida(UnidadMedida idUnidadMedida) {
		this.idUnidadMedida = idUnidadMedida;
	}

}
