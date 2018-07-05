package org.paingan.boot.service;

import java.util.List;

import org.paingan.boot.dto.ChartDTO;
import org.paingan.boot.model.Chart4G;
import org.paingan.boot.repository.Chart4GRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Chart4GServiceImpl implements Chart4GService {

	@Autowired
	private Chart4GRepository chart4GRepository;
	
	public List<ChartDTO> findAllChart4G() {
		return chart4GRepository.findAllChart4G();
	}

	public List<Chart4G> findAll() {
		return chart4GRepository.findAll();
	}
}
