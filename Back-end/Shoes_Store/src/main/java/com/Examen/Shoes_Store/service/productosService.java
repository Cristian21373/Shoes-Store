package com.Examen.Shoes_Store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.Examen.Shoes_Store.interfaceService.IProductosService;
import com.Examen.Shoes_Store.interfaces.IProductos;
import com.Examen.Shoes_Store.models.productos;

public class productosService implements IProductosService{

	@Autowired
	private IProductos data;
	
	@Override
	public String save(productos productos) {
		data.save(productos);
		return productos.getId();
	}

	@Override
	public List<productos> findAll() {
		List<productos> ListProductos=(List<productos>) data.findAll();
		return ListProductos;
	}

	@Override
	public Optional<productos> findOne(String id) {
		Optional<productos> productos=data.findById(id);
		return productos;
	}

	@Override
	public int delete(String id) {
		data.deleteById(id);
		return 1;
	}

}
