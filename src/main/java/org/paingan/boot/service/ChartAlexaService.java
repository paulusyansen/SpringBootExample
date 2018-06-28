package org.paingan.boot.service;

import java.util.List;

import org.paingan.boot.model.ChartAlexa;

public interface ChartAlexaService {

//	List<ChartAlexa> findAllAlexa();
//	List<ChartAlexa> findChartAlexaById(int id);
//	public List<ChartAlexa> search(String search);
	public List<ChartAlexa> searchV2(String search);
}