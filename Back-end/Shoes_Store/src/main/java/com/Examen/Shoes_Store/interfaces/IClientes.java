package com.Examen.Shoes_Store.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Examen.Shoes_Store.models.clientes;

@Repository
public interface IClientes extends CrudRepository<clientes,String> {

}
