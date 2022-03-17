-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Mar 17, 2022 at 07:15 PM
-- Server version: 5.7.36
-- PHP Version: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `telecomunicacion_es`
--

-- --------------------------------------------------------

--
-- Table structure for table `asignacionescaso`
--

DROP TABLE IF EXISTS `asignacionescaso`;
CREATE TABLE IF NOT EXISTS `asignacionescaso` (
  `Id_asignacioncaso` int(11) NOT NULL AUTO_INCREMENT,
  `Id_caso` char(14) NOT NULL,
  `Id_usuarioasignado` int(11) NOT NULL,
  `Id_bitacora` int(11) NOT NULL,
  `fecha_limite` date DEFAULT NULL,
  `estado_asig_caso` int(11) NOT NULL,
  PRIMARY KEY (`Id_asignacioncaso`),
  KEY `FK_asigcasos_casos` (`Id_caso`),
  KEY `FK_asigcasos_usuarios` (`Id_usuarioasignado`),
  KEY `FK_asigcaso_estadoasig` (`estado_asig_caso`),
  KEY `FK_asigcaso_bitacora` (`Id_bitacora`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `bitacora_programador`
--

DROP TABLE IF EXISTS `bitacora_programador`;
CREATE TABLE IF NOT EXISTS `bitacora_programador` (
  `Id_bitacora` int(11) NOT NULL AUTO_INCREMENT,
  `Id_usuarioasig` int(11) NOT NULL,
  `porcentaje_trabajo` decimal(3,2) NOT NULL,
  PRIMARY KEY (`Id_bitacora`),
  KEY `FK_bitacora_programador_asignacionescaso` (`Id_usuarioasig`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `casos`
--

DROP TABLE IF EXISTS `casos`;
CREATE TABLE IF NOT EXISTS `casos` (
  `Id_caso` char(14) NOT NULL,
  `Id_solicitudcaso` int(11) NOT NULL,
  `Id_departamentosolicitante` int(11) NOT NULL,
  `estadoCaso` int(11) NOT NULL,
  `asignacioncaso` int(11) NOT NULL,
  PRIMARY KEY (`Id_caso`),
  KEY `FK_solicitudcaso` (`Id_solicitudcaso`),
  KEY `FK_departamentosolicitantecasos` (`Id_departamentosolicitante`),
  KEY `FK_estadocasoAceptado` (`estadoCaso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `departamentos`
--

DROP TABLE IF EXISTS `departamentos`;
CREATE TABLE IF NOT EXISTS `departamentos` (
  `Id_departamento` int(11) NOT NULL AUTO_INCREMENT,
  `nombreDepartamento` varchar(100) NOT NULL,
  `telDepContacto` char(10) NOT NULL,
  `usuarioJefeFunc` int(11) NOT NULL,
  `usuarioJefeDesa` int(11) NOT NULL,
  PRIMARY KEY (`Id_departamento`),
  KEY `FK_usuarioJefeFunc` (`usuarioJefeFunc`),
  KEY `FK_usuarioJefeDesa` (`usuarioJefeDesa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `descripciones_bitacora`
--

DROP TABLE IF EXISTS `descripciones_bitacora`;
CREATE TABLE IF NOT EXISTS `descripciones_bitacora` (
  `Id_descripcion` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` text NOT NULL,
  `Id_bitacora` int(11) NOT NULL,
  PRIMARY KEY (`Id_descripcion`),
  KEY `FK_descripcionesb_bitacoraprogr` (`Id_bitacora`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `descripelements_asigcaso`
--

DROP TABLE IF EXISTS `descripelements_asigcaso`;
CREATE TABLE IF NOT EXISTS `descripelements_asigcaso` (
  `Id_descripcionasig_caso` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion_elemento` text NOT NULL,
  `Id_asigcaso` int(11) NOT NULL,
  PRIMARY KEY (`Id_descripcionasig_caso`),
  KEY `FK_descripelements_asigcaso_asignacionescaso` (`Id_asigcaso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `estadoasignacion`
--

DROP TABLE IF EXISTS `estadoasignacion`;
CREATE TABLE IF NOT EXISTS `estadoasignacion` (
  `Id_estadoasig` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_estado` varchar(50) NOT NULL,
  PRIMARY KEY (`Id_estadoasig`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `estadocasos`
--

DROP TABLE IF EXISTS `estadocasos`;
CREATE TABLE IF NOT EXISTS `estadocasos` (
  `Id_estadocaso` int(11) NOT NULL AUTO_INCREMENT,
  `nombreestado` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Id_estadocaso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `estadosolicitud`
--

DROP TABLE IF EXISTS `estadosolicitud`;
CREATE TABLE IF NOT EXISTS `estadosolicitud` (
  `Id_estadosolicitud` int(11) NOT NULL AUTO_INCREMENT,
  `nombreEstado` varchar(30) NOT NULL,
  PRIMARY KEY (`Id_estadosolicitud`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `observaciones_testings`
--

DROP TABLE IF EXISTS `observaciones_testings`;
CREATE TABLE IF NOT EXISTS `observaciones_testings` (
  `Id_observacion_testing` int(11) NOT NULL,
  `descripcion_observacion` text NOT NULL,
  `Id_testing` int(11) NOT NULL,
  KEY `FK_observaciontesting_testings` (`Id_testing`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `solicitudescaso`
--

DROP TABLE IF EXISTS `solicitudescaso`;
CREATE TABLE IF NOT EXISTS `solicitudescaso` (
  `Id_solicitudcaso` int(11) NOT NULL AUTO_INCREMENT,
  `Id_usuariosolicitante` int(11) NOT NULL,
  `Id_usuarioreceptor` int(11) NOT NULL,
  `Id_departamentosolicitante` int(11) NOT NULL,
  `estado_solicitud` int(11) NOT NULL,
  `titulo_solicitud` varchar(50) NOT NULL,
  `descripcion_solicitud` text NOT NULL,
  PRIMARY KEY (`Id_solicitudcaso`),
  KEY `FK_usuariosolicitante` (`Id_usuariosolicitante`),
  KEY `FK_usuarioreceptor` (`Id_usuarioreceptor`),
  KEY `FK_departamentosolicitante` (`Id_departamentosolicitante`),
  KEY `FK_estadocaso` (`estado_solicitud`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `testers`
--

DROP TABLE IF EXISTS `testers`;
CREATE TABLE IF NOT EXISTS `testers` (
  `Id_asig_tester` int(11) NOT NULL AUTO_INCREMENT,
  `Id_usuariotester` int(11) NOT NULL,
  `Id_asignacioncaso` int(11) NOT NULL,
  PRIMARY KEY (`Id_asig_tester`),
  KEY `FK_testers_usuarios` (`Id_usuariotester`),
  KEY `FK_testers_asignacioncaso` (`Id_asignacioncaso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `testings`
--

DROP TABLE IF EXISTS `testings`;
CREATE TABLE IF NOT EXISTS `testings` (
  `Id_testing` int(11) NOT NULL AUTO_INCREMENT,
  `Id_asigtester` int(11) NOT NULL,
  `Id_usuarioasignado_tester` int(11) NOT NULL,
  PRIMARY KEY (`Id_testing`),
  KEY `FK_testingsasitester_testers` (`Id_asigtester`),
  KEY `FK_usuarioasignado_testers` (`Id_usuarioasignado_tester`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tiposusuarios`
--

DROP TABLE IF EXISTS `tiposusuarios`;
CREATE TABLE IF NOT EXISTS `tiposusuarios` (
  `Id_tipousuario` int(11) NOT NULL AUTO_INCREMENT,
  `tipoUsuario` varchar(100) NOT NULL,
  PRIMARY KEY (`Id_tipousuario`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tiposusuarios`
--

INSERT INTO `tiposusuarios` (`Id_tipousuario`, `tipoUsuario`) VALUES
(1, 'Jefatura'),
(2, 'Jefe Desarrollo'),
(3, 'Programador'),
(4, 'Probador');

-- --------------------------------------------------------

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `Id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `Id_departamento` int(11) NOT NULL,
  `tipoUsuario` int(11) NOT NULL,
  `Tel` int(11) NOT NULL,
  `nombresUsuario` varchar(50) NOT NULL,
  `apellidosUsuario` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `passwordUsuario` varchar(100) NOT NULL,
  `fechaNacimiento` date DEFAULT NULL,
  PRIMARY KEY (`Id_usuario`),
  KEY `FK_idDepartamento` (`Id_departamento`),
  KEY `FK_tipoUsuario` (`tipoUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `usuarios`
--

INSERT INTO `usuarios` (`Id_usuario`, `Id_departamento`, `tipoUsuario`, `Tel`, `nombresUsuario`, `apellidosUsuario`, `username`, `passwordUsuario`, `fechaNacimiento`) VALUES
(1, 1, 1, 77775555, 'Xochilt Azucena', 'Rivera Gómez', 'XochiltRivera', 'contraseña', '2003-03-04');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `asignacionescaso`
--
ALTER TABLE `asignacionescaso`
  ADD CONSTRAINT `FK_asigcaso_bitacora` FOREIGN KEY (`Id_bitacora`) REFERENCES `bitacora_programador` (`Id_bitacora`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_asigcaso_estadoasig` FOREIGN KEY (`estado_asig_caso`) REFERENCES `estadoasignacion` (`Id_estadoasig`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_asigcasos_casos` FOREIGN KEY (`Id_caso`) REFERENCES `casos` (`Id_caso`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_asigcasos_usuarios` FOREIGN KEY (`Id_usuarioasignado`) REFERENCES `usuarios` (`Id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `bitacora_programador`
--
ALTER TABLE `bitacora_programador`
  ADD CONSTRAINT `FK_bitacora_programador_asignacionescaso` FOREIGN KEY (`Id_usuarioasig`) REFERENCES `asignacionescaso` (`Id_usuarioasignado`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `casos`
--
ALTER TABLE `casos`
  ADD CONSTRAINT `FK_departamentosolicitantecasos` FOREIGN KEY (`Id_departamentosolicitante`) REFERENCES `solicitudescaso` (`Id_departamentosolicitante`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_estadocasoAceptado` FOREIGN KEY (`estadoCaso`) REFERENCES `estadocasos` (`Id_estadocaso`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_solicitudcaso` FOREIGN KEY (`Id_solicitudcaso`) REFERENCES `solicitudescaso` (`Id_solicitudcaso`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `departamentos`
--
ALTER TABLE `departamentos`
  ADD CONSTRAINT `FK_jefeFuncDep` FOREIGN KEY (`usuarioJefeFunc`) REFERENCES `usuarios` (`Id_usuario`),
  ADD CONSTRAINT `FK_usuarioJefeDesa` FOREIGN KEY (`usuarioJefeDesa`) REFERENCES `usuarios` (`Id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_usuarioJefeFunc` FOREIGN KEY (`usuarioJefeFunc`) REFERENCES `usuarios` (`Id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `descripciones_bitacora`
--
ALTER TABLE `descripciones_bitacora`
  ADD CONSTRAINT `FK_descripcionesb_bitacoraprogr` FOREIGN KEY (`Id_bitacora`) REFERENCES `bitacora_programador` (`Id_bitacora`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `descripelements_asigcaso`
--
ALTER TABLE `descripelements_asigcaso`
  ADD CONSTRAINT `FK_descripelements_asigcaso_asignacionescaso` FOREIGN KEY (`Id_asigcaso`) REFERENCES `asignacionescaso` (`Id_asignacioncaso`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `observaciones_testings`
--
ALTER TABLE `observaciones_testings`
  ADD CONSTRAINT `FK_observaciontesting_testings` FOREIGN KEY (`Id_testing`) REFERENCES `testings` (`Id_testing`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
