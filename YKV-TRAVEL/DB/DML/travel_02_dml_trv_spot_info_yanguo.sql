insert into trv_syc_tkttype (id_key, type_id, type_name, type_image) values(rand_string(32), concat('TKT', padIntToStr('L', nextval('trv_tkt_type_category  '), 15, '0')), '成人票', 'auditPic.png');
insert into trv_syc_tkttype (id_key, type_id, type_name, type_image) values(rand_string(32), concat('TKT', padIntToStr('L', nextval('trv_tkt_type_category  '), 15, '0')), '儿童票', 'childrenPic.png');
-- insert into trv_syc_tkttype (id_key, type_id, type_name, type_image) values(rand_string(32), 'TKT00000003', '老人票');
insert into trv_syc_tkttype (id_key, type_id, type_name, type_image) values(rand_string(32), concat('TKT', padIntToStr('L', nextval('trv_tkt_type_category  '), 15, '0')), '相关票','relativePic.png');
insert into trv_syc_tkttype (id_key, type_id, type_name, type_image) values(rand_string(32), concat('TKT', padIntToStr('L', nextval('trv_tkt_type_category  '), 15, '0')), '学生票', 'studentPic.png');
insert into trv_syc_tkttype (id_key, type_id, type_name, type_image) values(rand_string(32), concat('TKT', padIntToStr('L', nextval('trv_tkt_type_category  '), 15, '0')), '亲子票', 'qinziPic.png');
insert into trv_syc_tkttype (id_key, type_id, type_name, type_image) values(rand_string(32), concat('TKT', padIntToStr('L', nextval('trv_tkt_type_category  '), 15, '0')), '家庭票', 'familyPic.png');
insert into trv_syc_tkttype (id_key, type_id, type_name, type_image) values(rand_string(32), concat('TKT', padIntToStr('L', nextval('trv_tkt_type_category  '), 15, '0')), '双人票', 'doublePic.png');

insert into trv_spot_info(id_key, spot_id, spot_name, image_url, city_id, area_id, spot_price, spot_old_price,spot_level,spot_address)
values(rand_string(32), 'SP0000000000000001','银杏湖乐园', 'yinxinhu.png', 'CT0000000001', 'ARNJ000000008',95, 148, '','江苏省南京市江宁区银杏湖大道520号');


INSERT INTO `trv_spot_info`(id_key, spot_id, spot_name, image_url, city_id, area_id, spot_price, spot_old_price,spot_level,spot_address) VALUES (rand_string(32), 'SP0000000000000002', 'test3', 'images/498300.jpg', 'CT0000000002', 'ARWX000000002', 55.00, 85.00, '4A景区', '啊打发打发打发似的');
INSERT INTO `trv_spot_info`(id_key, spot_id, spot_name, image_url, city_id, area_id, spot_price, spot_old_price,spot_level,spot_address) VALUES (rand_string(32), 'SP0000000000000003', 'test4', 'images/829843.jpg', 'CT0000000002', 'ARWX000000003', 75.00, 110.00, '4A景区', '啊打发打发打发似的');
INSERT INTO `trv_spot_info`(id_key, spot_id, spot_name, image_url, city_id, area_id, spot_price, spot_old_price,spot_level,spot_address) VALUES (rand_string(32), 'SP0000000000000001', 'test2', 'images/timg1.png', 'CT0000000002', 'ARWX000000001', 25.00, 80.00, '4A景区', '啊打发打发打发似的');

