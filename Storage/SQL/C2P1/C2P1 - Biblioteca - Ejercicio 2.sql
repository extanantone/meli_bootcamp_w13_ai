-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema biblioteca
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema biblioteca
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `biblioteca` DEFAULT CHARACTER SET utf8 ;
USE `biblioteca` ;

-- -----------------------------------------------------
-- Table `biblioteca`.`Libro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`Libro` (
  `idLibro` INT NOT NULL,
  `titulo` VARCHAR(45) NULL,
  `editorial` VARCHAR(45) NULL,
  `area` VARCHAR(45) NULL,
  PRIMARY KEY (`idLibro`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `biblioteca`.`Autor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`Autor` (
  `idAutor` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `nacionalidad` VARCHAR(45) NULL,
  PRIMARY KEY (`idAutor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `biblioteca`.`LibroAutor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`LibroAutor` (
  `idAutor` INT NOT NULL,
  `idLibro` INT NOT NULL,
  PRIMARY KEY (`idAutor`, `idLibro`),
  INDEX `idLibro_idx` (`idLibro` ASC) VISIBLE,
  CONSTRAINT `idLibro`
    FOREIGN KEY (`idLibro`)
    REFERENCES `biblioteca`.`Libro` (`idLibro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idAutor`
    FOREIGN KEY (`idAutor`)
    REFERENCES `biblioteca`.`Autor` (`idAutor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `biblioteca`.`Estudiante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`Estudiante` (
  `idLector` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  `direccion` VARCHAR(45) NULL,
  `carrera` VARCHAR(45) NULL,
  `edad` INT NULL,
  PRIMARY KEY (`idLector`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `biblioteca`.`Prestamo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `biblioteca`.`Prestamo` (
  `idLector` INT NOT NULL,
  `IdLibro` INT NOT NULL,
  `fechaPrestamo` DATETIME NULL,
  `fechaDevolucion` DATETIME NULL,
  `devuelto` BIT(1) NULL,
  PRIMARY KEY (`idLector`, `IdLibro`),
  INDEX `idLibro_idx` (`IdLibro` ASC) VISIBLE,
  CONSTRAINT `idLibroPrestamo`
    FOREIGN KEY (`idLibro`)
    REFERENCES `biblioteca`.`Libro` (`idLibro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idLector`
    FOREIGN KEY (`idLector`)
    REFERENCES `biblioteca`.`Estudiante` (`idLector`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `biblioteca`.`Libro`
-- -----------------------------------------------------
START TRANSACTION;
USE `biblioteca`;
INSERT INTO `biblioteca`.`Libro` (`idLibro`, `titulo`, `editorial`, `area`) VALUES (1, 'Dracula', 'Aquilina', 'Terror');
INSERT INTO `biblioteca`.`Libro` (`idLibro`, `titulo`, `editorial`, `area`) VALUES (2, 'La llamada del Chthulhu', 'Aquilina', 'Misterio');
INSERT INTO `biblioteca`.`Libro` (`idLibro`, `titulo`, `editorial`, `area`) VALUES (3, 'Frankestein', 'Planeta', 'Ciencia Ficción');

COMMIT;


-- -----------------------------------------------------
-- Data for table `biblioteca`.`Autor`
-- -----------------------------------------------------
START TRANSACTION;
USE `biblioteca`;
INSERT INTO `biblioteca`.`Autor` (`idAutor`, `nombre`, `nacionalidad`) VALUES (1, 'H.P. Lovecraft', 'Estados Unidos');
INSERT INTO `biblioteca`.`Autor` (`idAutor`, `nombre`, `nacionalidad`) VALUES (2, 'Bram Stoker\nBram Stoker\nBram Stocker', 'Irlanda');
INSERT INTO `biblioteca`.`Autor` (`idAutor`, `nombre`, `nacionalidad`) VALUES (3, 'Mary Shelley', 'Inglaterra');

COMMIT;


-- -----------------------------------------------------
-- Data for table `biblioteca`.`LibroAutor`
-- -----------------------------------------------------
START TRANSACTION;
USE `biblioteca`;
INSERT INTO `biblioteca`.`LibroAutor` (`idAutor`, `idLibro`) VALUES (2, 1);
INSERT INTO `biblioteca`.`LibroAutor` (`idAutor`, `idLibro`) VALUES (1, 2);
INSERT INTO `biblioteca`.`LibroAutor` (`idAutor`, `idLibro`) VALUES (3, 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `biblioteca`.`Estudiante`
-- -----------------------------------------------------
START TRANSACTION;
USE `biblioteca`;
INSERT INTO `biblioteca`.`Estudiante` (`idLector`, `nombre`, `apellido`, `direccion`, `carrera`, `edad`) VALUES (1, 'Ana', 'Sanchez', 'Calle Falsa 123', 'Medicina', 18);
INSERT INTO `biblioteca`.`Estudiante` (`idLector`, `nombre`, `apellido`, `direccion`, `carrera`, `edad`) VALUES (2, 'Paula', 'Ramirez', 'Calle No Falsa 456', 'Ingeniería en Computación', 24);

COMMIT;


-- -----------------------------------------------------
-- Data for table `biblioteca`.`Prestamo`
-- -----------------------------------------------------
START TRANSACTION;
USE `biblioteca`;
INSERT INTO `biblioteca`.`Prestamo` (`idLector`, `IdLibro`, `fechaPrestamo`, `fechaDevolucion`, `devuelto`) VALUES (1, 3, '2021-01-03', '2021-01-20', 1);
INSERT INTO `biblioteca`.`Prestamo` (`idLector`, `IdLibro`, `fechaPrestamo`, `fechaDevolucion`, `devuelto`) VALUES (1, 2, '2021-02-06', '2021-03-19', 1);
INSERT INTO `biblioteca`.`Prestamo` (`idLector`, `IdLibro`, `fechaPrestamo`, `fechaDevolucion`, `devuelto`) VALUES (2, 3, '2021-01-05', '2021-01-22', 1);
INSERT INTO `biblioteca`.`Prestamo` (`idLector`, `IdLibro`, `fechaPrestamo`, `fechaDevolucion`, `devuelto`) VALUES (1, 1, '2021-01-03', NULL, 0);

COMMIT;

