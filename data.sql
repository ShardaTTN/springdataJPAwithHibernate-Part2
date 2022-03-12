use mydb;

create table payment(
id int PRIMARY KEY,
pmode varchar(2),
amount decimal(8,3) ,
cardnumber varchar(20),
checknumber varchar(20)
);

select * from payment;

drop table payment;


create table card(
id int PRIMARY KEY,
amount decimal(8,3),
cardnumber varchar(20)
);

create table bankcheck(
id int PRIMARY KEY,
amount decimal(8,3),
checknumber varchar(20)
);
select * from card;
select * from bankcheck;




create table payment(
id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
amount decimal(8,3)
);

create table card(
id int ,
cardnumber varchar(20),
 FOREIGN KEY (id)
REFERENCES payment(id)
);

create table bankcheck(
id int ,
checknumber varchar(20),
FOREIGN KEY (id)
REFERENCES payment(id)
);



create table employee (
id int,
firstname varchar(15),
lastname varchar(15),
age int,
basicsalary int,
bonussalary int,
taxamount int, 
specialallowancesalary int
);