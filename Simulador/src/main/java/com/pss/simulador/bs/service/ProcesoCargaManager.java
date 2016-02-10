/**
 * 
 */
package com.pss.simulador.bs.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import com.pss.simulador.bs.domain.CobranzaPago;
import com.pss.simulador.bs.domain.Infoport;
import com.pss.simulador.bs.domain.ProcesoCarga;
import com.pss.simulador.bs.domain.Saldo;

/**
 * @author pierre.obregon
 * @version 31/1/2016
 */
public interface ProcesoCargaManager {

	public List<ProcesoCarga> findProcesoCargaByFechas(Date dtDesde, Date dtHasta);
	public ProcesoCarga saveProcesoCarga(ProcesoCarga procesoCarga);
	public Boolean copyFileToLocal(InputStream is) throws IOException;
	public Boolean saveLoadFile(List<Infoport> lstInfoportLoad, List<Saldo> lstSaldos,List<CobranzaPago> lstCobPag, Date fhFecImporta);
	public Boolean deleteAllOtherLoad(Date fhFecImporta);
}
