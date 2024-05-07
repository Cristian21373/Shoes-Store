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

import com.Examen.Shoes_Store.interfaces.IClientes;
import com.Examen.Shoes_Store.models.clientes;

@RestController
@RequestMapping("api/v1/clientes")
public class clientesController {

    @Autowired
	private IClientes clientesService;
	
	@PostMapping("/")
    public ResponseEntity<Object> save(
            
            @ModelAttribute("clientes") clientes clientes
            ){
        
        clientesService.save(clientes);
        return new ResponseEntity<>(clientes, HttpStatus.OK);
        
    }
	
	@GetMapping("/")
    public ResponseEntity<Object> findAll(){
        var ListClientes =clientesService.findAll();
        return new ResponseEntity<>(ListClientes, HttpStatus.OK);
    }
	
	@GetMapping("/{id_cliente}")
    public ResponseEntity<Object> findOne(@PathVariable("id_cliente") String id){
        var clientes = clientesService.findById(id);
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }
	
	@DeleteMapping("/{id_cliente}")
    public ResponseEntity<Object> delete(@PathVariable("id_cliente") String id_cliente){
        clientesService.deleteById(id_cliente);
        return new ResponseEntity<>("Registro Eliminado", HttpStatus.OK);
    }

    public ResponseEntity<Object> update(@PathVariable("id_cliente") String id_cliente, @ModelAttribute("clientes") clientes clientesUpdate){
	    var clientes = clientesService.findById(id_cliente).orElse(null);
	    if (clientes != null) {
	        clientes.setTipo_identificacion(clientesUpdate.getTipo_identificacion());
	        clientes.setIdentificacion(clientesUpdate.getIdentificacion());	        
	        clientes.setNombre_cliente(clientesUpdate.getNombre_cliente());
	        clientes.setApellido_cliente(clientesUpdate.getApellido_cliente());
	        clientes.setTelefono(clientesUpdate.getTelefono());
	        clientes.setDireccion(clientesUpdate.getDireccion());
	        clientes.setCiudad(clientesUpdate.getCiudad());
            clientes.setEstado(clientesUpdate.getEstado());
	        
	        clientesService.save(clientes);
	        return new ResponseEntity<>("Guardado", HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>("Error: user no encontrado", HttpStatus.BAD_REQUEST);
	    }
	}
	}

