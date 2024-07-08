select month(a.start_date) as month, a.car_id, count(a.car_id) as records 
from car_rental_company_rental_history as a 
join (select car_id from car_rental_company_rental_history where start_date>='2022-08-01' and start_date<='2022-10-31' group by car_id having count(car_id)>=5 order by car_id) as b 
on a.car_id=b.car_id 
where start_date>='2022-08-1'and start_date<='2022-10-31'
group by month(start_date),a.car_id 
order by month asc, car_id desc