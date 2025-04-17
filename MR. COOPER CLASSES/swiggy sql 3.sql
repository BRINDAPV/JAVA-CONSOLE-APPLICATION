SELECT u.UserId, u.Name as UserName, t.Name as UserTypeName, f.Name as FoodName, oi.Quantity ,a.DoorNumber, a.Street, a.City, at.TypeName as AddressType
FROM swiggy.user u
join usertype t on t.UserTypeId = u.UserTypeId
join address a on a.UserId = u.UserId
join addresstype at on at.AddressTypeId = a.AddressTypeId
join orders o on o.UserId = u.UserId
join orderitem oi on oi.OrderId =  o.OrderId
join food f on f.FoodId = oi.FoodId
where u.UserId in (1,4)
order by UserId;

select u.Name, count(o.OrderId) as Orders from swiggy.user u
join orders o on o.UserId = u.UserId
group by u.Name
having count(o.OrderId) > 2;

-- join orderitem oi on oi.OrderId = o.OrderId
