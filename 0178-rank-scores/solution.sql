# Write your MySQL query statement below
select score, dense_rank() OVER (ORDER BY score desc) as "rank" from Scores;
