-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: taskify_db
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `flyway_schema_history`
--

DROP TABLE IF EXISTS `flyway_schema_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flyway_schema_history` (
  `installed_rank` int NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` int NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  KEY `flyway_schema_history_s_idx` (`success`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flyway_schema_history`
--

LOCK TABLES `flyway_schema_history` WRITE;
/*!40000 ALTER TABLE `flyway_schema_history` DISABLE KEYS */;
INSERT INTO `flyway_schema_history` VALUES (1,'1','CREATE-TABLE-USUARIOS','SQL','V1__CREATE-TABLE-USUARIOS.sql',1294844962,'root','2023-08-15 23:07:43',84,1),(2,'2','CREATE-TABLE-PROJETOS','SQL','V2__CREATE-TABLE-PROJETOS.sql',1536659264,'root','2023-08-16 00:16:45',59,1),(3,'3','CREATE-TABLE-TAREFAS','SQL','V3__CREATE-TABLE-TAREFAS.sql',-521519964,'root','2023-08-16 00:16:45',39,1),(4,'4','ALTER-TABLE-USUARIOS-ADD-GENERO','SQL','V4__ALTER-TABLE-USUARIOS-ADD-GENERO.sql',921409569,'root','2023-08-16 00:37:35',66,1),(5,'5','ALTER-TABLE-USUARIOS-ADD-ENDERECO','SQL','V5__ALTER-TABLE-USUARIOS-ADD-ENDERECO.sql',1620241425,'root','2023-09-01 00:36:23',122,1);
/*!40000 ALTER TABLE `flyway_schema_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_projetos`
--

DROP TABLE IF EXISTS `tb_projetos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_projetos` (
  `idProjeto` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `descricao` text,
  `idUsuario` bigint NOT NULL,
  PRIMARY KEY (`idProjeto`),
  KEY `idUsuario` (`idUsuario`),
  CONSTRAINT `tb_projetos_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `tb_usuarios` (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_projetos`
--

LOCK TABLES `tb_projetos` WRITE;
/*!40000 ALTER TABLE `tb_projetos` DISABLE KEYS */;
INSERT INTO `tb_projetos` VALUES (1,'Projeto Java com Spring Boot','',1),(2,'Projeto React JS','',4),(4,'Projeto React Native','',5);
/*!40000 ALTER TABLE `tb_projetos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tarefas`
--

DROP TABLE IF EXISTS `tb_tarefas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_tarefas` (
  `idTarefa` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `descricao` text,
  `dataDeCriacao` date NOT NULL,
  `dataDeConclusao` date DEFAULT NULL,
  `prioridade` varchar(20) NOT NULL,
  `status` varchar(20) NOT NULL,
  `idUsuario` bigint DEFAULT NULL,
  `idProjeto` bigint NOT NULL,
  PRIMARY KEY (`idTarefa`),
  KEY `idUsuario` (`idUsuario`),
  KEY `idProjeto` (`idProjeto`),
  CONSTRAINT `tb_tarefas_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `tb_usuarios` (`idUsuario`),
  CONSTRAINT `tb_tarefas_ibfk_2` FOREIGN KEY (`idProjeto`) REFERENCES `tb_projetos` (`idProjeto`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tarefas`
--

LOCK TABLES `tb_tarefas` WRITE;
/*!40000 ALTER TABLE `tb_tarefas` DISABLE KEYS */;
INSERT INTO `tb_tarefas` VALUES (1,'CRUD de Usuários','','2023-08-24',NULL,'MEDIA','PENDENTE',1,1),(2,'CRUD de Projetos','','2023-08-24',NULL,'ALTA','PENDENTE',4,1),(3,'CRUD de Tarefas','','2023-08-24',NULL,'BAIXA','PENDENTE',1,1),(4,'Tela de Usuários','','2023-08-24',NULL,'ALTA','PENDENTE',5,2);
/*!40000 ALTER TABLE `tb_tarefas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_usuarios`
--

DROP TABLE IF EXISTS `tb_usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_usuarios` (
  `idUsuario` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `sobrenome` varchar(150) NOT NULL,
  `email` varchar(255) NOT NULL,
  `senha` varchar(10) NOT NULL,
  `genero` varchar(20) DEFAULT NULL,
  `cep` varchar(255) DEFAULT NULL,
  `logradouro` varchar(255) DEFAULT NULL,
  `complemento` varchar(255) DEFAULT NULL,
  `bairro` varchar(255) DEFAULT NULL,
  `localidade` varchar(255) DEFAULT NULL,
  `uf` varchar(255) DEFAULT NULL,
  `ddd` bigint DEFAULT NULL,
  `numero` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_usuarios`
--

LOCK TABLES `tb_usuarios` WRITE;
/*!40000 ALTER TABLE `tb_usuarios` DISABLE KEYS */;
INSERT INTO `tb_usuarios` VALUES (1,'Alexandre','de Souza Jr.','alex@dev.com','abc123','MASCULINO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(4,'Jaime','Ximenes','ximenes@dev.com','abc123','MASCULINO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(5,'Daniel','Valença','daniel@dev.com','abc123','MASCULINO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(6,'Gabi','Souza','gabi@dev.com','abc123','FEMININO',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,'Marcelo','Rodolfo','Marcelo@gmail.com','123',NULL,'123450-280','Rua Frei Cassimirdo',NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `tb_usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-31 21:46:16
