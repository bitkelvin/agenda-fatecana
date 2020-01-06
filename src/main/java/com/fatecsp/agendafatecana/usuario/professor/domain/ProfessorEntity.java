package com.fatecsp.agendafatecana.usuario.professor.domain;

import java.util.List;

import com.fatecsp.agendafatecana.enumerated.DepartamentoEnum;
import com.fatecsp.agendafatecana.evento.Evento;
import com.fatecsp.agendafatecana.materia.domain.MateriaEntity;
import com.fatecsp.agendafatecana.usuario.Usuario;
import com.querydsl.core.annotations.QueryEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * ProfessorEntity
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@QueryEntity
public class ProfessorEntity extends Usuario {

    private DepartamentoEnum departamento;
    private List<Evento> eventos;
    private List<MateriaEntity> materias;
    
}