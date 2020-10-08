package com.bolsadeideas.springboot.di.app.models.service;


//@Component("miServicioSimple")
//@Primary
public class MiServicio implements IServicio{

	@Override
	public String operacion() {
		return "ejecutando algun proceso importante simple... ";
	}
	
	

}
