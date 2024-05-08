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

import com.Examen.Shoes_Store.interfaces.IVentas;
import com.Examen.Shoes_Store.models.ventas;









@RestController
@RequestMapping("api/v1/ventas")
public class ventasController {
	
	@Autowired
	private IVentas ventasService;
	
	@PostMapping("/")
    public ResponseEntity<Object> save(
            
            @ModelAttribute("ventas") ventas ventas
            ){
        
        ventasService.save(ventas);
        return new ResponseEntity<>(ventas, HttpStatus.OK);
        
    }
	
	@GetMapping("/")
    public ResponseEntity<Object> findAll(){
        var ListVentas =ventasService.findAll();
        return new ResponseEntity<>(ListVentas, HttpStatus.OK);
    }
	
	@GetMapping("/{id_venta}")
    public ResponseEntity<Object> findOne(@PathVariable("id_venta") String id){
        var ventas = ventasService.findById(id);
        return new ResponseEntity<>(ventas, HttpStatus.OK);
    }
	@DeleteMapping("/{id_venta}")
    public ResponseEntity<Object> delete(@PathVariable("id_venta") String id_venta){
        ventasService.deleteById(id_venta);
        return new ResponseEntity<>("Registro Eliminado", HttpStatus.OK);
    }

    public ResponseEntity<Object> update(@PathVariable("id_venta") String id_venta, @ModelAttribute("ventas") ventas ventasUpdate){
	    var ventas = ventasService.findById(id_venta).orElse(null);
	    if (ventas != null) {
	        ventas.setCliente_id_cliente(ventasUpdate.getCliente_id_cliente());
	        ventas.setTotal(ventasUpdate.getTotal());	        
	        ventas.setEstado(ventasUpdate.getEstado());
	        ventas.setFecha_venta(ventasUpdate.getFecha_venta());
	        
	        ventasService.save(ventas);
	        return new ResponseEntity<>("Guardado", HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>("Error: user no encontrado", HttpStatus.BAD_REQUEST);
	    }
	}
	}
