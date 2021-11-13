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
@Table(name = "cat_unidad_medida")
@XmlRootElement
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idUnidadMedida", scope = UnidadMedida.class)
public class UnidadMedida implements Serializable {

	private static final long serialVersionUID = 1L;

	public UnidadMedida() {

	}

	public UnidadMedida(Integer idUnidadMedida, String nombreUnidadMedida, Boolean statusUnidadMedida) {
		this.idUnidadMedida = idUnidadMedida;
		this.nombreUnidadMedida = nombreUnidadMedida;
		this.statusUnidadMedida = statusUnidadMedida;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_unidad_medida")
	private Integer idUnidadMedida;

	@Basic(optional = false)
	@Column(name = "nombre")
	private String nombreUnidadMedida;

	@Basic(optional = false)
	@Column(name = "status")
	private Boolean statusUnidadMedida;

	public Integer getIdUnidadMedida() {
		return idUnidadMedida;
	}

	public void setIdUnidadMedida(Integer idUnidadMedida) {
		this.idUnidadMedida = idUnidadMedida;
	}

	public String getNombreUnidadMedida() {
		return nombreUnidadMedida;
	}

	public void setNombreUnidadMedida(String nombreUnidadMedida) {
		this.nombreUnidadMedida = nombreUnidadMedida;
	}

	public Boolean getStatusUnidadMedida() {
		return statusUnidadMedida;
	}

	public void setStatusUnidadMedida(Boolean statusUnidadMedida) {
		this.statusUnidadMedida = statusUnidadMedida;
	}

}
