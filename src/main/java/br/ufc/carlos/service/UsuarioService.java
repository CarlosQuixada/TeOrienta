package br.ufc.carlos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.carlos.model.Usuario;
import br.ufc.carlos.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository usuarioRepository;

	public void addOrUpdateUsuario(Usuario usuario) {
		this.usuarioRepository.save(usuario);
	}
	
	public Usuario buscarUsuario(Integer id) {
		return this.usuarioRepository.findOne(id);
	}
	
	public void removeUsuario(Integer idUsuario){
		usuarioRepository.delete(idUsuario);
	}
	
	public Usuario buscarUsuarioNome(String nome) {
		return this.usuarioRepository.findUsuarioByNome(nome);
	}
}

