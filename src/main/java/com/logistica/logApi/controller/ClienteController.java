package com.logistica.logApi.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logistica.logApi.model.Cliente;

@RestController
public class ClienteController {
    
    @PersistenceContext
    private EntityManager manager;

    @GetMapping("/clientes")
    public List<Cliente> listar(){
        return manager.createQuery("from Cliente", Cliente.class).getResultList();
    }
    
}
