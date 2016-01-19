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
     * Combos
     */
    public static final String  NO_OPTION_SELECTED = "-1";
}
