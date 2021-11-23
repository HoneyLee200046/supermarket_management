package com.ibm.grupo2.model.seguridad;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ana Olvera
 */
@Entity
@Table(name = "usuario_detalle")
@XmlRootElement
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idUsuarioDetalle", scope = UsuarioDetalle.class)
public class UsuarioDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario_detalle")
    private Integer idUsuarioDetalle;
    @Basic(optional = false)
    @Column(name = "nombre_usuario_detalle")
    private String nombreUsuarioDetalle;
    @Basic(optional = false)
    @Column(name = "apellido1_usuario_detalle")
    private String apellido1UsuarioDetalle;
    @Basic(optional = false)
    @Column(name = "correo_usuario_detalle")
    private String correoUsuarioDetalle;
    @Basic(optional = false)
    @Column(name = "estatus_usuario_detalle")
    private Boolean estatusUsuarioDetalle;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idUsuarioDetalle")
    private Usuario usuario;

    public UsuarioDetalle() {
    }

    public UsuarioDetalle(Integer idUsuarioDetalle) {
        this.idUsuarioDetalle = idUsuarioDetalle;
    }

    public UsuarioDetalle(Integer idUsuarioDetalle, String nombreUsuarioDetalle, String apellido1UsuarioDetalle, String correoUsuarioDetalle, Boolean estatusUsuarioDetalle) {
        this.idUsuarioDetalle = idUsuarioDetalle;
        this.nombreUsuarioDetalle = nombreUsuarioDetalle;
        this.apellido1UsuarioDetalle = apellido1UsuarioDetalle;
        this.correoUsuarioDetalle = correoUsuarioDetalle;
        this.estatusUsuarioDetalle = estatusUsuarioDetalle;
    }

    public Integer getIdUsuarioDetalle() {
        return idUsuarioDetalle;
    }

    public void setIdUsuarioDetalle(Integer idUsuarioDetalle) {
        this.idUsuarioDetalle = idUsuarioDetalle;
    }

    public String getNombreUsuarioDetalle() {
        return nombreUsuarioDetalle;
    }

    public void setNombreUsuarioDetalle(String nombreUsuarioDetalle) {
        this.nombreUsuarioDetalle = nombreUsuarioDetalle;
    }

    public String getApellido1UsuarioDetalle() {
        return apellido1UsuarioDetalle;
    }

    public void setApellido1UsuarioDetalle(String apellido1UsuarioDetalle) {
        this.apellido1UsuarioDetalle = apellido1UsuarioDetalle;
    }

    public String getCorreoUsuarioDetalle() {
        return correoUsuarioDetalle;
    }

    public void setCorreoUsuarioDetalle(String correoUsuarioDetalle) {
        this.correoUsuarioDetalle = correoUsuarioDetalle;
    }

    public Boolean getEstatusUsuarioDetalle() {
        return estatusUsuarioDetalle;
    }

    public void setEstatusUsuarioDetalle(Boolean estatusUsuarioDetalle) {
        this.estatusUsuarioDetalle = estatusUsuarioDetalle;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuarioDetalle != null ? idUsuarioDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioDetalle)) {
            return false;
        }
        UsuarioDetalle other = (UsuarioDetalle) object;
        if ((this.idUsuarioDetalle == null && other.idUsuarioDetalle != null) || (this.idUsuarioDetalle != null && !this.idUsuarioDetalle.equals(other.idUsuarioDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ibm.grupo2.model.UsuarioDetalle[ idUsuarioDetalle=" + idUsuarioDetalle + " ]";
    }

}
