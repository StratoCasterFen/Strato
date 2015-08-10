-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.6.23-log - MySQL Community Server (GPL)
-- ОС Сервера:                   Win64
-- HeidiSQL Версия:              9.1.0.4867
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Дамп структуры базы данных policestation
CREATE DATABASE IF NOT EXISTS `policestation` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `policestation`;


-- Дамп структуры для таблица policestation.criminalevents
CREATE TABLE IF NOT EXISTS `criminalevents` (
  `EventId` int(11) NOT NULL AUTO_INCREMENT,
  `EventName` varchar(70) DEFAULT '0',
  `EventDescription` varchar(700) DEFAULT NULL,
  `EventDate` date DEFAULT NULL,
  `CriminalId` int(11) NOT NULL,
  `UserId` int(11) DEFAULT NULL,
  PRIMARY KEY (`EventId`),
  KEY `CriminalIdKey` (`CriminalId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы policestation.criminalevents: ~2 rows (приблизительно)
DELETE FROM `criminalevents`;
/*!40000 ALTER TABLE `criminalevents` DISABLE KEYS */;
INSERT INTO `criminalevents` (`EventId`, `EventName`, `EventDescription`, `EventDate`, `CriminalId`, `UserId`) VALUES
	(1, 'Взлом', 'Сломал Телефонную будку', '2015-08-03', 1, NULL),
	(2, 'Ограбление', 'Ограбление банка JP Morgan', '2014-02-07', 2, NULL);
/*!40000 ALTER TABLE `criminalevents` ENABLE KEYS */;


-- Дамп структуры для таблица policestation.criminals
CREATE TABLE IF NOT EXISTS `criminals` (
  `CriminalId` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) DEFAULT '0',
  `SurName` varchar(50) DEFAULT '0',
  `Birthday` date DEFAULT NULL,
  PRIMARY KEY (`CriminalId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы policestation.criminals: ~2 rows (приблизительно)
DELETE FROM `criminals`;
/*!40000 ALTER TABLE `criminals` DISABLE KEYS */;
INSERT INTO `criminals` (`CriminalId`, `Name`, `SurName`, `Birthday`) VALUES
	(1, 'Kevin', 'Mitnik', '1970-01-04'),
	(2, 'Dguliko', 'Banditto', '1972-05-06');
/*!40000 ALTER TABLE `criminals` ENABLE KEYS */;


-- Дамп структуры для таблица policestation.roles
CREATE TABLE IF NOT EXISTS `roles` (
  `RoleId` int(11) NOT NULL AUTO_INCREMENT,
  `RoleName` varchar(30) DEFAULT '0',
  PRIMARY KEY (`RoleId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы policestation.roles: ~1 rows (приблизительно)
DELETE FROM `roles`;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` (`RoleId`, `RoleName`) VALUES
	(1, 'administrator');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;


-- Дамп структуры для таблица policestation.users
CREATE TABLE IF NOT EXISTS `users` (
  `UserId` int(11) NOT NULL AUTO_INCREMENT,
  `UserName` varchar(50) DEFAULT '0',
  `Password` varchar(50) DEFAULT '0',
  PRIMARY KEY (`UserId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы policestation.users: ~5 rows (приблизительно)
DELETE FROM `users`;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`UserId`, `UserName`, `Password`) VALUES
	(3, 'admin', 'b1374a31148f365f61e1b30e655f1d6');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;


-- Дамп структуры для таблица policestation.user_role
CREATE TABLE IF NOT EXISTS `user_role` (
  `idUR` int(11) NOT NULL AUTO_INCREMENT,
  `UserId` int(11) DEFAULT '0',
  `RoleId` int(11) DEFAULT '0',
  PRIMARY KEY (`idUR`),
  KEY `User_key` (`UserId`),
  KEY `Role_key` (`RoleId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы policestation.user_role: ~1 rows (приблизительно)
DELETE FROM `user_role`;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` (`idUR`, `UserId`, `RoleId`) VALUES
	(1, 3, 1);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
