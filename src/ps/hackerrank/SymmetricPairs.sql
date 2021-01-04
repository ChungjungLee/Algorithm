/*
    https://www.hackerrank.com/challenges/symmetric-pairs/problem
*/

SELECT
    f1.x as X
    , f1.y as Y
FROM
    functions as f1
INNER JOIN
    functions as f2
ON
    f1.x = f2.y
    and f1.y = f2.x
GROUP BY
    f1.x, f1.y
HAVING
    COUNT(f1.x) > 1 or f1.x < f1.y
ORDER BY
    X