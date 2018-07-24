package org.paingan.boot.service;

import java.util.List;

import org.paingan.boot.domain.Chart4G;
import org.paingan.boot.dto.ChartDTO;
import org.paingan.boot.repository.Chart4GRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Chart4GServiceImpl implements Chart4GService {

	@Autowired
	private Chart4GRepository chart4GRepository;
	
	/*
	 * (non-Javadoc)
	 * @see org.paingan.boot.service.Chart4GService#findAllChart4G()
	 */
	public List<ChartDTO> findAllChart4G() {
		return chart4GRepository.findAllChart4G();
	}

	/*
	 * (non-Javadoc)
	 * @see org.paingan.boot.service.Chart4GService#findAll()
	 */
	public List<Chart4G> findAll() {
		return chart4GRepository.findAll();
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.paingan.boot.service.Chart4GService#save(org.paingan.boot.domain.Chart4G)
	 */
	public Chart4G save(Chart4G chart4G) {
		return chart4GRepository.save(chart4G);
	}
}
