package com.logistica.log.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.logistica.log.domain.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
    List<Cliente> findByNomeContaining(String nome);
    Optional<Cliente> findByEmail(String email);
}
