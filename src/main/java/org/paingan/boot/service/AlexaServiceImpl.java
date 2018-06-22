package org.paingan.boot.service;

import java.util.List;

import org.paingan.boot.dao.AlexaRepository;
import org.paingan.boot.model.Alexa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlexaServiceImpl implements AlexaService {

	@Autowired
	private AlexaRepository alexaRepository;

	/* (non-Javadoc)
	 * @see org.paingan.boot.service.AlexaService#findAllAlexa()
	 */
	@Override
	public List<Alexa> findAllAlexa() {
		return alexaRepository.findAll();
	}


	@Override
	public List<Alexa> findAlexaById(int id) {
		return alexaRepository.findAlexaById(id);
	}
		
}
