package com.Examen.Shoes_Store.interfaceService;

import java.util.List;
import java.util.Optional;

import com.Examen.Shoes_Store.models.ventas;






public interface IVentasService {
	
	public String save(ventas ventas);    
    public List<ventas> findAll();
    public Optional<ventas> findOne(String id);
    public int delete(String id);

}
