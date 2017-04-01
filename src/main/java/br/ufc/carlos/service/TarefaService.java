package br.ufc.carlos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.carlos.model.Tarefa;
import br.ufc.carlos.repository.TarefaRepository;

@Service
public class TarefaService {
	@Autowired
	TarefaRepository tarefaRepository;

	public void addOrUpdateUsuario(Tarefa tarefa) {
		this.tarefaRepository.save(tarefa);
	}
}
