# Write your MySQL query statement below
Select class 
From Courses
Group By Class
Having Count(student) >= 5;