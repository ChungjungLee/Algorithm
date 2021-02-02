/*
    https://www.hackerrank.com/challenges/african-cities/problem
*/

SELECT
    CITY.Name
FROM
    CITY
JOIN
    COUNTRY
ON
    CITY.CountryCode = COUNTRY.Code
    and COUNTRY.CONTINENT = 'Africa'