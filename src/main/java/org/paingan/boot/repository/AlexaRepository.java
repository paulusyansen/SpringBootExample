package org.paingan.boot.repository;

import java.util.List;

import org.paingan.boot.domain.Alexa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AlexaRepository extends JpaRepository<Alexa, Long>, JpaSpecificationExecutor<Alexa>    {
	public List<Alexa> findAllAlexa(); //TODO custom query
	
	public List<Alexa> findBySite(@Param("site") String site);
	
	@Query("SELECT a.date FROM Alexa a WHERE a.id =:id") 
    public List<Alexa> findAlexaById(@Param("id") int id);
}
