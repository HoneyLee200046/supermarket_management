package com.ibm.grupo2.model.seguridad;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ana Olvera
 */
@Entity
@Table(name = "grupo")
@XmlRootElement
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idGrupo", scope = Grupo.class)
public class Grupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_grupo")
    private Integer idGrupo;
    @Basic(optional = false)
    @Column(name = "nombre_grupo")
    private String nombreGrupo;
    @Column(name = "estatus_grupo")
    private Boolean estatusGrupo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGrupo")
    private Collection<MiembroGrupo> miembroGrupoCollection;

    public Grupo() {
    }

    public Grupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public Grupo(Integer idGrupo, String nombreGrupo) {
        this.idGrupo = idGrupo;
        this.nombreGrupo = nombreGrupo;
    }

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    public Boolean getEstatusGrupo() {
        return estatusGrupo;
    }

    public void setEstatusGrupo(Boolean estatusGrupo) {
        this.estatusGrupo = estatusGrupo;
    }

    @XmlTransient
    public Collection<MiembroGrupo> getMiembroGrupoCollection() {
        return miembroGrupoCollection;
    }

    public void setMiembroGrupoCollection(Collection<MiembroGrupo> miembroGrupoCollection) {
        this.miembroGrupoCollection = miembroGrupoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGrupo != null ? idGrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupo)) {
            return false;
        }
        Grupo other = (Grupo) object;
        if ((this.idGrupo == null && other.idGrupo != null) || (this.idGrupo != null && !this.idGrupo.equals(other.idGrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ibm.grupo2.model.Grupo[ idGrupo=" + idGrupo + " ]";
    }

}
