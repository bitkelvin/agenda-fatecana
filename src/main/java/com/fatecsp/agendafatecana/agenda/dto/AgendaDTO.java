package com.fatecsp.agendafatecana.agenda.dto;

import java.util.List;

import com.fatecsp.agendafatecana.calendario.domain.Mes;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AgendaDTO {

	private List<Mes> meses;
	
}
