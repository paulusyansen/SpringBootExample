package org.paingan.boot.service;

import java.util.List;

import org.paingan.boot.dto.ChartDTO;
import org.paingan.boot.model.Chart4G;

public interface Chart4GService {
	
	/**
	 * 
	 * @return
	 */
	public List<ChartDTO> findAllChart4G();
	
	/**
	 * 
	 * @return
	 */
	public List<Chart4G> findAll();
	
	/**
	 * 
	 * @param chart4G
	 * @return
	 */
	public Chart4G save(Chart4G chart4G);
}
