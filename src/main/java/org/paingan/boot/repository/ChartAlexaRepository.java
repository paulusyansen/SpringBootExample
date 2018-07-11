package org.paingan.boot.repository;

import org.paingan.boot.model.ChartAlexa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ChartAlexaRepository extends JpaRepository<ChartAlexa, Long>, JpaSpecificationExecutor<ChartAlexa>    {
//	@Query("SELECT a.date FROM chart_alexa a WHERE a.id =:id") 
//    public List<ChartAlexa> findChartAlexaById(@Param("id") int id);
}
