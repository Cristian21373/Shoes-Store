package com.Examen.Shoes_Store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Examen.Shoes_Store.interfaceService.IClientesService;
import com.Examen.Shoes_Store.interfaces.IClientes;
import com.Examen.Shoes_Store.models.clientes;

@Service
public class clientesService implements IClientesService{
	
	@Autowired
	private IClientes data;

	@Override
	public String save(clientes clientes) {
		data.save(clientes);
		return clientes.getId();
	}

	@Override
	public List<clientes> findAll() {
		List<clientes> ListClientes=(List<clientes>) data.findAll();
		return ListClientes;
	}

	@Override
	public Optional<clientes> findOne(String id) {
		Optional<clientes> clientes=data.findById(id);
		return clientes;
	}

	@Override
	public int delete(String id) {
		data.deleteById(id);
		return 1;
	}
	
   

}
