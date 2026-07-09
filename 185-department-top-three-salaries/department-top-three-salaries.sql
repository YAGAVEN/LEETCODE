select 
    department,
    Employee,
    Salary
from
    (select
        d.name as department,
        e.name as employee,
        e.salary,
        dense_rank() over(partition by e.departmentid order by e.salary desc) as 'rnk'
    from
        employee e
    join
        department d
    on
        e.departmentid = d.id
    ) as t
where
    rnk = 1 or rnk = 2 or rnk =3;