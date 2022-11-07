package com.logistica.log.domain.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logistica.log.domain.model.Entrega;
import com.logistica.log.domain.model.StatusEntrega;
import com.logistica.log.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {

    private EntregaRepository entregaRepository;

    @Transactional
    public Entrega solicitar(Entrega entrega){

        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(LocalDateTime.now());


        return entregaRepository.save(entrega);
    }
}
