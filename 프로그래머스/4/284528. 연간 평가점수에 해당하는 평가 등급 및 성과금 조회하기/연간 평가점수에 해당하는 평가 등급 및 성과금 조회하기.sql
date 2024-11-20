with b as(select emp_no, case
when avg(score) >=96 then 'S'
when avg(score) <96 and avg(score)>=90 then 'A'
when avg(score) <90 and avg(score) >=80 then 'B'
when avg(score) <80 then 'C' end as grade from hr_grade group by emp_no)


# select e.emp_no, e.emp_name, b.grade,
# case when grade ='S' then e.sal * 0.2
# when grade = 'A' then e.sal * 0.15
# when grade = 'B' then e.sal * 0.1
# when grade = 'C' then 0 
# end as bonus from b as b join hr_employees as e on b.emp_no=e.emp_no order by e.emp_no asc

select  e.emp_no, e.emp_name, b.grade,
case when b.grade ='S' then e.sal *0.2
when b.grade = 'A' then e.sal *0.15
when b.grade = 'B' then e.sal *0.1
when b.grade = 'C' then 0 end as bonus
from b as b join hr_employees as e on b.emp_no = e.emp_no group by e.emp_no order by e.emp_no asc