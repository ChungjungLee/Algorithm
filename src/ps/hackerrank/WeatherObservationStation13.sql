/*
    https://www.hackerrank.com/challenges/weather-observation-station-13/problem
*/
SELECT
    TRUNCATE(SUM(LAT_N), 4)
FROM
    STATION
WHERE
    38.7880 < LAT_N
    AND LAT_N < 137.2345