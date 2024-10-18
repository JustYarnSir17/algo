SELECT car.car_id, car.car_type, 
       ROUND(car.daily_fee * 30 * (100 - plan.discount_rate) / 100) AS fee 
FROM car_rental_company_car AS car
JOIN car_rental_company_discount_plan AS plan 
    ON car.car_type = plan.car_type 
WHERE NOT EXISTS (
    SELECT 1 
    FROM car_rental_company_rental_history 
    WHERE car_id = car.car_id 
    AND (start_date <= '2022-11-30' AND end_date >= '2022-11-01')
)
AND (car.car_type = 'SUV' OR car.car_type = '세단')
AND plan.duration_type = '30일 이상'
AND ROUND(car.daily_fee * 30 * (100 - plan.discount_rate) / 100) BETWEEN 500000 AND 1999999
ORDER BY fee DESC, car.car_type ASC, car.car_id DESC;