INSERT INTO `trv_spot_info`(id_key, spot_id, spot_name, image_url, city_id, area_id, spot_price, spot_old_price,spot_level,spot_address) VALUES (rand_string(32), concat('SP', padIntToStr('L', nextval('tour_spot_category'), 15, '0')), 'test5', 'images/498300.jpg', 'CT0000000002', 'ARWX000000002', 55.00, 85.00, '4A景区', '啊打发打发打发似的');
INSERT INTO `trv_spot_info`(id_key, spot_id, spot_name, image_url, city_id, area_id, spot_price, spot_old_price,spot_level,spot_address) VALUES (rand_string(32), concat('SP', padIntToStr('L', nextval('tour_spot_category'), 15, '0')), 'test6', 'images/829843.jpg', 'CT0000000002', 'ARWX000000003', 75.00, 110.00, '4A景区', '啊打发打发打发似的');
INSERT INTO `trv_spot_info`(id_key, spot_id, spot_name, image_url, city_id, area_id, spot_price, spot_old_price,spot_level,spot_address) VALUES (rand_string(32), concat('SP', padIntToStr('L', nextval('tour_spot_category'), 15, '0')), 'test7', 'images/timg1.png', 'CT0000000002', 'ARWX000000001', 25.00, 80.00, '4A景区', '啊打发打发打发似的');

INSERT INTO `trv_spot_info`(id_key, spot_id, spot_name, image_url, city_id, area_id, spot_price, spot_old_price,spot_level,spot_address) VALUES (rand_string(32), concat('SP', padIntToStr('L', nextval('tour_spot_category'), 15, '0')), 'test8', 'images/498300.jpg', 'CT0000000002', 'ARWX000000002', 55.00, 85.00, '4A景区', '啊打发打发打发似的');
INSERT INTO `trv_spot_info`(id_key, spot_id, spot_name, image_url, city_id, area_id, spot_price, spot_old_price,spot_level,spot_address) VALUES (rand_string(32), concat('SP', padIntToStr('L', nextval('tour_spot_category'), 15, '0')), 'test9', 'images/829843.jpg', 'CT0000000002', 'ARWX000000003', 75.00, 110.00, '4A景区', '啊打发打发打发似的');
INSERT INTO `trv_spot_info`(id_key, spot_id, spot_name, image_url, city_id, area_id, spot_price, spot_old_price,spot_level,spot_address) VALUES (rand_string(32), concat('SP', padIntToStr('L', nextval('tour_spot_category'), 15, '0')), 'test10', 'images/timg1.png', 'CT0000000002', 'ARWX000000001', 25.00, 80.00, '4A景区', '啊打发打发打发似的');

INSERT INTO `trv_spot_info`(id_key, spot_id, spot_name, image_url, city_id, area_id, spot_price, spot_old_price,spot_level,spot_address) VALUES (rand_string(32), concat('SP', padIntToStr('L', nextval('tour_spot_category'), 15, '0')), 'test11', 'images/498300.jpg', 'CT0000000002', 'ARWX000000002', 55.00, 85.00, '4A景区', '啊打发打发打发似的');
INSERT INTO `trv_spot_info`(id_key, spot_id, spot_name, image_url, city_id, area_id, spot_price, spot_old_price,spot_level,spot_address) VALUES (rand_string(32), concat('SP', padIntToStr('L', nextval('tour_spot_category'), 15, '0')), 'test12', 'images/829843.jpg', 'CT0000000002', 'ARWX000000003', 75.00, 110.00, '4A景区', '啊打发打发打发似的');
INSERT INTO `trv_spot_info`(id_key, spot_id, spot_name, image_url, city_id, area_id, spot_price, spot_old_price,spot_level,spot_address) VALUES (rand_string(32), concat('SP', padIntToStr('L', nextval('tour_spot_category'), 15, '0')), 'test13', 'images/timg1.png', 'CT0000000002', 'ARWX000000001', 25.00, 80.00, '4A景区', '啊打发打发打发似的');

insert into trv_spot_opentime(id_key, spot_id, open_time_desc) values(rand_string(32), 'SP0000000000000001','9:30-17:00（主题乐园（平日））');
insert into trv_spot_opentime(id_key, spot_id, open_time_desc) values(rand_string(32), 'SP0000000000000001','9:00-17:30（主题乐园（节假日））');
insert into trv_spot_opentime(id_key, spot_id, open_time_desc) values(rand_string(32), 'SP0000000000000001','5:30-17:00（高尔夫俱乐部）');
insert into trv_spot_opentime(id_key, spot_id, open_time_desc) values(rand_string(32), 'SP0000000000000001','0:00-24:00（度假酒店）');

