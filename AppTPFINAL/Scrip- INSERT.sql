/* Carga de datos de localidad*/
INSERT INTO localidad (ID_Localidad,Localidad)
VALUES (1,"San Fernando");
INSERT INTO localidad (ID_Localidad,Localidad)
VALUES (2,"Tigre");
INSERT INTO localidad (ID_Localidad,Localidad)
VALUES (3,"Pacheco");
/* Carga de datos de provincia*/
INSERT INTO privincia (ID_provincia,provincia)
VALUES (1,"Buenos Aires");
/* Carga de datos de Cliente*/
INSERT INTO cliente(`DNI`,`CUIL`,`Nombre`,`Apellido`,`Sexo`,`Nacimiento`,`Direccion`,`ID_Localodad`,`ID_Provincia`,`Email`,`Telefono`,`Estado`)
VALUES(11111111,"201111113","Cristian","Graus","M","1998-10-17","Cristian_Graus 1966","1","1","Cristian_Graus@hotmail.com","987654321",true);
INSERT INTO cliente(`DNI`,`CUIL`,`Nombre`,`Apellido`,`Sexo`,`Nacimiento`,`Direccion`,`ID_Localodad`,`ID_Provincia`,`Email`,`Telefono`,`Estado`)
VALUES(22222222,"202222223","Dalila","Baena","F","2001-10-16","Dalila_Baena 1966","2","1","Dalila_Baena@hotmail.com","987654321",true);
INSERT INTO cliente(`DNI`,`CUIL`,`Nombre`,`Apellido`,`Sexo`,`Nacimiento`,`Direccion`,`ID_Localodad`,`ID_Provincia`,`Email`,`Telefono`,`Estado`)
VALUES(33333333,"203333333","Wanda","Scarpatto","F","1999-02-18","Wanda_Scarpatto 1966","3","1","Wanda_Scarpatto@hotmail.com","987654321",true);
/* Carga de datos de Cuentas */
INSERT INTO cuenta (Fecha_cracion,Tipo,CBU, Saldo, DNI) 
VALUES ("2021-06-28","1","111111","1000",11111111);
INSERT INTO cuenta (Fecha_cracion,Tipo, CBU, Saldo, DNI) 
VALUES ("2021-06-28","2","111112","2000",11111111);
INSERT INTO cuenta (Fecha_cracion,Tipo,CBU, Saldo, DNI) 
VALUES ("2021-06-28","2","111113","3000",11111111);
INSERT INTO cuenta (Fecha_cracion,Tipo,CBU, Saldo, DNI) 
VALUES ("2021-06-20","1","111114","1000",22222222);
INSERT INTO cuenta (Fecha_cracion,Tipo,CBU, Saldo, DNI) 
VALUES ("2021-06-27","1","111115","2000",22222222);