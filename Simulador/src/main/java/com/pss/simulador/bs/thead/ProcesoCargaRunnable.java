
package com.pss.simulador.bs.thead;

import java.io.FileInputStream;
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
import com.pss.simulador.bs.domain.ProcesoLog;
import com.pss.simulador.bs.domain.Saldo;
import com.pss.simulador.bs.service.GeneralManager;
import com.pss.simulador.bs.service.ProcesoCargaManager;
import com.pss.simulador.helper.CargaArchivoHelper;
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
	private List<ProcesoLog> lstProcesoLog = new ArrayList<ProcesoLog>();
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
		} catch (IOException e) {
			logger.error(e,e);
			this.setLstProcesoLog(Utilitarios.addLog(Constante.Log.TipoMensaje.ERROR, 
					"Error no controlado. Error leer la ruta del archivo. Mensaje:"+e.getMessage()+" - Causa:"+e.getCause(), 
					this.getLstProcesoLog(), 
					this.getProcesoCarga().getCdIdproceso()));
		} catch (Exception e) {
			logger.error(e,e);
			this.setLstProcesoLog(Utilitarios.addLog(Constante.Log.TipoMensaje.ERROR, 
					"Error no controlado. Mensaje:"+e.getMessage(), 
					this.getLstProcesoLog(), 
					this.getProcesoCarga().getCdIdproceso()));
		} finally{
			try {
				is.close();
				workbook.close();
			} catch (IOException e) {
			}
		}
		
		procesoCarga.setCdUsuModifica(procesoCarga.getCdUsuCreacion());
		procesoCarga.setFhFecModifica(new Date());
		procesoCarga.setFhFecFin(new Date());
		procesoCarga.setProcesoLogList(this.getLstProcesoLog());
		procesoCarga.setStEstadoProceso(this.obtenerEstadoProcesoByLog(this.getLstProcesoLog()));	
		procesoCarga = procesoCargaManager.saveProcesoCarga(procesoCarga);
		
	}
	
	/**
	 * @param lstProcesoLog2
	 * @return
	 */
	private String obtenerEstadoProcesoByLog(List<ProcesoLog> lstProcesoLog2) {
		String strEstado = Constante.EstadoProceso.TERMINADO;
		for (ProcesoLog procesoLog : lstProcesoLog2) {
			if (procesoLog.getTpTipomensaje().equals(Constante.Log.TipoMensaje.ERROR)){
				strEstado = Constante.EstadoProceso.ERRADO;
				break;
			}
		}
		return strEstado;
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
				CargaArchivoHelper helper = new CargaArchivoHelper(this.getProcesoCarga(), this.getLstProcesoLog(), (contaFila+1), "SALDOS");
				cobranzaPago.setCdCodFondo(helper.parseDoubleToString(hsObjCols.get(0),1));
				cobranzaPago.setTipOperacion(helper.parseToString(hsObjCols.get(1)));
				cobranzaPago.setFhFecIngreso(helper.parseToDate(hsObjCols.get(2),3));
				cobranzaPago.setFhFecLiq(helper.parseToDate(hsObjCols.get(3),4));
				cobranzaPago.setNbDescripcion(helper.parseToString(hsObjCols.get(4)));
				cobranzaPago.setTpMoneda(helper.parseToString(hsObjCols.get(5)));
				cobranzaPago.setImMonto(helper.parseToDouble(hsObjCols.get(6),7));
				cobranzaPago.setImMtoMonFondo(helper.parseToDouble(hsObjCols.get(7),8));
				cobranzaPago.setCdSigla(helper.parseToString(hsObjCols.get(8)));
				cobranzaPago.setStEstado(Constante.ESTADO_ACTIVO);
				cobranzaPago.setFhFecImporta(this.getProcesoCarga().getFhFecImporta());
				lstResult.add(cobranzaPago);
				this.setLstProcesoLog(helper.getLstLog());
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
				CargaArchivoHelper helper = new CargaArchivoHelper(this.getProcesoCarga(), this.getLstProcesoLog(), (contaFila+1), "SALDOS");
				saldo.setCdCodFondo(helper.parseToString(hsObjCols.get(0)));
				saldo.setNbNomFondo(helper.parseToString(hsObjCols.get(1)));
				saldo.setTpTipmoneda(helper.parseToString(hsObjCols.get(2)));
				saldo.setNuNumCuenta(helper.parseToString(hsObjCols.get(3)));
				saldo.setToSaldoInicial(helper.parseToDouble(hsObjCols.get(4),5));
				saldo.setImDifRescate(helper.parseToDouble(hsObjCols.get(5),6));
				saldo.setImSuscripcion(helper.parseToDouble(hsObjCols.get(6),7));
				saldo.setImRescate(helper.parseToDouble(hsObjCols.get(7),8));
				saldo.setImVencimiento(helper.parseToDouble(hsObjCols.get(8),9));
				saldo.setImComprasTmasn(helper.parseToDouble(hsObjCols.get(9),10));
				saldo.setImVentasTmasn(helper.parseToDouble(hsObjCols.get(10),11));
				saldo.setImCompra(helper.parseToDouble(hsObjCols.get(11),12));
				saldo.setImVenta(helper.parseToDouble(hsObjCols.get(12),13));
				saldo.setImCxpAcciones(helper.parseToDouble(hsObjCols.get(13),14));
				saldo.setImCxcAcciones(helper.parseToDouble(hsObjCols.get(14),15));
				saldo.setImComision(helper.parseToDouble(hsObjCols.get(15),16));
				saldo.setToSaldoFinal(helper.parseToDouble(hsObjCols.get(16),17));
				saldo.setImRescateTmasn(helper.parseToDouble(hsObjCols.get(17),18));
				saldo.setImCarteTmenosuno(helper.parseToDouble(hsObjCols.get(18),19));
				saldo.setImPorcLiquidez(helper.parseToDouble(hsObjCols.get(19),20));
				saldo.setToSaldoInvertir(helper.parseToDouble(hsObjCols.get(20),21));
				saldo.setNbObservacion(helper.parseToString(hsObjCols.get(21)));
				saldo.setPcPorcPatrimonio(helper.parseToDouble(hsObjCols.get(22),23));
				saldo.setImPatMonFondo(helper.parseToDouble(hsObjCols.get(23),24));
				saldo.setPcPorcPatTot(helper.parseToDouble(hsObjCols.get(24),25));
				saldo.setPcPorcContinenta(helper.parseToDouble(hsObjCols.get(25),26));
				saldo.setPcPorcTotal(helper.parseToDouble(hsObjCols.get(26),27));
				saldo.setImMtoExceso(helper.parseToDouble(hsObjCols.get(27),28));
				saldo.setPcPorcAcciones(helper.parseToDouble(hsObjCols.get(28),29));
				saldo.setImVinculado(helper.parseToDouble(hsObjCols.get(29),30));
				saldo.setImLiquidezInmedi(helper.parseToDouble(hsObjCols.get(30),31));
				saldo.setImSolicitudSusc(helper.parseToDouble(hsObjCols.get(31),32));
				saldo.setImSolicitudResc(helper.parseToDouble(hsObjCols.get(32),33));
				saldo.setImCxpPendiente(helper.parseToDouble(hsObjCols.get(33),34));
				saldo.setImSaldoTmasn(helper.parseToDouble(hsObjCols.get(34),35));
				saldo.setStEstado(Constante.ESTADO_ACTIVO);
				saldo.setFhFecImporta(this.getProcesoCarga().getFhFecImporta());
			
				lstResult.add(saldo);
				this.setLstProcesoLog(helper.getLstLog());
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
				CargaArchivoHelper helper = new CargaArchivoHelper(this.getProcesoCarga(), this.getLstProcesoLog(), (contaFila+1), "INFOPORT");
				infoport.setNbNomFondo(helper.parseToString(hsObjCols.get(0)));
				infoport.setTpTipfondo(helper.parseToString(hsObjCols.get(1)));
				infoport.setNbNomEmisor(helper.parseToString(hsObjCols.get(2)));
				infoport.setTpRatingEmisor(helper.parseToString(hsObjCols.get(3)));
				infoport.setNbEspecie(helper.parseToString(hsObjCols.get(4)));
				infoport.setFhFecEmision(helper.parseToDate(hsObjCols.get(5),6));
				infoport.setFhFecVencimiento(helper.parseToDate(hsObjCols.get(6),7));
				infoport.setImNominalEnMil(helper.parseToDouble(hsObjCols.get(7),8));
				infoport.setImCupon(helper.parseToDouble(hsObjCols.get(8),9));
				infoport.setFhFecUltCupon(helper.parseToDate(hsObjCols.get(9),10));
				infoport.setTpModalidad(helper.parseToString(hsObjCols.get(10)));
				infoport.setImPrecioLimpio(helper.parseToDouble(hsObjCols.get(11),12));
				infoport.setImPrecioSucio(helper.parseToDouble(hsObjCols.get(12),13));
				infoport.setImValorSinInter(helper.parseToDouble(hsObjCols.get(13),14));
				infoport.setImInteresCorrid(helper.parseToDouble(hsObjCols.get(14),15));
				infoport.setImValorMonRef(helper.parseToDouble(hsObjCols.get(15),16));
				infoport.setTpAbrevMoneda(helper.parseToString(hsObjCols.get(16)));
				infoport.setImValorMonLocal(helper.parseToDouble(hsObjCols.get(17),18));
				infoport.setImTotCtasCobrar(helper.parseToDouble(hsObjCols.get(18),19));
				infoport.setImTotCtasPagar(helper.parseToDouble(hsObjCols.get(19),20));
				infoport.setNuPeriodo(helper.parseToDouble(hsObjCols.get(20),21));
				infoport.setImYtm(helper.parseToDouble(hsObjCols.get(21),22));
				infoport.setImDuracNorm(helper.parseToDouble(hsObjCols.get(22),23));
				infoport.setImDuracModif(helper.parseToDouble(hsObjCols.get(23),24));
				infoport.setTpClasifica(helper.parseToString(hsObjCols.get(24)));
				infoport.setImPrecioAct(helper.parseToDouble(hsObjCols.get(25),26));
				infoport.setImPrecCom(helper.parseToDouble(hsObjCols.get(26),27));
				infoport.setNbIsin(helper.parseToString(hsObjCols.get(27)));
				infoport.setNbMnemonico(helper.parseToString(hsObjCols.get(28)));
				infoport.setNuNumDiasVcto(helper.parseToDouble(hsObjCols.get(29),30));
				infoport.setFhFecvctoSgtCup(helper.parseToDate(hsObjCols.get(30),31));
				infoport.setFhFecUltOperac(helper.parseToDate(hsObjCols.get(31),32));
				infoport.setImDuracNorLibor(helper.parseToDouble(hsObjCols.get(32),33));
				infoport.setImCompraTMasN(helper.parseToDouble(hsObjCols.get(33),34));
				infoport.setNbObservacion(helper.parseToString(hsObjCols.get(34)));
				infoport.setImValorPorDurac(helper.parseToDouble(hsObjCols.get(35),35));
				infoport.setImValorPorYtm(helper.parseToDouble(hsObjCols.get(36),36));
				infoport.setNuDiaParaVenc(helper.parseToDouble(hsObjCols.get(37),37));
				infoport.setStEstadoPort(helper.parseToString(hsObjCols.get(38)));
				infoport.setStCondicion(helper.parseDoubleToString(hsObjCols.get(39),40));
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
				this.setLstProcesoLog(helper.getLstLog());
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

	/**
	 * @return the lstProcesoLog
	 */
	public List<ProcesoLog> getLstProcesoLog() {
		return lstProcesoLog;
	}

	/**
	 * @param lstProcesoLog the lstProcesoLog to set
	 */
	public void setLstProcesoLog(List<ProcesoLog> lstProcesoLog) {
		this.lstProcesoLog = lstProcesoLog;
	}

	
}
