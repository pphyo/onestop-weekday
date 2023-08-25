insert into category (name) values ('Foods');
insert into category (name) values ('Drinks');
insert into category (name) values ('Mobiles');

insert into product(name, category_id) values ('Potato Chips', 1);
insert into product(name, category_id) values ('Fish Chips', 1);
insert into product(name, category_id) values ('Coke', 2);
insert into product(name, category_id) values ('Pepsi', 2);
insert into product(name) values ('iPhone 13');

insert into supplier (name, phone, email) values ('196 Store', '0911889900', 'store196@gmail.com');
insert into supplier (name, phone, email) values ('Star Shop', '0911889911', 'starshop@gmail.com');
insert into supplier (name, phone, email) values ('Moon Star', '0911889922', 'moonstar@gmail.com');

insert into product_supply(product_id, supplier_id) values (1, 1);
insert into product_supply(product_id, supplier_id) values (2, 1);
insert into product_supply(product_id, supplier_id) values (3, 2);
insert into product_supply(product_id, supplier_id) values (4, 2);
