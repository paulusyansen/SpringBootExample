package org.paingan.boot.service;

import java.util.List;

import org.paingan.boot.model.ChartAlexa;

public interface ChartAlexaService {
	public List<ChartAlexa> search(String search);

	public ChartAlexa save(ChartAlexa chartAlexa);
}