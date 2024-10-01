WITH front AS (
    SELECT code
    FROM skillcodes
    WHERE category = 'Front End'
)

SELECT DISTINCT d.id, d.email, d.first_name, d.last_name 
FROM developers AS d
JOIN front AS b 
ON d.skill_code & b.code != 0 
ORDER BY d.id ASC;
