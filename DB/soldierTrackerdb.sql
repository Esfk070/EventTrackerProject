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
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NULL,
  `create_date` DATETIME NULL,
  `last_udate` DATETIME NULL,
  `image_url` VARCHAR(2000) NULL,
  `enabled` TINYINT NULL,
  PRIMARY KEY (`id`))
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
INSERT INTO `soldier` (`id`, `first_name`, `last_name`, `create_date`, `last_udate`, `image_url`, `enabled`) VALUES (1, 'Frank', 'Castle', '2024-09-06', '2024-09-06', NULL, 1);

COMMIT;

