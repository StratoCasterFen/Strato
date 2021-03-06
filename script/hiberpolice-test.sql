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

-- Дамп структуры базы данных hiberpolice
CREATE DATABASE IF NOT EXISTS `hiberpolice_test` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `hiberpolice_test`;


-- Дамп структуры для таблица hiberpolice.criminalevents
CREATE TABLE IF NOT EXISTS `criminalevents` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) DEFAULT '0',
  `Description` varchar(250) DEFAULT '0',
  `EventDate` varchar(250) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица hiberpolice.criminals
CREATE TABLE IF NOT EXISTS `criminals` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) DEFAULT '0',
  `SurName` varchar(50) DEFAULT '0',
  `Birthday` date DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица hiberpolice.eventlinks
CREATE TABLE IF NOT EXISTS `eventlinks` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `EventTypeId` int(11) DEFAULT NULL,
  `EventId` int(11) DEFAULT NULL,
  `CriminalId` int(11) DEFAULT NULL,
  `UserId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `CriminalIdKey` (`CriminalId`),
  KEY `EventTypeIdKey` (`EventTypeId`),
  KEY `UserIdKey` (`UserId`),
  KEY `EventId` (`EventId`),
  CONSTRAINT `FK_eventlinks_criminalevents` FOREIGN KEY (`EventId`) REFERENCES `criminalevents` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_eventlinks_criminals` FOREIGN KEY (`CriminalId`) REFERENCES `criminals` (`Id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_eventlinks_eventtype` FOREIGN KEY (`EventTypeId`) REFERENCES `eventtype` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `FK_eventlinks_users` FOREIGN KEY (`UserId`) REFERENCES `users` (`Id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица hiberpolice.eventtype
CREATE TABLE IF NOT EXISTS `eventtype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `TypeName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица hiberpolice.roles
CREATE TABLE IF NOT EXISTS `roles` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `RoleName` varchar(30) DEFAULT '0',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица hiberpolice.users
CREATE TABLE IF NOT EXISTS `users` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `UserName` varchar(50) DEFAULT '0',
  `Password` varchar(50) DEFAULT '0',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица hiberpolice.user_role
CREATE TABLE IF NOT EXISTS `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `UserId` int(11) DEFAULT '0',
  `RoleId` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `User_key` (`UserId`),
  KEY `Role_key` (`RoleId`),
  CONSTRAINT `FK_user_role_roles` FOREIGN KEY (`RoleId`) REFERENCES `roles` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_user_role_users` FOREIGN KEY (`UserId`) REFERENCES `users` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
