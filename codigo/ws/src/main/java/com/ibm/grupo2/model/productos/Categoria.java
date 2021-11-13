package com.ibm.grupo2.model.productos;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
*
* @author Nora Alvarez
*/

@Entity
@Table(name = "cat_categoria")
@XmlRootElement
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idCategoria", scope = Categoria.class)
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;

	public Categoria() {
		
	}

	 public Categoria(Integer idCategoria, String nombreCategoria, Boolean statusCategoria) {
		this.idCategoria = idCategoria;
		this.nombreCategoria = nombreCategoria;
		this.statusCategoria = statusCategoria;
	}



	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Basic(optional = false)
     @Column(name = "id_categoria")
	 private Integer idCategoria;
	 
	 @Basic(optional = false)
	 @Column(name = "nombre")
	 private String nombreCategoria;
	 
	 @Basic(optional = false)
	 @Column(name = "status")
	 private Boolean statusCategoria;

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	public Boolean getStatusCategoria() {
		return statusCategoria;
	}

	public void setStatusCategoria(Boolean statusCategoria) {
		this.statusCategoria = statusCategoria;
	}
	 
}
