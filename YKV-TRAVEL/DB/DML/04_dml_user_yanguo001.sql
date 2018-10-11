
insert into shop_user(id_key, user_id, user_name, user_pwd, user_sex,real_name, id_no, birthday, mobilephone)
values(UUID(),'admin', 'administrator',MD5('123456'), 'M', '管理员', '123456789012345678', '19920101', '13500955240');