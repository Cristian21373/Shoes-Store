package com.Examen.Shoes_Store.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Examen.Shoes_Store.interfaces.IProductos;
import com.Examen.Shoes_Store.models.productos;



@RestController
@RequestMapping("api/v1/productos")
public class productosController {
	
	@Autowired
	private IProductos productosService;
	
	@PostMapping("/")
    public ResponseEntity<Object> save(
            
            @ModelAttribute("productos") productos productos
            ){
        
        productosService.save(productos);
        return new ResponseEntity<>(productos, HttpStatus.OK);
        
    }
	
	@GetMapping("/")
    public ResponseEntity<Object> findAll(){
        var ListProductos =productosService.findAll();
        return new ResponseEntity<>(ListProductos, HttpStatus.OK);
    }
	
	@GetMapping("/{id_productos}")
    public ResponseEntity<Object> findOne(@PathVariable("id_producto") String id){
        var productos = productosService.findById(id);
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }
	
	@DeleteMapping("/{id_productos}")
    public ResponseEntity<Object> delete(@PathVariable("id_producto") String id_producto){
        productosService.deleteById(id_producto);
        return new ResponseEntity<>("Registro Eliminado", HttpStatus.OK);
    }

    public ResponseEntity<Object> update(@PathVariable("id_producto") String id_producto, @ModelAttribute("productos") productos productosUpdate){
	    var productos = productosService.findById(id_producto).orElse(null);
	    if (productos != null) {
	        productos.setNombre_producto(productosUpdate.getNombre_producto());
	        productos.setDescripcion(productosUpdate.getDescripcion());	        
	        productos.setCantidad(productosUpdate.getCantidad());
	        productos.setPrecio(productosUpdate.getPrecio());
	        productos.setPorcentaje_descuento(productosUpdate.getPorcentaje_descuento());
	        productos.setPorcentaje_descuento(productosUpdate.getPorcentaje_descuento());
            productos.setEstado(productosUpdate.getEstado());
	        
	        productosService.save(productos);
	        return new ResponseEntity<>("Guardado", HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>("Error: user no encontrado", HttpStatus.BAD_REQUEST);
	    }
	
}}
