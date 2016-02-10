/**
 * 
 */
package com.pss.simulador.bs.repository.data;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pss.simulador.bs.domain.Saldo;

/**
 * @author pierre.obregon
 * @version 27/1/2016
 */
@Repository
public interface SaldoRepository extends CrudRepository<Saldo, Integer> {

	@Query(value = "SELECT g FROM Saldo g WHERE UPPER(g.nbNomFondo) LIKE (CONCAT('%', UPPER(:nbNomFondo) , '%'))")	
	public abstract List<Saldo> findByName(@Param("nbNomFondo") String strNombre);
	
	@Transactional
	@Modifying
	@Query(value = "delete from BBVATESOR.TSI001_SALDO i where TO_CHAR(i.FH_FEC_IMPORTA,'yyyyMMddhhmiss') != ?1 ", nativeQuery=true)
	public abstract int deleteAllByDistintoFechaImportacion(String fechaImporta);
}
