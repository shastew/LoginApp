CREATE TABLE `user_accounts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `loginapp`.`user_accounts` 
ADD COLUMN `first_name` VARCHAR(50) NULL AFTER `password`,
ADD COLUMN `last_name` VARCHAR(50) NULL AFTER `first_name`;


