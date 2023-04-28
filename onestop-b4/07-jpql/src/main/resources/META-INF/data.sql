insert into category (name) values ('Foods');
insert into category (name) values ('Drinks');
insert into category (name) values ('Mobiles');

insert into product(name, category_id) values ('Potato Chips', 1);
insert into product(name, category_id) values ('Fish Chips', 1);
insert into product(name, category_id) values ('Coke', 2);
insert into product(name, category_id) values ('Pepsi', 2);
insert into product(name, category_id) values ('iPhone 13', 3);
insert into product(name, category_id) values ('Samsung Note 20', 3);

insert into remark (product_id, remarks) values (1, 'Yellow');
insert into remark (product_id, remarks) values (2, 'Yellow');
insert into remark (product_id, remarks) values (3, 'Black');
insert into remark (product_id, remarks) values (4, 'Blue');

insert into supplier (name, phone, email) values ('196 Store', '0911889900', 'store196@gmail.com');
insert into supplier (name, phone, email) values ('Star Shop', '0911889911', 'starshop@gmail.com');
insert into supplier (name, phone, email) values ('Grab and Go', '0911889922', 'store@gandg.com');
insert into supplier (name, phone, email) values ('Anycall Mobile', '0911774422', 'mobile@anycall.com');

insert into product_supply(product_id, supplier_id) values (1, 1);
insert into product_supply(product_id, supplier_id) values (2, 1);
insert into product_supply(product_id, supplier_id) values (3, 2);
insert into product_supply(product_id, supplier_id) values (4, 2);
insert into product_supply(product_id, supplier_id) values (5, 4);
insert into product_supply(product_id, supplier_id) values (6, 4);

insert into invoice (inv_date, inv_time, tax) values ('23-1-01', '12:33', 5);
insert into invoice (inv_date, inv_time, tax) values ('23-2-02', '13:33', 3);
insert into invoice (inv_date, inv_time, tax) values ('23-1-11', '16:50', 4);
insert into invoice (inv_date, inv_time, tax) values ('23-3-1', '8:30', 5);

insert into sale_order (qty, unit_price, product_id, invoice_id) values (2, 1000, 1, 1);
insert into sale_order (qty, unit_price, product_id, invoice_id) values (3, 1500, 2, 1);
insert into sale_order (qty, unit_price, product_id, invoice_id) values (1, 8000, 3, 1);
insert into sale_order (qty, unit_price, product_id, invoice_id) values (1, 3000000, 5, 2);
insert into sale_order (qty, unit_price, product_id, invoice_id) values (1, 2800000, 6, 3);
insert into sale_order (qty, unit_price, product_id, invoice_id) values (2, 1000, 1, 4);
insert into sale_order (qty, unit_price, product_id, invoice_id) values (3, 1500, 2, 4);
insert into sale_order (qty, unit_price, product_id, invoice_id) values (1, 8000, 3, 4);