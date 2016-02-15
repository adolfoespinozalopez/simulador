/*
 *******************************************
 * OWNER
 *******************************************
 */
/*
CREATE USER bbvatesor IDENTIFIED BY bbvatesor default tablespace users temporary tablespace temp quota unlimited on users account unlock;

grant create session to bbvatesor;
grant resource to bbvatesor;
grant dba to bbvatesor;
*/

/*
 *******************************************
 *DROP TABLES
 *******************************************
 */
DROP TABLE bbvatesor.TSI001_Saldo CASCADE CONSTRAINTS PURGE;
DROP TABLE bbvatesor.TSI002_Infoport CASCADE CONSTRAINTS PURGE;
DROP TABLE bbvatesor.TSI003_CobranzaPago CASCADE CONSTRAINTS PURGE;
DROP TABLE bbvatesor.TSI004_TipoCambio CASCADE CONSTRAINTS PURGE;
DROP TABLE bbvatesor.TSI006_Usuario CASCADE CONSTRAINTS PURGE;
DROP TABLE bbvatesor.TSI009_PerfilFondo CASCADE CONSTRAINTS PURGE;
DROP TABLE bbvatesor.TSI007_Perfil CASCADE CONSTRAINTS PURGE;
DROP TABLE bbvatesor.TSI011_LimitesEmisor CASCADE CONSTRAINTS PURGE;
DROP TABLE bbvatesor.TSI012_LimFondoEspecie CASCADE CONSTRAINTS PURGE;
DROP TABLE bbvatesor.TSI014_OrdenEstado CASCADE CONSTRAINTS PURGE;
DROP TABLE bbvatesor.TSI015_DetalleOrden CASCADE CONSTRAINTS PURGE;
DROP TABLE bbvatesor.TSI013_Orden CASCADE CONSTRAINTS PURGE;
DROP TABLE bbvatesor.TSI010_Emisor CASCADE CONSTRAINTS PURGE;
DROP TABLE bbvatesor.TSI008_Fondo CASCADE CONSTRAINTS PURGE;
DROP TABLE bbvatesor.TSI005_General CASCADE CONSTRAINTS PURGE;
DROP TABLE bbvatesor.TSI009_EXPOFONDO CASCADE CONSTRAINTS PURGE;
DROP TABLE bbvatesor.TSI016_PROCESOCARGA CASCADE CONSTRAINTS PURGE;
DROP TABLE bbvatesor.TSI017_PROCESOLOG CASCADE CONSTRAINTS PURGE;

/*
 *******************************************
 * SEQUENCES
 *******************************************
 */
DROP SEQUENCE bbvatesor.SEQ_TIPOCAMBIO;
DROP SEQUENCE bbvatesor.SEQ_GENERAL;
DROP SEQUENCE bbvatesor.SEQ_COBRANZAPAGO;
DROP SEQUENCE bbvatesor.SEQ_DETALLEORDEN;
DROP SEQUENCE bbvatesor.SEQ_EMISOR;
DROP SEQUENCE bbvatesor.SEQ_INFOPORT;
DROP SEQUENCE bbvatesor.SEQ_LIMFONDOESPECIE;
DROP SEQUENCE bbvatesor.SEQ_LIMITESEMISOR;
DROP SEQUENCE bbvatesor.SEQ_ORDEN;
DROP SEQUENCE bbvatesor.SEQ_ORDENESTADO;
DROP SEQUENCE bbvatesor.SEQ_PERFIL;
DROP SEQUENCE bbvatesor.SEQ_SALDO;
DROP SEQUENCE bbvatesor.SEQ_PROCESOCARGA;
DROP SEQUENCE bbvatesor.SEQ_PROCESOLOG;
DROP SEQUENCE BBVATESOR.SEQ_EXPOFONDO;

CREATE SEQUENCE bbvatesor.SEQ_TIPOCAMBIO INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE bbvatesor.SEQ_GENERAL INCREMENT BY 1 START WITH 100;
CREATE SEQUENCE bbvatesor.SEQ_COBRANZAPAGO INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE bbvatesor.SEQ_DETALLEORDEN INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE bbvatesor.SEQ_EMISOR INCREMENT BY 1 START WITH 17;
CREATE SEQUENCE bbvatesor.SEQ_INFOPORT INCREMENT BY 1 START WITH 59;
CREATE SEQUENCE bbvatesor.SEQ_LIMFONDOESPECIE INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE bbvatesor.SEQ_LIMITESEMISOR INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE bbvatesor.SEQ_ORDEN INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE bbvatesor.SEQ_ORDENESTADO INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE bbvatesor.SEQ_PERFIL INCREMENT BY 1 START WITH 4;
CREATE SEQUENCE bbvatesor.SEQ_SALDO INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE bbvatesor.SEQ_PROCESOCARGA INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE bbvatesor.SEQ_PROCESOLOG INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE bbvatesor.SEQ_EXPOFONDO INCREMENT BY 1 START WITH 1;

/*
 *******************************************
 *CREATE TABLE
 *******************************************
 */
CREATE TABLE bbvatesor.TSI001_Saldo (
	cd_idsaldo  INTEGER  NOT NULL ,
	cd_cod_fondo  CHAR(4)  NULL ,
	nb_nom_fondo  VARCHAR2(40)  NULL ,
	tp_tipmoneda  CHAR(3)  NULL ,
	nu_num_cuenta  VARCHAR2(21)  NULL ,
	to_saldo_inicial  NUMBER  NULL ,
	im_dif_rescate  NUMBER  NULL ,
	im_suscripcion  NUMBER  NULL ,
	im_rescate  NUMBER  NULL ,
	im_vencimiento  NUMBER  NULL ,
	im_compras_tmasn  NUMBER  NULL ,
	im_ventas_tmasn  NUMBER  NULL ,
	im_compra  NUMBER  NULL ,
	im_venta  NUMBER  NULL ,
	im_cxp_acciones  NUMBER  NULL ,
	im_cxc_acciones  NUMBER  NULL ,
	im_comision  NUMBER  NULL ,
	to_saldo_final  NUMBER  NULL ,
	im_rescate_tmasn  NUMBER  NULL ,
	im_carte_tmenosuno  NUMBER  NULL ,
	im_porc_liquidez  NUMBER  NULL ,
	to_saldo_invertir  NUMBER  NULL ,
	nb_observacion  VARCHAR2(100)  NULL ,
	pc_porc_patrimonio  NUMBER  NULL ,
	im_pat_mon_fondo  NUMBER  NULL ,
	pc_porc_pat_tot  NUMBER  NULL ,
	pc_porc_continenta  NUMBER  NULL ,
	pc_porc_total  NUMBER  NULL ,
	im_mto_exceso  NUMBER  NULL ,
	pc_porc_acciones  NUMBER  NULL ,
	im_vinculado  NUMBER  NULL ,
	im_liquidez_inmedi  NUMBER  NULL ,
	im_solicitud_susc  NUMBER  NULL ,
	im_solicitud_resc  NUMBER  NULL ,
	im_cxp_pendiente  NUMBER  NULL ,
	im_saldo_tmasn  NUMBER  NULL ,
	st_estado  CHAR(1)  NULL ,
	fh_fec_importa  DATE  NULL 
);

CREATE  UNIQUE INDEX bbvatesor.ISI001P1_Saldo ON bbvatesor.TSI001_Saldo(cd_idsaldo  ASC);

ALTER TABLE bbvatesor.TSI001_Saldo ADD CONSTRAINT  ISI001P1_Saldo PRIMARY KEY (cd_idsaldo);


CREATE TABLE bbvatesor.TSI002_Infoport (
	cd_idinfoport  INTEGER  NOT NULL ,
	nb_nom_fondo  VARCHAR2(40)  NULL ,
	tp_tipfondo  CHAR(1)  NULL ,
	nb_nom_emisor  VARCHAR2(60)  NULL ,
	tp_rating_emisor  VARCHAR2(4)  NULL ,
	nb_especie  VARCHAR2(40)  NULL ,
	fh_fec_emision  DATE  NULL ,
	fh_fec_vencimiento  DATE  NULL ,
	im_nominal_en_mil  NUMBER  NULL ,
	im_cupon  NUMBER  NULL ,
	fh_fec_ult_cupon  DATE  NULL ,
	tp_modalidad  CHAR(1)  NULL ,
	im_precio_limpio  NUMBER  NULL ,
	im_precio_sucio  NUMBER  NULL ,
	im_valor_sin_inter  NUMBER  NULL ,
	im_interes_corrid  NUMBER  NULL ,
	im_valor_mon_ref  NUMBER  NULL ,
	tp_abrev_moneda  CHAR(3)  NULL ,
	im_valor_mon_local  NUMBER  NULL ,
	im_tot_ctas_cobrar  NUMBER  NULL ,
	im_tot_ctas_pagar  NUMBER  NULL ,
	nu_periodo  NUMBER  NULL ,
	im_ytm  NUMBER  NULL ,
	im_durac_norm  NUMBER  NULL ,
	im_durac_modif  NUMBER  NULL ,
	tp_clasifica  VARCHAR2(6)  NULL ,
	im_precio_act  NUMBER  NULL ,
	im_prec_com  NUMBER  NULL ,
	nb_isin  VARCHAR2(15)  NULL ,
	nb_mnemonico  VARCHAR2(15)  NULL ,
	nu_num_dias_vcto  NUMBER  NULL ,
	fh_fecvcto_sgt_cup  DATE  NULL ,
	fh_fec_ult_operac  DATE  NULL ,
	im_durac_nor_libor  NUMBER  NULL ,
	im_compra_t_mas_n  NUMBER  NULL ,
	nb_observacion  VARCHAR2(100)  NULL ,
	im_valor_por_durac  NUMBER  NULL ,
	im_valor_por_ytm  NUMBER  NULL ,
	nu_dia_para_venc  NUMBER  NULL ,
	st_estado_port  VARCHAR2(9)  NULL ,
	st_condicion  CHAR(1)  NULL ,
	st_estado  CHAR(1)  NULL ,
	fh_fec_importa  DATE  NULL ,
	tp_operacion  CHAR(1)  NULL
);

COMMENT ON TABLE bbvatesor.TSI002_Infoport IS 'Almacena la informaci�n del portafolio';

CREATE  UNIQUE INDEX bbvatesor.ISI002P1_Infoport ON bbvatesor.TSI002_Infoport(cd_idinfoport  ASC);

ALTER TABLE bbvatesor.TSI002_Infoport ADD CONSTRAINT  ISI002P1_Infoport PRIMARY KEY (cd_idinfoport);


CREATE TABLE bbvatesor.TSI003_CobranzaPago (
	cd_idcobranzaPago  INTEGER  NOT NULL ,
	cd_cod_fondo  CHAR(4)  NULL ,
	tip_operacion  VARCHAR2(6)  NULL ,
	fh_fec_ingreso  DATE  NULL ,
	fh_fec_liq  DATE  NULL ,
	nb_descripcion  VARCHAR2(100)  NULL ,
	tp_moneda  CHAR(1)  NULL ,
	im_monto  NUMBER  NULL ,
	im_mto_mon_fondo  NUMBER  NULL ,
	cd_sigla  CHAR(3)  NULL ,
	st_estado  CHAR(1)  NULL ,
	fh_fec_importa  DATE  NULL 
);

CREATE  UNIQUE INDEX bbvatesor.ISI003P1_CobranzaP ON bbvatesor.TSI003_CobranzaPago(cd_idcobranzaPago  ASC);

ALTER TABLE bbvatesor.TSI003_CobranzaPago ADD CONSTRAINT  ISI003P1_CobranzaP PRIMARY KEY (cd_idcobranzaPago);


CREATE TABLE bbvatesor.TSI004_TipoCambio (
	cd_idTipoCambio  INTEGER  NOT NULL ,
	fh_fec_ingreso  DATE  NULL ,
	nu_valor  NUMBER  NULL ,
	st_estado  CHAR(1)  NULL ,
	fh_fec_creacion  DATE  NULL ,
	cd_usu_creacion  VARCHAR2(10)  NULL ,
	fh_fec_modifica  DATE  NULL ,
	cd_usu_modifica  VARCHAR2(10)  NULL ,
	fh_fec_elimina  DATE  NULL ,
	cd_usu_elimina  VARCHAR2(10)  NULL
);

CREATE  UNIQUE INDEX bbvatesor.ISI004P1_TipCambio ON bbvatesor.TSI004_TipoCambio(cd_idTipoCambio  ASC);

ALTER TABLE bbvatesor.TSI004_TipoCambio ADD CONSTRAINT  ISI004P1_TipCambio PRIMARY KEY (cd_idTipoCambio);


CREATE TABLE bbvatesor.TSI005_General (
	cd_idgeneral  INTEGER  NOT NULL ,
	nb_dominio  VARCHAR2(30)  NULL ,
	nb_desc_general  VARCHAR2(60)  NULL ,
	nb_valor_general  VARCHAR2(40)  NULL ,
	st_estado  CHAR(1)  NULL ,
	fh_fec_creacion  DATE  NULL ,
	cd_usu_creacion  VARCHAR2(10)  NULL ,
	fh_fec_modifica  DATE  NULL ,
	cd_usu_modifica  VARCHAR2(10)  NULL ,
	fh_fec_elimina  DATE  NULL ,
	cd_usu_elimina  VARCHAR2(10)  NULL ,
	fg_editable char(1) NULL
);

CREATE  UNIQUE INDEX bbvatesor.ISI005P1_General ON bbvatesor.TSI005_General(cd_idgeneral  ASC);

ALTER TABLE bbvatesor.TSI005_General ADD CONSTRAINT  ISI005P1_General PRIMARY KEY (cd_idgeneral);

comment on column BBVATESOR.TSI005_GENERAL.fg_editable is '1-EDITABLE 0-NOEDITABLE';

CREATE TABLE bbvatesor.TSI006_Usuario (
	cd_idusuario  INTEGER  NOT NULL ,
	cd_idperfil  INTEGER  NOT NULL ,
	nb_nom_usu  VARCHAR2(40)  NULL ,
	nb_ape_pat_usu  VARCHAR2(40)  NULL ,
	nb_ape_mat_usu  VARCHAR2(40)  NULL ,
	cd_login  VARCHAR2(10)  NULL ,
	cd_clave  VARCHAR2(20)  NULL ,
	tp_tipdocumento  INTEGER  NULL ,
	nu_documento  VARCHAR2(14)  NULL ,
	st_estado  CHAR(1)  NULL ,
	fh_fec_creacion  DATE  NULL ,
	cd_usu_creacion  VARCHAR2(10)  NULL ,
	fh_fec_modifica  DATE  NULL ,
	cd_usu_modifica  VARCHAR2(10)  NULL ,
	fh_fec_elimina  DATE  NULL ,
	cd_usu_elimina  VARCHAR2(10)  NULL
);

CREATE  UNIQUE INDEX bbvatesor.ISI006P1_Usuario ON bbvatesor.TSI006_Usuario(cd_idusuario  ASC);

ALTER TABLE bbvatesor.TSI006_Usuario ADD CONSTRAINT  ISI006P1_Usuario PRIMARY KEY (cd_idusuario);

CREATE INDEX ISI006S1_Usuario ON bbvatesor.TSI006_Usuario (cd_idperfil  ASC);

CREATE TABLE bbvatesor.TSI007_Perfil (
	cd_idperfil  INTEGER  NOT NULL ,
	nb_mon_perfil  VARCHAR2(40)  NULL ,
	fh_fec_inicio  DATE  NULL ,
	fh_fec_fin  DATE  NULL ,
	tp_tipperfil  INTEGER  NULL ,
	st_estado  CHAR(1)  NULL ,
	fh_fec_creacion  DATE  NULL ,
	cd_usu_creacion  VARCHAR2(10)  NULL ,
	fh_fec_modifica  DATE  NULL ,
	cd_usu_modifica  VARCHAR2(10)  NULL ,
	fh_fec_elimina  DATE  NULL ,
	cd_usu_elimina  VARCHAR2(10)  NULL
);

CREATE  UNIQUE INDEX bbvatesor.ISI007P1_Perfil ON bbvatesor.TSI007_Perfil(cd_idperfil  ASC);

ALTER TABLE bbvatesor.TSI007_Perfil ADD CONSTRAINT  ISI007P1_Perfil PRIMARY KEY (cd_idperfil);


CREATE TABLE bbvatesor.TSI008_Fondo (
	cd_idfondo  INTEGER  NOT NULL ,
	cd_cod_fondo  CHAR(4)  NULL ,
	nb_nom_fondo  VARCHAR2(40)  NULL ,
	tp_tipmoneda  INTEGER  NULL ,
	tp_tipfondo  CHAR(1)  NULL 
);

CREATE  UNIQUE INDEX bbvatesor.ISI008P1_Fondo ON bbvatesor.TSI008_Fondo(cd_idfondo  ASC);

ALTER TABLE bbvatesor.TSI008_Fondo ADD CONSTRAINT  ISI008P1_Fondo PRIMARY KEY (cd_idfondo);


CREATE TABLE bbvatesor.TSI009_PerfilFondo (
	cd_idperfil  INTEGER  NOT NULL ,
	cd_idfondo  INTEGER  NOT NULL ,
	st_estado  CHAR(1)  NULL ,
	fh_fec_creacion  DATE  NULL ,
	cd_usu_creacion  VARCHAR2(10)  NULL ,
	fh_fec_modifica  DATE  NULL ,
	cd_usu_modifica  VARCHAR2(10)  NULL ,
	fh_fec_elimina  DATE  NULL ,
	cd_usu_elimina  VARCHAR2(10)  NULL
);

CREATE  UNIQUE INDEX bbvatesor.ISI009P1_PerfilFdo ON bbvatesor.TSI009_PerfilFondo(cd_idperfil  ASC, cd_idfondo  ASC);

ALTER TABLE bbvatesor.TSI009_PerfilFondo ADD CONSTRAINT  ISI009P1_PerfilFdo PRIMARY KEY (cd_idperfil,cd_idfondo);

CREATE INDEX ISI009S1_PerfilFdo ON bbvatesor.TSI009_PerfilFondo (cd_idperfil  ASC);

CREATE INDEX ISI009S2_PerfilFdo ON bbvatesor.TSI009_PerfilFondo (cd_idfondo  ASC);


CREATE TABLE bbvatesor.TSI010_Emisor (
	cd_idemisor  INTEGER  NOT NULL ,
	nb_nom_emisor  VARCHAR2(60)  NULL ,
	tp_rating  VARCHAR2(3)  NULL ,
	im_pasivo  NUMBER  NULL ,
	tp_tipemisor  INTEGER  NULL ,
	st_estado  CHAR(1)  NULL ,
	fh_fec_creacion  DATE  NULL ,
	cd_usu_creacion  VARCHAR2(10)  NULL ,
	fh_fec_modifica  DATE  NULL ,
	cd_usu_modifica  VARCHAR2(10)  NULL ,
	fh_fec_elimina  DATE  NULL ,
	cd_usu_elimina  VARCHAR2(10)  NULL
);

