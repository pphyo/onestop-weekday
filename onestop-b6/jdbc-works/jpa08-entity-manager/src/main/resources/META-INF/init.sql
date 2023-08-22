insert into ledger (name, type) values ('Shopping', 'Debit');
insert into ledger (name, type) values ('Award', 'Credit');
insert into ledger (name, type) values ('Tax', 'Debit');
insert into ledger (name, type) values ('Salary', 'Credit');
insert into ledger (name, type) values ('Lottery', 'Credit');
insert into ledger (name, type) values ('Bill', 'Debit');

insert into tags (tag, ledger_id) values ('Mini Market', 1);
insert into tags (tag, ledger_id) values ('Shopping Center', 1);
insert into tags (tag, ledger_id) values ('Bonus', 2);

insert into transaction (issued_date, issued_user, ledger_id) values ('2023-01-20', 'Min Lwin', 1);
insert into transaction (issued_date, issued_user, ledger_id) values ('2023-02-10', 'Min Khant', 1);
insert into transaction (issued_date, issued_user, ledger_id) values ('2023-03-1', 'Pyae Phyo', 1);
insert into transaction (issued_date, issued_user, ledger_id) values ('2023-02-10', 'Min Khant', 2);
insert into transaction (issued_date, issued_user, ledger_id) values ('2023-01-20', 'Min Lwin', 3);
insert into transaction (issued_date, issued_user, ledger_id) values ('2023-02-10', 'Min Khant', 3);
insert into transaction (issued_date, issued_user, ledger_id) values ('2023-03-1', 'Pyae Phyo', 3);
insert into transaction (issued_date, issued_user, ledger_id) values ('2023-04-4', 'Zin Lin Htet', 4);
insert into transaction (issued_date, issued_user, ledger_id) values ('2023-01-20', 'Min Lwin', 5);
insert into transaction (issued_date, issued_user, ledger_id) values ('2023-02-10', 'Min Khant', 5);
insert into transaction (issued_date, issued_user, ledger_id) values ('2023-05-09', 'Kyaw Khant Zin', 5);
insert into transaction (issued_date, issued_user, ledger_id) values ('2023-05-20', 'Zaw Han Tun', 6);

insert into account (name, amount) values ('Pyae Phyo', 100000);
insert into account (name, amount) values ('Min Khant', 100000);






