package org.paingan.boot.service;

import java.util.List;

import org.paingan.boot.dao.ChartRepository;
import org.paingan.boot.model.Chart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChartServiceImpl implements ChartService {

	@Autowired
	private ChartRepository chartRepository;

	/* (non-Javadoc)
	 * @see org.paingan.boot.service.ChartService#findAllChart()
	 */
//	@Override
//	public List<Chart> findAllChart() {
//		return chartRepository.findAllChart();
//	}
		
}
