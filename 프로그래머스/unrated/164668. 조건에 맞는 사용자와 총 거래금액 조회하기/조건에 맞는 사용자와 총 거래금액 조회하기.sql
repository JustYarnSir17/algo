-- 코드를 입력하세요
SELECT u.USER_ID, u.NICKNAME, SUM(b.price) AS TOTAL_SALES FROM USED_GOODS_USER AS u JOIN USED_GOODS_BOARD AS b ON b.WRITER_ID = u.USER_ID WHERE b.STATUS='DONE' GROUP BY u.USER_ID HAVING SUM(b.price)>=700000 ORDER BY TOTAL_SALES ASC