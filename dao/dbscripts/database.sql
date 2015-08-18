-- Дамп структуры базы данных policetest
CREATE DATABASE IF NOT EXISTS `policetest` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `policetest`;

-- Дамп структуры для таблица policetest.criminalevents
CREATE TABLE IF NOT EXISTS `criminalevents` (
  `Id` int(11),
  `EventName` varchar(70) DEFAULT '0',
  `EventDescription` varchar(700) DEFAULT NULL,
  `EventDate` date DEFAULT NULL,
  `CriminalId` int(11),
  `UserId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп структуры для таблица policetest.criminals
CREATE TABLE IF NOT EXISTS `criminals` (
  `Id` int(11),
  `Name` varchar(50) DEFAULT '0',
  `SurName` varchar(50) DEFAULT '0',
  `Birthday` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп структуры для таблица policetest.dbmaintain_scripts
CREATE TABLE IF NOT EXISTS `dbmaintain_scripts` (
  `file_name` varchar(150) DEFAULT NULL,
  `version` varchar(25) DEFAULT NULL,
  `file_last_modified_at` bigint(20) DEFAULT NULL,
  `checksum` varchar(50) DEFAULT NULL,
  `executed_at` varchar(20) DEFAULT NULL,
  `succeeded` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп структуры для таблица policetest.roles
CREATE TABLE IF NOT EXISTS `roles` (
  `Id` int(11),
  `RoleName` varchar(30) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп структуры для таблица policetest.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11),
  `username` varchar(50),
  `password` varchar(50)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Дамп структуры для таблица policetest.user_role
CREATE TABLE IF NOT EXISTS `user_role` (
  `id` int(11),
  `UserId` int(11),
  `RoleId` int(11) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


