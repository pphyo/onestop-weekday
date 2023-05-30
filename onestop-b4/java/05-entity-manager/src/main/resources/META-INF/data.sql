insert into image (path) values ('/icons/photo1.svg');
insert into image (path) values ('/icons/photo2.svg');
insert into image (path) values ('/icons/photo3.svg');
insert into image (path) values ('/icons/photo4.svg');

insert into category (name, image_id) values ('Foods', 1);
insert into category (name, image_id) values ('Drinks', 2);
insert into category (name, image_id) values ('Fashion', 3);
insert into category (name, image_id) values ('Electronics', 4);
insert into category (name) values ('Furniture');
insert into category (name) values ('Mobile');
insert into category (name) values ('Laptop');

insert into product (name, price, size, stock, category_id) values ('Sushi', 10000, 'MEDIUM', 200, 1);
insert into product (name, price, size, stock, category_id) values ('Bacon', 15000, 'SMALL', 60, 1);
insert into product (name, price, size, stock, category_id) values ('Burn', 1000, 'MEDIUM', 500, 2);
insert into product (name, price, size, stock, category_id) values ('Shark', 1200, 'MEDIUM', 400, 2);
insert into product (name, price, size, stock, category_id) values ('IPhone 13 Pro', 2500000, 'MEDIUM', 20, 6);

insert into remarks (product_id, remark) values (1, 'Diet Food but not Fast Food');
insert into remarks (product_id, remark) values (1, 'Myanmar Foods, Chinese Foods and European Foods');
