# Write your MySQL query statement below
Select(
    Select Distinct salary From Employee
    Order by salary DESC 
    LIMIT 1 OFFSET 1
) As SecondHighestSalary 