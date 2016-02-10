
package com.pss.simulador.bs.thead;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pss.simulador.bs.domain.CobranzaPago;
import com.pss.simulador.bs.domain.General;
import com.pss.simulador.bs.domain.Infoport;
import com.pss.simulador.bs.domain.ProcesoCarga;
import com.pss.simulador.bs.domain.Saldo;
import com.pss.simulador.bs.service.GeneralManager;
import com.pss.simulador.bs.service.ProcesoCargaManager;
import com.pss.simulador.util.Constante;
import com.pss.simulador.util.Utilitarios;

/**
 * @author pierre.obregon
 * @version 4/2/2016
 */
@Component
public class ProcesoCargaRunnable implements Runnable {

	private static final Logger logger = Logger
			.getLogger(ProcesoCargaRunnable.class);

	@Autowired
	GeneralManager generalManager;
	@Autowired
	ProcesoCargaManager procesoCargaManager;
	private ProcesoCarga procesoCarga;
	public void run() {

		List<General> lstGeneral = generalManager.findByDomain(
				Constante.Dominio.RUTAPROCESOCARGA, Constante.ESTADO_TODOS);
		String rutaArchivo = lstGeneral.get(0).getNbValorGeneral();

		FileInputStream is = null;
		XSSFWorkbook workbook = null;
		try {
			is = new FileInputStream(rutaArchivo);
			workbook = new XSSFWorkbook(is);
			XSSFSheet sheetInfoport = workbook.getSheetAt(0);
			XSSFSheet sheetSaldos = workbook.getSheetAt(1);
			XSSFSheet sheetCobPag = workbook.getSheetAt(2);

			List<Infoport> lstInfoportLoad = this.parseToInfoport(this.convertirHojaToList(sheetInfoport));
			List<Saldo> lstSaldos = this.parseToSaldo(this.convertirHojaToList(sheetSaldos));
			List<CobranzaPago> lstCobPag = this.parseToCobranzaPago(this.convertirHojaToList(sheetCobPag));
			
			if(procesoCargaManager.saveLoadFile(lstInfoportLoad, lstSaldos, lstCobPag, this.getProcesoCarga().getFhFecImporta())){
				procesoCargaManager.deleteAllOtherLoad(this.getProcesoCarga().getFhFecImporta());
			}
		} catch (FileNotFoundException e) {
			logger.error(e,e);
		} catch (IOException e) {
			logger.error(e,e);
		}finally{
			try {
				is.close();
				workbook.close();
			} catch (IOException e) {
			}
		}
		
		procesoCarga.setCdUsuModifica(procesoCarga.getCdUsuCreacion());
		procesoCarga.setFhFecModifica(new Date());
		procesoCarga.setFhFecFin(new Date());
		procesoCarga.setStEstadoProceso(Constante.EstadoProceso.TERMINADO);
		procesoCarga = procesoCargaManager.saveProcesoCarga(procesoCarga);
		
	}

	/**
	 * @param convertirHojaToList
	 * @return
	 */
	private List<CobranzaPago> parseToCobranzaPago(
			List<HashMap<Integer,Object>> lstObjRows) {
		List<CobranzaPago> lstResult = new ArrayList<CobranzaPago>();
		Integer nroFilaData = 1;
		Integer contaFila=0;
		for (HashMap<Integer,Object> hsObjCols : lstObjRows) {
			CobranzaPago cobranzaPago = new CobranzaPago();
			if (contaFila >= nroFilaData){
				cobranzaPago.setCdCodFondo(Utilitarios.parseDoubleToString(hsObjCols.get(0)));
				cobranzaPago.setTipOperacion(Utilitarios.parseToString(hsObjCols.get(1)));
				cobranzaPago.setFhFecIngreso(Utilitarios.parseToDate(hsObjCols.get(2)));
				cobranzaPago.setFhFecLiq(Utilitarios.parseToDate(hsObjCols.get(3)));
				cobranzaPago.setNbDescripcion(Utilitarios.parseToString(hsObjCols.get(4)));
				cobranzaPago.setTpMoneda(Utilitarios.parseToString(hsObjCols.get(5)));
				cobranzaPago.setImMonto(Utilitarios.parseToDouble(hsObjCols.get(6)));
				cobranzaPago.setImMtoMonFondo(Utilitarios.parseToDouble(hsObjCols.get(7)));
				cobranzaPago.setCdSigla(Utilitarios.parseToString(hsObjCols.get(8)));
				cobranzaPago.setStEstado(Constante.ESTADO_ACTIVO);
				cobranzaPago.setFhFecImporta(this.getProcesoCarga().getFhFecImporta());
				lstResult.add(cobranzaPago);
			}
			contaFila++;
			
		}
		return lstResult;
	}

