# Write your MySQL query statement below
SELECT 
    ROUND(
        COUNT(DISTINCT temp.player_id) / (SELECT COUNT(DISTINCT player_id) FROM Activity), 
        2
    ) AS fraction
FROM (
    SELECT player_id, MIN(event_date) AS first_login
    FROM Activity
    GROUP BY player_id
) temp
JOIN Activity a 
  ON temp.player_id = a.player_id 
  AND a.event_date = DATE_ADD(temp.first_login, INTERVAL 1 DAY);