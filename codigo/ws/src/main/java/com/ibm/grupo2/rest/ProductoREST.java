package com.ibm.grupo2.rest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ibm.grupo2.model.productos.Categoria;
import com.ibm.grupo2.model.productos.Producto;
import com.ibm.grupo2.service.ProductoService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Nora Alvarez
 */
@RestController
@RequestMapping("/prod")
public class ProductoREST {

    @Autowired
    private ProductoService productoService;
    @Autowired
    private Environment env;
    private final Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("productos")
    public ResponseEntity<List<Producto>> listaProductos() {
        try {
            List<Producto> producto = new ArrayList<Producto>();
            producto = (List<Producto>) productoService.listaProductos();

            if (producto.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(producto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(value = "/guardar")
    @ResponseBody
    public Map<String, Object> guardar(@Valid @RequestBody Producto producto, RedirectAttributes redAttr) {

        try {
            ResponseEntity resultado = productoService.crearProducto(producto);
            resultado.getStatusCode().value();
            if (resultado.getStatusCode().value() == 201) {
                redAttr.addFlashAttribute("mensaje", "success");
                redAttr.addFlashAttribute("producto", resultado);
            } else {
                redAttr.addFlashAttribute("mensaje", "error");
                redAttr.addFlashAttribute("detalle", resultado.getStatusCode());
            }
        } catch (Exception e) {
            redAttr.addAttribute("mensaje", "error");
        }
        return (Map<String, Object>) redAttr.getFlashAttributes();
    }

    @PostMapping(value = "upload")
    public Map<String, Object> upload(@RequestParam("file") MultipartFile file, RedirectAttributes redAttr) {
        String rootPath = env.getProperty("imagen.producto");

        try {
            if (!file.isEmpty()) {
                File directorio = new File(rootPath);
                if (!directorio.exists()) {
                    directorio.mkdirs();
                }

                byte[] bytes;
                bytes = file.getBytes();
                Path rutaCompleta = Paths.get(rootPath + "//" + file.getOriginalFilename());
                Files.write(rutaCompleta, bytes);
                redAttr.addFlashAttribute("mensaje", "success");
                redAttr.addFlashAttribute("info", "Has subido correctamente " + file.getOriginalFilename());
            }
        } catch (IOException e) {
            e.printStackTrace();
            redAttr.addFlashAttribute("error", "Error al subir el archivo");
        }
        return (Map<String, Object>) redAttr.getFlashAttributes();
    }

}