insert into trv_spot_tkt_type(id_key, spot_id, tkt_type) values(rand_string(32), 'SP0000000000000001', 'TKT000000000000001');
insert into trv_spot_tkt_type(id_key, spot_id, tkt_type) values(rand_string(32), 'SP0000000000000001', 'TKT000000000000002');
insert into trv_spot_tkt_type(id_key, spot_id, tkt_type) values(rand_string(32), 'SP0000000000000001', 'TKT000000000000004');
insert into trv_spot_tkt_type(id_key, spot_id, tkt_type) values(rand_string(32), 'SP0000000000000001', 'TKT000000000000005');

insert into trv_tkt_info(id_key, tkt_id, tkt_name, tkt_price, tkt_old_price, spot_id, tkt_type)
values(rand_string(32), concat('TK', padIntToStr('L', nextval('trv_tkt_category'), 16, '0')), '[门票]银杏湖乐园成人票[提前一天订票]摩天轮-一天【可带1.2米以下儿童】', 95, 148, 'SP0000000000000001', 'TKT000000000000001');

insert into trv_tkt_info(id_key, tkt_id, tkt_name, tkt_price, tkt_old_price, spot_id, tkt_type)
values(rand_string(32), concat('TK', padIntToStr('L', nextval('trv_tkt_category'), 16, '0')), '[门票]银杏湖乐园成人票[提前一天订票]摩天轮-二天【可带1.2米以下儿童】', 180, 296, 'SP0000000000000001', 'TKT000000000000001');


insert into trv_spot_img(id_key, spot_id, image_url)values(rand_string(32), 'SP0000000000000001', 'images/498300.jpg');
insert into trv_spot_img(id_key, spot_id, image_url)values(rand_string(32), 'SP0000000000000001', 'images/829843.jpg');
insert into trv_spot_img(id_key, spot_id, image_url)values(rand_string(32), 'SP0000000000000001', 'images/timg1.png');

insert into `trv_spot_keyword`(`id_key`, `word_id`, `word_name`, `word_status`,`word_level` ) values(rand_string(32), 'SP0000000000000001','银杏湖', 'Y',1);
insert into `trv_spot_keyword`(`id_key`, `word_id`, `word_name`, `word_status`,`word_level` ) values(rand_string(32), 'SP0000000000000001','银杏湖1', 'Y',2);
insert into `trv_spot_keyword`(`id_key`, `word_id`, `word_name`, `word_status`,`word_level` ) values(rand_string(32), 'SP0000000000000001','银杏湖2', 'Y',3);
insert into `trv_spot_keyword`(`id_key`, `word_id`, `word_name`, `word_status`,`word_level` ) values(rand_string(32), 'SP0000000000000001','银杏湖3', 'Y',4);
insert into `trv_spot_keyword`(`id_key`, `word_id`, `word_name`, `word_status`,`word_level` ) values(rand_string(32), 'SP0000000000000001','银杏湖4', 'Y',5);
insert into `trv_spot_keyword`(`id_key`, `word_id`, `word_name`, `word_status`,`word_level` ) values(rand_string(32), 'SP0000000000000001','银杏湖5', 'Y',6);
insert into `trv_spot_keyword`(`id_key`, `word_id`, `word_name`, `word_status`,`word_level` ) values(rand_string(32), 'SP0000000000000001','银杏湖6', 'Y',7);
insert into `trv_spot_keyword`(`id_key`, `word_id`, `word_name`, `word_status`,`word_level` ) values(rand_string(32), 'SP0000000000000001','银杏湖7', 'Y',8);


