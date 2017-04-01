package br.ufc.carlos.controller;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		usuarioService.addOrUpdateUsuario(usuario);
		return "index";
	}
	
	@RequestMapping(value="/alterarUsuarioForm")
	public String alterarUsuarioForm(HttpSession session, Model model){
		Usuario usuLogado = (Usuario)session.getAttribute("usuario_logado");
		Usuario usuario = usuarioService.buscarUsuario(usuLogado.getIdUsuario());
		model.addAttribute("usuario", usuario);
		return "usuario/alterarUsuarioForm";
	}
	
	@RequestMapping(value="/alterarUsuario")
	public String alterarUsuario(@ModelAttribute Usuario usuario){
		usuarioService.addOrUpdateUsuario(usuario);
		return "index";
	}
	
	@RequestMapping(value="/deletarUsuarioForm")
	public String deletarUsuarioForm(Model model){
		Usuario usuario = usuarioService.buscarUsuario(1);
		model.addAttribute("usuario", usuario);
		return "usuario/deletarUsuarioForm";
	}
	
	@RequestMapping(value="/deletarUsuario")
	public String deletarUsuario(Integer idUsuario){
		usuarioService.removeUsuario(idUsuario);
		return "index";
	}
}