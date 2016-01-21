package com.pss.simulador.bs.repository.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pss.simulador.bs.domain.Infoport;

/**
*
* @author Adolfo Espinoza
* @version 1.0, 20/01/2016
* @since 1.0
*/
@Repository
public interface InfoportRepository extends CrudRepository<Infoport, Integer> {

	@Query(value = "SELECT f FROM Infoport f ORDER BY f.cdIdinfoport")
	public abstract List<Infoport> findAllInfo();
	
}