CREATE  UNIQUE INDEX bbvatesor.ISI010P1_Emisor ON bbvatesor.TSI010_Emisor(cd_idemisor  ASC);

ALTER TABLE bbvatesor.TSI010_Emisor ADD CONSTRAINT  ISI010P1_Emisor PRIMARY KEY (cd_idemisor);


CREATE TABLE bbvatesor.TSI011_LimitesEmisor (
	cd_idlimite  INTEGER  NOT NULL ,
	cd_idfondo  INTEGER  NULL ,
	cd_idemisor  INTEGER  NULL ,
	pc_porc_ini  NUMBER  NULL ,
	pc_porc_fin  NUMBER  NULL ,
	nu_monto_ini  NUMBER  NULL ,
	nu_monto_fin  NUMBER  NULL ,
	st_estado  CHAR(1)  NULL ,
	fh_fec_creacion  DATE  NULL ,
	cd_usu_creacion  VARCHAR2(10)  NULL ,
	fh_fec_modifica  DATE  NULL ,
	cd_usu_modifica  VARCHAR2(10)  NULL ,
	fh_fec_elimina  DATE  NULL ,
	cd_usu_elimina  VARCHAR2(10)  NULL
);

CREATE  UNIQUE INDEX bbvatesor.ISI011P1_LimEmisor ON bbvatesor.TSI011_LimitesEmisor(cd_idlimite  ASC);

ALTER TABLE bbvatesor.TSI011_LimitesEmisor ADD CONSTRAINT  ISI011P1_LimEmisor PRIMARY KEY (cd_idlimite);

CREATE INDEX ISI011S1_LimEmisor ON bbvatesor.TSI011_LimitesEmisor (cd_idfondo  ASC);

CREATE INDEX ISI011S2_LimEmisor ON bbvatesor.TSI011_LimitesEmisor (cd_idemisor  ASC);


CREATE TABLE bbvatesor.TSI012_LimFondoEspecie (
	cd_idconfiguracion  INTEGER  NOT NULL ,
	cd_idfondo  INTEGER  NOT NULL ,
	cd_idgeneral  INTEGER  NOT NULL ,
	cd_idemisor  INTEGER  NOT NULL ,
	pc_porc_ini  NUMBER  NULL ,
	pc_porc_fin  NUMBER  NULL ,
	nu_monto_ini  NUMBER  NULL ,
	nu_monto_fin  NUMBER  NULL ,
	st_estado  CHAR(1)  NULL ,
	fh_fec_creacion  DATE  NULL ,
	cd_usu_creacion  VARCHAR2(10)  NULL ,
	fh_fec_modifica  DATE  NULL ,
	cd_usu_modifica  VARCHAR2(10)  NULL ,
	fh_fec_elimina  DATE  NULL ,
	cd_usu_elimina  VARCHAR2(10)  NULL 
);

ALTER TABLE bbvatesor.TSI012_LimFondoEspecie ADD CONSTRAINT  ISI012P1_LimFdoEsp PRIMARY KEY (cd_idconfiguracion);

alter table bbvatesor.TSI012_LIMFONDOESPECIE
  add constraint UK_LIMFONESP unique (CD_IDFONDO, CD_IDGENERAL, CD_IDEMISOR);

CREATE TABLE bbvatesor.TSI013_Orden (
	cd_idorden  INTEGER  NOT NULL ,
	cd_idfondo  INTEGER  NULL ,
	cd_idemisor  INTEGER  NULL ,
	cd_idcontraparte  INTEGER  NULL ,
	cd_idOperacion  INTEGER  NULL ,
	cd_idEspecie  INTEGER  NULL ,
	cd_idintermediario  INTEGER  NULL ,
	cd_idlugar  INTEGER  NULL ,
	cd_idpais   INTEGER  NULL ,
	cd_idtipmoneda  INTEGER  NULL ,
	tp_tipOperacion CHAR(1) NULL ,
	fh_fec_efectividad  DATE  NULL ,
	im_tasa  NUMBER  NULL ,
	nu_plazo_dia  NUMBER  NULL ,
	fh_fec_inicio  DATE  NULL ,
	fh_fec_vencimiento  DATE  NULL ,
	im_capital  NUMBER  NULL ,
	im_interes  NUMBER  NULL ,
	im_tasa_precancel  NUMBER  NULL ,
	im_monto_final  NUMBER  NULL ,
	im_tipoCambioSpot  NUMBER  NULL ,
	tp_moneOperacion VARCHAR2(40) NULL ,
	tp_forward  VARCHAR2(40)  NULL ,
	tp_apertura  VARCHAR2(40)  NULL ,
	tp_operacuenta  VARCHAR2(40)  NULL ,
	nu_puntofwd  NUMBER  NULL ,
	im_tipoCambioFwd  NUMBER  NULL ,
	nb_mnemonico  VARCHAR(15)  NULL ,
	im_precio_limpio  NUMBER  NULL ,
	im_precio_sucio  NUMBER  NULL ,
	im_precio_referencia  NUMBER  NULL ,
	st_estado  CHAR(1)  NULL ,
	fh_fec_creacion  DATE  NULL ,
	cd_usu_creacion  VARCHAR2(10)  NULL ,
	fh_fec_modifica  DATE  NULL ,
	cd_usu_modifica  VARCHAR2(10)  NULL ,
	fh_fec_elimina  DATE  NULL ,
	cd_usu_elimina  VARCHAR2(10)  NULL
);

CREATE  UNIQUE INDEX bbvatesor.ISI013P1_Orden ON bbvatesor.TSI013_Orden(cd_idorden  ASC);

ALTER TABLE bbvatesor.TSI013_Orden ADD CONSTRAINT  ISI013P1_Orden PRIMARY KEY (cd_idorden);

CREATE INDEX ISI013S1_Orden ON bbvatesor.TSI013_Orden (cd_idcontraparte  ASC);

CREATE INDEX ISI013S2_Orden ON bbvatesor.TSI013_Orden (cd_idfondo  ASC);

CREATE INDEX ISI013S3_Orden ON bbvatesor.TSI013_Orden (cd_idemisor  ASC);

CREATE INDEX ISI013S4_Orden ON bbvatesor.TSI013_Orden (cd_idOperacion  ASC);

CREATE INDEX ISI013S5_Orden ON bbvatesor.TSI013_Orden (cd_idEspecie  ASC);

CREATE INDEX ISI013S6_Orden ON bbvatesor.TSI013_Orden (cd_idintermediario  ASC);

CREATE INDEX ISI013S7_Orden ON bbvatesor.TSI013_Orden (cd_idlugar  ASC);

CREATE INDEX ISI013S8_Orden ON bbvatesor.TSI013_Orden (cd_idpais  ASC);

CREATE INDEX ISI013S9_Orden ON bbvatesor.TSI013_Orden (cd_idtipmoneda  ASC);

CREATE TABLE bbvatesor.TSI014_OrdenEstado (
	cd_idestOrden  INTEGER  NOT NULL ,
	cd_idorden  INTEGER  NULL ,
	cd_idgeneral  INTEGER  NULL ,
	fh_fec_creacion  DATE  NULL ,
	cd_usu_creacion  VARCHAR2(10)  NULL
);

CREATE  UNIQUE INDEX bbvatesor.ISI014P1_OrdenEstado ON bbvatesor.TSI014_OrdenEstado(cd_idestOrden  ASC);

ALTER TABLE bbvatesor.TSI014_OrdenEstado ADD CONSTRAINT  ISI014P1_OrdenEstado PRIMARY KEY (cd_idestOrden);

CREATE INDEX ISI014S1_OrdenEstado ON bbvatesor.TSI014_OrdenEstado (cd_idgeneral  ASC);


CREATE TABLE bbvatesor.TSI015_DetalleOrden (
	cd_iddetalle  INTEGER  NOT NULL ,
	cd_idorden  INTEGER  NULL ,
	nb_nom_fondo  VARCHAR2(40)  NULL ,
	tp_tipfondo  CHAR(1)  NULL ,
	nb_nom_emisor  VARCHAR2(60)  NULL ,
	tp_rating_emisor  VARCHAR2(4)  NULL ,
	nb_especie  VARCHAR2(40)  NULL ,
	fh_fec_emision  DATE  NULL ,
	fh_fec_vencimiento  DATE  NULL ,
	im_nominal_en_mil  NUMBER  NULL ,
	im_cupon  NUMBER  NULL ,
	fh_fec_ult_cupon  DATE  NULL ,
	tp_modalidad  CHAR(1)  NULL ,
	im_precio_limpio  NUMBER  NULL ,
	im_precio_sucio  NUMBER  NULL ,
	im_valor_sin_inter  NUMBER  NULL ,
	im_interes_corrid  NUMBER  NULL ,
	im_valor_mon_ref  NUMBER  NULL ,
	tp_abrev_moneda  CHAR(3)  NULL ,
	im_valor_mon_local  NUMBER  NULL ,
	im_tot_ctas_cobrar  NUMBER  NULL ,
	im_tot_ctas_pagar  NUMBER  NULL ,
	nu_periodo  NUMBER  NULL ,
	im_ytm  NUMBER  NULL ,
	im_durac_norm  NUMBER  NULL ,
	im_durac_modif  NUMBER  NULL ,
	tp_clasifica  VARCHAR2(6)  NULL ,
	im_precio_act  NUMBER  NULL ,
	im_prec_com  NUMBER  NULL ,
	nb_isin  VARCHAR2(15)  NULL ,
	nb_mnemonico  VARCHAR2(15)  NULL ,
	nu_num_dias_vcto  NUMBER  NULL ,
	fh_fecvcto_sgt_cup  DATE  NULL ,
	fh_fec_ult_operac  DATE  NULL ,
	im_durac_nor_libor  NUMBER  NULL ,
	im_compra_t_mas_n  NUMBER  NULL ,
	nb_observacion  VARCHAR2(100)  NULL ,
	im_valor_por_durac  NUMBER  NULL ,
	im_valor_por_ytm  NUMBER  NULL ,
	nu_dia_para_venc  NUMBER  NULL ,
	st_estado_port  VARCHAR2(9)  NULL ,
	st_condicion  CHAR(1)  NULL ,
	st_estado  CHAR(1)  NULL ,
	fh_fec_importa  DATE  NULL ,
	tp_operacion  CHAR(1)  NULL
);

CREATE  UNIQUE INDEX bbvatesor.ISI015P1_DetalleOrden ON bbvatesor.TSI015_DetalleOrden(cd_iddetalle  ASC);

ALTER TABLE bbvatesor.TSI015_DetalleOrden ADD CONSTRAINT  ISI015P1_DetalleOrden PRIMARY KEY (cd_iddetalle);

CREATE INDEX ISI015S1_DetalleOrden ON bbvatesor.TSI015_DetalleOrden (cd_idorden  ASC);


 /*
 *******************************************
 *FOREIGN KEY
 *******************************************
 */
ALTER TABLE bbvatesor.TSI006_Usuario 
  ADD (CONSTRAINT  R006007 FOREIGN KEY (cd_idperfil) REFERENCES TSI007_Perfil(cd_idperfil));

ALTER TABLE bbvatesor.TSI009_PerfilFondo
  ADD (CONSTRAINT  R007009 FOREIGN KEY (cd_idperfil) REFERENCES bbvatesor.TSI007_Perfil(cd_idperfil));

ALTER TABLE bbvatesor.TSI009_PerfilFondo
  ADD (CONSTRAINT  R008009 FOREIGN KEY (cd_idfondo) REFERENCES bbvatesor.TSI008_Fondo(cd_idfondo));

ALTER TABLE bbvatesor.TSI011_LimitesEmisor
  ADD (CONSTRAINT  R008011 FOREIGN KEY (cd_idfondo) REFERENCES bbvatesor.TSI008_Fondo(cd_idfondo));

ALTER TABLE bbvatesor.TSI011_LimitesEmisor
  ADD (CONSTRAINT  R010011 FOREIGN KEY (cd_idemisor) REFERENCES bbvatesor.TSI010_Emisor(cd_idemisor));

ALTER TABLE bbvatesor.TSI012_LimFondoEspecie
  ADD (CONSTRAINT  R010012 FOREIGN KEY (cd_idemisor) REFERENCES bbvatesor.TSI010_Emisor(cd_idemisor));

ALTER TABLE bbvatesor.TSI012_LimFondoEspecie
  ADD (CONSTRAINT  R005012 FOREIGN KEY (cd_idgeneral) REFERENCES bbvatesor.TSI005_General(cd_idgeneral));

ALTER TABLE bbvatesor.TSI012_LimFondoEspecie
  ADD (CONSTRAINT  R008012 FOREIGN KEY (cd_idfondo) REFERENCES bbvatesor.TSI008_Fondo(cd_idfondo));
  
ALTER TABLE bbvatesor.TSI013_Orden
  ADD (CONSTRAINT  R008013 FOREIGN KEY (cd_idfondo) REFERENCES bbvatesor.TSI008_Fondo(cd_idfondo));

ALTER TABLE bbvatesor.TSI013_Orden
  ADD (CONSTRAINT  R010013 FOREIGN KEY (cd_idemisor) REFERENCES bbvatesor.TSI010_Emisor(cd_idemisor));
  
ALTER TABLE bbvatesor.TSI013_Orden
  ADD (CONSTRAINT  R0050131 FOREIGN KEY (cd_idcontraparte) REFERENCES bbvatesor.TSI005_General(cd_idgeneral));

ALTER TABLE bbvatesor.TSI013_Orden
  ADD (CONSTRAINT  R0050132 FOREIGN KEY (cd_idOperacion) REFERENCES bbvatesor.TSI005_General(cd_idgeneral));

ALTER TABLE bbvatesor.TSI013_Orden
  ADD (CONSTRAINT  R0050133 FOREIGN KEY (cd_idEspecie) REFERENCES bbvatesor.TSI005_General(cd_idgeneral));
  
ALTER TABLE bbvatesor.TSI013_Orden
  ADD (CONSTRAINT  R0050134 FOREIGN KEY (cd_idintermediario) REFERENCES bbvatesor.TSI005_General(cd_idgeneral));
  
ALTER TABLE bbvatesor.TSI013_Orden
  ADD (CONSTRAINT  R0050135 FOREIGN KEY (cd_idlugar) REFERENCES bbvatesor.TSI005_General(cd_idgeneral));
  
ALTER TABLE bbvatesor.TSI013_Orden
  ADD (CONSTRAINT  R0050136 FOREIGN KEY (cd_idpais) REFERENCES bbvatesor.TSI005_General(cd_idgeneral));
   
ALTER TABLE bbvatesor.TSI013_Orden
  ADD (CONSTRAINT  R0050137 FOREIGN KEY (cd_idtipmoneda) REFERENCES bbvatesor.TSI005_General(cd_idgeneral));

ALTER TABLE bbvatesor.TSI014_OrdenEstado
  ADD (CONSTRAINT  R005014 FOREIGN KEY (cd_idgeneral) REFERENCES bbvatesor.TSI005_General(cd_idgeneral));

ALTER TABLE bbvatesor.TSI014_OrdenEstado
  ADD (CONSTRAINT  R013014 FOREIGN KEY (cd_idorden) REFERENCES bbvatesor.TSI013_Orden(cd_idorden));

ALTER TABLE bbvatesor.TSI015_DetalleOrden
  ADD (CONSTRAINT  R013015 FOREIGN KEY (cd_idorden) REFERENCES bbvatesor.TSI013_Orden(cd_idorden));

  
/*
 *******************************************
 * INSERTS TSI007_PERFIL
 *******************************************
 */
insert into bbvatesor.TSI007_PERFIL (cd_idperfil, nb_mon_perfil, fh_fec_inicio, fh_fec_fin, tp_tipperfil, fh_fec_creacion, cd_usu_creacion, fh_fec_modifica, cd_usu_modifica, fh_fec_elimina, cd_usu_elimina, st_estado)
values (1, 'Administrador de Sistema', to_date('21-01-2016', 'dd-mm-yyyy'), to_date('19-01-2017', 'dd-mm-yyyy'), 1, to_date('21-01-2016', 'dd-mm-yyyy'), 'Inicial', null, null, null, null, '1');
insert into bbvatesor.TSI007_PERFIL (cd_idperfil, nb_mon_perfil, fh_fec_inicio, fh_fec_fin, tp_tipperfil, fh_fec_creacion, cd_usu_creacion, fh_fec_modifica, cd_usu_modifica, fh_fec_elimina, cd_usu_elimina, st_estado)
values (2, 'Administrador de Inversiones', to_date('21-01-2016', 'dd-mm-yyyy'), to_date('19-01-2017', 'dd-mm-yyyy'), 1, to_date('21-01-2016', 'dd-mm-yyyy'), 'Inicial', null, null, null, null, '1');
insert into bbvatesor.TSI007_PERFIL (cd_idperfil, nb_mon_perfil, fh_fec_inicio, fh_fec_fin, tp_tipperfil, fh_fec_creacion, cd_usu_creacion, fh_fec_modifica, cd_usu_modifica, fh_fec_elimina, cd_usu_elimina, st_estado)
values (3, 'Riesgo', to_date('21-01-2016', 'dd-mm-yyyy'), to_date('19-01-2017', 'dd-mm-yyyy'), 3, to_date('21-01-2016', 'dd-mm-yyyy'), 'Inicial', null, null, null, null, '1');
insert into bbvatesor.TSI007_PERFIL (cd_idperfil, nb_mon_perfil, fh_fec_inicio, fh_fec_fin, tp_tipperfil, fh_fec_creacion, cd_usu_creacion, fh_fec_modifica, cd_usu_modifica, fh_fec_elimina, cd_usu_elimina, st_estado)
values (4, 'Inversionista', to_date('21-01-2016', 'dd-mm-yyyy'), to_date('19-01-2017', 'dd-mm-yyyy'), 2, to_date('21-01-2016', 'dd-mm-yyyy'), 'Inicial', null, null, null, null, '1');
commit;


/*
 *******************************************
 * INSERTS TSI006_USUARIO
 *******************************************
 */
insert into bbvatesor.TSI006_USUARIO (cd_idusuario, nb_nom_usu, nb_ape_pat_usu, nb_ape_mat_usu, cd_login, cd_clave, tp_tipdocumento, nu_documento, fh_fec_creacion, cd_usu_creacion, fh_fec_modifica, cd_usu_modifica, fh_fec_elimina, cd_usu_elimina, st_estado, cd_idperfil)
values (1, null, null, null, 'P004036', null, 1, '1', to_date('21-01-2016', 'dd-mm-yyyy'), 'Inicial', null, null, null, null, '1', 4);

