/*
    https://www.hackerrank.com/challenges/african-cities/problem
*/

SELECT
    CITY.Name
FROM
    CITY
INNER JOIN
    COUNTRY
ON
    CITY.Countrycode = COUNTRY.Code
WHERE
    COUNTRY.Continent = 'Africa'