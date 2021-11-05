package com.ibm.grupo2.dto.seguridad;

/**
 *
 * @author Ana Olvera
 */
public class UsuarioDetalleDTO {
    
    private Integer idUsuarioDetalle;    
    private String nombreUsuarioDetalle;    
    private String apellido1UsuarioDetalle;
    private String correoUsuarioDetalle;    
    private Boolean estatusUsuarioDetalle;

    public UsuarioDetalleDTO() {
    }

    public UsuarioDetalleDTO(Integer idUsuarioDetalle, String nombreUsuarioDetalle, String apellido1UsuarioDetalle, String correoUsuarioDetalle, Boolean estatusUsuarioDetalle) {
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
    
    

}
