package com.Examen.Shoes_Store.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Examen.Shoes_Store.models.productos;


@Repository
public interface IProductos extends CrudRepository<productos,String> {

}
