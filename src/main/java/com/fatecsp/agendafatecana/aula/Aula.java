package com.fatecsp.agendafatecana.aula;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fatecsp.agendafatecana.evento.Evento;
import com.querydsl.core.annotations.QueryEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "aula_entity")
@QueryEntity
public class Aula {

	private String codigoMateria;
	private String id;
	private LocalDateTime inicio;
	private LocalDateTime fim;
	private boolean isPresencial;
	private List<Evento> eventos;
	
	//cada periodo tem 55min
	private Integer periodos;
	
}
