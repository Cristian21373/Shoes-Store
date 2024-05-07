package com.Examen.Shoes_Store.interfaceService;

import java.util.List;
import java.util.Optional;

import com.Examen.Shoes_Store.models.productos;



public interface IProductosService {
	
	public String save(productos productos);    
    public List<productos> findAll();
    public Optional<productos> findOne(String id);
    public int delete(String id);

}
