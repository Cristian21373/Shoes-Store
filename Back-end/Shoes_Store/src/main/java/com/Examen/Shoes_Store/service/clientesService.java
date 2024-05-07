package com.Examen.Shoes_Store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Examen.Shoes_Store.interfaceService.IClientesService;
import com.Examen.Shoes_Store.models.clientes;

@Service
public class clientesService implements IClientesService{

    @Override
    public String save(clientes clientes) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public List<clientes> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Optional<clientes> findOne(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findOne'");
    }

    @Override
    public int delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
