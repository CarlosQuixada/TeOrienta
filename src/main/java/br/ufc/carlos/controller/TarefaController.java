package br.ufc.carlos.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.ufc.carlos.model.StatusTarefa;
import br.ufc.carlos.model.Tarefa;
import br.ufc.carlos.model.Usuario;
import br.ufc.carlos.service.TarefaService;
import br.ufc.carlos.service.UsuarioService;

@Controller
public class TarefaController {
	@Autowired
	TarefaService tarefaService;
	@Autowired
	UsuarioService usuarioService;

	@RequestMapping(value = "/cadastrarTarefaForm")
	public String cadastrarTarefaForm(Model model) {
		return "tarefa/cadastrarTarefaForm";
	}

	@RequestMapping(value = "/cadastrarTarefa")
	public String cadastrarTarefa(HttpSession session, Tarefa tarefa) {
		Usuario usuario = (Usuario) session.getAttribute("usuario_logado");
		tarefa.setUsuario(usuario);
		tarefa.setStatus(StatusTarefa.TODO);
		tarefaService.addOrUpdateUsuario(tarefa);
		return "redirect:home";
	}
	
	@RequestMapping(value="/listarTarefa")
	public String listarTarefa(HttpSession session,Model model){
		Usuario usuLogado = (Usuario) session.getAttribute("usuario_logado");
		Usuario usuario = usuarioService.buscarUsuario(usuLogado.getIdUsuario());
		List<Tarefa> tarefas = usuario.getTarefas();
		model.addAttribute("tarefas", tarefas);
		return "tarefa/listarTarefa";
	}
	
	@RequestMapping(value="/alterarTarefaForm/{idTarefa}", method=RequestMethod.GET)
	public String alterarUsuarioForm(@PathVariable Integer idTarefa,Model model){
		Tarefa tarefa = tarefaService.buscarTarefa(idTarefa);
		model.addAttribute("tarefa", tarefa);
		return "tarefa/alterarTarefaForm";
	}
	
	@RequestMapping(value="/alterarTarefa")
	public String alterarUsuario(@ModelAttribute Tarefa tarefa){
		tarefaService.addOrUpdateUsuario(tarefa);
		return "redirect:listarTarefa";
	}
	
	@RequestMapping(value = "/excluirTarefa/{idTarefa}", method = RequestMethod.GET)
	public String excluirAtividade(@PathVariable Integer idTarefa,Model model,HttpSession session) {
		tarefaService.removeTarefa(idTarefa);
		Usuario usuario = (Usuario) session.getAttribute("usuario_logado");
		model.addAttribute("usuario", usuario);
		return "home";
	}

}
