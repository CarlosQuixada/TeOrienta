package br.ufc.carlos.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@RequestMapping(value="/login")
	public String login(HttpSession session,@RequestParam String nome,@RequestParam String senha){
		
		
		Usuario usuario = usuarioService.buscarUsuarioNome(nome);
		
		if(usuario== null ||!usuario.getSenha().equals(senha)){
			return "index";
		}
		
		session.setAttribute("usuario_logado", usuario);
		
		return "home";
	}
}