package com.ibm.grupo2.rest;

import com.ibm.grupo2.dto.seguridad.UsuarioDTO;
import com.ibm.grupo2.service.SeguridadService;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Ana Olvera
 */
@RestController
@RequestMapping("/auth")
public class LoginREST {
    
    @Autowired
    private SeguridadService seguridadService;

    @PostMapping(value = "/usuarioRec/{correo}")
    @ResponseBody
    public Map<String, Object> recuperarPwd(@PathVariable("correo") String correo, RedirectAttributes redirectAttributes) {
        try {
            Map resultado = seguridadService.recuperarPwd(correo);
            if ((boolean) resultado.get("resultado")) {
                redirectAttributes.addFlashAttribute("mensaje", "success");
                redirectAttributes.addFlashAttribute("usr", resultado.get("usuario"));
                redirectAttributes.addFlashAttribute("pwd", resultado.get("pwd"));
            } else {
                redirectAttributes.addFlashAttribute("mensaje", "error");
                redirectAttributes.addFlashAttribute("detalle", resultado.get("excepcion"));
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensaje", "error");
        }
        return (Map<String, Object>) redirectAttributes.getFlashAttributes();
    }

    @PostMapping(value = "/login")
    @ResponseBody
    @Transactional
    public Map<String, Object>post(@Valid @RequestBody UsuarioDTO usuario, RedirectAttributes redAttr) {
        try {
            Map resultado = seguridadService.buscarUsuario(usuario);
            if((boolean) resultado.get("resultado")){
                redAttr.addFlashAttribute("mensaje", "success");
                redAttr.addFlashAttribute("token", resultado.get("usuario"));
            }else{
                redAttr.addFlashAttribute("mensaje", "error");
                redAttr.addFlashAttribute("detalle", resultado.get("error"));
            }
        } catch (Exception e) {
            redAttr.addFlashAttribute("mensaje", "error");
        }
        return (Map<String,Object>) redAttr.getFlashAttributes();
    }

}
