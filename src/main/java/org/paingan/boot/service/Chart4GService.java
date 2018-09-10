package org.paingan.boot.service;

import java.util.List;

import org.paingan.boot.domain.Chart4G;
import org.paingan.boot.dto.ChartDTO;

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
	
	/**
	 * 
	 * @param search
	 * @return
	 */
	public List<Chart4G> search(String search);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Chart4G findChart4GById(int id);
}
