-- create database Swiggy;
use Swiggy;
-- create table AddressType(
-- 	AddressTypeId int auto_increment  primary key,
--     TypeName varchar(15));

-- create table Address(
-- 	Address_id int auto_increment primary key,
--     UserId int not null,
-- 	DoorNumber int,
--     Street varchar(20),
--     City varchar(20),
--     AddressTypeId int not null,
--     foreign key (AddressTypeId) references AddressType(AddressTypeId));

-- create table UserType(
-- 	UserTypeId int auto_increment primary key,
-- 	Name varchar(10) not null);

-- -- create table User(
-- -- 	UserId int auto_increment primary key,
-- --     Name varchar(25) not null,
-- --     UserTypeId int not null,
-- --     PhoneNumber bigint,
-- --     foreign key (UserTypeId) references UserType(UserTypeId) );
--     
-- create table Food(
-- 	FoodId int auto_increment primary key,
--     Name varchar(35) not null,
--     Quantity int not null,
--     FoodType varchar(10) not null);
 
create table OrderItem(
	OrderId int not null,
    FoodId int not null,
    Quantity int not null,
    foreign key (OrderId) references Orders(OrderId));
    
-- create table Orders(
-- 	OrderId int auto_increment primary key,
--     UserId int not null);