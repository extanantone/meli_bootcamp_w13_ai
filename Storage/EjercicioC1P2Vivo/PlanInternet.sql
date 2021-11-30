-- MySQL Workbench Synchronization
-- Generated: 2021-11-29 17:35
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: Vanesa Belen Garro

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `empresa_internet` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE IF NOT EXISTS `empresa_internet`.`cliente` (
  `id_cliente` INT(11) NOT NULL AUTO_INCREMENT,
  `nro_ident_cliente` VARCHAR(10) NOT NULL,
  `nombre_cliente` VARCHAR(45) NOT NULL,
  `apellido_cliente` VARCHAR(45) NOT NULL,
  `fecha_nacimiento_cliente` DATE NULL DEFAULT NULL,
  `tipo_identificacion_id_tipo_identificacion` INT(11) NOT NULL,
  `ciudad_id_ciudad1` INT(11) NOT NULL,
  PRIMARY KEY (`id_cliente`, `tipo_identificacion_id_tipo_identificacion`, `ciudad_id_ciudad1`),
  INDEX `fk_cliente_tipo_identificacion1_idx` (`tipo_identificacion_id_tipo_identificacion` ASC) VISIBLE,
  INDEX `fk_cliente_ciudad2_idx` (`ciudad_id_ciudad1` ASC) VISIBLE,
  CONSTRAINT `fk_cliente_tipo_identificacion1`
    FOREIGN KEY (`tipo_identificacion_id_tipo_identificacion`)
    REFERENCES `empresa_internet`.`tipo_identificacion` (`id_tipo_identificacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cliente_ciudad2`
    FOREIGN KEY (`ciudad_id_ciudad1`)
    REFERENCES `empresa_internet`.`ciudad` (`id_ciudad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `empresa_internet`.`pais` (
  `id_pais` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre_pais` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id_pais`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `empresa_internet`.`provincia` (
  `id_provincia` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre_provincia` VARCHAR(45) NULL DEFAULT NULL,
  `pais_id_pais1` INT(11) NOT NULL,
  PRIMARY KEY (`id_provincia`, `pais_id_pais1`),
  INDEX `fk_provincia_pais1_idx` (`pais_id_pais1` ASC) VISIBLE,
  CONSTRAINT `fk_provincia_pais1`
    FOREIGN KEY (`pais_id_pais1`)
    REFERENCES `empresa_internet`.`pais` (`id_pais`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `empresa_internet`.`ciudad` (
  `id_ciudad` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre_ciudad` VARCHAR(100) NOT NULL,
  `cp_ciudad` VARCHAR(45) NULL DEFAULT NULL,
  `provincia_id_provincia1` INT(11) NOT NULL,
  PRIMARY KEY (`id_ciudad`, `provincia_id_provincia1`),
  INDEX `fk_ciudad_provincia2_idx` (`provincia_id_provincia1` ASC) VISIBLE,
  CONSTRAINT `fk_ciudad_provincia2`
    FOREIGN KEY (`provincia_id_provincia1`)
    REFERENCES `empresa_internet`.`provincia` (`id_provincia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `empresa_internet`.`plan` (
  `id_plan` INT(11) NOT NULL AUTO_INCREMENT,
  `velocidad_plan` INT(11) NOT NULL,
  `precio_plan` DECIMAL(10,2) NULL DEFAULT NULL,
  PRIMARY KEY (`id_plan`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `empresa_internet`.`contrata_plan` (
  `precio_contrata_plan` VARCHAR(45) NULL DEFAULT NULL,
  `descuento_contrata_plan` VARCHAR(45) NULL DEFAULT NULL,
  `id_contrata_plan` INT(11) NOT NULL AUTO_INCREMENT,
  `plan_id_plan` INT(11) NOT NULL,
  `cliente_id_cliente` INT(11) NOT NULL,
  `cliente_tipo_identificacion_id_tipo_identificacion` INT(11) NOT NULL,
  `cliente_ciudad_id_ciudad1` INT(11) NOT NULL,
  PRIMARY KEY (`id_contrata_plan`, `plan_id_plan`, `cliente_id_cliente`, `cliente_tipo_identificacion_id_tipo_identificacion`, `cliente_ciudad_id_ciudad1`),
  INDEX `fk_contrata_plan_plan1_idx` (`plan_id_plan` ASC) VISIBLE,
  INDEX `fk_contrata_plan_cliente1_idx` (`cliente_id_cliente` ASC, `cliente_tipo_identificacion_id_tipo_identificacion` ASC, `cliente_ciudad_id_ciudad1` ASC) VISIBLE,
  CONSTRAINT `fk_contrata_plan_plan1`
    FOREIGN KEY (`plan_id_plan`)
    REFERENCES `empresa_internet`.`plan` (`id_plan`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_contrata_plan_cliente1`
    FOREIGN KEY (`cliente_id_cliente` , `cliente_tipo_identificacion_id_tipo_identificacion` , `cliente_ciudad_id_ciudad1`)
    REFERENCES `empresa_internet`.`cliente` (`id_cliente` , `tipo_identificacion_id_tipo_identificacion` , `ciudad_id_ciudad1`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `empresa_internet`.`historial_precio` (
  `id_historial_precio` INT(11) NOT NULL AUTO_INCREMENT,
  `fecha_historial_precio` VARCHAR(45) NOT NULL,
  `precio_historial_precio` DECIMAL(10,2) NOT NULL,
  `plan_id_plan` INT(11) NOT NULL,
  INDEX `fk_historial_precio_plan1_idx` (`plan_id_plan` ASC) VISIBLE,
  PRIMARY KEY (`id_historial_precio`),
  CONSTRAINT `fk_historial_precio_plan1`
    FOREIGN KEY (`plan_id_plan`)
    REFERENCES `empresa_internet`.`plan` (`id_plan`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `empresa_internet`.`tipo_identificacion` (
  `id_tipo_identificacion` INT(11) NOT NULL AUTO_INCREMENT,
  `descripcion_tipo_identificacion` VARCHAR(45) NOT NULL,
  `codigo_tipo_identificacion` VARCHAR(4) NOT NULL,
  PRIMARY KEY (`id_tipo_identificacion`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
