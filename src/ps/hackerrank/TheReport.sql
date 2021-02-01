/*
    https://www.hackerrank.com/challenges/the-report/problem
*/

SELECT
    CASE WHEN Grades.Grade > 7 THEN Students.Name
    ELSE 'NULL'
    END AS Name
    , Grades.Grade AS Grade
    , Students.Marks AS Marks
FROM
    Students
JOIN
    Grades
ON
    Students.Marks <= Grades.Max_Mark and Students.Marks >= Grades.Min_Mark
ORDER BY
    Grade DESC
    , Name ASC
    , Marks ASC