select
    department,
    employee,
    salary
from
    (select 
        d.name as Department,
        e.name as Employee,
        e.salary as Salary,
        dense_rank() over(partition by e.departmentid order by e.salary desc) as 'rnk'
    from
        Employee e
    join
        department d
    on
        e.departmentid = d.id
    ) as t
where
    rnk = 1;