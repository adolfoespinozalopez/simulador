/**
 * 
 */
package com.pss.simulador.bs.repository.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pss.simulador.bs.domain.LimFondoEspecie;

/**
 * @author pierre.obregon
 * @version 27/1/2016
 */
@Repository
public interface LimFondoEspecieRepository extends CrudRepository<LimFondoEspecie, Integer> {

	@Query(value = "SELECT g FROM LimFondoEspecie g WHERE g.cdIdemisor.cdIdemisor = :cdIdemisor AND g.cdIdfondo.cdIdfondo = :cdIdfondo AND g.cdIdgeneral.cdIdgeneral = :cdIdEspecie AND g.stEstado = :estado")	
	public abstract LimFondoEspecie findByFondoAndEmisorAndEspecie(@Param("cdIdfondo") Integer idFondo, @Param("cdIdemisor") Integer idEmisor, @Param("cdIdEspecie") Integer cdIdEspecie, @Param("estado") String strStEstado);
	
}
