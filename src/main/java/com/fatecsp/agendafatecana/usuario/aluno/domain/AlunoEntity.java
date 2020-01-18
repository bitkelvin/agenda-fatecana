package com.fatecsp.agendafatecana.usuario.aluno.domain;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fatecsp.agendafatecana.evento.Evento;
import com.fatecsp.agendafatecana.usuario.Usuario;
import com.fatecsp.agendafatecana.usuario.aluno.Falta;
import com.fatecsp.agendafatecana.usuario.aluno.Nota;
import com.querydsl.core.annotations.QueryEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * AlunoEntity
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Document(collection = "aluno_entity")
@QueryEntity
public class AlunoEntity extends Usuario{

    private String matricula;
    private String idCurso;
    private LocalDate dataInicioCurso;
    private List<Evento> eventos;
    private List<String> materias;
    private List<Nota> notas;
    private List<Falta> faltas;
}