	private List<Saldo> parseToSaldo(List<HashMap<Integer,Object>> lstObjRows) {
		List<Saldo> lstResult = new ArrayList<Saldo>();
		Integer nroFilaData = 5;
		Integer contaFila=0;
		for (HashMap<Integer,Object> hsObjCols : lstObjRows) {
			Saldo saldo = new Saldo();
			if (contaFila >= nroFilaData){
				saldo.setCdCodFondo(Utilitarios.parseToString(hsObjCols.get(0)));
				saldo.setNbNomFondo(Utilitarios.parseToString(hsObjCols.get(1)));
				saldo.setTpTipmoneda(Utilitarios.parseToString(hsObjCols.get(2)));
				saldo.setNuNumCuenta(Utilitarios.parseToString(hsObjCols.get(3)));
				saldo.setToSaldoInicial(Utilitarios.parseToDouble(hsObjCols.get(4)));
				saldo.setImDifRescate(Utilitarios.parseToDouble(hsObjCols.get(5)));
				saldo.setImSuscripcion(Utilitarios.parseToDouble(hsObjCols.get(6)));
				saldo.setImRescate(Utilitarios.parseToDouble(hsObjCols.get(7)));
				saldo.setImVencimiento(Utilitarios.parseToDouble(hsObjCols.get(8)));
				saldo.setImComprasTmasn(Utilitarios.parseToDouble(hsObjCols.get(9)));
				saldo.setImVentasTmasn(Utilitarios.parseToDouble(hsObjCols.get(10)));
				saldo.setImCompra(Utilitarios.parseToDouble(hsObjCols.get(11)));
				saldo.setImVenta(Utilitarios.parseToDouble(hsObjCols.get(12)));
				saldo.setImCxpAcciones(Utilitarios.parseToDouble(hsObjCols.get(13)));
				saldo.setImCxcAcciones(Utilitarios.parseToDouble(hsObjCols.get(14)));
				saldo.setImComision(Utilitarios.parseToDouble(hsObjCols.get(15)));
				saldo.setToSaldoFinal(Utilitarios.parseToDouble(hsObjCols.get(16)));
				saldo.setImRescateTmasn(Utilitarios.parseToDouble(hsObjCols.get(17)));
				saldo.setImCarteTmenosuno(Utilitarios.parseToDouble(hsObjCols.get(18)));
				saldo.setImPorcLiquidez(Utilitarios.parseToDouble(hsObjCols.get(19)));
				saldo.setToSaldoInvertir(Utilitarios.parseToDouble(hsObjCols.get(20)));
				saldo.setNbObservacion(Utilitarios.parseToString(hsObjCols.get(21)));
				saldo.setPcPorcPatrimonio(Utilitarios.parseToDouble(hsObjCols.get(22)));
				saldo.setImPatMonFondo(Utilitarios.parseToDouble(hsObjCols.get(23)));
				saldo.setPcPorcPatTot(Utilitarios.parseToDouble(hsObjCols.get(24)));
				saldo.setPcPorcContinenta(Utilitarios.parseToDouble(hsObjCols.get(25)));
				saldo.setPcPorcTotal(Utilitarios.parseToDouble(hsObjCols.get(26)));
				saldo.setImMtoExceso(Utilitarios.parseToDouble(hsObjCols.get(27)));
				saldo.setPcPorcAcciones(Utilitarios.parseToDouble(hsObjCols.get(28)));
				saldo.setImVinculado(Utilitarios.parseToDouble(hsObjCols.get(29)));
				saldo.setImLiquidezInmedi(Utilitarios.parseToDouble(hsObjCols.get(30)));
				saldo.setImSolicitudSusc(Utilitarios.parseToDouble(hsObjCols.get(31)));
				saldo.setImSolicitudResc(Utilitarios.parseToDouble(hsObjCols.get(32)));
				saldo.setImCxpPendiente(Utilitarios.parseToDouble(hsObjCols.get(33)));
				saldo.setImSaldoTmasn(Utilitarios.parseToDouble(hsObjCols.get(34)));
				saldo.setStEstado(Constante.ESTADO_ACTIVO);
				saldo.setFhFecImporta(this.getProcesoCarga().getFhFecImporta());
			
				lstResult.add(saldo);
			}
			contaFila++;
			
		}
		return lstResult;
	}
	
