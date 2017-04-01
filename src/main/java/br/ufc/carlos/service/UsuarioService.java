package br.ufc.carlos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.carlos.model.Usuario;
import br.ufc.carlos.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository usuarioRepository;

	public void cadastrarUsuario(Usuario usuario) {
		this.usuarioRepository.save(usuario);
	}
}

