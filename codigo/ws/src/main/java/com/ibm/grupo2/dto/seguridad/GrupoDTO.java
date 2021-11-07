package com.ibm.grupo2.dto.seguridad;

/**
 *
 * @author Ana Olvera
 */
public class GrupoDTO {
    
    private Integer idGrupo;
    private String nombreGrupo;
    private Boolean estatusGrupo;

    public GrupoDTO() {
    }

    public GrupoDTO(Integer idGrupo, String nombreGrupo) {
        this.idGrupo = idGrupo;
        this.nombreGrupo = nombreGrupo;
    }

    public GrupoDTO(Integer idGrupo, String nombreGrupo, Boolean estatusGrupo) {
        this.idGrupo = idGrupo;
        this.nombreGrupo = nombreGrupo;
        this.estatusGrupo = estatusGrupo;
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

}
