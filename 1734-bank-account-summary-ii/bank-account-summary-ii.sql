select
    name,balance
from (select
    u.name,
    sum(t.amount) as balance
from
    users u
left join
    transactions t
on
    u.account = t.account
group by
    u.name) as t
where 
    balance > 10000;