package com.bolsadeideas.springboot.error.app.controllers;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bolsadeideas.springboot.error.app.errors.UsuarioNoEncontradoException;

//Maneja erores
@ControllerAdvice 
public class ErrorHandlerController {
	
	@ExceptionHandler(ArithmeticException.class)
	public String aritmeticaError(ArithmeticException ex, Model  model) {
		model.addAttribute("error", "Error de aritmética"); 
		model.addAttribute("message", ex.getMessage()); 
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date()); 
		return "error/generica"; 
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public String numberError(NumberFormatException ex, Model  model) {
		model.addAttribute("error", "¡Formato número inválido!"); 
		model.addAttribute("message", ex.getMessage()); 
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date()); 
		return "error/number"; 
	}
	
	@ExceptionHandler(UsuarioNoEncontradoException.class)
	public String numberError(UsuarioNoEncontradoException ex, Model  model) {
		model.addAttribute("error", "¡Usuario no encontrado!"); 
		model.addAttribute("message", ex.getMessage()); 
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date()); 
		return "error/generica"; 
	}
	
}
