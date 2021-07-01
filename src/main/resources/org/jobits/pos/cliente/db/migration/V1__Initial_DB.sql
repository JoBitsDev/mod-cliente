CREATE TABLE cliente.cliente (
  id        SERIAL NOT NULL, 
  nombre    varchar(255) NOT NULL, 
  apellidos varchar(50), 
  correo    varchar(50), 
  foto_url  varchar(255), 
  telefono  varchar(20) NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE cliente.cliente_meta (
  clienteid int4 NOT NULL, 
  id        SERIAL NOT NULL, 
  name      text NOT NULL, 
  value     text NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE cliente.direccion_envio (
  id                  SERIAL NOT NULL, 
  clienteid           int4 NOT NULL, 
  alias               varchar(50) NOT NULL, 
  nombre              varchar(255) NOT NULL, 
  apellidos           varchar(255), 
  telefono            varchar(255) NOT NULL, 
  empresa             varchar(255), 
  direccion           varchar(255) NOT NULL, 
  direccion_adicional varchar(255), 
  ciudad              varchar(255) NOT NULL, 
  provincia           varchar(255) NOT NULL, 
  PRIMARY KEY (id));
CREATE INDEX cliente_meta_clienteid 
  ON cliente.cliente_meta (clienteid);
ALTER TABLE cliente.cliente_meta ADD CONSTRAINT FKcliente_me334824 FOREIGN KEY (clienteid) REFERENCES cliente.cliente (id);
ALTER TABLE cliente.direccion_envio ADD CONSTRAINT FKdireccion_364169 FOREIGN KEY (clienteid) REFERENCES cliente.cliente (id);
