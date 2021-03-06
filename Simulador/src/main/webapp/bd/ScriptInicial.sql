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
DROP TABLE bbvatesor.TSI008_Fondo CASCADE CONSTRAINTS PURGE;
DROP TABLE bbvatesor.TSI005_General CASCADE CONSTRAINTS PURGE;
DROP TABLE bbvatesor.TSI010_Emisor CASCADE CONSTRAINTS PURGE;


/*
 *******************************************
 *CREATE TABLE
 *******************************************
 */
CREATE TABLE bbvatesor.TSI001_Saldo (
  cd_cod_fondo  CHAR(4)  NULL ,
  cd_idsaldo  INTEGER  NOT NULL ,
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
  im_saldo_tmasn  NUMBER  NULL 
);

CREATE  UNIQUE INDEX ISI001P1_Saldo ON bbvatesor.TSI001_Saldo (cd_idsaldo  ASC);

ALTER TABLE bbvatesor.TSI001_Saldo ADD CONSTRAINT  ISI001P1_Saldo PRIMARY KEY (cd_idsaldo);

CREATE TABLE bbvatesor.TSI002_Infoport (
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
  nb_isim  VARCHAR2(15)  NULL ,
  nb_mnemoniaco  VARCHAR2(15)  NULL ,
  nu_num_dias_vcto  NUMBER  NULL ,
  fh_fecvcto_sgt_cup  DATE  NULL ,
  fh_fec_ult_operac  DATE  NULL ,
  im_durac_nor_libor  NUMBER  NULL ,
  im_compra_t_mas_n  NUMBER  NULL ,
  nb_observacion  VARCHAR2(100)  NULL ,
  im_valor_por_durac  NUMBER  NULL ,
  im_valor_por_ytm  NUMBER  NULL ,
  nu_dia_para_venc  NUMBER  NULL ,
  st_estado  VARCHAR2(9)  NULL ,
  st_condicion  CHAR(1)  NULL ,
  cd_idinfoport  INTEGER  NOT NULL 
);

COMMENT ON TABLE bbvatesor.TSI002_Infoport IS 'Almacena la informaci�n del portafolio';

CREATE  UNIQUE INDEX ISI002P1_Infoport ON bbvatesor.TSI002_Infoport (cd_idinfoport  ASC);

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
  cd_sigla  CHAR(3)  NULL 
);

CREATE  UNIQUE INDEX ISI003P1_CobranzaP ON bbvatesor.TSI003_CobranzaPago (cd_idcobranzaPago  ASC);

ALTER TABLE bbvatesor.TSI003_CobranzaPago ADD CONSTRAINT  ISI003P1_CobranzaP PRIMARY KEY (cd_idcobranzaPago);

CREATE TABLE bbvatesor.TSI004_TipoCambio (
  cd_idTipoCambio  INTEGER  NOT NULL ,
  fh_fec_ingreso  DATE  NULL ,
  nu_valor  NUMBER  NULL ,
  fh_fec_creacion  DATE  NULL ,
  cd_usu_creacion  VARCHAR2(10)  NULL ,
  fh_fec_modifica  DATE  NULL ,
  cd_usu_modifica  VARCHAR2(10)  NULL ,
  fh_fec_elimina  DATE  NULL ,
  cd_usu_elimina  VARCHAR2(10)  NULL ,
  st_estado  CHAR(1)  NULL 
);

CREATE  UNIQUE INDEX ISI004P1_TipCambio ON bbvatesor.TSI004_TipoCambio (cd_idTipoCambio  ASC);

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

CREATE  UNIQUE INDEX ISI005P1_General ON bbvatesor.TSI005_General (cd_idgeneral  ASC);

ALTER TABLE bbvatesor.TSI005_General ADD CONSTRAINT  ISI005P1_General PRIMARY KEY (cd_idgeneral);

comment on column BBVATESOR.TSI005_GENERAL.fg_editable
  is '1-EDITABLE 0-NOEDITABLE';

CREATE TABLE bbvatesor.TSI006_Usuario (
  cd_idusuario  INTEGER  NOT NULL ,
  nb_nom_usu  VARCHAR2(40)  NULL ,
  nb_ape_pat_usu  VARCHAR2(40)  NULL ,
  nb_ape_mat_usu  VARCHAR2(40)  NULL ,
  cd_login  VARCHAR2(10)  NULL ,
  cd_clave  VARCHAR2(20)  NULL ,
  tp_tipdocumento  INTEGER  NULL ,
  nu_documento  VARCHAR2(14)  NULL ,
  fh_fec_creacion  DATE  NULL ,
  cd_usu_creacion  VARCHAR2(10)  NULL ,
  fh_fec_modifica  DATE  NULL ,
  cd_usu_modifica  VARCHAR2(10)  NULL ,
  fh_fec_elimina  DATE  NULL ,
  cd_usu_elimina  VARCHAR2(10)  NULL ,
  st_estado  CHAR(1)  NULL ,
  cd_idperfil  INTEGER  NOT NULL 
);

