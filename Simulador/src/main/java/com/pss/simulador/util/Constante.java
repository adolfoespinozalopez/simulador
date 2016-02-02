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
    
    public static class OrdenEstado{
    	public static final String GENERADO = "1";
    	public static final String APROBADO = "2";
    	public static final String RECHAZADO = "3";
    	public static final String ENVIADO = "4";
    }
    
    public static class Dominio{
    	public static final String TIPO_EMISOR = "TIPOEMISOR";
    	public static final String TIPO_OPERACION = "TIPOOPERACION";
    	public static final String MONEDA = "MONEDA";
    	public static final String CONTRAPARTE = "CONTRAPARTE";
    	public static final String ESTADO_ORDEN = "ESTADOORDEN";
    	public static final String ESPECIE = "ESPECIE";
    }
    
    /**
     * Valores Dominio
     */
    public static final String TIPOAPERTURA_COBERTURADO = "COBERTURADO";
    public static final String TIPOAPERTURA_NORMAL = "NORMAL";
    public static final String VENCE_HOY = "VENCE HOY";
    
    /**
     * Combos
     */
    public static final String  NO_OPTION_SELECTED = "-1";
    public static final Integer NO_OPTION_SELECTED_INT = -1;
    
    /**
     * Alertas
     */
    public static final String ORDENES_PAGE = "frmOrdenes.jsf";
    public static final int HORA_MONEY_MARKET = 12;
    public static final int HORA_RENTA_FIJA = 13;
    public static final int HORA_RENTA_VARIABLE = 16;
    public static final int MINUTO_ALERTA = 30;
    
    /**
     * Perfil
     */
    public static final String __USUARIO_SESSION__ = "__USUARIO_SESSION__";
    
    public static final String WSLDAP_ENDPOINT = "http://118.180.14.23:8080/ws-ldap3/wService?wsdl";
    
    public static class Perfil{
    	public static final Integer TIPO_ADMINISTRADOR = 1;
    	public static final Integer TIPO_INVERSIONISTA = 2;
    }
    
    public static class Mensajes{
    	public static final String MSJ_REGISTRO_OK = "Se registraron los datos exitosamente.";
    	public static final String MSJ_ACTUALIZACION_OK = "Se actualizaron los datos exitosamente.";
		public static final String MSJ_ELIMINACION_OK = "Se eliminó el registro exitosamente.";

		public static final String MSJ_REGISTRO_FAIL = "Ocurrió un error al registrar los datos.";
		public static final String MSJ_ACTUALIZACION_FAIL = "Ocurrió un error al actualizar los datos.";
		public static final String MSJ_ELIMINACION_FAIL = "Ocurrió un error al eliminar los datos.";
    }
}
