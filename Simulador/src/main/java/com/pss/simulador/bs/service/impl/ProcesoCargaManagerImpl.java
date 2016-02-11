/**
 * 
 */
package com.pss.simulador.bs.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pss.simulador.bs.domain.CobranzaPago;
import com.pss.simulador.bs.domain.General;
import com.pss.simulador.bs.domain.Infoport;
import com.pss.simulador.bs.domain.ProcesoCarga;
import com.pss.simulador.bs.domain.Saldo;
import com.pss.simulador.bs.repository.data.CobranzaPagoRepository;
import com.pss.simulador.bs.repository.data.GeneralRepository;
import com.pss.simulador.bs.repository.data.InfoportRepository;
import com.pss.simulador.bs.repository.data.ProcesoCargaRepository;
import com.pss.simulador.bs.repository.data.ProcesoLogRepository;
import com.pss.simulador.bs.repository.data.SaldoRepository;
import com.pss.simulador.bs.service.ProcesoCargaManager;
import com.pss.simulador.util.Constante;
import com.pss.simulador.util.FechasUtil;

/**
 * @author pierre.obregon
 * @version 31/1/2016
 */
@Service
@Transactional(readOnly = true)
public class ProcesoCargaManagerImpl implements ProcesoCargaManager {

	private static final Logger logger = Logger.getLogger(ProcesoCargaManagerImpl.class);
	@Autowired
	ProcesoCargaRepository procesoCargaRepository;
	@Autowired
	ProcesoLogRepository procesoLogRepository;
	@Autowired
	GeneralRepository generalRepository;
	@Autowired
	SaldoRepository saldoRepository;
	@Autowired
	InfoportRepository infoportRepository;
	@Autowired
	CobranzaPagoRepository cobranzaPagoRepository;

	public List<ProcesoCarga> findProcesoCargaByFechas(Date dtDesde, Date dtHasta) {
		return procesoCargaRepository.findByFechaDesdeHasta(dtDesde, dtHasta, Constante.ESTADO_ACTIVO);
	}
	
	@Transactional
	public ProcesoCarga saveProcesoCarga(ProcesoCarga procesoCarga) {
		return procesoCargaRepository.save(procesoCarga);
	}
	
	public Boolean copyFileToLocal(InputStream is) throws IOException{
		Boolean blResp = true;
		List<General> lstGeneral = generalRepository.findByDomain(Constante.Dominio.RUTAPROCESOCARGA, Constante.ESTADO_TODOS);
		String rutaArchivo = lstGeneral.get(0).getNbValorGeneral();
		BufferedReader br = null;
		FileOutputStream fos = null;
		br = new BufferedReader(new InputStreamReader(is));
		File newFile = new File(rutaArchivo);
		
		fos = new FileOutputStream(newFile);
		IOUtils.copy(is, fos);
        if (is != null) {
			try {
				is.close();
			} catch (IOException e) {
				logger.error(e,e);
			}
		}
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				logger.error(e,e);
			}
		}
		try {
			fos.close();
		} catch (IOException e) {
			logger.error(e,e);
		}
		return blResp;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public Boolean saveLoadFile(List<Infoport> lstInfoportLoad,
			List<Saldo> lstSaldos, List<CobranzaPago> lstCobPag, Date fhFecImporta) throws SQLException, Exception{
		infoportRepository.save(lstInfoportLoad);
		saldoRepository.save(lstSaldos);
		cobranzaPagoRepository.save(lstCobPag);
		return true;
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public Boolean deleteAllOtherLoad(Date fhFecImporta) {
		infoportRepository.deleteAllByDistintoFechaImportacion(FechasUtil.formatFecha(fhFecImporta, "yyyyMMddhhmmss") );
		saldoRepository.deleteAllByDistintoFechaImportacion(FechasUtil.formatFecha(fhFecImporta, "yyyyMMddhhmmss") );
		cobranzaPagoRepository.deleteAllByDistintoFechaImportacion(FechasUtil.formatFecha(fhFecImporta, "yyyyMMddhhmmss") );
		return true;
	}
	

	
	

}