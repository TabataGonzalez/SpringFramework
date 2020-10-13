package com.bolsadeideas.springboot.error.app.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.bolsadeideas.springboot.error.app.models.domain.Usuario;

@Service
public class UsuarioServiceImplements implements UsuarioService {

	private List<Usuario> lista; 
	
	public UsuarioServiceImplements() {
		this.lista = Arrays.asList(
				new Usuario(1,"Andres", "Guzman"), 
				new Usuario(2,"Andres1", "Guzman1"), 
				new Usuario(3,"Andres2", "Guzman2"),
				new Usuario(4,"Andres3", "Guzman3"), 
				new Usuario(5,"Andres4", "Guzman4"), 
				new Usuario(6,"Andres5", "Guzman5"),
				new Usuario(7,"Andres6", "Guzman6")); 
	}

	@Override
	public List<Usuario> listar() {
		return this.lista;
	}

	@Override
	public Usuario obtenerPorId(Integer id) {
		Usuario resultado = null; 
		for(Usuario u:this.lista) {
			if (u.getId().equals(id)) {
				resultado = u; 
				break; 
			}
		}
		return resultado;
	}

	@Override
	public Optional<Usuario> obtenerPorIdOptional(Integer id) {
		Usuario usuario = this.obtenerPorId(id); 
		return Optional.ofNullable(usuario);
	}

}
