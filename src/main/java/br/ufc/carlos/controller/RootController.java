package br.ufc.carlos.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.ufc.carlos.model.StatusTarefa;
import br.ufc.carlos.model.Tarefa;
import br.ufc.carlos.model.Usuario;
import br.ufc.carlos.service.UsuarioService;

@Controller
public class RootController {
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping(value="/")
	public String index(){
		return "index";
	}
	
	@RequestMapping(value="/home")
	public String home(HttpSession session,Model model){
		Usuario usuario = (Usuario) session.getAttribute("usuario_logado");
		List<Tarefa> tarefas = usuarioService.buscarUsuario(usuario.getIdUsuario()).getTarefas();
		model.addAttribute("usuario", usuario);
		model.addAttribute("tarefas", tarefas);
		model.addAttribute("TODO", StatusTarefa.TODO);
		model.addAttribute("FAZENDO", StatusTarefa.FAZENDO);
		model.addAttribute("CONCLUIDO", StatusTarefa.CONCLUIDO);
		
		return "home";
	}
	
	@RequestMapping(value="/login")
	public String login(HttpSession session,@RequestParam String nome,@RequestParam String senha){
		
		
		Usuario usuario = usuarioService.buscarUsuarioNome(nome);
		
		if(usuario== null ||!usuario.getSenha().equals(senha)){
			return "index";
		}
		
		session.setAttribute("usuario_logado", usuario);
		
		return "redirect:home";
	}
}