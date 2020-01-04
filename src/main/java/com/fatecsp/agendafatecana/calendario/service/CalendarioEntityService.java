package com.fatecsp.agendafatecana.calendario.service;

import com.fatecsp.agendafatecana.calendario.domain.CalendarioEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * CalendarioEntityService
 */
@Service
public class CalendarioEntityService {

    @Autowired
    CalendarioEntityQueryService calendarioQueryService;

    @Transactional
    public CalendarioEntity salvarCalendario(CalendarioEntity e) {
        if (e.getId() != null) throw new RuntimeException("A entidade não pode conter um ID");
        return calendarioQueryService.salvarCalendario(e);
    }

    @Transactional
    public CalendarioEntity atualizarCalendario(CalendarioEntity e) {
        if (e.getId() != null) throw new RuntimeException("A entidade não pode ter id nulo");
        return calendarioQueryService.salvarCalendario(e);
    }

    @Transactional
    public CalendarioEntity deletarCalendario(CalendarioEntity e) {
        calendarioQueryService.deletarCalendario(e);
        return e;
    }

    @Transactional
    public void deletarCalendarioPorId(String id) {
        calendarioQueryService.deletarCalendarioPorId(id);
    }
}