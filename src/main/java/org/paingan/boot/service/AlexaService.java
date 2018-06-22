package org.paingan.boot.service;

import java.util.List;

import org.paingan.boot.model.Alexa;

public interface AlexaService {

	List<Alexa> findAllAlexa();
	List<Alexa> findAlexaById(int id);
}