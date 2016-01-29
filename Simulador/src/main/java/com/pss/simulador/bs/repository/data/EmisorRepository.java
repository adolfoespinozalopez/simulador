package com.pss.simulador.bs.repository.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pss.simulador.bs.domain.Emisor;

/**
 * @author pierre.obregon
 * @version 25/1/2016
 */
@Repository
public interface EmisorRepository extends CrudRepository<Emisor, Integer> {

	@Query(value = "SELECT g FROM Emisor g "
			+ " left join fetch g.limitesEmisorList le "
			+ " WHERE g.nbNomEmisor LIKE (CONCAT('%', :nombEmisor , '%')) AND ( -1 = :tipoEmisor OR g.tpTipemisor = :tipoEmisor ) AND g.stEstado = :estado")	
	public abstract List<Emisor> findByNameAndType(@Param("nombEmisor") String strNombEmisor, @Param("tipoEmisor") Integer tipoEmisor, @Param("estado") String strStEstado);

	@Query(value = "SELECT DISTINCT e FROM Emisor e, Infoport f "
			+ "WHERE f.nbNomFondo LIKE :nomFondo "
			+ "AND e.nbNomEmisor = f.nbNomEmisor AND e.stEstado = 1")
	public abstract List<Emisor> findByFund(@Param("nomFondo") String strNomFondo);
	
	@Query(value = "SELECT e FROM Emisor e WHERE e.stEstado = 1 ORDER BY e.nbNomEmisor")
	public abstract List<Emisor> findAllActive();
}