CREATE  UNIQUE INDEX ISI006P1_Usuario ON bbvatesor.TSI006_Usuario (cd_idusuario  ASC);

ALTER TABLE bbvatesor.TSI006_Usuario ADD CONSTRAINT  ISI006P1_Usuario PRIMARY KEY (cd_idusuario);

CREATE INDEX ISI006S1_Usuario ON bbvatesor.TSI006_Usuario (cd_idperfil  ASC);

CREATE TABLE bbvatesor.TSI007_Perfil (
  cd_idperfil  INTEGER  NOT NULL ,
  nb_mon_perfil  VARCHAR2(40)  NULL ,
  fh_fec_inicio  DATE  NULL ,
  fh_fec_fin  DATE  NULL ,
  tp_tipperfil  INTEGER  NULL ,
  fh_fec_creacion  DATE  NULL ,
  cd_usu_creacion  VARCHAR2(10)  NULL ,
  fh_fec_modifica  DATE  NULL ,
  cd_usu_modifica  VARCHAR2(10)  NULL ,
  fh_fec_elimina  DATE  NULL ,
  cd_usu_elimina  VARCHAR2(10)  NULL ,
  st_estado  CHAR(1)  NULL 
);

CREATE  UNIQUE INDEX ISI007P1_Perfil ON bbvatesor.TSI007_Perfil (cd_idperfil  ASC);

ALTER TABLE bbvatesor.TSI007_Perfil ADD CONSTRAINT ISI007P1_Perfil PRIMARY KEY (cd_idperfil);

CREATE TABLE bbvatesor.TSI008_Fondo (
  cd_idfondo  INTEGER  NOT NULL ,
  cd_cod_fondo  CHAR(4)  NULL ,
  nb_nom_fondo  VARCHAR2(40)  NULL ,
  tp_tipmoneda  INTEGER  NULL ,
  tp_tipfondo  CHAR(1)  NULL 
);

CREATE  UNIQUE INDEX ISI008P1_Fondo ON bbvatesor.TSI008_Fondo (cd_idfondo  ASC);

ALTER TABLE bbvatesor.TSI008_Fondo ADD CONSTRAINT  ISI008P1_Fondo PRIMARY KEY (cd_idfondo);

CREATE TABLE bbvatesor.TSI009_PerfilFondo (
  cd_idperfil  INTEGER  NOT NULL ,
  cd_idfondo  INTEGER  NOT NULL ,
  fh_fec_creacion  DATE  NULL ,
  cd_usu_creacion  VARCHAR2(10)  NULL ,
  fh_fec_modifica  DATE  NULL ,
  cd_usu_modifica  VARCHAR2(10)  NULL ,
  fh_fec_elimina  DATE  NULL ,
  cd_usu_elimina  VARCHAR2(10)  NULL ,
  st_estado  CHAR(1)  NULL 
);

CREATE  UNIQUE INDEX ISI009P1_PerfilFdo ON bbvatesor.TSI009_PerfilFondo (cd_idperfil  ASC, cd_idfondo  ASC);

ALTER TABLE bbvatesor.TSI009_PerfilFondo ADD CONSTRAINT  ISI009P1_PerfilFdo PRIMARY KEY (cd_idperfil,cd_idfondo);

CREATE INDEX ISI009S1_PerfilFdo ON bbvatesor.TSI009_PerfilFondo (cd_idperfil  ASC);

CREATE INDEX ISI009S2_PerfilFdo ON bbvatesor.TSI009_PerfilFondo (cd_idfondo  ASC);

CREATE TABLE bbvatesor.TSI010_Emisor (
  cd_idemisor  INTEGER  NOT NULL ,
  nb_nom_emisor  VARCHAR2(60)  NULL ,
  tp_rating  VARCHAR2(3)  NULL ,
  im_pasivo  NUMBER  NULL ,
  tp_tipemisor  INTEGER  NULL ,
  fh_fec_creacion  DATE  NULL ,
  cd_usu_creacion  VARCHAR2(10)  NULL ,
  fh_fec_modifica  DATE  NULL ,
  cd_usu_modifica  VARCHAR2(10)  NULL ,
  fh_fec_elimina  DATE  NULL ,
  cd_usu_elimina  VARCHAR2(10)  NULL ,
  st_estado  CHAR(1)  NULL 
);

