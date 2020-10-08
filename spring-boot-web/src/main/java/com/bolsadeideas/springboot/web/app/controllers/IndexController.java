package com.bolsadeideas.springboot.web.app.controllers;



import java.util.Arrays;
import java.util.List;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import com.bolsadeideas.springboot.web.app.models.Usuario;


@Controller
@RequestMapping("/app")
public class IndexController {
	
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil; 
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar; 
	
	@GetMapping({"/index","/", "/home"})
	public String index(Model model) {
		model.addAttribute("titulo",textoIndex);
		return "index"; 
	}
	
	@RequestMapping("/perfil")
	public String prefil(Model model) {
		
		Usuario usuario = new Usuario(); 
		usuario.setNombre("Andres");
		usuario.setApellido("Guzmán");
		usuario.setEmail("andres@correo.com");
		
		model.addAttribute("usuario", usuario); 
		model.addAttribute("titulo",textoPerfil.concat(usuario.getNombre()));
		
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo",textoListar);
		return "listar"; 
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		List<Usuario>usuarios = Arrays.asList(new Usuario("Andres","Guzman","andres@correo.com"),
				new Usuario("Juanito","Doe","juanito@correo.com"),
				new Usuario("Panchita","Doe","panchita@correo.com"),
				new Usuario("Tornado","Roe", "tornado@correo.com")); 
		return usuarios; 
	}
	
}
