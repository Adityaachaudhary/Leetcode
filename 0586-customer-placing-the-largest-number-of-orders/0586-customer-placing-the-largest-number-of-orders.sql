# Write your MySQL query statement below
Select customer_number
     from Orders
    Group By customer_number
    Order By count(*) Desc
    Limit 1;