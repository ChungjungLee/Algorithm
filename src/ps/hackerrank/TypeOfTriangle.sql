/*
    https://www.hackerrank.com/challenges/what-type-of-triangle/problem
*/
SELECT
    CASE
        WHEN (A + B <= C) THEN 'Not A Triangle'
        WHEN (A != B and B != C and C != A) THEN 'Scalene'
        WHEN (A = B and B = C) THEN 'Equilateral'
        ELSE 'Isosceles'
    END
FROM
    TRIANGLES