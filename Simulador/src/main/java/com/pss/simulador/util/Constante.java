package com.pss.simulador.util;

import java.util.Date;

/**
 *
 * @author Adolfo Espinoza
 * @version 1.0, 13/01/2016
 * @since 1.0
 */
public class Constante {
    
    /**
     * Estados
     */
    public static final String ESTADO_ACTIVO = "1";
    public static final String ESTADO_INACTIVO = "0"; 
    public static final String ESTADO_TODOS = "-1";
    
    /**
     * Fecha Inicial
     */
    public final static Date FECHA_ACTUAL = new Date();
    
    /**
     * Dominio
     */
    public static final String TIPO_APERTURA = "TIPOAPERTURA";
    public static final String MONEDA_OPERACION = "MONEDAOPERACION";
    public static final String TIPO_OPERACION_FWD = "TIPOOPERACIONFWD";
    public static final String TIPO_OPERACION_CUENTA = "TIPOOPERACIONCUENTA";
    
    public static class Dominio{
    	public static final String OPERACION = "OPERACION";
    	public static final String TIPO_EMISOR = "TIPOEMISOR";
    	public static final String TIPO_OPERACION = "TIPOOPERACION";
    	public static final String MONEDA = "MONEDA";
    	public static final String CONTRAPARTE = "CONTRAPARTE";
    	public static final String ESTADO_ORDEN = "ESTADOORDEN";
    	public static final String ESPECIE = "ESPECIE";
    	public static final String RUTAPROCESOCARGA = "RUTAPROCESOCARGA";
    	public static final String INTERMEDIARIO = "BROKERS";
    	public static final String LUGAR = "LUGAR_NEGOCIACION";
    	public static final String PAIS = "PAIS_NEGOCIACION";
    }
    
    /**
     * Valores Dominio
     */
    public static final String TIPOAPERTURA_COBERTURADO = "COBERTURADO";
    public static final String TIPOAPERTURA_NORMAL = "NORMAL";
    
    public static final String TIPOOPERACIONCUENTA_ABONO = "ABONO";
    public static final String TIPOOPERACIONCUENTA_CARGO = "CARGO";
    
    public static final String MONEDAOPERACION_COMPRA = "COMPRA";
    public static final String MONEDAOPERACION_VENTA = "VENTA";
    
    public static final String VENCE_HOY = "VENCE HOY";
    
    public static final Double VALOR_CERO = 0.0;
    
    public static class OrdenEstado{
    	public static final String GENERADO = "1";
    	public static final String APROBADO = "2";
    	public static final String RECHAZADO = "3";
    	public static final String ENVIADO = "4";
    }
    
    /**
     * Operaciones
     */
    public static final Integer ID_OPERA_CANCELACION = 127;
    public static final Integer ID_OPERA_APERTURA_DPF = 128;
    public static final Integer ID_OPERA_APERTURA_DPF_COB = 129;
    public static final Integer ID_OPERA_PRE_CANCELACION = 130;
    public static final Integer ID_OPERA_RENOVACION = 131;
    public static final Integer ID_OPERA_COMPRA_SPOT = 132;
    public static final Integer ID_OPERA_VENTA_SPOT = 133;
    public static final Integer ID_OPERA_COMPRA_FWD= 134;
    public static final Integer ID_OPERA_VENTA_FWD = 135;
    public static final Integer ID_OPERA_ABONO_CTA_AHORRO = 136;
    public static final Integer ID_OPERA_RETIRO_CTA_AHORRO = 137;
    public static final Integer ID_OPERA_COMPRA_FIJA = 138;
    public static final Integer ID_OPERA_VENTA_FIJA = 139;
    public static final Integer ID_OPERA_COMPRA_VARIABLE = 139;
    public static final Integer ID_OPERA_VENTA_VARIABLE = 139;
    /**
     * Combos
     */
    public static final String  NO_OPTION_SELECTED = "-1";
    public static final Integer NO_OPTION_SELECTED_INT = -1;
    
    /**
     * Alertas
     */
    public static final String ORDENES_PAGE = "frmOrdenes.jsf";
    public static final String PORTAFOLIO_PAGE = "frmPortafolio.jsf";
    
    public static final int HORA_MONEY_MARKET = 11;
    public static final int HORA_RENTA_FIJA = 13;
    public static final int HORA_RENTA_VARIABLE = 15;
    public static final int MINUTO_ALERTA = 30;
    /**
     * Observaciones de Operaciones de Orden
     */
    public static final String CANCELAR_OBS = "Cancelar"; 
    
    public static final String __USUARIO_SESSION__ = "__USUARIO_SESSION__";
    
    public static final String WSLDAP_ENDPOINT = "http://118.180.14.23:8080/ws-ldap3/wService?wsdl";
    /**
     * Perfil
     */
    public static class Perfil{
    	public static final Integer TIPO_ADMINISTRADOR = 1;
    	public static final Integer TIPO_INVERSIONISTA = 2;
    	public static final Integer TIPO_RIESGO = 3;
    }
    
    public static class Mensajes{
    	public static final String MSJ_REGISTRO_OK = "Se registraron los datos exitosamente.";
    	public static final String MSJ_ACTUALIZACION_OK = "Se actualizaron los datos exitosamente.";
		public static final String MSJ_ELIMINACION_OK = "Se eliminó el registro exitosamente.";

		public static final String MSJ_REGISTRO_FAIL = "Ocurrió un error al registrar los datos.";
		public static final String MSJ_ACTUALIZACION_FAIL = "Ocurrió un error al actualizar los datos.";
		public static final String MSJ_ELIMINACION_FAIL = "Ocurrió un error al eliminar los datos.";
    }
    public static class EstadoProceso{
    	public static final String EN_PROCESO = "P";
    	public static final String ERRADO = "E";
    	public static final String TERMINADO = "T";
    }
    public static class Especie{
    	public static final String DESC_INSTRUMENTO_COBERTURA = "Instrum.Coberturad";
    	public static final String DESC_LETRAS_DEL_TESORO = "Letras del Tesoro";
    	public static final String DESC_CERTIFICADOS = "Certificados";
    	public static final String DESC_PAPELES_COMERCIALES = "Papeles Comerciale";
    	public static final String DESC_DEPOSITOS_PLAZO = "Depositos a plazo";
    	public static final String DESC_DEPOSITOS_DE_AHORRO = "Depositos de ahorr";
    	
    	public static final String DESC_ACCIONES = "Acciones";
    }
    public static class InfoPortTipoOperacion{
    	public static final String CODIGO_M = "M";
    	public static final String CODIGO_V = "V";
    	public static final String CODIGO_F = "F";
    }
    public static class Log{
    	public static class Mensaje{
    		public static final String MSJ_ERROR_PARSE_DOUBLE = "Error de lectura del campo. Error al convertir el valor a Numérico.";
    		public static final String MSJ_ERROR_PARSE_INTEGER = "Error de lectura del campo. Error al convertir el valor a Numérico Entero.";
    		public static final String MSJ_ERROR_PARSE_DATE = "Error de lectura del campo. Error al convertir el valor a Fecha.";
    		public static final String MSJ_ERROR_PARSE_DOUBLE_TO_STRING_ENTERO = "Error de lectura del campo. Error al convertir el valor entero a texto.";
    	}
    	public static class TipoMensaje{
    		public static final String INFO = "INFO";
    		public static final String WARNING = "WARNING";
    		public static final String ERROR = "ERROR";
    	}
    }
}
