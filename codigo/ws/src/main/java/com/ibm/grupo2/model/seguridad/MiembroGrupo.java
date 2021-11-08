package com.ibm.grupo2.model.seguridad;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ana Olvera
 */
@Entity
@Table(name = "miembro_grupo")
@XmlRootElement
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idMiembroGrupo", scope = MiembroGrupo.class)
public class MiembroGrupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_miembro_grupo")
    private Integer idMiembroGrupo;
    @JoinColumn(name = "id_grupo", referencedColumnName = "id_grupo")
    @ManyToOne(optional = false)
    private Grupo idGrupo;
    @Basic(optional = false)
    @Column(name = "estatus_miembro_grupo")
    private Boolean estatusMiembroGrupo;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public MiembroGrupo() {
    }

    public MiembroGrupo(Integer idMiembroGrupo) {
        this.idMiembroGrupo = idMiembroGrupo;
    }

    public Integer getIdMiembroGrupo() {
        return idMiembroGrupo;
    }

    public void setIdMiembroGrupo(Integer idMiembroGrupo) {
        this.idMiembroGrupo = idMiembroGrupo;
    }

    public Grupo getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Grupo idGrupo) {
        this.idGrupo = idGrupo;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Boolean getEstatusMiembroGrupo() {
        return estatusMiembroGrupo;
    }

    public void setEstatusMiembroGrupo(Boolean estatusMiembroGrupo) {
        this.estatusMiembroGrupo = estatusMiembroGrupo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMiembroGrupo != null ? idMiembroGrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MiembroGrupo)) {
            return false;
        }
        MiembroGrupo other = (MiembroGrupo) object;
        if ((this.idMiembroGrupo == null && other.idMiembroGrupo != null) || (this.idMiembroGrupo != null && !this.idMiembroGrupo.equals(other.idMiembroGrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ibm.grupo2.model.MiembroGrupo[ idMiembroGrupo=" + idMiembroGrupo + " ]";
    }

}
