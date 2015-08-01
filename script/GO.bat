rem @echo off

set git_cmd=git
set remoteRepo=https://github.com/StratoCasterFen/Strato.git

set repo=%CD%\matsak-jd2

rem	clean old info
rd /S /Q %repo%
if EXIST %repo% (
	tskill TGitCache
	rd /S /Q %repo%
	if EXIST %repo% (
		echo Не удалось удалить каталог %repo%
 		exit 1
		pause
	)
)
md %repo%

rem import git db
%git_cmd% clone --recursive %remoteRepo% %repo%
cd %repo%
%git_cmd% checkout develop


rem import sql dump
set sql_cmd="C:\Program Files\MySQL\MySQL Server 5.6\bin\mysql.exe"
%sql_cmd% -u root -pqwe321 -B -s -f policestation "%repo%\script\policest.sql"

rem maven 
cd %repo%
mvn clean install

rem start
java -jar %repo%\dao\target\matsak-dao-1.0.jar
pause

