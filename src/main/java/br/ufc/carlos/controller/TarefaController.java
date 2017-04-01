package br.ufc.carlos.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.carlos.model.Tarefa;
import br.ufc.carlos.model.Usuario;
import br.ufc.carlos.service.TarefaService;

@Controller
public class TarefaController {
	@Autowired
	TarefaService tarefaService;

	@RequestMapping(value = "/cadastrarTarefaForm")
	public String cadastrarTarefaForm() {
		return "tarefa/cadastrarTarefaForm";
	}

	@RequestMapping(value = "/cadastrarTarefa")
	public String cadastrarTarefa(HttpSession session, Tarefa tarefa) {
		Usuario usuario = (Usuario) session.getAttribute("usuario_logado");
		tarefa.setUsuario(usuario);
		tarefaService.addOrUpdateUsuario(tarefa);
		return "home";
	}
}
