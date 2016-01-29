/**
 * 
 */
package com.pss.simulador.bs.repository.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pss.simulador.bs.domain.Saldo;

/**
 * @author pierre.obregon
 * @version 27/1/2016
 */
@Repository
public interface SaldoRepository extends CrudRepository<Saldo, Integer> {

	@Query(value = "SELECT g FROM Saldo g WHERE UPPER(g.nbNomFondo) LIKE (CONCAT('%', UPPER(:nbNomFondo) , '%'))")	
	public abstract List<Saldo> findByName(@Param("nbNomFondo") String strNombre);
	
}
