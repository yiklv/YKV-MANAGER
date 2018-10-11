CREATE USER 'TRAVELDATA'@'localhost' IDENTIFIED BY '~TRAVEL1234';

CREATE USER 'TRAVELDATA'@'127.0.0.1' IDENTIFIED BY '~TRAVEL1234';
CREATE USER 'TRAVELDATA'@'::1' IDENTIFIED BY '~TRAVEL1234';

create user 'TRAVELDATA'@'%' IDENTIFIED BY '~TRAVEL1234';

flush privileges;

CREATE DATABASE TRAVEL_YIKLV default character set utf8;

use TRAVEL_YIKLV;

grant all privileges on `TRAVEL_YIKLV`.* to 'TRAVELDATA'@'localhost';

grant all privileges on `TRAVEL_YIKLV`.* to 'TRAVELDATA'@'%';


-- 删除用户
-- DROP USER 'username'@'host';
-- 撤销权限
-- REVOKE privilege ON databasename.tablename FROM 'username'@'host';