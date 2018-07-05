package org.paingan.boot.service;

import java.util.List;

import org.paingan.boot.dto.ChartDTO;
import org.paingan.boot.model.Chart4G;

public interface Chart4GService {
	public List<ChartDTO> findAllChart4G();
	public List<Chart4G> findAll();
}
