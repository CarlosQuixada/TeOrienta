package br.ufc.carlos.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.carlos.model.Usuario;
import br.ufc.carlos.service.UsuarioService;

@Controller
public class UsuarioController {
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping(value="/cadastrarUsuarioForm")
	public String cadastrarUsuarioTelaForm(Model model){
		Usuario usuario = new Usuario();
		model.addAttribute("usuario",usuario);
		return "usuario/cadastrarUsuarioForm";
	}
	
	@RequestMapping(value="/cadastrarUsuario")
	public String cadastrarUsuario(Usuario usuario){
		usuarioService.cadastrarUsuario(usuario);
		return "index";
	}
}