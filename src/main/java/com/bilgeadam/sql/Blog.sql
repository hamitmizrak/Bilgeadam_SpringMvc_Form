-- CREATE DATABASE
CREATE SCHEMA `bilgeadam_blog` DEFAULT CHARACTER SET utf8 COLLATE utf8_turkish_ci ;
use bilgeadam_blog;

-- ##### TABLE CREATE
-- SubScriber
CREATE TABLE `bilgeadam_blog`.`subscriber` (
   `subscriber_id` INT NOT NULL AUTO_INCREMENT,
   `subscriber_name` VARCHAR(150) NULL,
   `subscriber_surname` VARCHAR(150) NULL,
   `subscriber_address` VARCHAR(350) NULL,
   `subscriber_email_addres` VARCHAR(150) NULL,
   `created_date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
   PRIMARY KEY (`subscriber_id`)
   );
