package org.paingan.boot.dao;

import java.util.List;

import org.paingan.boot.model.Alexa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AlexaRepository extends JpaRepository<Alexa, Long>   {
	public List<Alexa> findAllAlexa(); //TODO custom query
	
	@Query("SELECT a.date FROM Alexa a WHERE a.id =:id") 
    public List<Alexa> findAlexaById(@Param("id") int id);
}
