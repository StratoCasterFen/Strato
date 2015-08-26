-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.6.23-log - MySQL Community Server (GPL)
-- ОС Сервера:                   Win32
-- HeidiSQL Версия:              9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Дамп структуры базы данных policestation
CREATE DATABASE IF NOT EXISTS `hiberpolice` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `hiberpolice`;


-- Дамп структуры для таблица policestation.criminalevents
CREATE TABLE IF NOT EXISTS `criminalevents` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `EventName` varchar(70) DEFAULT '0',
  `EventDescription` varchar(700) DEFAULT NULL,
  `EventDate` date DEFAULT NULL,
  `CriminalId` int(11) DEFAULT NULL,
  `UserId` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `CriminalIdKey` (`CriminalId`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы policestation.criminalevents: ~3 rows (приблизительно)
/*!40000 ALTER TABLE `criminalevents` DISABLE KEYS */;
INSERT INTO `criminalevents` (`Id`, `EventName`, `EventDescription`, `EventDate`, `CriminalId`, `UserId`) VALUES
	(1, 'Взлом', 'Сломал Телефонную будку', '2015-08-03', 1, 3),
	(2, 'Ограбление', 'Ограбление банка JP Morgan', '2014-02-17', 2, 3),
	(3, 'test', 'test * * -cvd-b- -d', NULL, 2, 1);
/*!40000 ALTER TABLE `criminalevents` ENABLE KEYS */;


-- Дамп структуры для таблица policestation.criminals
CREATE TABLE IF NOT EXISTS `criminals` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) DEFAULT '0',
  `SurName` varchar(50) DEFAULT '0',
  `Birthday` date DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы policestation.criminals: ~2 rows (приблизительно)
/*!40000 ALTER TABLE `criminals` DISABLE KEYS */;
INSERT INTO `criminals` (`Id`, `Name`, `SurName`, `Birthday`) VALUES
	(1, 'Kevin', 'Mitnik', '1970-01-04'),
	(2, 'Djulicko', 'Banditto', '2068-08-25');
/*!40000 ALTER TABLE `criminals` ENABLE KEYS */;


-- Дамп структуры для таблица policestation.roles
CREATE TABLE IF NOT EXISTS `roles` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `RoleName` varchar(30) DEFAULT '0',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы policestation.roles: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` (`Id`, `RoleName`) VALUES
	(1, 'administrator');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;


-- Дамп структуры для таблица policestation.users
CREATE TABLE IF NOT EXISTS `users` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `UserName` varchar(50) DEFAULT '0',
  `Password` varchar(50) DEFAULT '0',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы policestation.users: ~3 rows (приблизительно)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`Id`, `UserName`, `Password`) VALUES
	(3, 'admin', 'b1374a31148f365f61e1b30e655f1d6'),
	(66, 'Pervanuk', '415133'),
	(79, 'Ivanko', '133');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;


-- Дамп структуры для таблица policestation.user_role
CREATE TABLE IF NOT EXISTS `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `UserId` int(11) DEFAULT '0',
  `RoleId` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `User_key` (`UserId`),
  KEY `Role_key` (`RoleId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы policestation.user_role: ~0 rows (приблизительно)
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` (`id`, `UserId`, `RoleId`) VALUES
	(1, 3, 1);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
