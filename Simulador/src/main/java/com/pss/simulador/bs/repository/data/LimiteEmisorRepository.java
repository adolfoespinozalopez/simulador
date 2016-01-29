package com.pss.simulador.bs.repository.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pss.simulador.bs.domain.LimitesEmisor;
/**
 * @author pierre.obregon
 * @version 25/1/2016
 */
@Repository
public interface LimiteEmisorRepository extends CrudRepository<LimitesEmisor, Integer> {

	@Query(value = "SELECT g FROM LimitesEmisor g WHERE g.cdIdlimite = :cdIdlimite AND g.stEstado = :estado")	
	public abstract List<LimitesEmisor> findByPK(@Param("cdIdlimite") Integer cdIdlimite, @Param("estado") String strStEstado);

}
