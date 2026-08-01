# Write your MySQL query statement below
Select user_id, 
    CONCAT(UPPER(SUBSTRING(name, 1, 1)),
            LOWER(SUBSTRING(name,2))
        ) As name
From Users
Order By user_id;        


