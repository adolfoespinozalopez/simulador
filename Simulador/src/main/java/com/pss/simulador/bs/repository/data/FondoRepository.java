/**
 * 
 */
package com.pss.simulador.bs.repository.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pss.simulador.bs.domain.Fondo;

/**
 * @author pierre.obregon
 * @version 25/1/2016
 */
@Repository
public interface FondoRepository extends CrudRepository<Fondo, Integer> {

	@Query(value = "SELECT g FROM Fondo g WHERE g.nbNomFondo LIKE (CONCAT('%', :nombFondo , '%'))")	
	public abstract Fondo findByName(@Param("nombFondo") String nombFondo);

}
