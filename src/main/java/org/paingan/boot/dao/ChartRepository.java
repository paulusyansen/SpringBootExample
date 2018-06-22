package org.paingan.boot.dao;

import java.util.List;

import org.paingan.boot.model.Chart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChartRepository extends JpaRepository<Chart, Long>   {
	public List<Chart> findAllChart(); //TODO custom query
}