	private List<Infoport> parseToInfoport(
			List<HashMap<Integer,Object>> lstObjRows) {
		List<Infoport> lstResult = new ArrayList<Infoport>();
		Integer nroFilaData = 4;
		Integer contaFila=0;
		for (HashMap<Integer,Object> hsObjCols : lstObjRows) {
			Infoport infoport = new Infoport();
			if (contaFila >= nroFilaData){
				infoport.setNbNomFondo(Utilitarios.parseToString(hsObjCols.get(0)));
				infoport.setTpTipfondo(Utilitarios.parseToString(hsObjCols.get(1)));
				infoport.setNbNomEmisor(Utilitarios.parseToString(hsObjCols.get(2)));
				infoport.setTpRatingEmisor(Utilitarios.parseToString(hsObjCols.get(3)));
				infoport.setNbEspecie(Utilitarios.parseToString(hsObjCols.get(4)));
				infoport.setFhFecEmision(Utilitarios.parseToDate(hsObjCols.get(5)));
				infoport.setFhFecVencimiento(Utilitarios.parseToDate(hsObjCols.get(6)));
				infoport.setImNominalEnMil(Utilitarios.parseToDouble(hsObjCols.get(7)));
				infoport.setImCupon(Utilitarios.parseToDouble(hsObjCols.get(8)));
				infoport.setFhFecUltCupon(Utilitarios.parseToDate(hsObjCols.get(9)));
				infoport.setTpModalidad(Utilitarios.parseToString(hsObjCols.get(10)));
				infoport.setImPrecioLimpio(Utilitarios.parseToDouble(hsObjCols.get(11)));
				infoport.setImPrecioSucio(Utilitarios.parseToDouble(hsObjCols.get(12)));
				infoport.setImValorSinInter(Utilitarios.parseToDouble(hsObjCols.get(13)));
				infoport.setImInteresCorrid(Utilitarios.parseToDouble(hsObjCols.get(14)));
				infoport.setImValorMonRef(Utilitarios.parseToDouble(hsObjCols.get(15)));
				infoport.setTpAbrevMoneda(Utilitarios.parseToString(hsObjCols.get(16)));
				infoport.setImValorMonLocal(Utilitarios.parseToDouble(hsObjCols.get(17)));
				infoport.setImTotCtasCobrar(Utilitarios.parseToDouble(hsObjCols.get(18)));
				infoport.setImTotCtasPagar(Utilitarios.parseToDouble(hsObjCols.get(19)));
				infoport.setNuPeriodo(Utilitarios.parseToDouble(hsObjCols.get(20)));
				infoport.setImYtm(Utilitarios.parseToDouble(hsObjCols.get(21)));
				infoport.setImDuracNorm(Utilitarios.parseToDouble(hsObjCols.get(22)));
				infoport.setImDuracModif(Utilitarios.parseToDouble(hsObjCols.get(23)));
				infoport.setTpClasifica(Utilitarios.parseToString(hsObjCols.get(24)));
				infoport.setImPrecioAct(Utilitarios.parseToDouble(hsObjCols.get(25)));
				infoport.setImPrecCom(Utilitarios.parseToDouble(hsObjCols.get(26)));
				infoport.setNbIsin(Utilitarios.parseToString(hsObjCols.get(27)));
				infoport.setNbMnemonico(Utilitarios.parseToString(hsObjCols.get(28)));
				infoport.setNuNumDiasVcto(Utilitarios.parseToDouble(hsObjCols.get(29)));
				infoport.setFhFecvctoSgtCup(Utilitarios.parseToDate(hsObjCols.get(30)));
				infoport.setFhFecUltOperac(Utilitarios.parseToDate(hsObjCols.get(31)));
				infoport.setImDuracNorLibor(Utilitarios.parseToDouble(hsObjCols.get(32)));
				infoport.setImCompraTMasN(Utilitarios.parseToDouble(hsObjCols.get(33)));
				infoport.setNbObservacion(Utilitarios.parseToString(hsObjCols.get(34)));
				infoport.setImValorPorDurac(Utilitarios.parseToDouble(hsObjCols.get(35)));
				infoport.setImValorPorYtm(Utilitarios.parseToDouble(hsObjCols.get(36)));
				infoport.setNuDiaParaVenc(Utilitarios.parseToDouble(hsObjCols.get(37)));
				infoport.setStEstadoPort(Utilitarios.parseToString(hsObjCols.get(38)));
				infoport.setStCondicion(Utilitarios.parseDoubleToString(hsObjCols.get(39)));
				infoport.setStEstado(Constante.ESTADO_ACTIVO);
				if(infoport.getNbEspecie()!=null && !infoport.getNbEspecie().isEmpty()){
					if (infoport.getNbEspecie().equals(Constante.Especie.DESC_CERTIFICADOS) ||
						infoport.getNbEspecie().equals(Constante.Especie.DESC_DEPOSITOS_DE_AHORRO) ||
						infoport.getNbEspecie().equals(Constante.Especie.DESC_DEPOSITOS_PLAZO) ||
						infoport.getNbEspecie().equals(Constante.Especie.DESC_INSTRUMENTO_COBERTURA) ||
						infoport.getNbEspecie().equals(Constante.Especie.DESC_LETRAS_DEL_TESORO) ||
						infoport.getNbEspecie().equals(Constante.Especie.DESC_PAPELES_COMERCIALES)){
						infoport.setTpOperacion(Constante.InfoPortTipoOperacion.CODIGO_M);
					} else if(infoport.getNbEspecie().equals(Constante.Especie.DESC_ACCIONES)) {
						infoport.setTpOperacion(Constante.InfoPortTipoOperacion.CODIGO_V);
					} else{
						infoport.setTpOperacion(Constante.InfoPortTipoOperacion.CODIGO_F);
					}
				}
				infoport.setFhFecImporta(this.getProcesoCarga().getFhFecImporta());
				lstResult.add(infoport);
			}
			contaFila++;
			
		}
		return lstResult;
	}

