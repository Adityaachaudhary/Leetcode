# Write your MySQL query statement below
Select teacher_id,
    Count( Distinct subject_id) As cnt
From Teacher
Group By teacher_id;
