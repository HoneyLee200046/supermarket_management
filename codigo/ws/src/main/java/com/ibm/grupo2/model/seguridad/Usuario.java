package com.ibm.grupo2.model.seguridad;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ana Olvera
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idUsuario", scope = Usuario.class)
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    @Basic(optional = false)
    @Column(name = "pwd_usuario")
    private String pwdUsuario;
    @Basic(optional = false)
    @Column(name = "fecha_registro_usuario")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistroUsuario;
    @Column(name = "fecha_baja_usuario")
    @Temporal(TemporalType.DATE)
    private Date fechaBajaUsuario;
    @Basic(optional = false)
    @Column(name = "estatus_usuario")
    private Boolean estatusUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private Collection<MiembroGrupo> miembroGrupoCollection;
    @JoinColumn(name = "id_usuario_detalle", referencedColumnName = "id_usuario_detalle")
    @OneToOne(optional = false)
    private UsuarioDetalle idUsuarioDetalle;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Integer idUsuario, String nombreUsuario, String pwdUsuario, Date fechaRegistroUsuario, Date fechaBajaUsuario, Boolean estatusUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.pwdUsuario = pwdUsuario;
        this.fechaRegistroUsuario = fechaRegistroUsuario;
        this.fechaBajaUsuario = fechaBajaUsuario;
        this.estatusUsuario = estatusUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPwdUsuario() {
        return pwdUsuario;
    }

    public void setPwdUsuario(String pwdUsuario) {
        this.pwdUsuario = pwdUsuario;
    }

    public Date getFechaRegistroUsuario() {
        return fechaRegistroUsuario;
    }

    public void setFechaRegistroUsuario(Date fechaRegistroUsuario) {
        this.fechaRegistroUsuario = fechaRegistroUsuario;
    }

    public Date getFechaBajaUsuario() {
        return fechaBajaUsuario;
    }

    public void setFechaBajaUsuario(Date fechaBajaUsuario) {
        this.fechaBajaUsuario = fechaBajaUsuario;
    }

    public Boolean getEstatusUsuario() {
        return estatusUsuario;
    }

    public void setEstatusUsuario(Boolean estatusUsuario) {
        this.estatusUsuario = estatusUsuario;
    }

    @XmlTransient
    public Collection<MiembroGrupo> getMiembroGrupoCollection() {
        return miembroGrupoCollection;
    }

    public void setMiembroGrupoCollection(Collection<MiembroGrupo> miembroGrupoCollection) {
        this.miembroGrupoCollection = miembroGrupoCollection;
    }

    public UsuarioDetalle getIdUsuarioDetalle() {
        return idUsuarioDetalle;
    }

    public void setIdUsuarioDetalle(UsuarioDetalle idUsuarioDetalle) {
        this.idUsuarioDetalle = idUsuarioDetalle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ibm.grupo2.model.Usuario[ idUsuario=" + idUsuario + " ]";
    }

}
