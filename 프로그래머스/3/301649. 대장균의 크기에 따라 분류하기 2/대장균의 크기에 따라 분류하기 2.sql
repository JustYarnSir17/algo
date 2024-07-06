select id, 
case
when per.p <=0.25 then 'CRITICAL'
when per.p >0.25 and p<=0.5 then 'HIGH'
when per.p >0.5 and p<=0.75 then 'MEDIUM'
else 'LOW'
end as colony_name
from (select id, percent_rank()over(order by size_of_colony desc)as p from ecoli_data ) as per
order by id asc