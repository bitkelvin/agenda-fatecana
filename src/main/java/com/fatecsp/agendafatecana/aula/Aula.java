package com.fatecsp.agendafatecana.aula;

import java.time.LocalDateTime;
import java.util.List;

import com.fatecsp.agendafatecana.evento.Evento;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "aula_entity")
public class Aula {

	private String id;
	private LocalDateTime inicio;
	private LocalDateTime fim;
	private boolean isPresencial;
	private List<Evento> eventos; 
	
}
