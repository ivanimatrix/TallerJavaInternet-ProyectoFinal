-- MySQL dump 10.16  Distrib 10.1.26-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: taller_java
-- ------------------------------------------------------
-- Server version	10.1.26-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `id_cliente` bigint(20) unsigned NOT NULL,
  `email_cliente` varchar(50) DEFAULT NULL,
  `fono_cliente` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_cliente`),
  UNIQUE KEY `email_cliente` (`email_cliente`),
  CONSTRAINT `fk_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (3,'lalal@lala.cl','123'),(4,'vale@mail.cl','123'),(5,'melania@mail.cl','123'),(6,'konichiwa@mail.com','123');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estados_revision`
--

DROP TABLE IF EXISTS `estados_revision`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estados_revision` (
  `codigo_estrev` tinyint(4) NOT NULL,
  `nombre_estrev` varchar(20) NOT NULL,
  PRIMARY KEY (`codigo_estrev`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estados_revision`
--

LOCK TABLES `estados_revision` WRITE;
/*!40000 ALTER TABLE `estados_revision` DISABLE KEYS */;
INSERT INTO `estados_revision` VALUES (1,'EN REVISION'),(2,'FINALIZADO');
/*!40000 ALTER TABLE `estados_revision` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `formulario_contacto`
--

DROP TABLE IF EXISTS `formulario_contacto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `formulario_contacto` (
  `id_contacto` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `nombres_contacto` varchar(100) NOT NULL,
  `apellidos_contacto` varchar(100) NOT NULL,
  `email_contacto` varchar(100) DEFAULT NULL,
  `telefono_contacto` varchar(100) DEFAULT NULL,
  `mensaje_contacto` text NOT NULL,
  PRIMARY KEY (`id_contacto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `formulario_contacto`
--

LOCK TABLES `formulario_contacto` WRITE;
/*!40000 ALTER TABLE `formulario_contacto` DISABLE KEYS */;
/*!40000 ALTER TABLE `formulario_contacto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mecanico`
--

DROP TABLE IF EXISTS `mecanico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mecanico` (
  `id_mecanico` bigint(20) unsigned NOT NULL,
  `especialidad_mecanico` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id_mecanico`),
  CONSTRAINT `fk_mecanico` FOREIGN KEY (`id_mecanico`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mecanico`
--

LOCK TABLES `mecanico` WRITE;
/*!40000 ALTER TABLE `mecanico` DISABLE KEYS */;
/*!40000 ALTER TABLE `mecanico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfil`
--

DROP TABLE IF EXISTS `perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `perfil` (
  `codigo_perfil` tinyint(4) NOT NULL,
  `nombre_perfil` varchar(15) NOT NULL,
  PRIMARY KEY (`codigo_perfil`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfil`
--

LOCK TABLES `perfil` WRITE;
/*!40000 ALTER TABLE `perfil` DISABLE KEYS */;
INSERT INTO `perfil` VALUES (1,'ADMINISTRADOR'),(2,'MECANICO'),(3,'CLIENTE');
/*!40000 ALTER TABLE `perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `revision`
--

DROP TABLE IF EXISTS `revision`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `revision` (
  `id_revision` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `fk_vehiculo_revision` bigint(20) unsigned NOT NULL,
  `estado_revision` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_revision`),
  KEY `fk_estado_revision` (`estado_revision`),
  CONSTRAINT `fk_estado_revision` FOREIGN KEY (`estado_revision`) REFERENCES `estados_revision` (`codigo_estrev`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `revision`
--

LOCK TABLES `revision` WRITE;
/*!40000 ALTER TABLE `revision` DISABLE KEYS */;
/*!40000 ALTER TABLE `revision` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trabajo`
--

DROP TABLE IF EXISTS `trabajo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trabajo` (
  `id_trabajo` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `fk_revision_trabajo` bigint(20) unsigned NOT NULL,
  `fk_mecanico_trabajo` bigint(20) unsigned NOT NULL,
  `fecha_trabajo` date NOT NULL,
  `descripcion_trabajo` text NOT NULL,
  `valor_trabajo` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_trabajo`),
  KEY `fk_revision` (`fk_revision_trabajo`),
  KEY `fk_mecanico_trabajo` (`fk_mecanico_trabajo`),
  CONSTRAINT `fk_mecanico_trabajo` FOREIGN KEY (`fk_mecanico_trabajo`) REFERENCES `mecanico` (`id_mecanico`),
  CONSTRAINT `fk_revision` FOREIGN KEY (`fk_revision_trabajo`) REFERENCES `revision` (`id_revision`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trabajo`
--

LOCK TABLES `trabajo` WRITE;
/*!40000 ALTER TABLE `trabajo` DISABLE KEYS */;
/*!40000 ALTER TABLE `trabajo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id_usuario` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `rut_usuario` varchar(10) NOT NULL,
  `nombres_usuario` varchar(40) NOT NULL,
  `apellidos_usuario` varchar(40) NOT NULL,
  `pass_usuario` varchar(250) NOT NULL,
  `perfil_usuario` tinyint(4) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `rut_usuario` (`rut_usuario`),
  KEY `fk_perfil` (`perfil_usuario`),
  CONSTRAINT `fk_perfil` FOREIGN KEY (`perfil_usuario`) REFERENCES `perfil` (`codigo_perfil`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'15489151-k','Iván','Almonacid','demo',1),(3,'15175863-0','Carolina','Valenzuela','123',3),(4,'19613351-8','Valentina','Ornella','123',3),(5,'19012770-2','Melania','Nuñez','123',3),(6,'17090046-4','Konichan','Elso','123',3);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehiculo`
--

DROP TABLE IF EXISTS `vehiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vehiculo` (
  `id_vehiculo` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `patente_vehiculo` varchar(6) NOT NULL,
  `marca_vehiculo` varchar(30) NOT NULL,
  `modelo_vehiculo` varchar(30) NOT NULL,
  `anyo_vehiculo` int(11) NOT NULL,
  `fk_cliente_vehiculo` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id_vehiculo`),
  UNIQUE KEY `patente_vehiculo` (`patente_vehiculo`),
  KEY `fk_vehiculo` (`fk_cliente_vehiculo`),
  CONSTRAINT `fk_vehiculo` FOREIGN KEY (`fk_cliente_vehiculo`) REFERENCES `cliente` (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehiculo`
--

LOCK TABLES `vehiculo` WRITE;
/*!40000 ALTER TABLE `vehiculo` DISABLE KEYS */;
INSERT INTO `vehiculo` VALUES (3,'DDSA45','Audi','X1',2002,5),(4,'RE4354','safsfa','fsasfa',2000,3);
/*!40000 ALTER TABLE `vehiculo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'taller_java'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-26 10:27:48
