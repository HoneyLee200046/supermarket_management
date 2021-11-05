package com.ibm.grupo2.dto.seguridad;

/**
 *
 * @author Ana Olvera
 */
public class MiembroGrupoDTO {
    
    private Integer idMiembroGrupo;
    private GrupoDTO idGrupo;
    private UsuarioDTO idUsuario;
    private Boolean estatusMiembroGrupo;

    public MiembroGrupoDTO() {
    }

    public MiembroGrupoDTO(Integer idMiembroGrupo, GrupoDTO idGrupo, UsuarioDTO idUsuario, Boolean estatusMiembroGrupo) {
        this.idMiembroGrupo = idMiembroGrupo;
        this.idGrupo = idGrupo;
        this.idUsuario = idUsuario;
        this.estatusMiembroGrupo = estatusMiembroGrupo;
    }

    public Integer getIdMiembroGrupo() {
        return idMiembroGrupo;
    }

    public void setIdMiembroGrupo(Integer idMiembroGrupo) {
        this.idMiembroGrupo = idMiembroGrupo;
    }

    public GrupoDTO getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(GrupoDTO idGrupo) {
        this.idGrupo = idGrupo;
    }

    public UsuarioDTO getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UsuarioDTO idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Boolean getEstatusMiembroGrupo() {
        return estatusMiembroGrupo;
    }

    public void setEstatusMiembroGrupo(Boolean estatusMiembroGrupo) {
        this.estatusMiembroGrupo = estatusMiembroGrupo;
    }

}
