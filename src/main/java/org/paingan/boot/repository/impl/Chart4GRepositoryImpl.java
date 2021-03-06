package org.paingan.boot.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.paingan.boot.dto.ChartDTO;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class Chart4GRepositoryImpl{
	
	@PersistenceContext
	private EntityManager em;
	
	public List<ChartDTO> findAllChart4G() {
		
		List<ChartDTO> list = new ArrayList<ChartDTO>();
		
		String sql = "SELECT date, avg(elevenia) as elevenia, avg(tokopedia) as tokopedia, avg(shopee) as shopee, avg(lazada) as lazada, avg(blibli) as blibli FROM Chart4G WHERE show_yn = 1 GROUP BY date";
			
		List<Object[]> resultList  = em.createQuery(sql, Object[].class).getResultList();
		
		for (Object[] result : resultList) {
			ChartDTO chartDTO = new ChartDTO(result[0].toString(),Float.parseFloat(result[1].toString()),Float.parseFloat(result[2].toString()),Float.parseFloat(result[3].toString()),Float.parseFloat(result[4].toString()),Float.parseFloat(result[5].toString()));
			list.add(chartDTO);
		}
		

		return list;
	}
}
