SELECT
    d.Name AS Department,
    e.Name AS Employee,
    e.Salary
FROM (
    SELECT
        Name,
        departmentId,
        Salary,
        DENSE_RANK() OVER (PARTITION BY departmentId ORDER BY Salary DESC) AS rnk
    FROM Employee
) e
INNER JOIN Department d ON e.departmentId = d.Id
WHERE e.rnk <= 3;
