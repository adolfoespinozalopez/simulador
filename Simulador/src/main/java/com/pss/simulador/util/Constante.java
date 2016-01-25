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
    
    /**
     * Fecha Inicial
     */
    public final static Date FECHA_INICIO = new Date(-1898, 0, 0, 0, 0, 0);
    public final static Date FECHA_ACTUAL = new Date();
    /**
     * Dominio
     */
    public static final String DOMINIO_MONEDA = "MONEDA";
    public static final String TIPO_APERTURA = "TIPOAPERTURA";
    public static final String MONEDA_OPERACION = "MONEDAOPERACION";
    public static final String TIPO_OPERACION_FWD = "TIPOOPERACIONFWD";
    public static final String TIPO_OPERACION_CUENTA = "TIPOOPERACIONCUENTA";
    
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
    
    /**
     * Perfil
     */
    public static final String __USUARIO_SESSION__ = "__USUARIO_SESSION__";
    
    public static final String WSLDAP_ENDPOINT = "http://118.180.14.23:8080/ws-ldap3/wService?wsdl";
    public static class Perfil{
    	public static final Integer ID_ADMINISTRADOR_SISTEMA = 1;
    	public static final Integer ID_ADMINISTRADOR_INVERSORES = 2;
    	public static final Integer ID_INVERSINISTA_EUR = 3;
    	public static final Integer ID_INVERSIONISTA_BBVA = 4;
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
