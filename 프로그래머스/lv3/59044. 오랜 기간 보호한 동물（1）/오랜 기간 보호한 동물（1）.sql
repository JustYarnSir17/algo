-- 코드를 입력하세요
SELECT i.NAME, i.DATETIME FROM ANIMAL_INS AS i LEFT JOIN ANIMAL_OUTS AS o on i.ANIMAL_ID = o.ANIMAL_ID WHERE ISNULL(o.ANIMAL_ID) ORDER BY i.DATETIME LIMIT 3