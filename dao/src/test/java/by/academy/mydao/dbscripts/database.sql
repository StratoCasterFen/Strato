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

-- Дамп структуры базы данных policetest
CREATE DATABASE IF NOT EXISTS `policetest` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `policetest`;


-- Дамп структуры для таблица policetest.criminalevents
CREATE TABLE IF NOT EXISTS `criminalevents` (
  `EventId` int(11) NOT NULL,
  `EventName` varchar(70) DEFAULT '0',
  `EventDescription` varchar(700) DEFAULT NULL,
  `EventDate` date DEFAULT NULL,
  `CriminalId` int(11) NOT NULL,
  `UserId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица policetest.criminals
CREATE TABLE IF NOT EXISTS `criminals` (
  `CriminalId` int(11) NOT NULL,
  `Name` varchar(50) DEFAULT '0',
  `SurName` varchar(50) DEFAULT '0',
  `Birthday` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица policetest.roles
CREATE TABLE IF NOT EXISTS `roles` (
  `RoleId` int(11) NOT NULL,
  `RoleName` varchar(30) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица policetest.users
CREATE TABLE IF NOT EXISTS `users` (
  `UserId` int(11) NOT NULL,
  `UserName` varchar(50) DEFAULT '0',
  `Password` varchar(50) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.


-- Дамп структуры для таблица policetest.user_role
CREATE TABLE IF NOT EXISTS `user_role` (
  `idUR` int(11) NOT NULL,
  `UserId` int(11) DEFAULT '0',
  `RoleId` int(11) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Экспортируемые данные не выделены.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
