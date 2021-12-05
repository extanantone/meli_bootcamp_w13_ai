-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema empresa_internet
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema empresa_internet
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `empresa_internet` DEFAULT CHARACTER SET utf8 ;
USE `empresa_internet` ;

-- -----------------------------------------------------
-- Table `empresa_internet`.`Provincias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresa_internet`.`Provincias` (
  `id_provincia` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`id_provincia`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `empresa_internet`.`Ciudades`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresa_internet`.`Ciudades` (
  `id_ciudad` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `id_provincia` INT NULL,
  PRIMARY KEY (`id_ciudad`),
  CONSTRAINT `id_provincia`
    FOREIGN KEY (`id_provincia`)
    REFERENCES `empresa_internet`.`Provincias` (`id_provincia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `id_provincia_idx` ON `empresa_internet`.`Ciudades` (`id_provincia` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `empresa_internet`.`Planes_Internet`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresa_internet`.`Planes_Internet` (
  `id_plan_internet` INT NOT NULL,
  `velocidad` DECIMAL(10,2) NULL,
  `precio` DECIMAL(10,2) NULL,
  `descuento` DECIMAL(10,2) NULL,
  PRIMARY KEY (`id_plan_internet`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `empresa_internet`.`Clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresa_internet`.`Clientes` (
  `id_clientes` INT NOT NULL,
  `dni` INT NULL,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  `fecha_nacimiento` DATETIME NULL,
  `id_ciudad` INT NULL,
  `id_plan_internet` INT NULL,
  PRIMARY KEY (`id_clientes`),
  CONSTRAINT `id_ciudad`
    FOREIGN KEY (`id_ciudad`)
    REFERENCES `empresa_internet`.`Ciudades` (`id_ciudad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_plan_internet`
    FOREIGN KEY (`id_plan_internet`)
    REFERENCES `empresa_internet`.`Planes_Internet` (`id_plan_internet`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `id_ciudad_idx` ON `empresa_internet`.`Clientes` (`id_ciudad` ASC, `id_plan_internet` ASC) VISIBLE;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `empresa_internet`.`Provincias`
-- -----------------------------------------------------
START TRANSACTION;
USE `empresa_internet`;
INSERT INTO `empresa_internet`.`Provincias` (`id_provincia`, `nombre`) VALUES (1, 'Córdoba');
INSERT INTO `empresa_internet`.`Provincias` (`id_provincia`, `nombre`) VALUES (2, 'Buenos Aires');

COMMIT;


-- -----------------------------------------------------
-- Data for table `empresa_internet`.`Ciudades`
-- -----------------------------------------------------
START TRANSACTION;
USE `empresa_internet`;
INSERT INTO `empresa_internet`.`Ciudades` (`id_ciudad`, `nombre`, `id_provincia`) VALUES (1, 'Córdoba Capital', 1);
INSERT INTO `empresa_internet`.`Ciudades` (`id_ciudad`, `nombre`, `id_provincia`) VALUES (2, 'Río Ceballos', 1);
INSERT INTO `empresa_internet`.`Ciudades` (`id_ciudad`, `nombre`, `id_provincia`) VALUES (3, 'La Boca', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `empresa_internet`.`Planes_Internet`
-- -----------------------------------------------------
START TRANSACTION;
USE `empresa_internet`;
INSERT INTO `empresa_internet`.`Planes_Internet` (`id_plan_internet`, `velocidad`, `precio`, `descuento`) VALUES (1, 500, 3000, 0.1);
INSERT INTO `empresa_internet`.`Planes_Internet` (`id_plan_internet`, `velocidad`, `precio`, `descuento`) VALUES (2, 300, 1500, 0.3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `empresa_internet`.`Clientes`
-- -----------------------------------------------------
START TRANSACTION;
USE `empresa_internet`;
INSERT INTO `empresa_internet`.`Clientes` (`id_clientes`, `dni`, `nombre`, `apellido`, `fecha_nacimiento`, `id_ciudad`, `id_plan_internet`) VALUES (1, 39620502, 'Marina', 'Santiso', '1996-01-16', 1, 1);
INSERT INTO `empresa_internet`.`Clientes` (`id_clientes`, `dni`, `nombre`, `apellido`, `fecha_nacimiento`, `id_ciudad`, `id_plan_internet`) VALUES (2, 39937696, 'Fabrizio', 'Nuñez', '1996-11-29', 3, 1);

COMMIT;

-- SELECTS EJERCICIO 04
-- 01
select dni, CONCAT(apellido, " ", nombre) AS 'Nombre Completo' from clientes LIMIT 100;
-- 02
select dni, CONCAT(apellido, " ", nombre) AS 'Nombre Completo' from clientes where id_ciudad = 1 LIMIT 100;
-- 03 
select dni, CONCAT(apellido, " ", nombre) AS 'Nombre Completo' from clientes where id_plan_internet = 1 LIMIT 100;
-- 04
select id_plan_internet, velocidad from Planes_Internet where precio > 2000;
-- 05
select id_plan_internet, velocidad from Planes_Internet where precio BETWEEN 1000 AND 6000;
-- 06
select id_plan_internet, precio, velocidad from Planes_Internet where velocidad between 100 and 500;
-- 07
select dni, CONCAT(apellido, " ", nombre) AS 'Nombre Completo', fecha_nacimiento AS 'Nombre Completo' from clientes where id_plan_internet = 1 and year(fecha_nacimiento) between 1996 and 2006 LIMIT 100;
-- 08
select dni, CONCAT(apellido, " ", nombre) AS 'Nombre Completo', fecha_nacimiento AS 'Nombre Completo' from clientes where id_plan_internet = 1 OR id_plan_internet = 2 LIMIT 100;
-- 09
select id_plan_internet, precio, velocidad from Planes_Internet where velocidad between 100 and 500 OR velocidad between 10 and 80;
-- 10
select id_plan_internet, velocidad from Planes_Internet where precio > 5000;