/*
    https://www.hackerrank.com/challenges/asian-population/problem
*/
SELECT
    SUM(CITY.POPULATION)
FROM
    CITY
JOIN
    COUNTRY
ON
    CITY.COUNTRYCODE = COUNTRY.CODE
    AND COUNTRY.CONTINENT = "Asia"