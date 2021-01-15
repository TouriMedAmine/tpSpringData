package com.Entities;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface VehiculeCRUD extends CrudRepository<Vehicule, Integer> {
	
	@Query("select v from Vehicule v where v.codeInterne like :x and v.immatricule like :y")
	public Vehicule chercher(@Param("x")String codeInterne, @Param("y")String immatricule );
}