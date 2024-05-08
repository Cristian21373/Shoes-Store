package com.Examen.Shoes_Store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Examen.Shoes_Store.interfaceService.IVentasService;
import com.Examen.Shoes_Store.interfaces.IVentas;
import com.Examen.Shoes_Store.models.ventas;





@Service
public class ventasService implements IVentasService{
	
	@Autowired
	private IVentas data;

	@Override
	public String save(ventas ventas) {
		data.save(ventas);
		return ventas.getId();
	}

	@Override
	public List<ventas> findAll() {
		List<ventas> ListVentas=(List<ventas>) data.findAll();
		return ListVentas;
	}

	@Override
	public Optional<ventas> findOne(String id) {
		Optional<ventas> ventas=data.findById(id);
		return ventas;
	}

	@Override
	public int delete(String id) {
		data.deleteById(id);
		return 1;
	}
	
	

}