CREATE  UNIQUE INDEX ISI010P1_Emisor ON bbvatesor.TSI010_Emisor (cd_idemisor  ASC);

ALTER TABLE bbvatesor.TSI010_Emisor ADD CONSTRAINT  ISI010P1_Emisor PRIMARY KEY (cd_idemisor);

CREATE TABLE bbvatesor.TSI011_LimitesEmisor (
  cd_idlimite  INTEGER  NOT NULL ,
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

CREATE  UNIQUE INDEX ISI011P1_LimEmisor ON bbvatesor.TSI011_LimitesEmisor (cd_idlimite  ASC, cd_idemisor  ASC);

ALTER TABLE bbvatesor.TSI011_LimitesEmisor ADD CONSTRAINT  ISI011P1_LimEmisor PRIMARY KEY (cd_idlimite,cd_idemisor);

CREATE INDEX ISI011S1_LimEmisor ON bbvatesor.TSI011_LimitesEmisor (cd_idemisor  ASC);

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

CREATE  UNIQUE INDEX ISI012P1_LimFdoEsp ON bbvatesor.TSI012_LimFondoEspecie (cd_idconfiguracion);

ALTER TABLE bbvatesor.TSI012_LimFondoEspecie ADD CONSTRAINT ISI012P1_LimFdoEsp PRIMARY KEY (cd_idconfiguracion);

CREATE INDEX ISI012S1_LimFdoEsp ON bbvatesor.TSI012_LimFondoEspecie (cd_idemisor  ASC);

CREATE INDEX ISI012S2_LimFdoEsp ON bbvatesor.TSI012_LimFondoEspecie (cd_idgeneral  ASC);

CREATE INDEX ISI012S3_LimFdoEsp ON bbvatesor.TSI012_LimFondoEspecie (cd_idfondo  ASC);


/*
 *******************************************
 *FOREIGN KEY
 *******************************************
 */
ALTER TABLE bbvatesor.TSI006_Usuario 
  ADD (CONSTRAINT  R006007 FOREIGN KEY (cd_idperfil) REFERENCES TSI007_Perfil(cd_idperfil));

ALTER TABLE bbvatesor.TSI009_PerfilFondo 
  ADD (CONSTRAINT  R007009 FOREIGN KEY (cd_idperfil) REFERENCES TSI007_Perfil(cd_idperfil));


ALTER TABLE bbvatesor.TSI009_PerfilFondo
  ADD (CONSTRAINT  R008009 FOREIGN KEY (cd_idfondo) REFERENCES TSI008_Fondo(cd_idfondo));


ALTER TABLE bbvatesor.TSI011_LimitesEmisor
  ADD (CONSTRAINT  R010011 FOREIGN KEY (cd_idemisor) REFERENCES TSI010_Emisor(cd_idemisor));


ALTER TABLE bbvatesor.TSI012_LimFondoEspecie
  ADD (CONSTRAINT  R010012 FOREIGN KEY (cd_idemisor) REFERENCES TSI010_Emisor(cd_idemisor));


ALTER TABLE bbvatesor.TSI012_LimFondoEspecie
  ADD (CONSTRAINT  R005012 FOREIGN KEY (cd_idgeneral) REFERENCES TSI005_General(cd_idgeneral));


ALTER TABLE bbvatesor.TSI012_LimFondoEspecie
  ADD (CONSTRAINT  R008012 FOREIGN KEY (cd_idfondo) REFERENCES TSI008_Fondo(cd_idfondo));


  
/*
 *******************************************
 *USUARIO APP
 *******************************************
 */
CREATE USER simultes IDENTIFIED BY simultes 
default tablespace users 
temporary tablespace temp 
quota unlimited on users 
account unlock;

/*
 *******************************************
 *PERMISOS APP
 *******************************************
 */
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


--GRANT USAGE ON SEQUENCE sequenceName TO grantees  

/*
 *******************************************
 *SINONIMOS
 *******************************************
 */
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


/*
 *******************************************
 * SEQUENCES
 *******************************************
 */
CREATE SEQUENCE bbvatesor.SEQ_TIPOCAMBIO;
CREATE SEQUENCE bbvatesor.SEQ_GENERAL start with 10;
CREATE SEQUENCE bbvatesor.SEQ_EMISOR;
CREATE SEQUENCE bbvatesor.SEQ_LIMITESEMISOR;
CREATE SEQUENCE bbvatesor.SEQ_PERFIL START WITH 10;
CREATE SEQUENCE BBVATESOR.SEQ_LIMFONDOESPECIE;

/*
 *******************************************
 * INSERTS TSI007_PERFIL
 *******************************************
 */
insert into bbvatesor.TSI007_PERFIL (cd_idperfil, nb_mon_perfil, fh_fec_inicio, fh_fec_fin, tp_tipperfil, fh_fec_creacion, cd_usu_creacion, fh_fec_modifica, cd_usu_modifica, fh_fec_elimina, cd_usu_elimina, st_estado)
values (1, 'Administrador de Sistema', to_date('21-01-2016', 'dd-mm-yyyy'), to_date('19-01-2017', 'dd-mm-yyyy'), 1, to_date('21-01-2016', 'dd-mm-yyyy'), 'P00000', null, null, null, null, '1');
insert into bbvatesor.TSI007_PERFIL (cd_idperfil, nb_mon_perfil, fh_fec_inicio, fh_fec_fin, tp_tipperfil, fh_fec_creacion, cd_usu_creacion, fh_fec_modifica, cd_usu_modifica, fh_fec_elimina, cd_usu_elimina, st_estado)
values (2, 'Administrador de Inversiones', to_date('21-01-2016', 'dd-mm-yyyy'), to_date('19-01-2017', 'dd-mm-yyyy'), 1, to_date('21-01-2016', 'dd-mm-yyyy'), 'P00000', null, null, null, null, '1');
insert into bbvatesor.TSI007_PERFIL (cd_idperfil, nb_mon_perfil, fh_fec_inicio, fh_fec_fin, tp_tipperfil, fh_fec_creacion, cd_usu_creacion, fh_fec_modifica, cd_usu_modifica, fh_fec_elimina, cd_usu_elimina, st_estado)
values (4, 'Inversionista BBVA Soles', to_date('21-01-2016', 'dd-mm-yyyy'), to_date('19-01-2017', 'dd-mm-yyyy'), 1, to_date('21-01-2016', 'dd-mm-yyyy'), 'P00000', null, null, null, null, '1');
insert into bbvatesor.TSI007_PERFIL (cd_idperfil, nb_mon_perfil, fh_fec_inicio, fh_fec_fin, tp_tipperfil, fh_fec_creacion, cd_usu_creacion, fh_fec_modifica, cd_usu_modifica, fh_fec_elimina, cd_usu_elimina, st_estado)
values (3, 'Inversionista EUR', to_date('21-01-2016', 'dd-mm-yyyy'), to_date('19-01-2017', 'dd-mm-yyyy'), 1, to_date('21-01-2016', 'dd-mm-yyyy'), 'P00000', null, null, null, null, '1');
commit;

/*
 *******************************************
 * INSERTS TSI006_USUARIO
 *******************************************
 */
insert into bbvatesor.TSI006_USUARIO (cd_idusuario, nb_nom_usu, nb_ape_pat_usu, nb_ape_mat_usu, cd_login, cd_clave, tp_tipdocumento, nu_documento, fh_fec_creacion, cd_usu_creacion, fh_fec_modifica, cd_usu_modifica, fh_fec_elimina, cd_usu_elimina, st_estado, cd_idperfil)
values (1, null, null, null, 'P004036', null, 1, '1', to_date('21-01-2016', 'dd-mm-yyyy'), 'P004036', null, null, null, null, '1', 1);

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

--OPERACION
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (11, 'OPERACION', 'COMPRA', 'COMPRA', '1', to_date('13-01-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '0');
insert into bbvatesor.tsi005_general (CD_IDGENERAL, NB_DOMINIO, NB_DESC_GENERAL, NB_VALOR_GENERAL, ST_ESTADO, FH_FEC_CREACION, CD_USU_CREACION, FH_FEC_MODIFICA, CD_USU_MODIFICA, FH_FEC_ELIMINA, CD_USU_ELIMINA, fg_editable)
values (12, 'OPERACION', 'VENTA', 'VENTA', '1', to_date('13-01-2016', 'dd-mm-yyyy'), 'Inicial', null, '', null, '', '0');

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

/*
 ******************************************************
 * Agregación de campos en la tabla TSI002_INFOPORT
 ******************************************************
 */
alter table BBVATESOR.TSI002_INFOPORT rename column ST_ESTADO to ST_ESTADO_PORT; 

alter table BBVATESOR.TSI002_INFOPORT add TP_OPERACION CHAR(1);
alter table BBVATESOR.TSI002_INFOPORT add ST_ESTADO CHAR(1);
alter table BBVATESOR.TSI002_INFOPORT add FH_FEC_IMPORTA date;

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


