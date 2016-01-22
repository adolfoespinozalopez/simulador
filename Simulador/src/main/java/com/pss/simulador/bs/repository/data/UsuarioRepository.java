/**
 * 
 */
package com.pss.simulador.bs.repository.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pss.simulador.bs.domain.Usuario;

/**
 * @author pierre.obregon
 * @version 21/1/2016
 */
@Repository
public interface UsuarioRepository  extends CrudRepository<Usuario, Integer> {

	@Query(value = "FROM Usuario u WHERE u.cdLogin = :strCodUsuario AND u.stEstado = :stEstado")
	public abstract Usuario findByRegUser(@Param("strCodUsuario") String strCodUsuario, @Param("stEstado") String stEstado);
}
