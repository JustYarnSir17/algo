-- 코드를 입력하세요
SELECT ID,NAME,HOST_ID FROM PLACES
WHERE host_id in(select host_id from places group by host_id having count(*)>1)
order by id asc