insert into bbvatesor.TSI006_USUARIO (cd_idusuario, nb_nom_usu, nb_ape_pat_usu, nb_ape_mat_usu, cd_login, cd_clave, tp_tipdocumento, nu_documento, fh_fec_creacion, cd_usu_creacion, fh_fec_modifica, cd_usu_modifica, fh_fec_elimina, cd_usu_elimina, st_estado, cd_idperfil)
values (2, null, null, null, 'P005738', null, 1, '1', to_date('29-01-2016', 'dd-mm-yyyy'), 'Inicial', null, null, null, null, '1', 1);

insert into bbvatesor.TSI006_USUARIO (cd_idusuario, nb_nom_usu, nb_ape_pat_usu, nb_ape_mat_usu, cd_login, cd_clave, tp_tipdocumento, nu_documento, fh_fec_creacion, cd_usu_creacion, fh_fec_modifica, cd_usu_modifica, fh_fec_elimina, cd_usu_elimina, st_estado, cd_idperfil)
values (3, null, null, null, 'P020188', null, 1, '1', to_date('29-01-2016', 'dd-mm-yyyy'), 'Inicial', null, null, null, null, '1', 2);

insert into bbvatesor.TSI006_USUARIO (cd_idusuario, nb_nom_usu, nb_ape_pat_usu, nb_ape_mat_usu, cd_login, cd_clave, tp_tipdocumento, nu_documento, fh_fec_creacion, cd_usu_creacion, fh_fec_modifica, cd_usu_modifica, fh_fec_elimina, cd_usu_elimina, st_estado, cd_idperfil)
values (4, null, null, null, 'P004943', null, 1, '1', to_date('29-01-2016', 'dd-mm-yyyy'), 'Inicial', null, null, null, null, '1', 3);

commit;


 /*
 *******************************************
 * INSERTS TSI005_GENERAL
 *******************************************
 */
