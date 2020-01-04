package com.fatecsp.agendafatecana.usuario.aluno.service;

import com.fatecsp.agendafatecana.repository.AlunoEntityRepository;
import com.fatecsp.agendafatecana.usuario.aluno.domain.AlunoEntity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * AlunoEntityQueryService
 */
@Service
public class AlunoEntityQueryService {
    private final Logger log = LoggerFactory.getLogger(AlunoEntityQueryService.class);

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    AlunoEntityRepository alunoRepository;

    public AlunoEntity salvarAluno(AlunoEntity e) {        
        log.debug("chamada ao queryService salvarAluno id: {}", e.getId());
        return alunoRepository.save(e);
    }

    public void deletarAluno(AlunoEntity e) {
        log.debug("chamada ao queryService deletarAluno id: {}", e.getId());
        alunoRepository.delete(e);
    }
    
    public void deletarAlunoPorId(String id) {
        log.debug("chamada ao queryService deletarAlunoPorId id: {}", id);
        alunoRepository.deleteById(id);
    }

    /**
     * Procura uma Aluno por ID
     * @param id
     * @return a AlunoEntity (RETORNA NULO SE NÃO ENCONTRAR)
     */
    public AlunoEntity recuperarPorId(String id) {        
        log.debug("chamada ao queryService recuperarPorId id: {}", id);
        return alunoRepository.findById(id).orElse(null);
    }

}