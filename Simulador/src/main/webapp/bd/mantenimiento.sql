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
DROP TABLE bbvatesor.TSI019_Sede CASCADE CONSTRAINTS PURGE;


CREATE TABLE bbvatesor.TSI019_Sede (
  cd_idsede  INTEGER  NOT NULL ,
  nb_descsede  VARCHAR(200)  NULL ,
  cd_codDir INTEGER  NOT NULL ,
  st_estado  CHAR(1)  NULL 
);

CREATE  UNIQUE INDEX ISI019P1_Sede ON bbvatesor.TSI019_Sede (cd_idsede);


/*
 *******************************************
 *FOREIGN KEY
 *******************************************
 */


 *******************************************
 *PERMISOS APP
 *******************************************
 */
grant create session to simultes;
grant create SYNONYM to simultes;

GRANT SELECT, INSERT, UPDATE ON bbvatesor.TSI019_Sede TO simultes;


--GRANT USAGE ON SEQUENCE sequenceName TO grantees  

/*
 *******************************************
 *SINONIMOS
 *******************************************
 */
CREATE or replace SYNONYM TSI019_Sede  FOR bbvatesor.TSI019_Sede;


/*
 *******************************************
 * SEQUENCES
 *******************************************
 */
CREATE SEQUENCE bbvatesor.SEQ_SEDE;


 *******************************************
 * INSERTS TSI005_GENERAL
 *******************************************
 */
--MONEDA
insert into bbvatesor.TSI019_Sede (CD_IDSEDE, NB_DESCSEDE, CD_CODDIR, ST_ESTADO )
values (1, 'SAN JUAN DE MIRAFLORES', 666, '1');
