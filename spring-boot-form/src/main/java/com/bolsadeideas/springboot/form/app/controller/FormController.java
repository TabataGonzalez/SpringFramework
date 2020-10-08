package com.bolsadeideas.springboot.form.app.controller;



import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bolsadeideas.springboot.form.app.models.domain.Usuario;

@Controller 
@SessionAttributes("usuario")
public class FormController {

	@GetMapping("/form")
	public String form (Model  model) {
		Usuario usuario = new Usuario(); 
		usuario.setNombre("John");
		usuario.setApellido("DOE");
		usuario.setIdentificador("123.146-k");
		model.addAttribute("titulo","Formulario usuarios"); 
		model.addAttribute("usuario", usuario); 
		
		return("form");
	}
	
	@PostMapping("/form")
	public String procesar(@Valid Usuario usuario,BindingResult  result, Model model, SessionStatus status) {
		
		model.addAttribute("titulo","Resultado form"); 
		
		if (result.hasErrors()) {
			/*Map <String, String> errores = new HashMap<>(); 
			result.getFieldErrors().forEach(err -> {
				errores.put(err.getField(), "El campo ".concat(err.getField().concat(" ").concat(err.getDefaultMessage()))); 
			});
			model.addAttribute("error", errores); */
			return "form"; //Te regresa a la vista form si hay errores. 
		}
		
		model.addAttribute("usuario", usuario); 
		status.setComplete();
		return "resultado"; 
	}
	
}
