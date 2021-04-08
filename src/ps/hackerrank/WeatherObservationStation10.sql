/*
    https://www.hackerrank.com/challenges/weather-observation-station-10/submissions/code/207894872
*/
SELECT DISTINCT
    CITY
FROM
    STATION
WHERE
    CITY NOT REGEXP "[aeiou]$"