--MONEDA
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (1, 'MONEDA', 'PEN', 'PEN', '1', to_date('13-01-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (2, 'MONEDA', 'USD', 'USD', '1', to_date('13-01-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');

--TIPOEMISOR
insert into bbvatesor.TSI005_GENERAL (cd_idgeneral, nb_dominio, nb_desc_general, nb_valor_general, st_estado, fh_fec_creacion, cd_usu_creacion, fh_fec_modifica, cd_usu_modifica, fh_fec_elimina, cd_usu_elimina, fg_editable)
values (3, 'TIPOEMISOR', 'Bancos Locales', 'Bancos Locales', '1', to_date('25-01-2016', 'dd-mm-yyyy'), 'P000000', null, null, null, null, '1');
insert into bbvatesor.TSI005_GENERAL (cd_idgeneral, nb_dominio, nb_desc_general, nb_valor_general, st_estado, fh_fec_creacion, cd_usu_creacion, fh_fec_modifica, cd_usu_modifica, fh_fec_elimina, cd_usu_elimina, fg_editable)
values (4, 'TIPOEMISOR', 'Corps. Locales', 'Corps. Locales', '1', to_date('25-01-2016', 'dd-mm-yyyy'), 'P000000', null, null, null, null, '1');
insert into bbvatesor.TSI005_GENERAL (cd_idgeneral, nb_dominio, nb_desc_general, nb_valor_general, st_estado, fh_fec_creacion, cd_usu_creacion, fh_fec_modifica, cd_usu_modifica, fh_fec_elimina, cd_usu_elimina, fg_editable)
values (5, 'TIPOEMISOR', 'LATAM', 'LATAM', '1', to_date('25-01-2016', 'dd-mm-yyyy'), 'P000000', null, null, null, null, '1');
insert into bbvatesor.TSI005_GENERAL (cd_idgeneral, nb_dominio, nb_desc_general, nb_valor_general, st_estado, fh_fec_creacion, cd_usu_creacion, fh_fec_modifica, cd_usu_modifica, fh_fec_elimina, cd_usu_elimina, fg_editable)
values (6, 'TIPOEMISOR', 'Otros', 'Otros', '1', to_date('25-01-2016', 'dd-mm-yyyy'), 'P000000', null, null, null, null, '1');

--TIPOAPERTURA
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (7, 'TIPOAPERTURA', 'Normal', 'Normal', '1', to_date('13-01-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '0');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (8, 'TIPOAPERTURA', 'Coberturado', 'Coberturado', '1', to_date('13-01-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '0');

--TIPOOPERACIONFWD
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (9, 'TIPOOPERACIONFWD', 'FULL', 'FULL', '1', to_date('13-01-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '0');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (10, 'TIPOOPERACIONFWD', 'NDF', 'NDF', '1', to_date('13-01-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '0');

--MONEDAOPERACION
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (11, 'MONEDAOPERACION', 'COMPRA', 'COMPRA', '1', to_date('13-01-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '0');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (12, 'MONEDAOPERACION', 'VENTA', 'VENTA', '1', to_date('13-01-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '0');

--TIPOOPERACIONCUENTA
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (13, 'TIPOOPERACIONCUENTA', 'ABONO', 'ABONO', '1', to_date('13-01-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '0');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (14, 'TIPOOPERACIONCUENTA', 'CARGO', 'CARGO', '1', to_date('13-01-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '0');

--ESPECIE
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (15, 'ESPECIE', 'Acciones', 'Acciones', '1', to_date('13-01-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (16, 'ESPECIE', 'Bonos corporativos', 'Bonos corporativos', '1', to_date('13-01-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (17, 'ESPECIE', 'Bonos de arrendami', 'Bonos de arrendami', '1', to_date('13-01-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (18, 'ESPECIE', 'Bonos subordinados', 'Bonos subordinados', '1', to_date('13-01-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (19, 'ESPECIE', 'Certificados', 'Certificados', '1', to_date('13-01-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (20, 'ESPECIE', 'Depositos a plazo', 'Depositos a plazo', '1', to_date('13-01-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (21, 'ESPECIE', 'Depositos de ahorr', 'Depositos de ahorr', '1', to_date('13-01-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (22, 'ESPECIE', 'Instrum.Coberturad', 'Instrum.Coberturad', '1', to_date('13-01-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (23, 'ESPECIE', 'Instrumentos de go', 'Instrumentos de go', '1', to_date('13-01-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (24, 'ESPECIE', 'Letras del Tesoro', 'Letras del Tesoro', '1', to_date('13-01-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (25, 'ESPECIE', 'Papeles Comerciale', 'Papeles Comerciale', '1', to_date('13-01-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');

--CONTRAPARTE
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (26, 'CONTRAPARTE', 'BANCO CONTINENTAL', 'BANCO CONTINENTAL', '1', to_date('13-01-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (27, 'CONTRAPARTE', 'BANCO DE CREDITO', 'BANCO DE CREDITO', '1', to_date('13-01-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (28, 'CONTRAPARTE', 'BANCO FALABELLA PERU S.A.', 'BANCO FALABELLA PERU S.A.', '1', to_date('13-01-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (29, 'CONTRAPARTE', 'BANCO GNB', 'BANCO GNB', '1', to_date('13-01-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (30, 'CONTRAPARTE', 'BANCO RIPLEY', 'BANCO RIPLEY', '1', to_date('13-01-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (31, 'CONTRAPARTE', 'BANCO SANTANDER', 'BANCO SANTANDER', '1', to_date('13-01-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (32, 'CONTRAPARTE', 'BIF', 'BIF', '1', to_date('13-01-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (33, 'CONTRAPARTE', 'CREDISCOTIA FINANCIERA S.A.', 'CREDISCOTIA FINANCIERA S.A.', '1', to_date('13-01-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (34, 'CONTRAPARTE', 'DEUTSCHE BANK', 'DEUTSCHE BANK', '1', to_date('13-01-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (35, 'CONTRAPARTE', 'EMPRESA FINANCIERA EDYFICAR', 'EMPRESA FINANCIERA EDYFICAR', '1', to_date('13-01-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (36, 'CONTRAPARTE', 'FINANCIERA CONFIANZA S.A.A.', 'FINANCIERA CONFIANZA S.A.A.', '1', to_date('13-01-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (37, 'CONTRAPARTE', 'INTERBANK', 'INTERBANK', '1', to_date('13-01-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (38, 'CONTRAPARTE', 'MI BANCO', 'MI BANCO', '1', to_date('13-01-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (39, 'CONTRAPARTE', 'SCOTIABANK PERU', 'SCOTIABANK PERU', '1', to_date('13-01-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (40, 'CONTRAPARTE', 'BBVA NY', 'BBVA NY', '1', to_date('13-01-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (41, 'CONTRAPARTE', 'BANCOLOMBIA PANAMA', 'BANCOLOMBIA PANAMA', '1', to_date('13-01-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (42, 'CONTRAPARTE', 'BANCO DAVIVIENDA SA', 'BANCO DAVIVIENDA SA', '1', to_date('13-01-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (43, 'CONTRAPARTE', 'BANCO DE BOGOTA NY', 'BANCO DE BOGOTA NY', '1', to_date('13-01-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (44, 'CONTRAPARTE', 'SANTANDER BRASIL', 'SANTANDER BRASIL', '1', to_date('13-01-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
commit;

--TIPOOPERACION
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (45, 'TIPOOPERACION', 'Money Market', 'M', '1', to_date('28-01-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '0');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (46, 'TIPOOPERACION', 'Renta Fija', 'F', '1', to_date('28-01-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '0');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (47, 'TIPOOPERACION', 'Renta Variable', 'V', '1', to_date('28-01-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '0');

--ESTADOORDEN
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (48, 'ESTADOORDEN', 'Generado', '1', '1', to_date('28-01-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '0');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (49, 'ESTADOORDEN', 'Aprobado', '2', '1', to_date('28-01-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '0');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (50, 'ESTADOORDEN', 'Rechazado', '3', '1', to_date('28-01-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '0');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (51, 'ESTADOORDEN', 'Enviado', '4', '1', to_date('28-01-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '0');

--BROKERS
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (52, 'BROKERS', 'CREDIBOLSA SAB', 'CREDIBOLSA SAB', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (53, 'BROKERS', 'LEK SECURITIES', 'LEK SECURITIES', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (54, 'BROKERS', 'INTELIGO', 'INTELIGO', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (55, 'BROKERS', 'MGS SAB', 'MGS SAB', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (56, 'BROKERS', 'SCOTIA SAB', 'SCOTIA SAB', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (57, 'BROKERS', 'SEMINARIO SAB', 'SEMINARIO SAB', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (58, 'BROKERS', 'COMPASS GROUP SAB', 'COMPASS GROUP SAB', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (59, 'BROKERS', 'BTG Pactual Perú', 'BTG Pactual Perú', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (60, 'BROKERS', 'LARRAIN PERU SAB', 'LARRAIN PERU SAB', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (61, 'BROKERS', 'LARRAIN VIAL CHILE', 'LARRAIN VIAL CHILE', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (62, 'BROKERS', 'CONTINENTAL SAB', 'CONTINENTAL SAB', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');

--LUGAR_NEGOCIACION
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (63, 'LUGAR_NEGOCIACION', 'O.T.C.', '01', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (64, 'LUGAR_NEGOCIACION', 'MERCADO CENTRALIZADO', '02', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');

--PAIS_NEGOCIACION
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (65, 'PAIS_NEGOCIACION', 'PERU', '001', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (66, 'PAIS_NEGOCIACION', 'U.S.A.', '002', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (67, 'PAIS_NEGOCIACION', 'ALEMANIA', '005', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (68, 'PAIS_NEGOCIACION', 'ARABIA SAUDITA', '010', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (69, 'PAIS_NEGOCIACION', 'BELGICA', '011', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (70, 'PAIS_NEGOCIACION', 'ARGENTINA', '012', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (71, 'PAIS_NEGOCIACION', 'AUSTRALIA', '013', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (72, 'PAIS_NEGOCIACION', 'AUSTRIA', '014', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (73, 'PAIS_NEGOCIACION', 'BAHAMAS', '015', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (74, 'PAIS_NEGOCIACION', 'BARBADOS', '018', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (75, 'PAIS_NEGOCIACION', 'BELIZE', '019', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (76, 'PAIS_NEGOCIACION', 'BERMUDAS', '022', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (77, 'PAIS_NEGOCIACION', 'BOLIVIA', '024', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (78, 'PAIS_NEGOCIACION', 'BRASIL', '026', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (79, 'PAIS_NEGOCIACION', 'BULGARIA', '028', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (80, 'PAIS_NEGOCIACION', 'CANADA', '034', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (81, 'PAIS_NEGOCIACION', 'CHILE', '037', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (82, 'PAIS_NEGOCIACION', 'CHINA', '038', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (83, 'PAIS_NEGOCIACION', 'COLOMBIA', '040', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (84, 'PAIS_NEGOCIACION', 'COSTA RICA', '044', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (85, 'PAIS_NEGOCIACION', 'CUBA', '047', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (86, 'PAIS_NEGOCIACION', 'DINAMARCA', '048', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (87, 'PAIS_NEGOCIACION', 'DOMINICA', '050', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (88, 'PAIS_NEGOCIACION', 'ECUADOR', '051', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (89, 'PAIS_NEGOCIACION', 'EL SALVADOR', '054', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (90, 'PAIS_NEGOCIACION', 'ESPAÑA', '057', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (91, 'PAIS_NEGOCIACION', 'FILIPINAS', '060', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (92, 'PAIS_NEGOCIACION', 'FINLANDIA', '061', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (93, 'PAIS_NEGOCIACION', 'FRANCIA', '062', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (94, 'PAIS_NEGOCIACION', 'GRECIA', '067', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (95, 'PAIS_NEGOCIACION', 'GUATEMALA', '068', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (96, 'PAIS_NEGOCIACION', 'HAITI', '073', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (97, 'PAIS_NEGOCIACION', 'HOLANDA', '074', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (98, 'PAIS_NEGOCIACION', 'HONDURAS', '075', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (99, 'PAIS_NEGOCIACION', 'HUNGRIA', '076', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (100, 'PAIS_NEGOCIACION', 'IRLANDIA', '084', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (101, 'PAIS_NEGOCIACION', 'ISRAEL', '088', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (102, 'PAIS_NEGOCIACION', 'ITALIA', '089', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (103, 'PAIS_NEGOCIACION', 'JAMAICA', '091', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (104, 'PAIS_NEGOCIACION', 'JAPON', '092', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (105, 'PAIS_NEGOCIACION', 'OTROS PAISES', '099', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (106, 'PAIS_NEGOCIACION', 'LIECHTENSTEIN', '100', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (107, 'PAIS_NEGOCIACION', 'LUXEMBURGO', '101', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (108, 'PAIS_NEGOCIACION', 'MEXICO', '111', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (109, 'PAIS_NEGOCIACION', 'NICARAGUA', '119', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (110, 'PAIS_NEGOCIACION', 'NORUEGA', '122', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (111, 'PAIS_NEGOCIACION', 'NUEVA ZELANDA', '123', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (112, 'PAIS_NEGOCIACION', 'PANAMA', '127', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (113, 'PAIS_NEGOCIACION', 'PARAGUAY', '129', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (114, 'PAIS_NEGOCIACION', 'POLONIA', '130', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (115, 'PAIS_NEGOCIACION', 'PORTUGAL', '131', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (116, 'PAIS_NEGOCIACION', 'PUERTO RICO', '132', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (117, 'PAIS_NEGOCIACION', 'REPUBLICA DOMINICANA', '136', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (118, 'PAIS_NEGOCIACION', 'RUMANIA', '143', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (119, 'PAIS_NEGOCIACION', 'RUSIA', '144', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (120, 'PAIS_NEGOCIACION', 'SUECIA', '162', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (121, 'PAIS_NEGOCIACION', 'SUIZA', '163', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (122, 'PAIS_NEGOCIACION', 'SURINAME', '164', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (123, 'PAIS_NEGOCIACION', 'URUGUAY', '177', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (124, 'PAIS_NEGOCIACION', 'VENEZUELA', '179', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (125, 'PAIS_NEGOCIACION', 'YUGOSLAVIA', '181', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (126, 'PAIS_NEGOCIACION', 'REINO UNIDO', '200', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');

--OPERACION
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (127, 'OPERACION', 'Cancelación', 'Cancelación', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (128, 'OPERACION', 'Apertura DPF', 'Apertura DPF', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (129, 'OPERACION', 'Apertura DPF Cob', 'Apertura DPF Cob', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (130, 'OPERACION', 'Precancelación', 'Precancelación', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (131, 'OPERACION', 'Renovación DPF', 'Renovación DPF', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (132, 'OPERACION', 'Compra USD Spot', 'Compra USD Spot', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (133, 'OPERACION', 'Venta USD Spot', 'Venta USD Spot', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (134, 'OPERACION', 'Compra USD FWD', 'Compra USD FWD', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (135, 'OPERACION', 'Venta USD FWD', 'Venta USD FWD', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (136, 'OPERACION', 'Abono Cta Ahorro', 'Abono Cta Ahorro', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (137, 'OPERACION', 'Retiro Cta Ahorro', 'Retiro Cta Ahorro', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (138, 'OPERACION', 'Compra Fija', 'Compra Fija', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (139, 'OPERACION', 'Venta Fija', 'Venta Fija', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (140, 'OPERACION', 'Compra Variable', 'Compra Variable', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (141, 'OPERACION', 'Venta Variable', 'Venta Variable', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '1');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (142, 'RUTAPROCESOCARGA', 'Ruta de Archivo de Proceso de Carga', 'G:\mnt\simulador\tmp\portafolios.xlsm', '1', to_date('11-02-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '0');


 /*
 *******************************************
 * INSERTS TSI004_TIPOCAMBIO
 *******************************************
 */
insert into BBVATESOR.TSI004_TIPOCAMBIO (CD_IDTIPOCAMBIO, FH_FEC_INGRESO, NU_VALOR, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA)
values (1, to_date('04-02-2016', 'dd-mm-yyyy'), 2.8078, '1', to_date('04-02-2016', 'dd-mm-yyyy'), 'Inicial', null, null, null, null);
commit;

 /*
 *******************************************
 * INSERTS TSI010_EMISOR
 *******************************************
 */
insert into BBVATESOR.TSI010_EMISOR (CD_IDEMISOR, NB_NOM_EMISOR, TP_RATING, IM_PASIVO, TP_TIPEMISOR, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, ST_ESTADO)
values (1, 'MI BANCO', 'I', 0, 3, to_date('26-01-2016', 'dd-mm-yyyy'), 'Inicial', null, null, null, null, '1');
insert into BBVATESOR.TSI010_EMISOR (CD_IDEMISOR, NB_NOM_EMISOR, TP_RATING, IM_PASIVO, TP_TIPEMISOR, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, ST_ESTADO)
values (2, 'MEF', 'I', 0, 6, to_date('26-01-2016', 'dd-mm-yyyy'), 'Inicial', null, null, null, null, '1');
insert into BBVATESOR.TSI010_EMISOR (CD_IDEMISOR, NB_NOM_EMISOR, TP_RATING, IM_PASIVO, TP_TIPEMISOR, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, ST_ESTADO)
values (3, 'SCOTIABANK PERU', 'I', 0, 3, to_date('26-01-2016', 'dd-mm-yyyy'), 'Inicial', null, null, null, null, '1');
insert into BBVATESOR.TSI010_EMISOR (CD_IDEMISOR, NB_NOM_EMISOR, TP_RATING, IM_PASIVO, TP_TIPEMISOR, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, ST_ESTADO)
values (4, 'SAGA FALABELLA S.A.', 'I', 0, 3, to_date('26-01-2016', 'dd-mm-yyyy'), 'Inicial', null, null, null, null, '1');
insert into BBVATESOR.TSI010_EMISOR (CD_IDEMISOR, NB_NOM_EMISOR, TP_RATING, IM_PASIVO, TP_TIPEMISOR, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, ST_ESTADO)
values (5, 'INTERBANK', 'I', 0, 3, to_date('26-01-2016', 'dd-mm-yyyy'), 'Inicial', null, null, null, null, '1');
insert into BBVATESOR.TSI010_EMISOR (CD_IDEMISOR, NB_NOM_EMISOR, TP_RATING, IM_PASIVO, TP_TIPEMISOR, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, ST_ESTADO)
values (6, 'BANCO DE CREDITO', 'I', 0, 3, to_date('26-01-2016', 'dd-mm-yyyy'), 'Inicial', null, null, null, null, '1');
insert into BBVATESOR.TSI010_EMISOR (CD_IDEMISOR, NB_NOM_EMISOR, TP_RATING, IM_PASIVO, TP_TIPEMISOR, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, ST_ESTADO)
values (7, 'LUZ DEL SUR', 'I', 0, 4, to_date('26-01-2016', 'dd-mm-yyyy'), 'Inicial', null, null, null, null, '1');
insert into BBVATESOR.TSI010_EMISOR (CD_IDEMISOR, NB_NOM_EMISOR, TP_RATING, IM_PASIVO, TP_TIPEMISOR, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, ST_ESTADO)
values (8, 'CINEPLEX S.A.', 'I', 0, 4, to_date('26-01-2016', 'dd-mm-yyyy'), 'Inicial', null, null, null, null, '1');
insert into BBVATESOR.TSI010_EMISOR (CD_IDEMISOR, NB_NOM_EMISOR, TP_RATING, IM_PASIVO, TP_TIPEMISOR, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, ST_ESTADO)
values (9, 'BANCO FALABELLA PERU S.A.', 'I', 0, 3, to_date('26-01-2016', 'dd-mm-yyyy'), 'Inicial', null, null, null, null, '1');
insert into BBVATESOR.TSI010_EMISOR (CD_IDEMISOR, NB_NOM_EMISOR, TP_RATING, IM_PASIVO, TP_TIPEMISOR, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, ST_ESTADO)
values (10, 'SUPERMERCADOS PERUANOS', 'I', 0, 4, to_date('26-01-2016', 'dd-mm-yyyy'), 'Inicial', null, null, null, null, '1');
insert into BBVATESOR.TSI010_EMISOR (CD_IDEMISOR, NB_NOM_EMISOR, TP_RATING, IM_PASIVO, TP_TIPEMISOR, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, ST_ESTADO)
values (11, 'CREDISCOTIA FINANCIERA S.A.', 'I', 0, 3, to_date('26-01-2016', 'dd-mm-yyyy'), 'Inicial', null, null, null, null, '1');
insert into BBVATESOR.TSI010_EMISOR (CD_IDEMISOR, NB_NOM_EMISOR, TP_RATING, IM_PASIVO, TP_TIPEMISOR, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, ST_ESTADO)
values (12, 'COFIDE', 'I', 0, 3, to_date('26-01-2016', 'dd-mm-yyyy'), 'Inicial', null, null, null, null, '1');
insert into BBVATESOR.TSI010_EMISOR (CD_IDEMISOR, NB_NOM_EMISOR, TP_RATING, IM_PASIVO, TP_TIPEMISOR, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, ST_ESTADO)
values (13, 'BANCO CONTINENTAL', 'I', 0, 3, to_date('26-01-2016', 'dd-mm-yyyy'), 'Inicial', null, null, null, null, '1');
insert into BBVATESOR.TSI010_EMISOR (CD_IDEMISOR, NB_NOM_EMISOR, TP_RATING, IM_PASIVO, TP_TIPEMISOR, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, ST_ESTADO)
values (14, 'GLORIA', 'I', 0, 4, to_date('26-01-2016', 'dd-mm-yyyy'), 'Inicial', null, null, null, null, '1');
insert into BBVATESOR.TSI010_EMISOR (CD_IDEMISOR, NB_NOM_EMISOR, TP_RATING, IM_PASIVO, TP_TIPEMISOR, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, ST_ESTADO)
values (15, 'BANCO GNB', 'I', 0, 3, to_date('26-01-2016', 'dd-mm-yyyy'), 'Inicial', null, null, null, null, '1');
insert into BBVATESOR.TSI010_EMISOR (CD_IDEMISOR, NB_NOM_EMISOR, TP_RATING, IM_PASIVO, TP_TIPEMISOR, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, ST_ESTADO)
values (16, 'EMPRESA FINANCIERA EDYFICAR', 'I', 0, 3, to_date('26-01-2016', 'dd-mm-yyyy'), 'Inicial', null, null, null, null, '1');
insert into BBVATESOR.TSI010_EMISOR (CD_IDEMISOR, NB_NOM_EMISOR, TP_RATING, IM_PASIVO, TP_TIPEMISOR, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, ST_ESTADO)
values (17, 'BANCO CENTRAL DE RESERVA', 'I', 0, 6, to_date('26-01-2016', 'dd-mm-yyyy'), 'Inicial', null, null, null, null, '1');
commit;


 /*
 *******************************************
 * INSERTS TSI008_FONDO
 *******************************************
 */
insert into BBVATESOR.TSI008_FONDO (CD_IDFONDO, CD_COD_FONDO, NB_NOM_FONDO, TP_TIPMONEDA, TP_TIPFONDO)
values (1, '00', 'BBVA AGRE.SOLES', 1, 'F');
insert into BBVATESOR.TSI008_FONDO (CD_IDFONDO, CD_COD_FONDO, NB_NOM_FONDO, TP_TIPMONEDA, TP_TIPFONDO)
values (2, '00', 'BBVA AGRES. USD', 2, 'F');
insert into BBVATESOR.TSI008_FONDO (CD_IDFONDO, CD_COD_FONDO, NB_NOM_FONDO, TP_TIPMONEDA, TP_TIPFONDO)
values (3, '00', 'BBVA ANDINO', 2, 'F');
insert into BBVATESOR.TSI008_FONDO (CD_IDFONDO, CD_COD_FONDO, NB_NOM_FONDO, TP_TIPMONEDA, TP_TIPFONDO)
values (4, '00', 'BBVA BALA.SOLES', 1, 'F');
insert into BBVATESOR.TSI008_FONDO (CD_IDFONDO, CD_COD_FONDO, NB_NOM_FONDO, TP_TIPMONEDA, TP_TIPFONDO)
values (5, '00', 'BBVA BALANCEADO', 1, 'F');
insert into BBVATESOR.TSI008_FONDO (CD_IDFONDO, CD_COD_FONDO, NB_NOM_FONDO, TP_TIPMONEDA, TP_TIPFONDO)
values (6, '00', 'BBVA CREC.SOLES', 1, 'F');
insert into BBVATESOR.TSI008_FONDO (CD_IDFONDO, CD_COD_FONDO, NB_NOM_FONDO, TP_TIPMONEDA, TP_TIPFONDO)
values (7, '00', 'BBVA CRECIMIENT', 1, 'F');
insert into BBVATESOR.TSI008_FONDO (CD_IDFONDO, CD_COD_FONDO, NB_NOM_FONDO, TP_TIPMONEDA, TP_TIPFONDO)
values (8, '00', 'BBVA D.MONETAR.', 2, 'F');
insert into BBVATESOR.TSI008_FONDO (CD_IDFONDO, CD_COD_FONDO, NB_NOM_FONDO, TP_TIPMONEDA, TP_TIPFONDO)
values (9, '00', 'BBVA DOLARES', 2, 'F');
insert into BBVATESOR.TSI008_FONDO (CD_IDFONDO, CD_COD_FONDO, NB_NOM_FONDO, TP_TIPMONEDA, TP_TIPFONDO)
values (10, '00', 'BBVA LEER', 2, 'F');
insert into BBVATESOR.TSI008_FONDO (CD_IDFONDO, CD_COD_FONDO, NB_NOM_FONDO, TP_TIPMONEDA, TP_TIPFONDO)
values (11, '00', 'BBVA MODE.SOLES', 1, 'M');
insert into BBVATESOR.TSI008_FONDO (CD_IDFONDO, CD_COD_FONDO, NB_NOM_FONDO, TP_TIPMONEDA, TP_TIPFONDO)
values (12, '00', 'BBVA MODERADO', 1, 'F');
insert into BBVATESOR.TSI008_FONDO (CD_IDFONDO, CD_COD_FONDO, NB_NOM_FONDO, TP_TIPMONEDA, TP_TIPFONDO)
values (13, '00', 'BBVA PERU SOLES', 1, 'F');
insert into BBVATESOR.TSI008_FONDO (CD_IDFONDO, CD_COD_FONDO, NB_NOM_FONDO, TP_TIPMONEDA, TP_TIPFONDO)
values (14, '00', 'BBVA S.MONETAR.', 1, 'F');
insert into BBVATESOR.TSI008_FONDO (CD_IDFONDO, CD_COD_FONDO, NB_NOM_FONDO, TP_TIPMONEDA, TP_TIPFONDO)
values (15, '00', 'BBVA SEL.ESTRAT', 1, 'F');
insert into BBVATESOR.TSI008_FONDO (CD_IDFONDO, CD_COD_FONDO, NB_NOM_FONDO, TP_TIPMONEDA, TP_TIPFONDO)
values (16, '11', 'BBVA SOLES', 1, 'F');
insert into BBVATESOR.TSI008_FONDO (CD_IDFONDO, CD_COD_FONDO, NB_NOM_FONDO, TP_TIPMONEDA, TP_TIPFONDO)
values (17, '00', 'CASH DOLARES', 2, 'D');
insert into BBVATESOR.TSI008_FONDO (CD_IDFONDO, CD_COD_FONDO, NB_NOM_FONDO, TP_TIPMONEDA, TP_TIPFONDO)
values (18, '00', 'CASH SOLES', 1, 'D');
commit;


 /*
 *******************************************
 * INSERTS TSI002_INFOPORT
 *******************************************
 */
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'BANCO DE CREDITO', 'I', 'Bonos corporativos', to_date('21-08-2008', 'dd-mm-yyyy'), to_date('21-08-2018', 'dd-mm-yyyy'), 1500, 8.7187, to_date('21-02-2014', 'dd-mm-yyyy'), '4', 110.8934, 112.5588, 1663401.04, 24980.54, 1688381.59, 'PEN', 1688381.59, 0, 0, 90, 5.8799, 3.6781, 3.6259365, 'AAA', 110.8934, 117.34, 'PEP12000K059', 'CREDI1BA6A', 21, to_date('21-05-2014', 'dd-mm-yyyy'), to_date('09-07-2012', 'dd-mm-yyyy'), 3.6781325, null, null, 6210036, 9927515, 1573, 'ACTIVO', '0', 1, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'F');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'BANCO DE CREDITO', 'I', 'Bonos corporativos', to_date('21-08-2008', 'dd-mm-yyyy'), to_date('21-08-2018', 'dd-mm-yyyy'), 1500, 8.7187, to_date('21-02-2014', 'dd-mm-yyyy'), '4', 110.8934, 112.5588, 1663401.04, 24980.54, 1688381.59, 'PEN', 1688381.59, 0, 0, 90, 5.8799, 3.6781, 3.6259365, 'AAA', 110.8934, 117.34, 'PEP12000K059', 'CREDI1BA6A', 21, to_date('21-05-2014', 'dd-mm-yyyy'), to_date('09-07-2012', 'dd-mm-yyyy'), 3.6781325, null, null, 6210036.326179, 9927514.911041, 1573, 'ACTIVO', '0', 2, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'F');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'BANCO DE CREDITO', 'I', 'Bonos corporativos', to_date('02-11-2011', 'dd-mm-yyyy'), to_date('02-11-2016', 'dd-mm-yyyy'), 3000, 6.2188, to_date('02-11-2013', 'dd-mm-yyyy'), '2', 102.4673, 105.5423, 3074017.81, 92250.52, 3166268.33, 'PEN', 3166268.33, 0, 0, 180, 5.1352, 2.33, 2.2723844, 'AAA', 102.4673, 100, 'PEP12000M261', 'CREDI4BC9A', 2, to_date('02-05-2014', 'dd-mm-yyyy'), to_date('02-11-2011', 'dd-mm-yyyy'), 2.3299592, null, null, 7377405.2089, 16259421.128216, 916, 'ACTIVO', '0', 3, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'F');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'MI BANCO', 'I', 'Bonos corporativos', to_date('25-04-2012', 'dd-mm-yyyy'), to_date('25-04-2015', 'dd-mm-yyyy'), 4766, 5.3438, to_date('25-04-2014', 'dd-mm-yyyy'), '2', 99.8157, 99.8887, 4757883.15, 3479.76, 4761362.91, 'PEN', 4761362.91, 0, 0, 180, 5.5952, .7405, .7206146, 'AA', 99.8157, 100.12, 'PEP13300M082', 'MIBAN3BC2A', 178, to_date('25-10-2014', 'dd-mm-yyyy'), to_date('17-10-2013', 'dd-mm-yyyy'), .7404981, null, null, 3525789.234855, 26640777.754032, 359, 'ACTIVO', '0', 4, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'F');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'SCOTIABANK PERU', 'I', 'Bonos corporativos', to_date('23-07-2010', 'dd-mm-yyyy'), to_date('23-07-2017', 'dd-mm-yyyy'), 5000, 7.3125, to_date('23-01-2014', 'dd-mm-yyyy'), '2', 105.4876, 107.447, 5274379.82, 97971.34, 5372351.16, 'PEN', 5372351.16, 0, 0, 180, 5.4288, 2.9354, 2.8588256, 'AAA', 105.4876, 107.67, 'PEP14000M103', 'SCOTI1BC8A', 84, to_date('23-07-2014', 'dd-mm-yyyy'), to_date('16-03-2012', 'dd-mm-yyyy'), 2.9353858, null, null, 15769999.595064, 29165419.977408, 1179, 'ACTIVO', '0', 5, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'F');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'SCOTIABANK PERU', 'I', 'Bonos corporativos', to_date('17-02-2014', 'dd-mm-yyyy'), to_date('17-02-2017', 'dd-mm-yyyy'), 3000, 5.5, to_date('17-02-2014', 'dd-mm-yyyy'), '2', 100.5064, 101.6003, 3015191.14, 32817.68, 3048008.82, 'PEN', 3048008.82, 0, 0, 180, 5.2866, 2.6481, 2.5807609, 'AAA', 100.5064, 100, 'PEP14000M186', 'SCOTI2BC9A', 109, to_date('17-08-2014', 'dd-mm-yyyy'), to_date('17-02-2014', 'dd-mm-yyyy'), 2.6480576, null, null, 8071432.156242, 16113603.427812, 1023, 'ACTIVO', '0', 6, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'F');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'CREDISCOTIA FINANCIERA S.A.', 'I', 'Bonos corporativos', to_date('07-12-2011', 'dd-mm-yyyy'), to_date('07-12-2014', 'dd-mm-yyyy'), 1000, 6.2813, to_date('07-12-2013', 'dd-mm-yyyy'), '2', 101.1467, 103.6316, 1011467.43, 24848.9, 1036316.33, 'PEN', 1036316.33, 0, 0, 180, 4.3069, .5986, .5861113, 'AA', 101.1467, 101.48, 'PEP16920M027', 'CSCOT1BC2B', 38, to_date('07-06-2014', 'dd-mm-yyyy'), to_date('31-10-2013', 'dd-mm-yyyy'), .5985519, null, null, 620338.955138, 4463310.801677, 220, 'ACTIVO', '0', 7, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'F');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'LUZ DEL SUR', 'I', 'Bonos corporativos', to_date('30-10-2013', 'dd-mm-yyyy'), to_date('30-10-2017', 'dd-mm-yyyy'), 5000, 5.8125, to_date('30-04-2014', 'dd-mm-yyyy'), '2', 100.6539, 100.6539, 5032695.67, 0, 5032695.67, 'PEN', 5032695.67, 0, 0, 180, 5.5959, 3.2667, 3.1789644, 'AAA', 100.6539, 100, 'PEP70252M226', 'LUSUR2BC8U', 183, to_date('30-10-2014', 'dd-mm-yyyy'), to_date('30-10-2013', 'dd-mm-yyyy'), 3.2666552, null, null, 16440306.945189, 28162461.699753, 1278, 'ACTIVO', '0', 8, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'F');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'CINEPLEX S.A.', 'I', 'Bonos corporativos', to_date('30-04-2014', 'dd-mm-yyyy'), to_date('30-04-2021', 'dd-mm-yyyy'), 5000, 7.75, to_date('30-04-2014', 'dd-mm-yyyy'), '4', 100, 100, 5000000, 0, 5000000, 'PEN', 5000000, 0, 0, 90, 7.8566, 3.9318, 3.8581557, 'AA', 100, 100, 'PEP72840M010', 'CINEP1BC1A', 91, to_date('30-07-2014', 'dd-mm-yyyy'), to_date('30-04-2014', 'dd-mm-yyyy'), 3.9285177, null, null, 19659000, 39283000, 2556, 'ACTIVO', '0', 9, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'F');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'COFIDE', 'I', 'Bonos corporativos', to_date('01-06-2007', 'dd-mm-yyyy'), to_date('15-07-2017', 'dd-mm-yyyy'), 1300, 5.9, to_date('15-04-2014', 'dd-mm-yyyy'), '4', 101.6748, 101.918, 1321772.84, 3160.71, 1324933.55, 'PEN', 1324933.55, 0, 0, 90, 4.8728, 1.6446, 1.6251543, 'AAA', 101.6748, 100.98, 'PEP11100M138', 'COFID2BC8A', 76, to_date('15-07-2014', 'dd-mm-yyyy'), to_date('16-02-2012', 'dd-mm-yyyy'), 1.6446162, null, null, 2178985.71633, 6456136.20244, 1171, 'ACTIVO', '0', 10, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'F');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'COFIDE', 'I', 'Bonos corporativos', to_date('30-06-2011', 'dd-mm-yyyy'), to_date('30-06-2014', 'dd-mm-yyyy'), 3390, 6.7, to_date('15-01-2014', 'dd-mm-yyyy'), '2', 100.4143, 102.3567, 3404046.09, 65847.18, 3469893.27, 'PEN', 3469893.27, 0, 0, 180, 4.2994, .1694, .1658717, 'AAA', 100.4143, 103.58, 'PEP11100M211', 'COFI3DBC3A', 61, to_date('30-06-2014', 'dd-mm-yyyy'), to_date('12-03-2013', 'dd-mm-yyyy'), .1694444, null, null, 587799.919938, 14918459.125038, 60, 'ACTIVO', '0', 11, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'F');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'BANCO CONTINENTAL', 'I', 'Bonos corporativos', to_date('19-04-2012', 'dd-mm-yyyy'), to_date('19-04-2019', 'dd-mm-yyyy'), 725, 5.8125, to_date('19-04-2014', 'dd-mm-yyyy'), '2', 97.8137, 97.9884, 709149.02, 1266.52, 710415.54, 'PEN', 710415.54, 0, 0, 180, 6.337, 4.4356, 4.3014033, 'AAA', 97.8137, 98.25, 'PEP11600M194', 'CONTI5BC5U', 172, to_date('19-10-2014', 'dd-mm-yyyy'), to_date('30-10-2013', 'dd-mm-yyyy'), 4.4355607, null, null, 3151119.169224, 4501903.27698, 1814, 'ACTIVO', '0', 12, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'F');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'BANCO DE CREDITO', 'I', 'Bonos corporativos', to_date('20-12-2007', 'dd-mm-yyyy'), to_date('20-12-2014', 'dd-mm-yyyy'), 1000, 6.8437, to_date('20-12-2013', 'dd-mm-yyyy'), '2', 100.3641, 102.8271, 1003641.48, 24629.82, 1028271.28, 'PEN', 1028271.28, 0, 0, 180, 5.8528, .388, .3771209, 'AAA', 100.3641, 102.72, 'PEP12000M154', 'CREDI2BC1A', 51, to_date('20-06-2014', 'dd-mm-yyyy'), to_date('20-12-2012', 'dd-mm-yyyy'), .3880247, null, null, 398969.25664, 6018266.147584, 233, 'ACTIVO', '0', 13, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'F');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'BANCO DE CREDITO', 'I', 'Bonos corporativos', to_date('02-07-2009', 'dd-mm-yyyy'), to_date('02-07-2014', 'dd-mm-yyyy'), 4500, 6.875, to_date('02-01-2014', 'dd-mm-yyyy'), '2', 100.4672, 102.7082, 4521023.12, 100845.99, 4621869.11, 'PEN', 4621869.11, 0, 0, 180, 4.126, .175, .1714977, 'AAA', 100.4672, 101.63, 'PEP12000M204', 'CREDI4BC4A', 63, to_date('02-07-2014', 'dd-mm-yyyy'), to_date('19-07-2013', 'dd-mm-yyyy'), .175, null, null, 808827.09425, 19069831.94786, 62, 'ACTIVO', '0', 14, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'F');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'MI BANCO', 'I', 'Bonos corporativos', to_date('11-07-2013', 'dd-mm-yyyy'), to_date('11-01-2017', 'dd-mm-yyyy'), 1000, 6.5938, to_date('11-01-2014', 'dd-mm-yyyy'), '2', 99.8953, 101.8807, 998952.8, 19854.11, 1018806.91, 'PEN', 1018806.91, 0, 0, 180, 6.6335, 2.5082, 2.4289313, 'AA', 99.8953, 100, 'PEP13300M124', 'MIBAN3BC5A', 72, to_date('11-07-2014', 'dd-mm-yyyy'), to_date('11-07-2013', 'dd-mm-yyyy'), 2.5081801, null, null, 2555371.491662, 6758255.637485, 986, 'ACTIVO', '0', 15, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'F');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'SCOTIABANK PERU', 'I', 'Bonos corporativos', to_date('02-09-2011', 'dd-mm-yyyy'), to_date('02-09-2018', 'dd-mm-yyyy'), 5000, 6.7813, to_date('02-03-2014', 'dd-mm-yyyy'), '2', 102.998, 104.0853, 5149902.12, 54360.56, 5204262.69, 'PEN', 5204262.69, 0, 0, 180, 5.9798, 3.8599, 3.7494234, 'AAA', 102.998, 106.71, 'PEP14000M111', 'SCOTI2BC3A', 125, to_date('02-09-2014', 'dd-mm-yyyy'), to_date('09-05-2012', 'dd-mm-yyyy'), 3.8599416, null, null, 20087933.557131, 31120450.033662, 1585, 'ACTIVO', '0', 16, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'F');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'BANCO FALABELLA PERU S.A.', 'I', 'Bonos corporativos', to_date('27-03-2013', 'dd-mm-yyyy'), to_date('27-03-2020', 'dd-mm-yyyy'), 8571, 5.2188, to_date('27-03-2014', 'dd-mm-yyyy'), '4', 95.5748, 96.057, 8192124.64, 41328.75, 8233453.25, 'PEN', 8233453.25, 0, 0, 90, 6.9696, 2.7374, 2.6916787, 'AA-', 95.5748, 100, 'PEP14150M056', 'BFAL1BC4A', 58, to_date('27-06-2014', 'dd-mm-yyyy'), to_date('27-03-2013', 'dd-mm-yyyy'), 2.7374181, null, null, 22538254.92655, 57383875.7712, 2157, 'ACTIVO', '0', 17, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'F');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'EMPRESA FINANCIERA EDYFICAR', 'I', 'Bonos corporativos', to_date('24-05-2013', 'dd-mm-yyyy'), to_date('24-11-2016', 'dd-mm-yyyy'), 3000, 5.2813, to_date('24-11-2013', 'dd-mm-yyyy'), '2', 100.1328, 102.4233, 3003984.13, 68714.61, 3072698.73, 'PEN', 3072698.73, 0, 0, 180, 5.2046, 2.4189, 2.3583077, 'AA', 100.1328, 100, 'PEP16980M054', 'EDYFI3BC1A', 24, to_date('24-05-2014', 'dd-mm-yyyy'), to_date('24-05-2013', 'dd-mm-yyyy'), 2.4188765, null, null, 7432550.957997, 15992167.810158, 938, 'ACTIVO', '0', 18, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'F');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'GLORIA', 'I', 'Bonos corporativos', to_date('26-10-2007', 'dd-mm-yyyy'), to_date('26-10-2017', 'dd-mm-yyyy'), 87, 6.7813, to_date('26-04-2014', 'dd-mm-yyyy'), '2', 102.0073, 102.0814, 89256.37, 64.85, 89321.22, 'PEN', 89321.22, 0, 0, 180, 5.6774, 1.9019, 1.8501064, 'AAA', 102.0073, 95.76, 'PEP36100M089', 'GLOR2BC8A', 179, to_date('26-10-2014', 'dd-mm-yyyy'), to_date('17-03-2009', 'dd-mm-yyyy'), 1.9018929, null, null, 169880.028318, 507112.294428, 1274, 'ACTIVO', '0', 19, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'F');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'SAGA FALABELLA S.A.', 'I', 'Bonos corporativos', to_date('26-05-2011', 'dd-mm-yyyy'), to_date('26-05-2018', 'dd-mm-yyyy'), 2568, 7.5625, to_date('26-02-2014', 'dd-mm-yyyy'), '4', 103.4571, 104.7954, 2656999.91, 34370.65, 2691370.51, 'PEN', 2691370.51, 0, 0, 90, 5.7797, 1.9201, 1.8933165, 'AA', 103.4571, 107.59, 'PEP75700M054', 'SAGA2BC1B', 26, to_date('26-05-2014', 'dd-mm-yyyy'), to_date('06-03-2013', 'dd-mm-yyyy'), 1.9200801, null, null, 5167700.516251, 15555314.136647, 1486, 'ACTIVO', '0', 20, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'F');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'SAGA FALABELLA S.A.', 'I', 'Bonos corporativos', to_date('27-07-2011', 'dd-mm-yyyy'), to_date('27-07-2018', 'dd-mm-yyyy'), 3946, 7.0938, to_date('27-04-2014', 'dd-mm-yyyy'), '4', 102.5819, 102.6403, 4048320.02, 2307.28, 4050627.29, 'PEN', 4050627.29, 0, 0, 90, 5.8714, 2.0951, 2.0654279, 'AA', 102.5819, 103.32, 'PEP75700M062', 'SAGA2BC2A', 88, to_date('27-07-2014', 'dd-mm-yyyy'), to_date('13-02-2012', 'dd-mm-yyyy'), 2.0950924, null, null, 8486469.235279, 23782853.070506, 1548, 'ACTIVO', '0', 21, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'F');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'SAGA FALABELLA S.A.', 'I', 'Bonos corporativos', to_date('17-04-2013', 'dd-mm-yyyy'), to_date('17-04-2023', 'dd-mm-yyyy'), 3337, 5, to_date('17-04-2014', 'dd-mm-yyyy'), '4', 90.9121, 91.0907, 3033920.02, 5959.29, 3039879.31, 'PEN', 3039879.31, 0, 0, 90, 7.5655, 3.8882, 3.8179514, 'AA', 90.9121, 100, 'PEP75700M096', 'SAGA3BC2A', 78, to_date('17-07-2014', 'dd-mm-yyyy'), to_date('17-04-2013', 'dd-mm-yyyy'), 3.8882244, null, null, 11819658.733142, 22998206.919805, 3273, 'ACTIVO', '0', 22, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'F');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'SUPERMERCADOS PERUANOS', 'I', 'Bonos corporativos', to_date('26-11-2009', 'dd-mm-yyyy'), to_date('26-09-2014', 'dd-mm-yyyy'), 1714, 6.7, to_date('26-11-2013', 'dd-mm-yyyy'), '2', 101.0634, 103.9322, 1732514.86, 49179.33, 1781694.02, 'PEN', 1781694.02, 0, 0, 180, 5.8255, 1.2558, 1.2207463, 'AA-', 101.0634, 100, 'PEP75725M010', 'SUPER1BC1U', 26, to_date('26-05-2014', 'dd-mm-yyyy'), to_date('26-11-2009', 'dd-mm-yyyy'), 1.2557684, null, null, 2237451.350316, 10379258.51351, 148, 'ACTIVO', '0', 23, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'F');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'MEF', 'I', 'Instrumentos de go', to_date('12-08-2006', 'dd-mm-yyyy'), to_date('12-08-2026', 'dd-mm-yyyy'), 3750, 8.2, to_date('12-02-2014', 'dd-mm-yyyy'), '2', 117.9803, 119.7245, 4424261.95, 42669.73, 4489669.41, 'PEN', 4489669.41, 0, 0, 180, 6.1, 8.3369, 8.0936962, 'ESTADO', 117.9803, 111.91, 'PEP01000C0J9', 'SB12AGO26', 104, to_date('12-08-2014', 'dd-mm-yyyy'), to_date('11-03-2014', 'dd-mm-yyyy'), 8.3368608, null, null, 37429924.904229, 27386983.401, 4486, 'ACTIVO', '0', 24, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'F');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'MEF', 'I', 'Instrumentos de go', to_date('26-07-2007', 'dd-mm-yyyy'), to_date('12-08-2037', 'dd-mm-yyyy'), 220, 6.9, to_date('12-02-2014', 'dd-mm-yyyy'), '2', 101.0448, 102.5125, 222298.55, 700.55, 225527.44, 'PEN', 225527.44, 0, 0, 180, 6.8222, 11.9652, 11.5768193, 'ESTADO', 101.0448, 127, 'PEP01000C2Z1', 'SB12AGO37', 104, to_date('12-08-2014', 'dd-mm-yyyy'), to_date('29-01-2013', 'dd-mm-yyyy'), 11.9652017, null, null, 2698480.925088, 1538593.301168, 8504, 'ACTIVO', '0', 25, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'F');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'MEF', 'I', 'Instrumentos de go', to_date('24-04-2008', 'dd-mm-yyyy'), to_date('12-08-2031', 'dd-mm-yyyy'), 6911, 6.95, to_date('12-02-2014', 'dd-mm-yyyy'), '2', 103.0526, 104.5309, 7121965.55, 27901.1, 7224131.89, 'PEN', 7224131.89, 0, 0, 180, 6.66, 10.4324, 10.1014435, 'ESTADO', 103.0526, 104.83, 'PEP01000C4G7', 'SB12AGO31', 104, to_date('12-08-2014', 'dd-mm-yyyy'), to_date('01-07-2013', 'dd-mm-yyyy'), 10.4324386, null, null, 75365033.529236, 48112718.3874, 6312, 'ACTIVO', '0', 26, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'F');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'MEF', 'I', 'Instrumentos de go', to_date('05-05-2005', 'dd-mm-yyyy'), to_date('05-05-2015', 'dd-mm-yyyy'), 5000, 9.91, to_date('05-11-2013', 'dd-mm-yyyy'), '2', 106.1553, 110.9734, 5307764.23, 50645.03, 5548670.3, 'PEN', 5548670.3, 0, 0, 180, 3.65, .9605, .9434366, 'ESTADO', 106.1553, 106.59, 'PEP01000CX67', 'SB05MAY15', 5, to_date('05-05-2014', 'dd-mm-yyyy'), to_date('19-03-2014', 'dd-mm-yyyy'), .9604992, null, null, 5329497.82315, 20252646.595, 369, 'ACTIVO', '0', 27, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'F');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'MEF', 'I', 'Instrumentos de go', to_date('08-07-2005', 'dd-mm-yyyy'), to_date('12-08-2017', 'dd-mm-yyyy'), 21000, 8.6, to_date('12-02-2014', 'dd-mm-yyyy'), '2', 113.2076, 115.0368, 23773586.65, 384149.17, 24157735.83, 'PEN', 24157735.83, 0, 0, 180, 4.2335, 2.9536, 2.8929974, 'ESTADO', 113.2076, 115.2, 'PEP01000CY09', 'SB12AGO17', 104, to_date('12-08-2014', 'dd-mm-yyyy'), to_date('11-12-2013', 'dd-mm-yyyy'), 2.9535579, null, null, 71352288.547488, 102271774.636305, 1199, 'ACTIVO', '0', 28, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'F');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'MEF', 'I', 'Instrumentos de go', to_date('18-07-2005', 'dd-mm-yyyy'), to_date('12-08-2020', 'dd-mm-yyyy'), 45995, 7.84, to_date('12-02-2014', 'dd-mm-yyyy'), '2', 111.7039, 113.3918, 51378187.44, 497214.08, 52154567.26, 'PEN', 52154567.26, 0, 0, 180, 5.5988, 5.1572, 5.0186209, 'ESTADO', 111.7039, 120.72, 'PEP01000CY33', 'SB12AGO20', 104, to_date('12-08-2014', 'dd-mm-yyyy'), to_date('24-07-2012', 'dd-mm-yyyy'), 5.1571976, null, null, 268971534.273272, 292002991.175288, 2295, 'ACTIVO', '0', 29, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'F');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'MEF', 'I', 'Instrumentos de go', to_date('22-06-2012', 'dd-mm-yyyy'), to_date('12-09-2023', 'dd-mm-yyyy'), 9400, 5.2, to_date('12-03-2014', 'dd-mm-yyyy'), '2', 94.3855, 95.0779, 8872234.05, 64872.82, 8937318.84, 'PEN', 8937318.84, 0, 0, 180, 5.9892, 7.5256, 7.3098813, 'ESTADO', 94.3855, 92.64, 'PEP01000C4N3', 'SB12SEP23', 135, to_date('12-09-2014', 'dd-mm-yyyy'), to_date('12-03-2014', 'dd-mm-yyyy'), 7.5256085, null, null, 67258686.662304, 53527389.996528, 3421, 'ACTIVO', '0', 30, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'F');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'SCOTIABANK PERU', 'I', 'Depositos a plazo', to_date('29-04-2014', 'dd-mm-yyyy'), to_date('06-05-2014', 'dd-mm-yyyy'), 7124, .1, null, '0', 0, 100.0003, 7124536.91, 19.78, 7124556.69, 'USD', 20004330.27, 0, 0, 0, .1, .0166667, .0166667, 'CP-1', 7124536.91, 0, 'PEX14000T103', 'SCOTIADPZC', 0, null, to_date('29-04-2014', 'dd-mm-yyyy'), .0166667, null, null, 333406.171311009, 2000433.027, 5, 'ACTIVO', '0', 31, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'M');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'EMPRESA FINANCIERA EDYFICAR', 'I', 'Depositos a plazo', to_date('22-04-2014', 'dd-mm-yyyy'), to_date('07-05-2014', 'dd-mm-yyyy'), 10022, 4.11, null, '0', 0, 100.0895, 10022765.09, 8975.02, 10031740.11, 'PEN', 10031740.11, 0, 0, 0, 4.11, .0194444, .0194444, 'CP-1', 10022765.09, 0, 'PEX16980M022', 'EDYFIDPZ', 0, null, to_date('22-04-2014', 'dd-mm-yyyy'), .0194444, null, null, 195061.167394884, 41230451.8521, 6, 'ACTIVO', '0', 32, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'M');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'INTERBANK', 'I', 'Depositos a plazo', to_date('26-03-2014', 'dd-mm-yyyy'), to_date('06-05-2014', 'dd-mm-yyyy'), 28242, 4.2, null, '0', 0, 100.4008, 28242933.74, 113195.46, 28356129.2, 'PEN', 28356129.2, 0, 0, 0, 4.2, .0166667, .0166667, 'CP-1', 28242933.74, 0, 'PEP14800T101', 'INTERDPZ', 0, null, to_date('26-03-2014', 'dd-mm-yyyy'), .0166667, null, null, 472603.09853764, 119095742.64, 5, 'ACTIVO', '0', 33, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'M');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'INTERBANK', 'I', 'Depositos a plazo', to_date('02-04-2014', 'dd-mm-yyyy'), to_date('02-05-2014', 'dd-mm-yyyy'), 10000, 4.3, null, '0', 0, 100.328, 10000000, 32799.03, 10032799.03, 'PEN', 10032799.03, 0, 0, 0, 4.3, .0055556, .0055556, 'CP-1', 10000000, 0, 'PEP14800T101', 'INTERDPZ', 0, null, to_date('02-04-2014', 'dd-mm-yyyy'), .0055556, null, null, 55738.218291068, 43141035.829, 1, 'ACTIVO', '0', 34, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'M');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'INTERBANK', 'I', 'Depositos a plazo', to_date('10-04-2014', 'dd-mm-yyyy'), to_date('09-06-2014', 'dd-mm-yyyy'), 10003, 4.25, null, '0', 0, 100.2315, 10003389.07, 23157.75, 10026546.82, 'PEN', 10026546.82, 0, 0, 0, 4.25, .1111111, .1111111, 'CP-1', 10003389.07, 0, 'PEP14800T101', 'INTERDPZ', 0, null, to_date('10-04-2014', 'dd-mm-yyyy'), .1111111, null, null, 1114060.6463717, 42612823.985, 39, 'ACTIVO', '0', 35, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'M');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'BANCO GNB', 'I', 'Depositos a plazo', to_date('17-02-2014', 'dd-mm-yyyy'), to_date('19-05-2014', 'dd-mm-yyyy'), 16153, 4.35, null, '0', 0, 100.8552, 16153520.29, 138152.25, 16291672.54, 'PEN', 16291672.54, 0, 0, 0, 4.35, .0527778, .0527778, 'CP-1', 16153520.29, 0, 'PEX11800T101', 'GNBDPZ', 0, null, to_date('17-02-2014', 'dd-mm-yyyy'), .0527778, null, null, 859838.634981612, 70868775.549, 18, 'ACTIVO', '0', 36, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'M');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'MI BANCO', 'I', 'Depositos a plazo', to_date('05-03-2014', 'dd-mm-yyyy'), to_date('05-05-2014', 'dd-mm-yyyy'), 10000, 4.18, null, '0', 0, 100.639, 10000000, 63903.29, 10063903.29, 'PEN', 10063903.29, 0, 0, 0, 4.18, .0138889, .0138889, 'CP-1', 10000000, 0, 'PEX13300T101', 'MIBANCODPZ', 0, null, to_date('05-03-2014', 'dd-mm-yyyy'), .0138889, null, null, 139776.546404481, 42067115.7522, 4, 'ACTIVO', '0', 37, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'M');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'MI BANCO', 'I', 'Depositos a plazo', to_date('14-03-2014', 'dd-mm-yyyy'), to_date('12-06-2014', 'dd-mm-yyyy'), 5000, 4.2, null, '0', 0, 100.5386, 5000000, 26928.8, 5026928.8, 'PEN', 5026928.8, 0, 0, 0, 4.2, .1194444, .1194444, 'CP-1', 5000000, 0, 'PEX13300T101', 'MIBANCODPZ', 0, null, to_date('14-03-2014', 'dd-mm-yyyy'), .1194444, null, null, 600438.49435872, 21113100.96, 42, 'ACTIVO', '0', 38, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'M');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'SCOTIABANK PERU', 'I', 'Depositos a plazo', to_date('06-03-2014', 'dd-mm-yyyy'), to_date('04-06-2014', 'dd-mm-yyyy'), 5600, 4.35, null, '0', 0, 100.6527, 5600000, 36548.69, 5636548.69, 'PEN', 5636548.69, 0, 0, 0, 4.35, .0972222, .0972222, 'CP-1', 5600000, 0, 'PEX14000T101', 'SCOTIADPZ', 0, null, to_date('06-03-2014', 'dd-mm-yyyy'), .0972222, null, null, 547997.664048918, 24518986.8015, 34, 'ACTIVO', '0', 39, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'M');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'SCOTIABANK PERU', 'I', 'Depositos a plazo', to_date('23-04-2014', 'dd-mm-yyyy'), to_date('23-05-2014', 'dd-mm-yyyy'), 5076, 4, null, '0', 0, 100.0763, 5076575.33, 3873, 5080448.33, 'PEN', 5080448.33, 0, 0, 0, 4, .0638889, .0638889, 'CP-1', 5076575.33, 0, 'PEX14000T101', 'SCOTIADPZ', 0, null, to_date('23-04-2014', 'dd-mm-yyyy'), .0638889, null, null, 324584.255310537, 20321793.32, 22, 'ACTIVO', '0', 40, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'M');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'BANCO CENTRAL DE RESERVA', 'I', 'Certificados', to_date('17-10-2013', 'dd-mm-yyyy'), to_date('09-10-2014', 'dd-mm-yyyy'), 5000, 3.4753, to_date('17-10-2013', 'dd-mm-yyyy'), '1', 98.4744, 98.4744, 4923720.64, 0, 4923720.64, 'PEN', 4923720.64, 0, 0, 360, 3.4753, .45, .4348862, 'ESTADO', 98.4744, 96.23, 'PEX002006471', 'C00A1091014', 162, to_date('09-10-2014', 'dd-mm-yyyy'), to_date('17-10-2013', 'dd-mm-yyyy'), .45, null, null, 2215674.288, 17111406.340192, 161, 'ACTIVO', '0', 41, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'F');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'BANCO CENTRAL DE RESERVA', 'I', 'Certificados', to_date('12-09-2013', 'dd-mm-yyyy'), to_date('11-09-2014', 'dd-mm-yyyy'), 2500, 3.4529, to_date('12-09-2013', 'dd-mm-yyyy'), '1', 98.7444, 98.7444, 2468609.54, 0, 2468609.54, 'PEN', 2468609.54, 0, 0, 360, 3.4529, .3722, .3597771, 'ESTADO', 98.7444, 96.11, 'PEX002006473', 'C00A1110914', 134, to_date('11-09-2014', 'dd-mm-yyyy'), to_date('12-09-2013', 'dd-mm-yyyy'), .3722222, null, null, 918816.470788, 8523861.880666, 133, 'ACTIVO', '0', 42, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'F');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'BANCO CENTRAL DE RESERVA', 'I', 'Certificados', to_date('11-12-2013', 'dd-mm-yyyy'), to_date('12-06-2014', 'dd-mm-yyyy'), 6000, 3.3792, to_date('11-12-2013', 'dd-mm-yyyy'), '1', 99.6038, 99.6038, 5976229.91, 0, 5976229.91, 'PEN', 5976229.91, 0, 0, 360, 3.3792, .1194, .1154971, 'ESTADO', 99.6038, 98.22, 'PEX002009630', 'C00A1120614', 43, to_date('12-06-2014', 'dd-mm-yyyy'), to_date('11-12-2013', 'dd-mm-yyyy'), .1194444, null, null, 713561.851254, 20194876.111872, 42, 'ACTIVO', '0', 43, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'F');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'BANCO CENTRAL DE RESERVA', 'I', 'Certificados', to_date('21-11-2013', 'dd-mm-yyyy'), to_date('07-05-2015', 'dd-mm-yyyy'), 8300, 3.641, to_date('21-11-2013', 'dd-mm-yyyy'), '1', 96.3719, 96.3719, 7998871.77, 0, 7998871.77, 'PEN', 7998871.77, 0, 0, 360, 3.641, 1.0333, .9969992, 'ESTADO', 96.3719, 94.77, 'PEX002009631', 'C00A1070515', 372, to_date('07-05-2015', 'dd-mm-yyyy'), to_date('21-11-2013', 'dd-mm-yyyy'), 1.0333333, null, null, 8265234.199941, 29123892.11457, 371, 'ACTIVO', '0', 44, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'F');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'BANCO CENTRAL DE RESERVA', 'I', 'Certificados', to_date('30-10-2013', 'dd-mm-yyyy'), to_date('09-04-2015', 'dd-mm-yyyy'), 13500, 3.6192, to_date('30-10-2013', 'dd-mm-yyyy'), '1', 96.6599, 96.6599, 13049079.78, 0, 13049079.78, 'PEN', 13049079.78, 0, 0, 360, 3.6192, .9556, .9222232, 'ESTADO', 96.6599, 95.1, 'PEX002009601', 'C00A1090415', 344, to_date('09-04-2015', 'dd-mm-yyyy'), to_date('20-11-2013', 'dd-mm-yyyy'), .9555556, null, null, 12469700.637768, 47227229.539776, 343, 'ACTIVO', '0', 45, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'F');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'SCOTIABANK PERU', 'I', 'Instrum.Coberturad', to_date('29-04-2014', 'dd-mm-yyyy'), to_date('06-05-2014', 'dd-mm-yyyy'), 20000, .1, null, '0', 0, 0, 20000000, 0, -3049.36, 'PEN', -3049.36, 0, 0, 0, 2.8072, .0166667, .0166667, 'CP-1', 2.8096, 20000000, 'PEX14000T103', 'SCOTIADPZC', 0, null, to_date('29-04-2014', 'dd-mm-yyyy'), .0166667, null, null, -50.822768312, -8560.163392, 5, 'ACTIVO', '0', 46, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'F');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'MEF', 'I', 'Letras del Tesoro', to_date('07-08-2013', 'dd-mm-yyyy'), to_date('04-05-2014', 'dd-mm-yyyy'), 1375, 4.0543, to_date('07-08-2013', 'dd-mm-yyyy'), '1', 99.9559, 99.9559, 1374392.96, 0, 1374392.96, 'PEN', 1374392.96, 0, 0, 360, 0, .0111, .0106675, 'ESTADO', 99.9559, 99.31, 'PEP01000T061', 'LTP04MAY14', 4, to_date('04-05-2014', 'dd-mm-yyyy'), to_date('26-02-2014', 'dd-mm-yyyy'), 0, null, null, 15255.761856, 0, 3, 'ACTIVO', '0', 47, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'F');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'MEF', 'I', 'Letras del Tesoro', to_date('19-02-2014', 'dd-mm-yyyy'), to_date('16-08-2014', 'dd-mm-yyyy'), 375, 3.8289, to_date('19-02-2014', 'dd-mm-yyyy'), '1', 98.8791, 98.8791, 370796.66, 0, 370796.66, 'PEN', 370796.66, 0, 0, 360, 0, .3, .288937, 'ESTADO', 98.8791, 98.08, 'PEP01000T087', 'LTP16AGO14', 108, to_date('16-08-2014', 'dd-mm-yyyy'), to_date('19-02-2014', 'dd-mm-yyyy'), 0, null, null, 111238.998, 0, 107, 'ACTIVO', '0', 48, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'F');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'MEF', 'I', 'Letras del Tesoro', to_date('04-09-2013', 'dd-mm-yyyy'), to_date('01-06-2014', 'dd-mm-yyyy'), 375, 3.85, to_date('04-09-2013', 'dd-mm-yyyy'), '1', 99.6648, 99.6648, 373742.87, 0, 373742.87, 'PEN', 373742.87, 0, 0, 360, 0, .0889, .0856042, 'ESTADO', 99.6648, 99.05, 'PEP01000T103', 'LTP01JUN14', 32, to_date('01-06-2014', 'dd-mm-yyyy'), to_date('05-03-2014', 'dd-mm-yyyy'), 0, null, null, 33225.741143, 0, 31, 'ACTIVO', '0', 49, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'F');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'MEF', 'I', 'Letras del Tesoro', to_date('31-01-2014', 'dd-mm-yyyy'), to_date('13-09-2014', 'dd-mm-yyyy'), 350, 3.8875, to_date('31-01-2014', 'dd-mm-yyyy'), '1', 98.5696, 98.5696, 344993.44, 0, 344993.44, 'PEN', 344993.44, 0, 0, 360, 0, .3778, .3636627, 'ESTADO', 98.5696, 98.08, 'PEP01000T129', 'LTP13SEP14', 136, to_date('13-09-2014', 'dd-mm-yyyy'), to_date('19-03-2014', 'dd-mm-yyyy'), 0, null, null, 130338.521632, 0, 135, 'ACTIVO', '0', 50, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'F');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'MEF', 'I', 'Letras del Tesoro', to_date('23-04-2014', 'dd-mm-yyyy'), to_date('18-10-2014', 'dd-mm-yyyy'), 375, 3.9461, to_date('23-04-2014', 'dd-mm-yyyy'), '1', 98.1784, 98.1784, 368169.11, 0, 368169.11, 'PEN', 368169.11, 0, 0, 360, 0, .475, .4569676, 'ESTADO', 98.1784, 98.08, 'PEP01000T137', 'LTP18OCT14', 171, to_date('18-10-2014', 'dd-mm-yyyy'), to_date('23-04-2014', 'dd-mm-yyyy'), 0, null, null, 174880.32725, 0, 170, 'ACTIVO', '0', 51, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'F');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'MEF', 'I', 'Letras del Tesoro', to_date('20-11-2013', 'dd-mm-yyyy'), to_date('15-11-2014', 'dd-mm-yyyy'), 375, 3.9838, to_date('20-11-2013', 'dd-mm-yyyy'), '1', 97.8637, 97.8637, 366988.96, 0, 366988.96, 'PEN', 366988.96, 0, 0, 360, 0, .5528, .5316212, 'ESTADO', 97.8637, 96.89, 'PEP01000T145', 'LTP15NOV14', 199, to_date('15-11-2014', 'dd-mm-yyyy'), to_date('05-02-2014', 'dd-mm-yyyy'), 0, null, null, 202871.497088, 0, 198, 'ACTIVO', '0', 52, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'F');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'MEF', 'I', 'Letras del Tesoro', to_date('18-12-2013', 'dd-mm-yyyy'), to_date('13-12-2014', 'dd-mm-yyyy'), 375, 4.0007, to_date('18-12-2013', 'dd-mm-yyyy'), '1', 97.5568, 97.5568, 365838.13, 0, 365838.13, 'PEN', 365838.13, 0, 0, 360, 0, .6306, .6063421, 'ESTADO', 97.5568, 96.93, 'PEP01000T152', 'LTP13DIC14', 227, to_date('13-12-2014', 'dd-mm-yyyy'), to_date('05-03-2014', 'dd-mm-yyyy'), 0, null, null, 230697.524778, 0, 226, 'ACTIVO', '0', 53, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'F');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'MEF', 'I', 'Letras del Tesoro', to_date('19-02-2014', 'dd-mm-yyyy'), to_date('14-02-2015', 'dd-mm-yyyy'), 375, 4.0368, to_date('19-02-2014', 'dd-mm-yyyy'), '1', 96.8623, 96.8623, 363233.77, 0, 363233.77, 'PEN', 363233.77, 0, 0, 360, 0, .8056, .7743414, 'ESTADO', 96.8623, 96.09, 'PEP01000T178', 'LTP14FEB15', 290, to_date('14-02-2015', 'dd-mm-yyyy'), to_date('19-02-2014', 'dd-mm-yyyy'), 0, null, null, 292621.125112, 0, 289, 'ACTIVO', '0', 54, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'F');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'MEF', 'I', 'Letras del Tesoro', to_date('22-01-2014', 'dd-mm-yyyy'), to_date('12-07-2014', 'dd-mm-yyyy'), 375, 3.5001, to_date('22-01-2014', 'dd-mm-yyyy'), '1', 99.3048, 99.3048, 372393.09, 0, 372393.09, 'PEN', 372393.09, 0, 0, 360, 0, .2028, .1959418, 'ESTADO', 99.3048, 98.15, 'PEP01000T046', 'LTP12JUL14', 73, to_date('12-07-2014', 'dd-mm-yyyy'), to_date('22-01-2014', 'dd-mm-yyyy'), 0, null, null, 75521.318652, 0, 72, 'ACTIVO', '0', 55, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'F');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'MEF', 'I', 'Letras del Tesoro', to_date('22-01-2014', 'dd-mm-yyyy'), to_date('17-01-2015', 'dd-mm-yyyy'), 750, 4.0218, to_date('22-01-2014', 'dd-mm-yyyy'), '1', 97.1711, 97.1711, 728783.46, 0, 728783.46, 'PEN', 728783.46, 0, 0, 360, 0, .7278, .699661, 'ESTADO', 97.1711, 96.92, 'PEP01000T160', 'LTP17ENE15', 262, to_date('17-01-2015', 'dd-mm-yyyy'), to_date('09-04-2014', 'dd-mm-yyyy'), 0, null, null, 530408.602188, 0, 261, 'ACTIVO', '0', 56, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'F');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'MEF', 'I', 'Letras del Tesoro', to_date('19-03-2014', 'dd-mm-yyyy'), to_date('14-03-2015', 'dd-mm-yyyy'), 350, 4.0265, to_date('19-03-2014', 'dd-mm-yyyy'), '1', 96.5731, 96.5731, 338005.83, 0, 338005.83, 'PEN', 338005.83, 0, 0, 360, 0, .8833, .8491106, 'ESTADO', 96.5731, 96.11, 'PEP01000T186', 'LTP14MAR15', 318, to_date('14-03-2015', 'dd-mm-yyyy'), to_date('19-03-2014', 'dd-mm-yyyy'), 0, null, null, 298560.549639, 0, 317, 'ACTIVO', '0', 57, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'F');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'BANCO CONTINENTAL', 'I', 'Depositos de ahorr', null, null, 0, .2, null, '0', 0, 100, 570.45, 0, 570.45, 'USD', 1601.71, 0, 0, 0, .2, .0027778, .0027778, 'AAA', 0, 0, 'PEP11600U101', 'CONTINAHO', 0, null, null, .0027778, null, null, 4.449230038, 320.342, -41760, 'ACTIVO', '0', 58, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'M');
insert into BBVATESOR.TSI002_INFOPORT (NB_NOM_FONDO, TP_TIPFONDO, NB_NOM_EMISOR, TP_RATING_EMISOR, NB_ESPECIE, FH_FEC_EMISION, FH_FEC_VENCIMIENTO, IM_NOMINAL_EN_MIL, IM_CUPON, FH_FEC_ULT_CUPON, TP_MODALIDAD, IM_PRECIO_LIMPIO, IM_PRECIO_SUCIO, IM_VALOR_SIN_INTER, IM_INTERES_CORRID, IM_VALOR_MON_REF, TP_ABREV_MONEDA, IM_VALOR_MON_LOCAL, IM_TOT_CTAS_COBRAR, IM_TOT_CTAS_PAGAR, NU_PERIODO, IM_YTM, IM_DURAC_NORM, IM_DURAC_MODIF, TP_CLASIFICA, IM_PRECIO_ACT, IM_PREC_COM, NB_ISIN, NB_MNEMONICO, NU_NUM_DIAS_VCTO, FH_FECVCTO_SGT_CUP, FH_FEC_ULT_OPERAC, IM_DURAC_NOR_LIBOR, IM_COMPRA_T_MAS_N, NB_OBSERVACION, IM_VALOR_POR_DURAC, IM_VALOR_POR_YTM, NU_DIA_PARA_VENC, ST_ESTADO_PORT, ST_CONDICION, CD_IDINFOPORT, ST_ESTADO, FH_FEC_IMPORTA, TP_OPERACION)
values ('BBVA SOLES', 'F', 'BANCO CONTINENTAL', 'I', 'Depositos de ahorr', null, null, 6908, .3, null, '0', 0, 100.0529, 6908974.96, 3658.22, 6912633.18, 'PEN', 6912633.18, 0, 0, 0, .3, .0027778, .0027778, 'AAA', 0, 0, 'PEP11600U102', null, 0, null, null, .0027778, null, null, 19201.912447404, 2073789.954, -41760, 'ACTIVO', '0', 59, '1', to_date('26-01-2016 11:44:41', 'dd-mm-yyyy hh24:mi:ss'), 'M');
commit;

/*
 *******************************************
 * INSERTS TSI001_SALDO
 *******************************************
 */
insert into TSI001_SALDO (CD_IDSALDO, CD_COD_FONDO, NB_NOM_FONDO, TP_TIPMONEDA, NU_NUM_CUENTA, TO_SALDO_INICIAL, IM_DIF_RESCATE, IM_SUSCRIPCION, IM_RESCATE, IM_VENCIMIENTO, IM_COMPRAS_TMASN, IM_VENTAS_TMASN, IM_COMPRA, IM_VENTA, IM_CXP_ACCIONES, IM_CXC_ACCIONES, IM_COMISION, TO_SALDO_FINAL, IM_RESCATE_TMASN, IM_CARTE_TMENOSUNO, IM_PORC_LIQUIDEZ, TO_SALDO_INVERTIR, NB_OBSERVACION, PC_PORC_PATRIMONIO, IM_PAT_MON_FONDO, PC_PORC_PAT_TOT, PC_PORC_CONTINENTA, PC_PORC_TOTAL, IM_MTO_EXCESO, PC_PORC_ACCIONES, IM_VINCULADO, IM_LIQUIDEZ_INMEDI, IM_SOLICITUD_SUSC, IM_SOLICITUD_RESC, IM_CXP_PENDIENTE, IM_SALDO_TMASN, ST_ESTADO, FH_FEC_IMPORTA)
values (1, '0011', 'BBVA SOLES', 'USD', '00110661600200023085', 739.66, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 739.66, 0, 0, 0, 739.66, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, '1', to_date('29-01-2016', 'dd-mm-yyyy'));
insert into TSI001_SALDO (CD_IDSALDO, CD_COD_FONDO, NB_NOM_FONDO, TP_TIPMONEDA, NU_NUM_CUENTA, TO_SALDO_INICIAL, IM_DIF_RESCATE, IM_SUSCRIPCION, IM_RESCATE, IM_VENCIMIENTO, IM_COMPRAS_TMASN, IM_VENTAS_TMASN, IM_COMPRA, IM_VENTA, IM_CXP_ACCIONES, IM_CXC_ACCIONES, IM_COMISION, TO_SALDO_FINAL, IM_RESCATE_TMASN, IM_CARTE_TMENOSUNO, IM_PORC_LIQUIDEZ, TO_SALDO_INVERTIR, NB_OBSERVACION, PC_PORC_PATRIMONIO, IM_PAT_MON_FONDO, PC_PORC_PAT_TOT, PC_PORC_CONTINENTA, PC_PORC_TOTAL, IM_MTO_EXCESO, PC_PORC_ACCIONES, IM_VINCULADO, IM_LIQUIDEZ_INMEDI, IM_SOLICITUD_SUSC, IM_SOLICITUD_RESC, IM_CXP_PENDIENTE, IM_SALDO_TMASN, ST_ESTADO, FH_FEC_IMPORTA)
values (2, '0011', 'BBVA SOLES', 'PEN', '00110661650200023115', 5644254.02, 0, 108298, 1088152.4, 0, 0, 0, 0, 0, 0, 0, 0, 4664399.62, 0, 220189921.25, 4403798.425, 260601.194999999, null, 2.12, 4666845.38, 2.12, 2.81, 4.93, 0, 0, 4.93, 11859106.73, 0, 0, null, null, '1', to_date('29-01-2016', 'dd-mm-yyyy'));
commit;

/*
 *******************************************
 *USUARIO APP
 *******************************************
 
CREATE USER simultes IDENTIFIED BY simultes 
default tablespace users 
temporary tablespace temp 
quota unlimited on users 
account unlock;
*/

/*
 *******************************************
 *PERMISOS APP
 *******************************************
 
grant create session to simultes;
grant create SYNONYM to simultes;

GRANT SELECT, INSERT, UPDATE ON bbvatesor.TSI001_Saldo 			TO simultes;
GRANT SELECT, INSERT, UPDATE ON bbvatesor.TSI002_Infoport 		TO simultes;
GRANT SELECT, INSERT, UPDATE ON bbvatesor.TSI003_CobranzaPago 	TO simultes;
GRANT SELECT, INSERT, UPDATE ON bbvatesor.TSI004_TipoCambio 	TO simultes;
GRANT SELECT, INSERT, UPDATE ON bbvatesor.TSI005_General 		TO simultes;
GRANT SELECT, INSERT, UPDATE ON bbvatesor.TSI006_Usuario 		TO simultes;
GRANT SELECT, INSERT, UPDATE ON bbvatesor.TSI007_Perfil 		TO simultes;
GRANT SELECT, INSERT, UPDATE ON bbvatesor.TSI008_Fondo 			TO simultes;
GRANT SELECT, INSERT, UPDATE ON bbvatesor.TSI009_PerfilFondo 	TO simultes;
GRANT SELECT, INSERT, UPDATE ON bbvatesor.TSI010_Emisor 		TO simultes;
GRANT SELECT, INSERT, UPDATE ON bbvatesor.TSI011_LimitesEmisor 	TO simultes;
GRANT SELECT, INSERT, UPDATE ON bbvatesor.TSI012_LimFondoEspecie TO simultes;
GRANT SELECT, INSERT, UPDATE ON bbvatesor.TSI013_Orden			TO simultes;
GRANT SELECT, INSERT, UPDATE ON bbvatesor.TSI014_OrdenEstado	TO simultes;
GRANT SELECT, INSERT, UPDATE ON bbvatesor.TSI015_DetalleOrden	TO simultes;
*/

/*
 *******************************************
 *SINONIMOS
 *******************************************
 
CREATE or replace SYNONYM TSI001_Saldo    		 FOR bbvatesor.TSI001_Saldo;
CREATE or replace SYNONYM TSI002_Infoport 		 FOR bbvatesor.TSI002_Infoport;
CREATE or replace SYNONYM TSI003_CobranzaPago 	 FOR bbvatesor.TSI003_CobranzaPago;
CREATE or replace SYNONYM TSI004_TipoCambio 	 FOR bbvatesor.TSI004_TipoCambio;
CREATE or replace SYNONYM TSI005_General 		 FOR bbvatesor.TSI005_General;
CREATE or replace SYNONYM TSI006_Usuario 		 FOR bbvatesor.TSI006_Usuario;
CREATE or replace SYNONYM TSI007_Perfil 		 FOR bbvatesor.TSI007_Perfil;
CREATE or replace SYNONYM TSI008_Fondo 			 FOR bbvatesor.TSI008_Fondo;
CREATE or replace SYNONYM TSI009_PerfilFondo 	 FOR bbvatesor.TSI009_PerfilFondo;
CREATE or replace SYNONYM TSI010_Emisor 		 FOR bbvatesor.TSI010_Emisor;
CREATE or replace SYNONYM TSI011_LimitesEmisor 	 FOR bbvatesor.TSI011_LimitesEmisor;
CREATE or replace SYNONYM TSI012_LimFondoEspecie FOR bbvatesor.TSI012_LimFondoEspecie;
CREATE or replace SYNONYM TSI013_Orden			 FOR bbvatesor.TSI013_Orden;
CREATE or replace SYNONYM TSI014_OrdenEstado	 FOR bbvatesor.TSI014_OrdenEstado;
CREATE or replace SYNONYM TSI015_DetalleOrden	 FOR bbvatesor.TSI015_DetalleOrden;

*/

/*
 *******************************************
 *NUEVA TABLA EXPOFONDO
 *******************************************
 */

CREATE TABLE BBVATESOR.TSI009_EXPOFONDO (
    CID_EXPO NUMBER(*,0) NOT NULL ENABLE, 
    CD_IDFONDO NUMBER(*,0), 
    NB_ESPECIE VARCHAR2(60), 
    IM_MONTO NUMBER, 
    PC_PARTIC VARCHAR2(60), 
    IM_MONTO_PEN NUMBER, 
    PC_PARTIC_PEN VARCHAR2(60), 
    IM_MONTO_USD NUMBER, 
    PC_PARTIC_USD VARCHAR2(60), 
    IM_DURATION NUMBER, 
    PC_YTM VARCHAR2(60), 
    TP_MNEMONICO CHAR(1), 
    TP_TOTAL CHAR(1), 
    TO_TOTAL_EMI NUMBER,
    PC_EXPOSICION VARCHAR2(60),
    PC_LIMITE VARCHAR2(60),
    PC_ESPACIO VARCHAR2(60),
    IM_ESPACIO NUMBER,
    TP_SUBTITULO CHAR(1),
    TP_EMISOR CHAR(1)
);
 
CREATE  UNIQUE INDEX BBVATESOR.ISI009P1_EXPOFONDO ON BBVATESOR.TSI009_EXPOFONDO(CID_EXPO  ASC);

ALTER TABLE BBVATESOR.TSI009_EXPOFONDO ADD CONSTRAINT  ISI009P1_EXPOFONDO PRIMARY KEY (CID_EXPO);

/*
 *******************************************
 *  TABLAS CARGA ARCHIVO
 *******************************************
*/

create table BBVATESOR.TSI016_PROCESOCARGA
(
  cd_idproceso      NUMBER not null,
  fh_fec_ini        DATE,
  fh_fec_fin        DATE,
  nr_reg_leido      NUMBER,
  nr_reg_errado     NUMBER,
  st_estado_proceso CHAR(1),
  st_estado         CHAR(1),
  fh_fec_creacion   DATE,
  cd_usu_creacion   VARCHAR2(10),
  fh_fec_modifica   DATE,
  cd_usu_modifica   VARCHAR2(10),
  fh_fec_elimina    DATE,
  cd_usu_elimina    VARCHAR2(10),
  fh_fec_importa    DATE
);

-- Add comments to the columns 
comment on column BBVATESOR.TSI016_PROCESOCARGA.cd_idproceso
  is 'ID DE PROCESO DE CARGA';
comment on column BBVATESOR.TSI016_PROCESOCARGA.fh_fec_ini
  is 'FECHA INCIO PROCESO';
comment on column BBVATESOR.TSI016_PROCESOCARGA.fh_fec_fin
  is 'FECHA FIN PROCESO';
comment on column BBVATESOR.TSI016_PROCESOCARGA.nr_reg_leido
  is 'NUMERO DE REGISTROS LEIDOS';
comment on column BBVATESOR.TSI016_PROCESOCARGA.nr_reg_errado
  is 'NUMERO DE REGISTROS ERRADOS';
comment on column BBVATESOR.TSI016_PROCESOCARGA.st_estado_proceso
  is 'P-EN PROCESO T-TERMINADO E-ERRADO';
comment on column BBVATESOR.TSI016_PROCESOCARGA.st_estado
  is '1-ACTIVO 0-INACTIVO';
comment on column BBVATESOR.TSI016_PROCESOCARGA.fh_fec_importa
  is 'FECHA DE IMPORTACION yyyyMMdd';

-- Create/Recreate primary, unique and foreign key constraints 
alter table BBVATESOR.TSI016_PROCESOCARGA
  add constraint PK_PROCESOCARGA primary key (CD_IDPROCESO);

create table BBVATESOR.TSI017_PROCESOLOG
(
  cd_idlog       NUMBER not null,
  cd_idproceso   NUMBER,
  fh_fecreg      DATE,
  tp_tipomensaje VARCHAR2(10),
  ms_mensaje     VARCHAR2(2000)
);
-- Add comments to the columns 
comment on column BBVATESOR.TSI017_PROCESOLOG.cd_idlog
  is 'ID LOG';
comment on column BBVATESOR.TSI017_PROCESOLOG.cd_idproceso
  is 'ID PROCESO';
comment on column BBVATESOR.TSI017_PROCESOLOG.fh_fecreg
  is 'FECHA DE REGISTRO DE LOG';
comment on column BBVATESOR.TSI017_PROCESOLOG.tp_tipomensaje
  is 'TIPO DE MENSAJE LOG';
comment on column BBVATESOR.TSI017_PROCESOLOG.ms_mensaje
  is 'CONTENIDO MENSAJE';
-- Create/Recreate primary, unique and foreign key constraints 
alter table BBVATESOR.TSI017_PROCESOLOG
  add constraint PK_PROCESOLOG primary key (CD_IDLOG);

  
/*
 *******************************************
 *PACKAGE PKG_GENERAEXPOSICION
 *******************************************
 */
 create or replace package PKG_GENERAEXPOSICION is

  -- Author  : ADOLFO
  -- Created : 04/02/2016 09:58:09 a.m.
  -- Purpose : Visualizar la exposicion del fondo
  
  PROCEDURE SP_ACTUALIZA_FONDO(PNOM_FONDO TSI002_INFOPORT.NB_NOM_FONDO%TYPE);

end PKG_GENERAEXPOSICION;
/


create or replace package body PKG_GENERAEXPOSICION is

  PROCEDURE SP_ACTUALIZA_FONDO(PNOM_FONDO TSI002_INFOPORT.NB_NOM_FONDO%TYPE)
  IS
    --Globales
    V_ID_FONDO  BBVATESOR.TSI008_FONDO.CD_IDFONDO %TYPE;
    V_TC        BBVATESOR.TSI004_TIPOCAMBIO.NU_VALOR%TYPE;
    V_TOTAL     BBVATESOR.TSI009_EXPOFONDO.IM_MONTO%TYPE;
    --Utilitarias    
    V_MTOTOTAL  BBVATESOR.TSI009_EXPOFONDO.IM_MONTO%TYPE;
    V_MTOPEN    BBVATESOR.TSI009_EXPOFONDO.IM_MONTO_PEN%TYPE;
    V_MTOUSD    BBVATESOR.TSI009_EXPOFONDO.IM_MONTO_USD%TYPE;
    V_DURATION  BBVATESOR.TSI009_EXPOFONDO.IM_DURATION%TYPE;
        
    V_DEPOTOTAL  BBVATESOR.TSI009_EXPOFONDO.IM_MONTO%TYPE;
    V_DEPOPEN    BBVATESOR.TSI009_EXPOFONDO.IM_MONTO_PEN%TYPE;
    V_DEPOUSD    BBVATESOR.TSI009_EXPOFONDO.IM_MONTO_USD%TYPE;
    
    V_TIPEMISOR  BBVATESOR.TSI005_GENERAL.NB_DESC_GENERAL%TYPE;
    V_CANT_REG   NUMBER;
    V_TOT_EMISOR BBVATESOR.TSI009_EXPOFONDO.TO_TOTAL_EMI%TYPE;
    V_EXPOSICION BBVATESOR.TSI011_LIMITESEMISOR.PC_PORC_FIN%TYPE;
    V_LIMITE     BBVATESOR.TSI011_LIMITESEMISOR.PC_PORC_FIN%TYPE;
    V_ESPACIO    BBVATESOR.TSI011_LIMITESEMISOR.PC_PORC_FIN%TYPE;
            
    --Suscripcion
    V_VENTATOTAL  BBVATESOR.TSI009_EXPOFONDO.IM_MONTO%TYPE;
    V_VENTAPEN    BBVATESOR.TSI009_EXPOFONDO.IM_MONTO_PEN%TYPE;
    V_VENTAUSD    BBVATESOR.TSI009_EXPOFONDO.IM_MONTO_USD%TYPE;
    --Rescate
    V_COMPRATOTAL BBVATESOR.TSI009_EXPOFONDO.IM_MONTO%TYPE;
    V_COMPRAPEN   BBVATESOR.TSI009_EXPOFONDO.IM_MONTO_PEN%TYPE;
    V_COMPRAUSD   BBVATESOR.TSI009_EXPOFONDO.IM_MONTO_USD%TYPE; 
   
  BEGIN
    
    SELECT T.CD_IDFONDO INTO V_ID_FONDO
    FROM BBVATESOR.TSI008_FONDO T
    WHERE T.NB_NOM_FONDO LIKE PNOM_FONDO 
    AND ROWNUM=1;

    SELECT NVL((SELECT T.NU_VALOR 
    FROM BBVATESOR.TSI004_TIPOCAMBIO T
    WHERE T.ST_ESTADO = '1' AND ROWNUM=1),0) INTO V_TC FROM DUAL;
    
    --Borrar los registros anteriores
    DELETE FROM BBVATESOR.TSI009_EXPOFONDO WHERE CD_IDFONDO = V_ID_FONDO;
    COMMIT;
    
    --DBMS_OUTPUT.put_line('VAL =' || V_ID_FONDO);
    --DBMS_OUTPUT.put_line('VAL =' || V_TC);
    
    FOR ESPECIES IN (
        SELECT DISTINCT T.NB_ESPECIE
        FROM BBVATESOR.TSI002_INFOPORT T
        WHERE T.NB_NOM_FONDO LIKE PNOM_FONDO
        ORDER BY T.NB_ESPECIE)
    LOOP
        IF(ESPECIES.NB_ESPECIE = 'Certificados') THEN
        	DBMS_OUTPUT.put_line('VAL =' || V_ID_FONDO);
          --BCR
          
        END IF;
        
        --Monto Total
        SELECT ROUND(SUM(T.IM_VALOR_MON_LOCAL)) INTO V_MTOTOTAL
        FROM BBVATESOR.TSI002_INFOPORT T
        WHERE T.NB_NOM_FONDO LIKE PNOM_FONDO 
        AND T.NB_ESPECIE LIKE ESPECIES.NB_ESPECIE;
        
        --Monto PEN
        SELECT ROUND(SUM(T.IM_VALOR_MON_LOCAL)) INTO V_MTOPEN
        FROM BBVATESOR.TSI002_INFOPORT T
        WHERE T.NB_NOM_FONDO LIKE PNOM_FONDO  
        AND T.TP_ABREV_MONEDA LIKE 'PEN'
        AND T.NB_ESPECIE LIKE ESPECIES.NB_ESPECIE;

        --Monto USD
        SELECT ROUND(SUM(T.IM_VALOR_MON_LOCAL)) INTO V_MTOUSD
        FROM BBVATESOR.TSI002_INFOPORT T
        WHERE T.NB_NOM_FONDO LIKE PNOM_FONDO  
        AND T.TP_ABREV_MONEDA LIKE 'USD'
        AND T.NB_ESPECIE LIKE ESPECIES.NB_ESPECIE;
        
        --Duration
        SELECT ROUND((ROUND(SUM(T.IM_VALOR_POR_DURAC)) / V_MTOTOTAL),2) INTO V_DURATION
        FROM BBVATESOR.TSI002_INFOPORT T
        WHERE T.NB_NOM_FONDO LIKE PNOM_FONDO  
        AND T.NB_ESPECIE LIKE ESPECIES.NB_ESPECIE;

        --Registro
        INSERT INTO BBVATESOR.TSI009_EXPOFONDO 
        (CID_EXPO, CD_IDFONDO, NB_ESPECIE, IM_MONTO, IM_MONTO_PEN, IM_MONTO_USD, IM_DURATION, TP_MNEMONICO, TP_EMISOR)
        VALUES(SEQ_EXPOFONDO.NEXTVAL, V_ID_FONDO, ESPECIES.NB_ESPECIE, V_MTOTOTAL, V_MTOPEN, V_MTOUSD, V_DURATION, '0', '0');
        COMMIT;
        --Almacena valores de deposito
        IF(ESPECIES.NB_ESPECIE = 'Depositos de ahorr') THEN
        	V_DEPOTOTAL := V_MTOTOTAL;
        	V_DEPOPEN   := V_MTOPEN;
        	V_DEPOUSD   := V_MTOUSD;          
        END IF;
        
        IF(ESPECIES.NB_ESPECIE = 'Instrumentos de go') THEN                   
          FOR MNEMONICO IN (
              SELECT T.NB_MNEMONICO
              FROM BBVATESOR.TSI002_INFOPORT T
              WHERE T.NB_NOM_FONDO LIKE PNOM_FONDO
              AND T.NB_ESPECIE LIKE ESPECIES.NB_ESPECIE
              ORDER BY T.NB_MNEMONICO )
          LOOP
              --Monto Total Mnemonico
              SELECT ROUND(SUM(T.IM_VALOR_MON_LOCAL)) INTO V_MTOTOTAL
              FROM BBVATESOR.TSI002_INFOPORT T
              WHERE T.NB_NOM_FONDO LIKE PNOM_FONDO 
              AND T.NB_ESPECIE LIKE ESPECIES.NB_ESPECIE
              AND T.NB_MNEMONICO LIKE MNEMONICO.NB_MNEMONICO;
               
              --Monto PEN Mnemonico
              V_MTOPEN := NULL;

              --Monto USD Mnemonico
              V_MTOUSD := NULL;
              
              --Duration
              SELECT ROUND((ROUND(SUM(T.IM_VALOR_POR_DURAC)) / V_MTOTOTAL),2) INTO V_DURATION
              FROM BBVATESOR.TSI002_INFOPORT T
              WHERE T.NB_NOM_FONDO LIKE PNOM_FONDO  
              AND T.NB_ESPECIE LIKE ESPECIES.NB_ESPECIE
              AND T.NB_MNEMONICO LIKE MNEMONICO.NB_MNEMONICO;
              
              --Registro
              INSERT INTO BBVATESOR.TSI009_EXPOFONDO 
              (CID_EXPO, CD_IDFONDO, NB_ESPECIE, IM_MONTO, IM_MONTO_PEN, IM_MONTO_USD, IM_DURATION, TP_MNEMONICO, TP_EMISOR)
              VALUES(SEQ_EXPOFONDO.NEXTVAL, V_ID_FONDO, MNEMONICO.NB_MNEMONICO, V_MTOTOTAL, V_MTOPEN, V_MTOUSD, V_DURATION, '1', '0');
              COMMIT;
          END LOOP;              
        END IF;    
    END LOOP;
    
    --Suscripcion + Ventas
    SELECT ROUND(SUM(T.IM_SUSCRIPCION + T.IM_VENTAS_TMASN + T.IM_CXC_ACCIONES)) INTO V_VENTAPEN
    FROM BBVATESOR.TSI001_SALDO T 
    WHERE T.NB_NOM_FONDO LIKE PNOM_FONDO
    AND T.TP_TIPMONEDA LIKE 'PEN';
         
    SELECT ROUND(SUM(S.IM_VENTAS_TMASN + S.IM_CXC_ACCIONES)*V_TC) INTO V_VENTAUSD
    FROM BBVATESOR.TSI001_SALDO S WHERE S.NB_NOM_FONDO LIKE PNOM_FONDO
    AND S.TP_TIPMONEDA LIKE 'USD';
              
    SELECT ROUND(SUM(V_VENTAPEN+V_VENTAUSD)) INTO V_VENTATOTAL
    FROM DUAL;

    INSERT INTO BBVATESOR.TSI009_EXPOFONDO 
    (CID_EXPO, CD_IDFONDO, NB_ESPECIE, IM_MONTO, IM_MONTO_PEN, IM_MONTO_USD, TP_MNEMONICO, TP_EMISOR)
    VALUES(SEQ_EXPOFONDO.NEXTVAL, V_ID_FONDO, 'Suscripción + Vtas.', V_VENTATOTAL, V_VENTAPEN, V_VENTAUSD, '2', '0');
    COMMIT;
    
    --Rescate + Compras
    SELECT ROUND(SUM(T.IM_RESCATE + T.IM_COMPRAS_TMASN + T.IM_CXP_ACCIONES + T.IM_RESCATE_TMASN + T.IM_COMISION)) INTO V_COMPRAPEN
    FROM BBVATESOR.TSI001_SALDO T WHERE T.NB_NOM_FONDO LIKE PNOM_FONDO
    AND T.TP_TIPMONEDA LIKE 'PEN';
    
    SELECT ROUND(SUM(S.IM_COMPRAS_TMASN + S.IM_CXP_ACCIONES + S.IM_COMISION)*V_TC) INTO V_COMPRAUSD
    FROM BBVATESOR.TSI001_SALDO S WHERE S.NB_NOM_FONDO LIKE PNOM_FONDO
    AND S.TP_TIPMONEDA LIKE 'USD';
    
    SELECT ROUND(SUM(V_COMPRAPEN+V_COMPRAUSD)) INTO V_COMPRATOTAL 
    FROM DUAL;
    
    INSERT INTO BBVATESOR.TSI009_EXPOFONDO 
    (CID_EXPO, CD_IDFONDO, NB_ESPECIE, IM_MONTO, IM_MONTO_PEN, IM_MONTO_USD, TP_MNEMONICO, TP_EMISOR)
    VALUES(SEQ_EXPOFONDO.NEXTVAL, V_ID_FONDO, 'Rescate + Comp.', V_COMPRATOTAL, V_COMPRAPEN, V_COMPRAUSD, '2', '0');
    COMMIT;
    
    --Caja Final (Sumar las ventas, Restar las compras)
    INSERT INTO BBVATESOR.TSI009_EXPOFONDO 
    (CID_EXPO, CD_IDFONDO, NB_ESPECIE, IM_MONTO, IM_MONTO_PEN, IM_MONTO_USD, TP_EMISOR)
    VALUES(SEQ_EXPOFONDO.NEXTVAL, V_ID_FONDO, 'Caja Final', 
    	(V_DEPOTOTAL + V_VENTATOTAL - V_COMPRATOTAL), 
      (V_DEPOPEN   + V_VENTAPEN   - V_COMPRAPEN),
      (V_DEPOUSD   + V_VENTAUSD   - V_COMPRAUSD), '0');
    COMMIT;
    
    --TOTAL
    SELECT (SUM(T.IM_MONTO)     + V_VENTATOTAL - V_COMPRATOTAL), 
           (SUM(T.IM_MONTO_PEN) + V_VENTAPEN   - V_COMPRAPEN), 
           (SUM(T.IM_MONTO_USD) + V_VENTAUSD   - V_COMPRAUSD) 
           INTO V_TOTAL, V_MTOPEN, V_MTOUSD
    FROM BBVATESOR.TSI009_EXPOFONDO T
    WHERE T.CD_IDFONDO = V_ID_FONDO
    AND T.TP_MNEMONICO = '0';
    
    INSERT INTO BBVATESOR.TSI009_EXPOFONDO 
    (CID_EXPO, CD_IDFONDO, NB_ESPECIE, IM_MONTO, IM_MONTO_PEN, IM_MONTO_USD, TP_TOTAL, TP_EMISOR)
    VALUES(SEQ_EXPOFONDO.NEXTVAL, V_ID_FONDO, 'TOTAL', V_TOTAL, V_MTOPEN, V_MTOUSD, '1', '0');
    COMMIT;
    
    --PORCENTAJES
    FOR EXPO IN (
        SELECT T.CID_EXPO, T.NB_ESPECIE, T.IM_MONTO, T.IM_MONTO_PEN, T.IM_MONTO_USD
        FROM BBVATESOR.TSI009_EXPOFONDO T
        WHERE T.CD_IDFONDO = V_ID_FONDO
        AND T.TP_MNEMONICO IS NOT NULL)
    LOOP
        --Agregar el signo negativo
        IF(EXPO.NB_ESPECIE = 'Rescate + Comp.') THEN  
            IF(EXPO.IM_MONTO IS NOT NULL) THEN
              UPDATE BBVATESOR.TSI009_EXPOFONDO
              SET PC_PARTIC = '-'||LTRIM(TO_CHAR(ROUND((EXPO.IM_MONTO/V_TOTAL)*100,1),'90.0'))
              WHERE CID_EXPO = EXPO.CID_EXPO;
              COMMIT;
            END IF;
            IF(EXPO.IM_MONTO_PEN IS NOT NULL) THEN
              UPDATE BBVATESOR.TSI009_EXPOFONDO
              SET PC_PARTIC_PEN = '-'||LTRIM(TO_CHAR(ROUND((EXPO.IM_MONTO_PEN/V_TOTAL)*100,1),'90.0'))
              WHERE CID_EXPO = EXPO.CID_EXPO;
              COMMIT;
            END IF;
            IF(EXPO.IM_MONTO_USD IS NOT NULL) THEN
              UPDATE BBVATESOR.TSI009_EXPOFONDO
              SET PC_PARTIC_USD = '-'||LTRIM(TO_CHAR(ROUND((EXPO.IM_MONTO_USD/V_TOTAL)*100,1),'90.0'))
              WHERE CID_EXPO = EXPO.CID_EXPO;
              COMMIT;
            END IF;
        ELSE
          	IF(EXPO.IM_MONTO IS NOT NULL) THEN
              UPDATE BBVATESOR.TSI009_EXPOFONDO
              SET PC_PARTIC = LTRIM(TO_CHAR(ROUND((EXPO.IM_MONTO/V_TOTAL)*100,1),'90.0'))
              WHERE CID_EXPO = EXPO.CID_EXPO;
              COMMIT;
            END IF;
            IF(EXPO.IM_MONTO_PEN IS NOT NULL) THEN
              UPDATE BBVATESOR.TSI009_EXPOFONDO
              SET PC_PARTIC_PEN = LTRIM(TO_CHAR(ROUND((EXPO.IM_MONTO_PEN/V_TOTAL)*100,1),'90.0'))
              WHERE CID_EXPO = EXPO.CID_EXPO;
              COMMIT;
            END IF;
            IF(EXPO.IM_MONTO_USD IS NOT NULL) THEN
              UPDATE BBVATESOR.TSI009_EXPOFONDO
              SET PC_PARTIC_USD = LTRIM(TO_CHAR(ROUND((EXPO.IM_MONTO_USD/V_TOTAL)*100,1),'90.0'))
              WHERE CID_EXPO = EXPO.CID_EXPO;
              COMMIT;
            END IF;
        END IF;
    END LOOP;
    
    --PORCENTAJES TOTAL
    UPDATE BBVATESOR.TSI009_EXPOFONDO
    SET PC_PARTIC = (SELECT SUM(TO_NUMBER(T.PC_PARTIC,'90.0')) 
                    FROM TSI009_EXPOFONDO T 
                    WHERE T.TP_MNEMONICO IN ('0','2')
                    AND CD_IDFONDO = V_ID_FONDO),
        PC_PARTIC_PEN = (SELECT SUM(TO_NUMBER(T.PC_PARTIC_PEN,'90.0')) 
                    FROM TSI009_EXPOFONDO T 
                    WHERE T.TP_MNEMONICO IN ('0','2')
                    AND CD_IDFONDO = V_ID_FONDO),
        PC_PARTIC_USD = (SELECT SUM(TO_NUMBER(T.PC_PARTIC_USD,'90.0')) 
                    FROM TSI009_EXPOFONDO T 
                    WHERE T.TP_MNEMONICO IN ('0','2')
                    AND CD_IDFONDO = V_ID_FONDO)                    
    WHERE CID_EXPO IN (
    	SELECT CID_EXPO
      FROM TSI009_EXPOFONDO 
      WHERE TP_TOTAL = '1' 
      AND CD_IDFONDO = V_ID_FONDO
      AND ROWNUM=1
    );
    
    V_CANT_REG := 0;
    --Emisores
    FOR EMISORES IN (
        SELECT DISTINCT G.NB_DESC_GENERAL, E.NB_NOM_EMISOR, E.CD_IDEMISOR
        FROM BBVATESOR.TSI002_INFOPORT T
        INNER JOIN BBVATESOR.TSI010_EMISOR E ON T.NB_NOM_EMISOR=E.NB_NOM_EMISOR
        INNER JOIN BBVATESOR.TSI005_GENERAL G ON E.TP_TIPEMISOR=G.CD_IDGENERAL
        WHERE T.NB_NOM_FONDO LIKE PNOM_FONDO AND E.TP_TIPEMISOR <> 6
        AND E.ST_ESTADO = '1'
        ORDER BY G.NB_DESC_GENERAL, E.NB_NOM_EMISOR)
    LOOP
      IF(EMISORES.NB_DESC_GENERAL <> V_TIPEMISOR) THEN
	      V_CANT_REG := 0;
      END IF;
      IF(V_CANT_REG = 0) THEN
        V_TIPEMISOR := EMISORES.NB_DESC_GENERAL;
        
      	INSERT INTO BBVATESOR.TSI009_EXPOFONDO (CID_EXPO, CD_IDFONDO, NB_ESPECIE, TP_SUBTITULO, TP_EMISOR)
        VALUES(SEQ_EXPOFONDO.NEXTVAL, V_ID_FONDO, V_TIPEMISOR, '1', '1');
        COMMIT;
      END IF;
      V_CANT_REG:= V_CANT_REG + 1;
      
      --Ahorros
      SELECT ROUND(SUM(T.IM_VALOR_MON_LOCAL)) INTO V_MTOTOTAL
      FROM BBVATESOR.TSI002_INFOPORT T
      WHERE T.NB_NOM_FONDO LIKE PNOM_FONDO 
      AND T.NB_ESPECIE LIKE 'Depositos de ahorr'
      AND T.NB_NOM_EMISOR LIKE EMISORES.NB_NOM_EMISOR;

      IF(EMISORES.NB_NOM_EMISOR = 'BANCO CONTINENTAL') THEN
      	V_MTOTOTAL := V_MTOTOTAL + V_VENTATOTAL - V_COMPRATOTAL;
      END IF;
            
      --DPF
      SELECT ROUND(SUM(T.IM_VALOR_MON_LOCAL)) INTO V_MTOPEN
      FROM BBVATESOR.TSI002_INFOPORT T
      WHERE T.NB_NOM_FONDO LIKE PNOM_FONDO  
      AND T.NB_ESPECIE LIKE 'Depositos a plazo'
      AND T.NB_NOM_EMISOR LIKE EMISORES.NB_NOM_EMISOR;

      --CD y PC
      SELECT ROUND(SUM(T.IM_VALOR_MON_LOCAL)) INTO V_MTOUSD
      FROM BBVATESOR.TSI002_INFOPORT T
      WHERE T.NB_NOM_FONDO LIKE PNOM_FONDO  
      AND T.NB_ESPECIE IN ('Certificados', 'Papeles Comerciale')
      AND T.NB_NOM_EMISOR LIKE EMISORES.NB_NOM_EMISOR;
      
      --Bonos
      SELECT ROUND(SUM(T.IM_VALOR_MON_LOCAL)) INTO V_DURATION
      FROM BBVATESOR.TSI002_INFOPORT T
      WHERE T.NB_NOM_FONDO LIKE PNOM_FONDO  
      AND T.NB_ESPECIE IN ('Bonos corporativos','Bonos de arrendami','Bonos subordinados') 
      AND T.NB_NOM_EMISOR LIKE EMISORES.NB_NOM_EMISOR;
      
      --Total
      V_TOT_EMISOR := (NVL(V_MTOTOTAL,0) + NVL(V_MTOPEN,0) + NVL(V_MTOUSD,0) + NVL(V_DURATION,0));
      
      --Exposicion
      V_EXPOSICION := ROUND((V_TOT_EMISOR/V_TOTAL)*100,1);
      
      --Limite
      BEGIN
        SELECT NVL(T.PC_PORC_FIN,0) INTO V_LIMITE 
        FROM BBVATESOR.TSI011_LIMITESEMISOR T
        WHERE T.CD_IDFONDO = V_ID_FONDO 
        AND T.CD_IDEMISOR = EMISORES.CD_IDEMISOR;
        EXCEPTION
        WHEN NO_DATA_FOUND THEN
          V_LIMITE :=0;
      END;
      
      --Espacio
      IF V_LIMITE = 0 THEN
         V_ESPACIO := 0;
      ELSE
         V_ESPACIO := +V_LIMITE - V_EXPOSICION;
      END IF;
      
      --Registro  
       INSERT INTO BBVATESOR.TSI009_EXPOFONDO 
       (CID_EXPO, CD_IDFONDO, NB_ESPECIE, IM_MONTO, IM_MONTO_PEN, IM_MONTO_USD, IM_DURATION, TO_TOTAL_EMI ,TP_EMISOR, 
       PC_EXPOSICION, PC_LIMITE, PC_ESPACIO, IM_ESPACIO)
       VALUES(SEQ_EXPOFONDO.NEXTVAL, V_ID_FONDO, LOWER(EMISORES.NB_NOM_EMISOR), V_MTOTOTAL, V_MTOPEN, V_MTOUSD, V_DURATION, V_TOT_EMISOR, '1', 
       LTRIM(TO_CHAR(V_EXPOSICION,'90.0')), LTRIM(TO_CHAR(V_LIMITE,'90.0')), LTRIM(TO_CHAR(V_ESPACIO,'90.0')), ROUND((V_ESPACIO * V_TOTAL)/100));
       COMMIT;

    END LOOP;
    
    --TOTAL EMISORES
    SELECT SUM(T.IM_MONTO), SUM(T.IM_MONTO_PEN), 
       SUM(T.IM_MONTO_USD), SUM(T.IM_DURATION),
       SUM(T.TO_TOTAL_EMI)
       INTO V_MTOTOTAL, V_MTOPEN, V_MTOUSD, V_DURATION, V_TOT_EMISOR
       FROM TSI009_EXPOFONDO T 
    WHERE T.TP_EMISOR='1';

    INSERT INTO BBVATESOR.TSI009_EXPOFONDO 
    (CID_EXPO, CD_IDFONDO, IM_MONTO, IM_MONTO_PEN, IM_MONTO_USD, IM_DURATION, TO_TOTAL_EMI ,TP_EMISOR, TP_TOTAL)
    VALUES(SEQ_EXPOFONDO.NEXTVAL, V_ID_FONDO, V_MTOTOTAL, V_MTOPEN, V_MTOUSD, V_DURATION, V_TOT_EMISOR, '1', '1');
    COMMIT;
    
    EXCEPTION
      WHEN NO_DATA_FOUND THEN
        RAISE_APPLICATION_ERROR( -20001, 'NO SE ENCONTRO REGISTROS');
      WHEN OTHERS THEN
        RAISE_APPLICATION_ERROR(-20000,    sqlcode || ' ' || SQLERRM  );
        ROLLBACK;
  END;     

end PKG_GENERAEXPOSICION;
/