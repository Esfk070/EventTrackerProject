-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema soldierTrackerdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `soldierTrackerdb` ;

-- -----------------------------------------------------
-- Schema soldierTrackerdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `soldierTrackerdb` DEFAULT CHARACTER SET utf8 ;
USE `soldierTrackerdb` ;

-- -----------------------------------------------------
-- Table `soldier`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `soldier` ;

CREATE TABLE IF NOT EXISTS `soldier` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `rank` VARCHAR(45) NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `create_date` DATETIME NULL,
  `last_update` DATETIME NULL,
  `image_url` VARCHAR(2000) NULL,
  `enabled` TINYINT NULL,
  `profile` TINYINT NULL,
  `description` VARCHAR(2000) NULL,
  `dod` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `acft`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `acft` ;

CREATE TABLE IF NOT EXISTS `acft` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `score` INT NULL,
  `enabled` TINYINT NULL,
  `date_taken` DATETIME NULL,
  `soldier_id` INT NOT NULL,
  `passed` TINYINT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_acft_soldier_idx` (`soldier_id` ASC) VISIBLE,
  CONSTRAINT `fk_acft_soldier`
    FOREIGN KEY (`soldier_id`)
    REFERENCES `soldier` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `qualificationscore_weapon`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `qualificationscore_weapon` ;

CREATE TABLE IF NOT EXISTS `qualificationscore_weapon` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `enabled` TINYINT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `weapon`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `weapon` ;

CREATE TABLE IF NOT EXISTS `weapon` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `serial_number` VARCHAR(45) NULL,
  `soldier_id` INT NOT NULL,
  `nomenclature_id` INT NOT NULL,
  `fmc` TINYINT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_weapon_soldier1_idx` (`soldier_id` ASC) VISIBLE,
  INDEX `fk_weapon_nomenclature1_idx` (`nomenclature_id` ASC) VISIBLE,
  CONSTRAINT `fk_weapon_soldier1`
    FOREIGN KEY (`soldier_id`)
    REFERENCES `soldier` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_weapon_nomenclature1`
    FOREIGN KEY (`nomenclature_id`)
    REFERENCES `qualificationscore_weapon` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `qualification_score`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `qualification_score` ;

CREATE TABLE IF NOT EXISTS `qualification_score` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `score` INT NULL,
  `enabled` TINYINT NULL,
  `soldier_id` INT NOT NULL,
  `nomenclature_id` INT NOT NULL,
  `date_taken` DATETIME NULL,
  `passed` TINYINT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_qualification_score_soldier1_idx` (`soldier_id` ASC) VISIBLE,
  INDEX `fk_qualification_score_nomenclature1_idx` (`nomenclature_id` ASC) VISIBLE,
  CONSTRAINT `fk_qualification_score_soldier1`
    FOREIGN KEY (`soldier_id`)
    REFERENCES `soldier` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_qualification_score_nomenclature1`
    FOREIGN KEY (`nomenclature_id`)
    REFERENCES `qualificationscore_weapon` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS soldierTracker@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'soldierTracker'@'localhost' IDENTIFIED BY 'soldierTracker';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'soldierTracker'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `soldier`
-- -----------------------------------------------------
START TRANSACTION;
USE `soldierTrackerdb`;
INSERT INTO `soldier` (`id`, `rank`, `first_name`, `last_name`, `create_date`, `last_update`, `image_url`, `enabled`, `profile`, `description`, `dod`) VALUES (1, 'Major', 'Alan', 'Schaefer', '2024-09-06', '2024-09-06', NULL, 1, 0, NULL, 123);
INSERT INTO `soldier` (`id`, `rank`, `first_name`, `last_name`, `create_date`, `last_update`, `image_url`, `enabled`, `profile`, `description`, `dod`) VALUES (2, 'CIA', 'Al', 'Dillon', '2024-09-06', '2024-09-06', NULL, 1, 0, NULL, 456);
INSERT INTO `soldier` (`id`, `rank`, `first_name`, `last_name`, `create_date`, `last_update`, `image_url`, `enabled`, `profile`, `description`, `dod`) VALUES (3, 'SFC', 'Blain', 'Cooper', '2024-09-06', '2024-09-06', NULL, 1, 0, NULL, 789);
INSERT INTO `soldier` (`id`, `rank`, `first_name`, `last_name`, `create_date`, `last_update`, `image_url`, `enabled`, `profile`, `description`, `dod`) VALUES (4, 'MSG', 'Mac', 'Elliot', '2024-09-06', '2024-09-06', NULL, 1, 1, NULL, 234);
INSERT INTO `soldier` (`id`, `rank`, `first_name`, `last_name`, `create_date`, `last_update`, `image_url`, `enabled`, `profile`, `description`, `dod`) VALUES (5, 'SSG', 'Richard ', 'Chaves', '2024-09-06', '2024-09-06', NULL, 0, 0, NULL, 567);
INSERT INTO `soldier` (`id`, `rank`, `first_name`, `last_name`, `create_date`, `last_update`, `image_url`, `enabled`, `profile`, `description`, `dod`) VALUES (6, 'SFC', 'Billy', 'Sole', '2024-09-06', '2024-09-06', NULL, 1, 1, NULL, 763);

COMMIT;


-- -----------------------------------------------------
-- Data for table `acft`
-- -----------------------------------------------------
START TRANSACTION;
USE `soldierTrackerdb`;
INSERT INTO `acft` (`id`, `score`, `enabled`, `date_taken`, `soldier_id`, `passed`) VALUES (1, 600, 1, '2024-09-06', 1, 1);
INSERT INTO `acft` (`id`, `score`, `enabled`, `date_taken`, `soldier_id`, `passed`) VALUES (2, 595, 1, '2024-03-02', 2, 1);
INSERT INTO `acft` (`id`, `score`, `enabled`, `date_taken`, `soldier_id`, `passed`) VALUES (3, 590, 1, '2024-11-13', 3, 1);
INSERT INTO `acft` (`id`, `score`, `enabled`, `date_taken`, `soldier_id`, `passed`) VALUES (4, 600, 1, '2024-09-06', 4, 1);
INSERT INTO `acft` (`id`, `score`, `enabled`, `date_taken`, `soldier_id`, `passed`) VALUES (5, 580, 1, '2024-08-06', 5, 1);
INSERT INTO `acft` (`id`, `score`, `enabled`, `date_taken`, `soldier_id`, `passed`) VALUES (6, 600, 1, '2024-07-06', 6, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `qualificationscore_weapon`
-- -----------------------------------------------------
START TRANSACTION;
USE `soldierTrackerdb`;
INSERT INTO `qualificationscore_weapon` (`id`, `name`, `enabled`) VALUES (1, 'M4', 1);
INSERT INTO `qualificationscore_weapon` (`id`, `name`, `enabled`) VALUES (2, 'M17', 1);
INSERT INTO `qualificationscore_weapon` (`id`, `name`, `enabled`) VALUES (3, 'M240', 1);
INSERT INTO `qualificationscore_weapon` (`id`, `name`, `enabled`) VALUES (4, 'M249', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `weapon`
-- -----------------------------------------------------
START TRANSACTION;
USE `soldierTrackerdb`;
INSERT INTO `weapon` (`id`, `serial_number`, `soldier_id`, `nomenclature_id`, `fmc`) VALUES (1, '1234', 1, 1, 1);
INSERT INTO `weapon` (`id`, `serial_number`, `soldier_id`, `nomenclature_id`, `fmc`) VALUES (2, '124134', 2, 1, 1);
INSERT INTO `weapon` (`id`, `serial_number`, `soldier_id`, `nomenclature_id`, `fmc`) VALUES (3, '234135', 3, 1, 1);
INSERT INTO `weapon` (`id`, `serial_number`, `soldier_id`, `nomenclature_id`, `fmc`) VALUES (4, '1234124', 4, 2, 1);
INSERT INTO `weapon` (`id`, `serial_number`, `soldier_id`, `nomenclature_id`, `fmc`) VALUES (5, '1421412', 5, 3, 0);
INSERT INTO `weapon` (`id`, `serial_number`, `soldier_id`, `nomenclature_id`, `fmc`) VALUES (6, '142512', 6, 4, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `qualification_score`
-- -----------------------------------------------------
START TRANSACTION;
USE `soldierTrackerdb`;
INSERT INTO `qualification_score` (`id`, `score`, `enabled`, `soldier_id`, `nomenclature_id`, `date_taken`, `passed`) VALUES (1, 40, 1, 5, 1, '2024-09-06', 1);
INSERT INTO `qualification_score` (`id`, `score`, `enabled`, `soldier_id`, `nomenclature_id`, `date_taken`, `passed`) VALUES (2, 37, 1, 3, 1, '2024-09-06', 1);
INSERT INTO `qualification_score` (`id`, `score`, `enabled`, `soldier_id`, `nomenclature_id`, `date_taken`, `passed`) VALUES (3, 36, 1, 6, 3, '2024-09-06', 1);
INSERT INTO `qualification_score` (`id`, `score`, `enabled`, `soldier_id`, `nomenclature_id`, `date_taken`, `passed`) VALUES (4, 40, 1, 2, 1, '2024-09-06', 1);
INSERT INTO `qualification_score` (`id`, `score`, `enabled`, `soldier_id`, `nomenclature_id`, `date_taken`, `passed`) VALUES (5, 37, 1, 4, 2, '2024-09-06', 1);
INSERT INTO `qualification_score` (`id`, `score`, `enabled`, `soldier_id`, `nomenclature_id`, `date_taken`, `passed`) VALUES (6, 40, 1, 1, 4, '2024-05-03', 1);
INSERT INTO `qualification_score` (`id`, `score`, `enabled`, `soldier_id`, `nomenclature_id`, `date_taken`, `passed`) VALUES (7, 40, 1, 1, 1, '2024-09-06', 1);

COMMIT;

