/**
 * 
 */
package com.pss.simulador.bs.repository.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pss.simulador.bs.domain.ExpoFondo;
import com.pss.simulador.bs.domain.Fondo;

/**
 * @author pierre.obregon
 * @version 25/1/2016
 */
@Repository
public interface FondoRepository extends CrudRepository<Fondo, Integer> {

	@Query(value = "SELECT g FROM Fondo g WHERE g.nbNomFondo LIKE (CONCAT('%', :nombFondo , '%'))")	
	public abstract Fondo findByName(@Param("nombFondo") String nombFondo);

	@Query(value = "SELECT g FROM Fondo g ORDER BY g.nbNomFondo ")
	public abstract List<Fondo> findAll();
	
	@Query(value = "SELECT DISTINCT g.fondo FROM PerfilFondo g WHERE g.stEstado = 1 AND g.perfil.cdIdperfil = :idPerfil ORDER BY g.fondo.nbNomFondo ")
	public abstract List<Fondo> findByIdPerfil(@Param("idPerfil") Integer idPerfil);
	
	
	//Exposicion del Fondo
	@Query(value = "SELECT e FROM ExpoFondo e WHERE e.cdIdfondo = :idFondo ORDER BY e.cidExpo ")
	public abstract List<ExpoFondo> obtenerExposicionDelFondo(@Param("idFondo") Integer idFondo);
}
