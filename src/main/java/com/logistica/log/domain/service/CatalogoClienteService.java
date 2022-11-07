package com.logistica.log.domain.service;

import javax.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.logistica.log.domain.exeption.NegocioException;
import com.logistica.log.domain.model.Cliente;
import com.logistica.log.domain.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CatalogoClienteService {
    
    private ClienteRepository clienteRepository;

    @Transactional
    public Cliente salvar (Cliente cliente){
        boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail()).isPresent();

        if(emailEmUso) {
            throw new NegocioException("Já existe um cliente cadastrado com esse email");
        }
        
        return clienteRepository.save(cliente);
    }

    public void excluir (Long clienteId){
        if(!clienteRepository.existsById(clienteId)){
            ResponseEntity.notFound().build();
        }
        clienteRepository.deleteById(clienteId);
    }
}
