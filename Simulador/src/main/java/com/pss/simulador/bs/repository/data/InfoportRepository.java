package com.pss.simulador.bs.repository.data;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pss.simulador.bs.domain.Infoport;

/**
*
* @author Adolfo Espinoza
* @version 1.0, 20/01/2016
* @since 1.0
*/
@Repository
public interface InfoportRepository extends CrudRepository<Infoport, Integer> {

	@Query(value = "SELECT f FROM Infoport f WHERE f.fhFecImporta >= :fecImporta "
			+ "AND (:nomFondo  IS NULL OR f.nbNomFondo LIKE :nomFondo) "
			+ "AND (:nomEmisor IS NULL OR f.nbNomEmisor =:nomEmisor) "
			+ "AND (:vencehoy  IS NULL OR f.stEstadoPort LIKE :vencehoy) "
			+ "AND (:operacion IS NULL OR f.tpOperacion LIKE :operacion) "
			+ "ORDER BY f.cdIdinfoport")
	public abstract List<Infoport> findByFilter(@Param("fecImporta") Date fechaActual, @Param("nomFondo") String nomFondo, @Param("nomEmisor") String nomEmisor, @Param("vencehoy") String vencehoy, @Param("operacion") String operacion);
	
	@Transactional
	@Modifying
	@Query(value = "delete from BBVATESOR.TSI002_INFOPORT i where TO_CHAR(i.FH_FEC_IMPORTA,'yyyyMMddhhmiss') != ?1", nativeQuery=true)
	public abstract int deleteAllByDistintoFechaImportacion(String fechaImporta);
	
}
