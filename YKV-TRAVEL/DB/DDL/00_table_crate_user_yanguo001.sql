CREATE USER 'traveldata'@'localhost' IDENTIFIED BY '~TRAVEL1234';

CREATE USER 'traveldata'@'127.0.0.1' IDENTIFIED BY '~TRAVEL1234';
CREATE USER 'traveldata'@'::1' IDENTIFIED BY '~TRAVEL1234';

create user 'traveldata'@'%' IDENTIFIED BY '~TRAVEL1234';

flush privileges;

CREATE DATABASE travel_ykv default character set utf8;

use travel_ykv;

grant all privileges on `travel_ykv`.* to 'traveldata'@'localhost';

grant all privileges on `travel_ykv`.* to 'traveldata'@'%';


-- 删除用户
-- DROP USER 'username'@'host';
-- 撤销权限
-- REVOKE privilege ON databasename.tablename FROM 'username'@'host';