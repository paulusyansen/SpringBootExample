package org.paingan.boot.service;

import java.util.List;

import org.paingan.boot.domain.ChartAlexa;

public interface ChartAlexaService {
	
	/**
	 * 
	 * @param search
	 * @return
	 */
	public List<ChartAlexa> search(String search);

	/**
	 * 
	 * @param chartAlexa
	 * @return
	 */
	public ChartAlexa save(ChartAlexa chartAlexa);
	
	/**
	 * 
	 * @param search
	 * @return
	 */
	public List<ChartAlexa> findAll();
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public ChartAlexa findAlexaByid(Long id);
}