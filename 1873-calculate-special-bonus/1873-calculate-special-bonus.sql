# Write your MySQL query statement below
Select employee_id , 
salary * ( employee_id%2 ) * ( name not like 'M%') as bonus
From employees
Order By employee_id;