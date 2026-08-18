# Write your MySQL query statement below
WITH CategoryCounts AS (
    SELECT 
        SUM(CASE WHEN income < 20000 THEN 1 ELSE 0 END) AS low_count,
        SUM(CASE WHEN income >= 20000 AND income <= 50000 THEN 1 ELSE 0 END) AS avg_count,
        SUM(CASE WHEN income > 50000 THEN 1 ELSE 0 END) AS high_count
    FROM Accounts
)
SELECT 'Low Salary' AS category, low_count AS accounts_count FROM CategoryCounts
UNION ALL
SELECT 'Average Salary' AS category, avg_count AS accounts_count FROM CategoryCounts
UNION ALL
SELECT 'High Salary' AS category, high_count AS accounts_count FROM CategoryCounts; 