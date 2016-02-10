package com.pss.simulador.bs.repository.data;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pss.simulador.bs.domain.CobranzaPago;

/**
 * @author pierre.obregon
 * @version 7/2/2016
 */
@Repository
public interface CobranzaPagoRepository extends CrudRepository<CobranzaPago, Integer> {

	@Transactional
	@Modifying
	@Query(value = "delete from BBVATESOR.TSI003_COBRANZAPAGO i where TO_CHAR(i.FH_FEC_IMPORTA,'yyyyMMddhhmiss') !=  ?1", nativeQuery=true)
	public abstract int deleteAllByDistintoFechaImportacion(String fechaImporta);
}
