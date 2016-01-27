/**
 * 
 */
package com.pss.simulador.bs.repository.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pss.simulador.bs.domain.Perfil;

/**
 * @author pierre.obregon
 * @version 21/1/2016
 */
@Repository
public interface PerfilRepository extends CrudRepository<Perfil, Integer> {

	@Query(value = "SELECT g FROM Perfil g "
			+ " WHERE g.nbMonPerfil LIKE CONCAT('%', :strNombre,'%') AND g.stEstado = :stEstado")	
	public abstract List<Perfil> findPerfilByName(@Param("strNombre") String strNombre, @Param("stEstado") String stEstado);

}
