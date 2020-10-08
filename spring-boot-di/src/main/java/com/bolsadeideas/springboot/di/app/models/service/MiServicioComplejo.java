package com.bolsadeideas.springboot.di.app.models.service;

//@Component("miServicioComplejo")
public class MiServicioComplejo implements IServicio{

	@Override
	public String operacion() {
		return "ejecutando algun proceso importante complicado... ";
	}
	
	

}
