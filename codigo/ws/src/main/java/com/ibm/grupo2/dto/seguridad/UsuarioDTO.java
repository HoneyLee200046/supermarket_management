package com.ibm.grupo2.dto.seguridad;

import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author Ana Olvera
 */
public class UsuarioDTO {
    
    private Integer idUsuario;
    @NotBlank(message = "El nombre de usuario es requerido")
    private String nombreUsuario;
    @NotBlank(message = "El password encriptado es requerido")
    private String pwdUsuario;    
    private Date fechaRegistroUsuario;
    private Date fechaBajaUsuario;
    private Boolean estatusUsuario;
    private UsuarioDetalleDTO idUsuarioDetalle;
    private List<MiembroGrupoDTO> miembrosGrupoCollection;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Integer idUsuario, String nombreUsuario, String pwdUsuario, Date fechaRegistroUsuario, Date fechaBajaUsuario, Boolean estatusUsuario, UsuarioDetalleDTO idUsuarioDetalle) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.pwdUsuario = pwdUsuario;
        this.fechaRegistroUsuario = fechaRegistroUsuario;
        this.fechaBajaUsuario = fechaBajaUsuario;
        this.estatusUsuario = estatusUsuario;
        this.idUsuarioDetalle = idUsuarioDetalle;
    }

    public UsuarioDTO(Integer idUsuario, String nombreUsuario, String pwdUsuario, Date fechaRegistroUsuario, Date fechaBajaUsuario, Boolean estatusUsuario, UsuarioDetalleDTO idUsuarioDetalle, List<MiembroGrupoDTO> miembrosGrupoCollection) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.pwdUsuario = pwdUsuario;
        this.fechaRegistroUsuario = fechaRegistroUsuario;
        this.fechaBajaUsuario = fechaBajaUsuario;
        this.estatusUsuario = estatusUsuario;
        this.idUsuarioDetalle = idUsuarioDetalle;
        this.miembrosGrupoCollection = miembrosGrupoCollection;
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

    public UsuarioDetalleDTO getIdUsuarioDetalle() {
        return idUsuarioDetalle;
    }

    public void setIdUsuarioDetalle(UsuarioDetalleDTO idUsuarioDetalle) {
        this.idUsuarioDetalle = idUsuarioDetalle;
    }

    public List<MiembroGrupoDTO> getMiembrosGrupoCollection() {
        return miembrosGrupoCollection;
    }

    public void setMiembrosGrupoCollection(List<MiembroGrupoDTO> miembrosGrupoCollection) {
        this.miembrosGrupoCollection = miembrosGrupoCollection;
    }

    @Override
    public String toString() {
        return "{" + "\"idUsuario\":" + this.idUsuario + 
                ", \"nombreUsuario\":\"" + this.nombreUsuario + "\"" +
                ", \"pwdUsuario\":\"" + this.pwdUsuario + "\"" +
                ", \"fechaRegistroUsuario\":\"" + this.fechaRegistroUsuario + "\"" +
                ", \"fechaBajaUsuario\":" + this.fechaBajaUsuario + 
                ", \"estatusUsuario\":" + this.estatusUsuario + 
                ", \"idUsuarioDetalle\":\"" + this.idUsuarioDetalle.toString() + "}";
    }
    
}
