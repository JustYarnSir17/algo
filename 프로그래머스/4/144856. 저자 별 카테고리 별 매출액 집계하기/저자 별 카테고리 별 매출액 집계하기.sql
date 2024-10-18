-- 코드를 입력하세요
with total as(select b.author_id, sum(s.sales*b.price) as total_sales,b.category from book_sales as s join book as b on s.book_id = b.book_id where s.sales_date between '2022-01-01' and '2022-01-31'group by b.author_id,b.category)

select a.author_id, a.author_name, t.category,t.total_sales from author as a join total as t on a.author_id=t.author_id order by 1 asc, 3 desc