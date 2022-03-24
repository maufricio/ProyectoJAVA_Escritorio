-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 25, 2022 at 12:23 AM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 7.4.13

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

CREATE TABLE `asignacionescaso` (
  `Id_asignacioncaso` int(11) NOT NULL,
  `Id_caso` char(14) NOT NULL,
  `Id_usuarioasignado` int(11) NOT NULL,
  `Id_bitacora` int(11) NOT NULL,
  `fecha_limite` date DEFAULT NULL,
  `estado_asig_caso` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `bitacora_programador`
--

CREATE TABLE `bitacora_programador` (
  `Id_bitacora` int(11) NOT NULL,
  `Id_usuarioasig` int(11) NOT NULL,
  `porcentaje_trabajo` decimal(3,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `casos`
--

CREATE TABLE `casos` (
  `Id_caso` char(14) NOT NULL,
  `Id_solicitudcaso` int(11) NOT NULL,
  `Id_departamentosolicitante` int(11) NOT NULL,
  `estadoCaso` int(11) NOT NULL,
  `asignacioncaso` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `departamentos`
--

CREATE TABLE `departamentos` (
  `Id_departamento` int(11) NOT NULL,
  `nombreDepartamento` varchar(100) NOT NULL,
  `telDepContacto` char(10) NOT NULL,
  `usuarioJefeFunc` int(11) NOT NULL,
  `usuarioJefeDesa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `departamentos`
--

INSERT INTO `departamentos` (`Id_departamento`, `nombreDepartamento`, `telDepContacto`, `usuarioJefeFunc`, `usuarioJefeDesa`) VALUES
(1, 'Departamento de Desarrollo de Software', '11223344', 1, 2),
(2, 'Departamento de Finanzas', '11223344', 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `descripciones_bitacora`
--

CREATE TABLE `descripciones_bitacora` (
  `Id_descripcion` int(11) NOT NULL,
  `descripcion` text NOT NULL,
  `Id_bitacora` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `descripelements_asigcaso`
--

CREATE TABLE `descripelements_asigcaso` (
  `Id_descripcionasig_caso` int(11) NOT NULL,
  `descripcion_elemento` text NOT NULL,
  `Id_asigcaso` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `estadoasignacion`
--

CREATE TABLE `estadoasignacion` (
  `Id_estadoasig` int(11) NOT NULL,
  `nombre_estado` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `estadocasos`
--

CREATE TABLE `estadocasos` (
  `Id_estadocaso` int(11) NOT NULL,
  `nombreestado` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `estadosolicitud`
--

CREATE TABLE `estadosolicitud` (
  `Id_estadosolicitud` int(11) NOT NULL,
  `nombreEstado` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `observaciones_testings`
--

CREATE TABLE `observaciones_testings` (
  `Id_observacion_testing` int(11) NOT NULL,
  `descripcion_observacion` text NOT NULL,
  `Id_testing` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `solicitudescaso`
--

CREATE TABLE `solicitudescaso` (
  `Id_solicitudcaso` int(11) NOT NULL,
  `Id_usuariosolicitante` int(11) NOT NULL,
  `Id_usuarioreceptor` int(11) NOT NULL,
  `Id_departamentosolicitante` int(11) NOT NULL,
  `estado_solicitud` int(11) NOT NULL,
  `titulo_solicitud` varchar(50) NOT NULL,
  `descripcion_solicitud` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `testers`
--

CREATE TABLE `testers` (
  `Id_asig_tester` int(11) NOT NULL,
  `Id_usuariotester` int(11) NOT NULL,
  `Id_asignacioncaso` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `testings`
--

CREATE TABLE `testings` (
  `Id_testing` int(11) NOT NULL,
  `Id_asigtester` int(11) NOT NULL,
  `Id_usuarioasignado_tester` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tiposusuarios`
--

CREATE TABLE `tiposusuarios` (
  `Id_tipousuario` int(11) NOT NULL,
  `tipoUsuario` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tiposusuarios`
--

INSERT INTO `tiposusuarios` (`Id_tipousuario`, `tipoUsuario`) VALUES
(1, 'Jefe Funcional'),
(2, 'Jefe Desarrollo'),
(3, 'Programador'),
(4, 'Probador'),
(5, 'Administrador');

-- --------------------------------------------------------

--
-- Table structure for table `usuarios`
--

CREATE TABLE `usuarios` (
  `Id_usuario` int(11) NOT NULL,
  `Id_departamento` int(11) NOT NULL,
  `tipoUsuario` int(11) NOT NULL,
  `Tel` int(11) NOT NULL,
  `nombresUsuario` varchar(50) NOT NULL,
  `apellidosUsuario` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `passwordUsuario` varchar(100) NOT NULL,
  `fechaNacimiento` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `usuarios`
--

INSERT INTO `usuarios` (`Id_usuario`, `Id_departamento`, `tipoUsuario`, `Tel`, `nombresUsuario`, `apellidosUsuario`, `username`, `passwordUsuario`, `fechaNacimiento`) VALUES
(1, 1, 1, 77775555, 'Xochilt Azucena', 'Rivera Gómez', 'XochiltRivera', 'contraseña', '2003-03-04'),
(2, 2, 2, 88885555, 'José Samuel', 'Lara Alberto', 'Albert', 'Albert', '2002-05-06'),
(3, 2, 3, 44445555, 'Kathy', 'Maravilla', 'Kathy', '[C@c123897', '2003-03-04'),
(4, 2, 4, 85555222, 'Mauricio', 'Mauricio', 'Mauricio', '1234567', '2022-03-04');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `asignacionescaso`
--
ALTER TABLE `asignacionescaso`
  ADD PRIMARY KEY (`Id_asignacioncaso`),
  ADD KEY `FK_asigcasos_casos` (`Id_caso`),
  ADD KEY `FK_asigcasos_usuarios` (`Id_usuarioasignado`),
  ADD KEY `FK_asigcaso_estadoasig` (`estado_asig_caso`),
  ADD KEY `FK_asigcaso_bitacora` (`Id_bitacora`);

--
-- Indexes for table `bitacora_programador`
--
ALTER TABLE `bitacora_programador`
  ADD PRIMARY KEY (`Id_bitacora`),
  ADD KEY `FK_bitacora_programador_asignacionescaso` (`Id_usuarioasig`);

--
-- Indexes for table `casos`
--
ALTER TABLE `casos`
  ADD PRIMARY KEY (`Id_caso`),
  ADD KEY `FK_solicitudcaso` (`Id_solicitudcaso`),
  ADD KEY `FK_departamentosolicitantecasos` (`Id_departamentosolicitante`),
  ADD KEY `FK_estadocasoAceptado` (`estadoCaso`);

--
-- Indexes for table `departamentos`
--
ALTER TABLE `departamentos`
  ADD PRIMARY KEY (`Id_departamento`),
  ADD KEY `FK_usuarioJefeFunc` (`usuarioJefeFunc`),
  ADD KEY `FK_usuarioJefeDesa` (`usuarioJefeDesa`);

--
-- Indexes for table `descripciones_bitacora`
--
ALTER TABLE `descripciones_bitacora`
  ADD PRIMARY KEY (`Id_descripcion`),
  ADD KEY `FK_descripcionesb_bitacoraprogr` (`Id_bitacora`);

--
-- Indexes for table `descripelements_asigcaso`
--
ALTER TABLE `descripelements_asigcaso`
  ADD PRIMARY KEY (`Id_descripcionasig_caso`),
  ADD KEY `FK_descripelements_asigcaso_asignacionescaso` (`Id_asigcaso`);

--
-- Indexes for table `estadoasignacion`
--
ALTER TABLE `estadoasignacion`
  ADD PRIMARY KEY (`Id_estadoasig`);

--
-- Indexes for table `estadocasos`
--
ALTER TABLE `estadocasos`
  ADD PRIMARY KEY (`Id_estadocaso`);

--
-- Indexes for table `estadosolicitud`
--
ALTER TABLE `estadosolicitud`
  ADD PRIMARY KEY (`Id_estadosolicitud`);

--
-- Indexes for table `observaciones_testings`
--
ALTER TABLE `observaciones_testings`
  ADD KEY `FK_observaciontesting_testings` (`Id_testing`);

--
-- Indexes for table `solicitudescaso`
--
ALTER TABLE `solicitudescaso`
  ADD PRIMARY KEY (`Id_solicitudcaso`),
  ADD KEY `FK_usuariosolicitante` (`Id_usuariosolicitante`),
  ADD KEY `FK_usuarioreceptor` (`Id_usuarioreceptor`),
  ADD KEY `FK_departamentosolicitante` (`Id_departamentosolicitante`),
  ADD KEY `FK_estadocaso` (`estado_solicitud`);

--
-- Indexes for table `testers`
--
ALTER TABLE `testers`
  ADD PRIMARY KEY (`Id_asig_tester`),
  ADD KEY `FK_testers_usuarios` (`Id_usuariotester`),
  ADD KEY `FK_testers_asignacioncaso` (`Id_asignacioncaso`);

--
-- Indexes for table `testings`
--
ALTER TABLE `testings`
  ADD PRIMARY KEY (`Id_testing`),
  ADD KEY `FK_testingsasitester_testers` (`Id_asigtester`),
  ADD KEY `FK_usuarioasignado_testers` (`Id_usuarioasignado_tester`);

--
-- Indexes for table `tiposusuarios`
--
ALTER TABLE `tiposusuarios`
  ADD PRIMARY KEY (`Id_tipousuario`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`Id_usuario`),
  ADD KEY `FK_idDepartamento` (`Id_departamento`),
  ADD KEY `FK_tipoUsuario` (`tipoUsuario`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `asignacionescaso`
--
ALTER TABLE `asignacionescaso`
  MODIFY `Id_asignacioncaso` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `bitacora_programador`
--
ALTER TABLE `bitacora_programador`
  MODIFY `Id_bitacora` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `departamentos`
--
ALTER TABLE `departamentos`
  MODIFY `Id_departamento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `descripciones_bitacora`
--
ALTER TABLE `descripciones_bitacora`
  MODIFY `Id_descripcion` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `descripelements_asigcaso`
--
ALTER TABLE `descripelements_asigcaso`
  MODIFY `Id_descripcionasig_caso` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `estadoasignacion`
--
ALTER TABLE `estadoasignacion`
  MODIFY `Id_estadoasig` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `estadocasos`
--
ALTER TABLE `estadocasos`
  MODIFY `Id_estadocaso` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `estadosolicitud`
--
ALTER TABLE `estadosolicitud`
  MODIFY `Id_estadosolicitud` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `solicitudescaso`
--
ALTER TABLE `solicitudescaso`
  MODIFY `Id_solicitudcaso` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `testers`
--
ALTER TABLE `testers`
  MODIFY `Id_asig_tester` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `testings`
--
ALTER TABLE `testings`
  MODIFY `Id_testing` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tiposusuarios`
--
ALTER TABLE `tiposusuarios`
  MODIFY `Id_tipousuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `Id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

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

--
-- Constraints for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `FK_departamentodeusuario` FOREIGN KEY (`Id_departamento`) REFERENCES `departamentos` (`Id_departamento`),
  ADD CONSTRAINT `FK_tipoUsuario_usuarios` FOREIGN KEY (`tipoUsuario`) REFERENCES `tiposusuarios` (`Id_tipousuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
