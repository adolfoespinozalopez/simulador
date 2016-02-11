package com.pss.simulador.bs.repository.data;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
/**
*
* @author Adolfo Espinoza
* @version 1.0, 05/02/2016
* @since 1.0
*/
@Repository
public class ExpoFondoRepository {

	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall spEjecutarData;
	
	@Autowired
	public void setDataSource(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.spEjecutarData = new SimpleJdbcCall(this.jdbcTemplate).withCatalogName("BBVATESOR.PKG_GENERAEXPOSICION").withProcedureName("SP_ACTUALIZA_FONDO").withoutProcedureColumnMetaDataAccess().declareParameters(new SqlParameter[] { new SqlParameter("PNOM_FONDO", 12) });
	}
	
	public boolean executeExposicionDelFondo(String nbFondo){
		try {
			Map<String, Object> parametros = new HashMap<String, Object>();	
			parametros.put("PNOM_FONDO", nbFondo);
			this.spEjecutarData.execute(parametros);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}