	private List<HashMap<Integer,Object>> convertirHojaToList(XSSFSheet sheetInfoport) {
		List<HashMap<Integer,Object>> lstRows = new ArrayList<HashMap<Integer,Object>>();
		
		Iterator<Row> rowIterator = sheetInfoport.iterator();
		Row row;
		while (rowIterator.hasNext()) {
			HashMap<Integer,Object> hmValoresColumnas = new HashMap<Integer,Object>();
			row = rowIterator.next();

			Iterator<Cell> cellIterator = row.cellIterator();
			Cell celda;
			
			while (cellIterator.hasNext()) {
				celda = cellIterator.next();
				switch (celda.getCellType()) {
				case Cell.CELL_TYPE_NUMERIC:
					if (HSSFDateUtil.isCellDateFormatted(celda)) {
						hmValoresColumnas.put(celda.getColumnIndex(), celda.getDateCellValue());
					} else {
						hmValoresColumnas.put(celda.getColumnIndex(), celda.getNumericCellValue());
					}
					break;
				case Cell.CELL_TYPE_STRING:
					hmValoresColumnas.put(celda.getColumnIndex(),celda.getStringCellValue());
					break;
				case Cell.CELL_TYPE_BOOLEAN:
					hmValoresColumnas.put(celda.getColumnIndex(),celda.getStringCellValue());
					break;
				case Cell.CELL_TYPE_FORMULA:
					switch(celda.getCachedFormulaResultType()) {
			            case Cell.CELL_TYPE_NUMERIC:
			                hmValoresColumnas.put(celda.getColumnIndex(),celda.getNumericCellValue());
			                break;
			            case Cell.CELL_TYPE_STRING:
			                hmValoresColumnas.put(celda.getColumnIndex(),celda.getStringCellValue());
			                break;
			            default:
			            	hmValoresColumnas.put(celda.getColumnIndex(),null);
			        }
					break;
				default:
//					System.out.println("Tipo Celda:"+celda.getCellType());
					hmValoresColumnas.put(celda.getColumnIndex(),null);
				}
			}
			lstRows.add(hmValoresColumnas);
		}
		return lstRows;
	}

	public ProcesoCarga getProcesoCarga() {
		return procesoCarga;
	}

	public void setProcesoCarga(ProcesoCarga procesoCarga) {
		this.procesoCarga = procesoCarga;
	}

	
}
