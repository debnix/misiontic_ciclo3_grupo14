-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema grupo_14
-- -----------------------------------------------------
-- Esto es un ejemplo de creación de base de datos con MRD
DROP SCHEMA IF EXISTS `grupo_14` ;

-- -----------------------------------------------------
-- Schema grupo_14
--
-- Esto es un ejemplo de creación de base de datos con MRD
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `grupo_14` DEFAULT CHARACTER SET utf8 ;
USE `grupo_14` ;

-- -----------------------------------------------------
-- Table `grupo_14`.`facultad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo_14`.`facultad` (
  `numero` VARCHAR(15) NOT NULL,
  `nombre` VARCHAR(80) NOT NULL,
  `ubicacion` VARCHAR(45) NULL,
  PRIMARY KEY (`numero`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `grupo_14`.`decano`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo_14`.`decano` (
  `cedula` VARCHAR(15) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(80) NOT NULL COMMENT 'Esta tabla representa a un Decano',
  `facultad_numero` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`cedula`),
  INDEX `fk_decano_facultad1_idx` (`facultad_numero` ASC) VISIBLE,
  CONSTRAINT `fk_decano_facultad1`
    FOREIGN KEY (`facultad_numero`)
    REFERENCES `grupo_14`.`facultad` (`numero`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `grupo_14`.`telefono`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo_14`.`telefono` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `codigo_pais` VARCHAR(3) NOT NULL,
  `numero` VARCHAR(10) NOT NULL,
  `decano_cedula` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_telefono_decano_idx` (`decano_cedula` ASC) VISIBLE,
  CONSTRAINT `fk_telefono_decano`
    FOREIGN KEY (`decano_cedula`)
    REFERENCES `grupo_14`.`decano` (`cedula`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `grupo_14`.`docente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo_14`.`docente` (
  `cedula` VARCHAR(15) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `facultad_numero` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`cedula`),
  INDEX `fk_docente_facultad1_idx` (`facultad_numero` ASC) VISIBLE,
  CONSTRAINT `fk_docente_facultad1`
    FOREIGN KEY (`facultad_numero`)
    REFERENCES `grupo_14`.`facultad` (`numero`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `grupo_14`.`titulos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo_14`.`titulos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `grupo_14`.`docente_titulos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo_14`.`docente_titulos` (
  `docente_cedula` VARCHAR(15) NOT NULL,
  `titulos_id` INT NOT NULL,
  INDEX `fk_table1_docente1_idx` (`docente_cedula` ASC) VISIBLE,
  INDEX `fk_table1_titulos1_idx` (`titulos_id` ASC) VISIBLE,
  PRIMARY KEY (`docente_cedula`, `titulos_id`),
  CONSTRAINT `fk_table1_docente1`
    FOREIGN KEY (`docente_cedula`)
    REFERENCES `grupo_14`.`docente` (`cedula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_table1_titulos1`
    FOREIGN KEY (`titulos_id`)
    REFERENCES `grupo_14`.`titulos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `grupo_14`.`agisnatura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo_14`.`agisnatura` (
  `codigo` VARCHAR(10) NOT NULL,
  `creditos` INT NOT NULL,
  `nombre` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `grupo_14`.`docente_asignaturas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo_14`.`docente_asignaturas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `agisnatura_codigo` VARCHAR(10) NOT NULL,
  `docente_cedula` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_docente_asignaturas_agisnatura1_idx` (`agisnatura_codigo` ASC) VISIBLE,
  INDEX `fk_docente_asignaturas_docente1_idx` (`docente_cedula` ASC) VISIBLE,
  CONSTRAINT `fk_docente_asignaturas_agisnatura1`
    FOREIGN KEY (`agisnatura_codigo`)
    REFERENCES `grupo_14`.`agisnatura` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_docente_asignaturas_docente1`
    FOREIGN KEY (`docente_cedula`)
    REFERENCES `grupo_14`.`docente` (`cedula`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `grupo_14`.`estudiante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo_14`.`estudiante` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(60) NOT NULL,
  `direccion` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `grupo_14`.`estudiante_asignaturas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo_14`.`estudiante_asignaturas` (
  `estudiante_id` INT NOT NULL,
  `agisnatura_codigo` VARCHAR(10) NOT NULL,
  INDEX `fk_table1_estudiante1_idx` (`estudiante_id` ASC) VISIBLE,
  INDEX `fk_table1_agisnatura1_idx` (`agisnatura_codigo` ASC) VISIBLE,
  PRIMARY KEY (`estudiante_id`, `agisnatura_codigo`),
  CONSTRAINT `fk_table1_estudiante1`
    FOREIGN KEY (`estudiante_id`)
    REFERENCES `grupo_14`.`estudiante` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_table1_agisnatura1`
    FOREIGN KEY (`agisnatura_codigo`)
    REFERENCES `grupo_14`.`agisnatura` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
