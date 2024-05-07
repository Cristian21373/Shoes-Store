package com.Examen.Shoes_Store.interfaceService;

import java.util.List;
import java.util.Optional;

import com.Examen.Shoes_Store.models.clientes;

public interface IClientesService {
    public String save(clientes clientes);    
    public List<clientes> findAll();
    public Optional<clientes> findOne(String id);
    public int delete(String id);

}
