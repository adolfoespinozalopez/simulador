/**
 * 
 */
package com.pss.simulador.bs.repository.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pss.simulador.bs.domain.PerfilFondo;

/**
 * @author pierre.obregon
 * @version 25/1/2016
 */
@Repository
public interface PerfilFondoRepository extends CrudRepository<PerfilFondo, Integer> {

	@Query(value = "SELECT g FROM PerfilFondo g "
			+ " WHERE g.perfilFondoPK.cdIdperfil = :cdIdperfil AND ( :stEstado = '-1' OR g.stEstado = :stEstado )")	
	public abstract List<PerfilFondo> findPerfilFondoByIdPerfil(@Param("cdIdperfil") Integer cdIdperfil, @Param("stEstado") String stEstado);

}
