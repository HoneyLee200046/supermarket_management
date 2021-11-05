package com.ibm.grupo2.rest;

import com.ibm.grupo2.dto.seguridad.UsuarioDTO;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Ana Olvera
 */
@RestController
@RequestMapping("/auth")
public class LoginREST {

    @GetMapping()
    public String list() {
        return "Hola";
    }

    @GetMapping("/{id}")
    public Object get(@PathVariable String id) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Object input) {
        return null;
    }

    @PostMapping(value = "/login")
    @ResponseBody
    public Map<String, Object>post(@Valid @RequestBody UsuarioDTO usuario, RedirectAttributes redAttr) {
        try {
            redAttr.addFlashAttribute("mensaje", "success");
            redAttr.addFlashAttribute("usuario", "Aquí va un valor");
            redAttr.addFlashAttribute("token", "Aquí va otro valor");
        } catch (Exception e) {
            redAttr.addFlashAttribute("mensaje", "error");
        }
        return (Map<String,Object>) redAttr.getFlashAttributes();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return null;
    }

}
