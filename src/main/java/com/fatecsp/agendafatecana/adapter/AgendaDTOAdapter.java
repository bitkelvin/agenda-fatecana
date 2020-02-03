package com.fatecsp.agendafatecana.adapter;

import java.util.List;

import org.springframework.util.CollectionUtils;

import com.fatecsp.agendafatecana.agenda.dto.AgendaDTO;
import com.fatecsp.agendafatecana.calendario.domain.CalendarioEntity;
import com.fatecsp.agendafatecana.materia.domain.MateriaEntity;
import com.fatecsp.agendafatecana.usuario.aluno.domain.AlunoEntity;

public class AgendaDTOAdapter {

	public static AgendaDTO toAgendaAluno(AlunoEntity aluno, List<MateriaEntity> materias, CalendarioEntity calendario) {
		if (!CollectionUtils.isEmpty(aluno.getEventos())) {
			aluno.getEventos().stream().filter(e -> {
				int inicio = calendario.getSemestre() == 1 ? 1 : 7;
				int fim = calendario.getSemestre() == 1 ? 6 : 12;
				return e.getInicio().getMonthValue() >= inicio && e.getInicio().getMonthValue() <= fim;
			}).forEach(evento -> {
				Integer mes = evento.getInicio().getMonthValue();
				Integer dia = evento.getInicio().getDayOfMonth();
				calendario.getMeses().stream()
								.filter(m -> m.getMes().ordinal()+1 == mes)
								.findAny()
								.get()
								.getDias()
								.stream()
								.filter(d -> d.getDia() == dia)
								.findAny()
								.get()
								.getEventos()
								.add(evento);
			});
		}
		if (!CollectionUtils.isEmpty(materias)) {
			for (MateriaEntity materia : materias) {
				if (!CollectionUtils.isEmpty(materia.getEventos())) {
					materia.getEventos().stream()
						.forEach(evento -> {
							Integer mes = evento.getInicio().getMonthValue();
							Integer dia = evento.getInicio().getDayOfMonth();
							calendario.getMeses().stream()
											.filter(m -> m.getMes().ordinal()+1 == mes)
											.findAny()
											.get()
											.getDias()
											.stream()
											.filter(d -> d.getDia() == dia)
											.findAny()
											.get()
											.getEventos()
											.add(evento);
						});
				}
				if (!CollectionUtils.isEmpty(materia.getAulas())) {
					materia.getAulas().stream()
						.forEach(aula -> {
							Integer mes = aula.getInicio().getMonthValue();
							Integer dia = aula.getInicio().getDayOfMonth();
							calendario.getMeses().stream()
											.filter(m -> m.getMes().ordinal()+1 == mes)
											.findAny()
											.get()
											.getDias()
											.stream()
											.filter(d -> d.getDia() == dia)
											.findAny()
											.get()
											.getAulas()
											.add(aula);
						});
				}
			}	
			
		}
		
		
		return AgendaDTO.builder().meses(calendario.getMeses()).build();
		
	}
	
}
