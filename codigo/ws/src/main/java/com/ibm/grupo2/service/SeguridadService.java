package com.ibm.grupo2.service;

import com.ibm.grupo2.dto.seguridad.GrupoDTO;
import com.ibm.grupo2.dto.seguridad.MiembroGrupoDTO;
import com.ibm.grupo2.dto.seguridad.UsuarioDTO;
import com.ibm.grupo2.dto.seguridad.UsuarioDetalleDTO;
import com.ibm.grupo2.model.seguridad.MiembroGrupo;
import com.ibm.grupo2.model.seguridad.Usuario;
import com.ibm.grupo2.model.seguridad.UsuarioDetalle;
import com.ibm.grupo2.repository.seguridad.UsuarioDetalleRepo;
import com.ibm.grupo2.repository.seguridad.UsuarioRepo;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ana Olvera
 */
@Service
public class SeguridadService {

    @Autowired
    private UsuarioRepo usuarioRepo;
    @Autowired
    private UsuarioDetalleRepo detalleRepo;
    @Autowired
    private PasswordEncoder encoder;

    public Map buscarUsuario(UsuarioDTO usuario) {
        Map respuesta = new HashMap();
        Usuario usuarioBd = new Usuario();
        try {
            usuarioBd = usuarioRepo.findUserByUsername(usuario.getNombreUsuario());
            if (usuarioBd != null) {
                if (encoder.matches(usuario.getPwdUsuario(), usuarioBd.getPwdUsuario())) {
                    if (usuarioBd.getMiembroGrupoCollection().size() > 0) {
                        UsuarioDTO usuarioDto = crearUsuarioDTO(usuarioBd);
                        respuesta.put("resultado", Boolean.TRUE);
                        respuesta.put("usuario", getJWTToken(usuarioDto));
                    } else {
                        respuesta.put("resultado", Boolean.FALSE);
                        respuesta.put("error", "El usuario no cuenta con permisos para ingresar al sistema. Consulta al administrador.");
                    }
                } else {
                    respuesta.put("resultado", Boolean.FALSE);
                    respuesta.put("error", "La contraseña no es correcta, inténtalo nuevamente.");
                }
            } else {
                respuesta.put("resultado", Boolean.FALSE);
                respuesta.put("error", "El usuario no existe, favor de verificar.");
            }
        } catch (Exception e) {
            respuesta.put("resultado", Boolean.FALSE);
            respuesta.put("error", e.getClass().getCanonicalName());
        }
        return respuesta;
    }
    
    public Map recuperarPwd(String correo) {
        Map respuesta = new HashMap();
        UsuarioDetalle usuarioNuevo = new UsuarioDetalle();
        try {
            usuarioNuevo = detalleRepo.findUsuario(correo);
            if (usuarioNuevo != null) {
                respuesta = passwordGenerator();
                usuarioNuevo.getUsuario().setPwdUsuario((String) respuesta.get("password_encriptado"));
                usuarioNuevo.setUsuario(this.usuarioRepo.save(usuarioNuevo.getUsuario()));
                respuesta.put("resultado", true);
                respuesta.put("usuario", usuarioNuevo.getCorreoUsuarioDetalle());
                respuesta.put("pwd", respuesta.get("password"));
            } else {
                respuesta.put("resultado", false);
                respuesta.put("excepcion", "No existe el usuario");
            }
        } catch (Exception e) {
            respuesta.put("resultado", false);
            respuesta.put("excepcion", e.getClass().getCanonicalName());
            System.out.println("Error en metodo recuperar contraseña");
        }
        return respuesta;
    }
    
    private String getJWTToken(UsuarioDTO username) {
        String secretKey = "grupo2SecretKey";
        List<String> roles = new ArrayList<>();
        username.getMiembrosGrupoCollection().forEach((gm) -> {
            roles.add(gm.getIdGrupo().getNombreGrupo());
        });
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList(roles.stream()
                        .collect(Collectors.joining(",")));
        String token;
        token = Jwts
                .builder()
                .setId("grupo2JWT")
                .setSubject(username.toString())
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1800000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }

    public List<UsuarioDTO> findAll(){
        List<Usuario> listabd =  (List<Usuario>) usuarioRepo.findAll();
        List<UsuarioDTO> resultado = new ArrayList<>();
        listabd.forEach((usuario)-> {
            resultado.add(crearUsuarioDTO(usuario));
        });

        return resultado;
    }

    private UsuarioDTO crearUsuarioDTO(Usuario usuarioBD) {
        UsuarioDTO respuesta = new UsuarioDTO();
        List<MiembroGrupoDTO> listaPerfiles = new ArrayList<>();
        usuarioBD.getMiembroGrupoCollection().stream().map((mg) -> {
            MiembroGrupoDTO dto = new MiembroGrupoDTO(mg.getIdMiembroGrupo());
            dto.setIdGrupo(new GrupoDTO(mg.getIdGrupo().getIdGrupo(), mg.getIdGrupo().getNombreGrupo()));
            return dto;
        }).forEachOrdered((dto) -> {
            listaPerfiles.add(dto);
        });
        respuesta.setIdUsuarioDetalle(crearUsuarioDetalleDTO(usuarioBD.getIdUsuarioDetalle()));
        respuesta.setMiembrosGrupoCollection(listaPerfiles);
        respuesta.setEstatusUsuario(usuarioBD.getEstatusUsuario());
        respuesta.setFechaRegistroUsuario(usuarioBD.getFechaRegistroUsuario());
        respuesta.setFechaBajaUsuario(usuarioBD.getFechaBajaUsuario());
        respuesta.setIdUsuario(usuarioBD.getIdUsuario());
        respuesta.setNombreUsuario(usuarioBD.getNombreUsuario());
        respuesta.setPwdUsuario(usuarioBD.getPwdUsuario());
        return respuesta;
    }

    private UsuarioDetalleDTO crearUsuarioDetalleDTO(UsuarioDetalle usuarioBD) {
        UsuarioDetalleDTO respuesta = new UsuarioDetalleDTO();
        respuesta.setIdUsuarioDetalle(usuarioBD.getIdUsuarioDetalle());
        respuesta.setNombreUsuarioDetalle(usuarioBD.getNombreUsuarioDetalle());
        respuesta.setApellido1UsuarioDetalle(usuarioBD.getApellido1UsuarioDetalle());
        respuesta.setCorreoUsuarioDetalle(usuarioBD.getCorreoUsuarioDetalle());
        respuesta.setEstatusUsuarioDetalle(usuarioBD.getEstatusUsuarioDetalle());
        return respuesta;
    }
    
    public Map passwordGenerator() {

        Map respuesta = new HashMap();
        String NUMEROS = "23456789";
        String MAYUSCULAS = "ABCDEFGHJKMNPQRSTUVWXYZ";
        String MINUSCULAS = "abcdefghjkmnpqrstuvwxyz";
        String ESPECIALES = "ñÑ*@";
        String key = NUMEROS + MINUSCULAS + ESPECIALES;
        String pwd = "";

        for (int i = 0; i < 6; i++) {
            pwd += (key.charAt((int) (Math.random() * key.length())));
        }
        respuesta.put("password", pwd);
        respuesta.put("password_encriptado", encoder.encode(pwd));

        return respuesta;

    }

}
