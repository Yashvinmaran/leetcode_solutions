/* Write your PL/SQL query statement below */
SELECT p.product_name, s.year, s.price from Sales s
inner join Product p
ON p.product_id = s.product_id;
