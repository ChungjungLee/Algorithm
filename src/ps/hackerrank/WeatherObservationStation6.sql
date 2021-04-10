/*
    https://www.hackerrank.com/challenges/weather-observation-station-6/problem
*/
SELECT
    CITY
FROM
    STATION
WHERE
    CITY REGEXP ('^[a|e|i|o|u]')