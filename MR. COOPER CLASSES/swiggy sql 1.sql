use Swiggy;
delete from UserType where UserTypeId in (4,5);

-- insert into Addresstype (TypeName) values ("Office");
-- insert into Addresstype (TypeName) values ("Residential");
-- alter table OrderItem
-- add constraint FK_OrderItem_FoodId
-- foreign key (FoodId) references Food(FoodId);

--  insert into UserType (Name) values ("Vendor");
--  insert into UserType (Name) values ("Buyer");
 insert into UserType (Name) values ("Delivery Boy");

-- alter table UserType 
-- modify column Name varchar(25);