package com.ibm.grupo2.rest;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ibm.grupo2.model.productos.Producto;
import com.ibm.grupo2.service.ProductoService;

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
	
	@PostMapping("/nuevo")
    @ResponseBody
    public Map<String, Object>guardaProducto(@Valid @RequestBody Producto producto, File archivo, @RequestParam("file") MultipartFile imagen, RedirectAttributes redAttr){
		log.info("File " + imagen);
		//try {
		/*
		 * String imagen = producto.getUrlImagen(); if(!imagen.isEmpty()) { String
		 * rootPath = env.getProperty("imagen.producto");
		 * 
		 * byte[] bytes = imagen.getBytes(); Path rutaCompleta = Paths.get(rootPath +
		 * "//" + imagen.getOriginalFilename()); Files.write(rutaCompleta, bytes);
		 * //redAttr.addFlashAttribute("info", "Has subido correctamente '" +
		 * imagen.getOriginalFilename() + "'");
		 * producto.setUrlImagen(rutaCompleta.toString()); }
		 */
			 
			
			
			/*
			 * Map resultado = (Map) productoService.crearProducto(producto); if((boolean)
			 * resultado.get("resultado")){ redAttr.addFlashAttribute("mensaje", "success");
			 * redAttr.addFlashAttribute("producto", resultado); }else{
			 * redAttr.addFlashAttribute("mensaje", "error");
			 * redAttr.addFlashAttribute("detalle", resultado.get("error")); } } catch
			 * (Exception e) { redAttr.addFlashAttribute("mensaje", "error"); }
			 */
		
			 log.info("Producto " + producto);
			 //log.info("imagen " + imagen);
        
        return (Map<String,Object>) redAttr.getFlashAttributes();
    }
}
