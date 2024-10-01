with grade as(
    select id,
    case 
    when skill_code &(
        select code
        from skillcodes 
        where name = 'Python')
    and (select count(*)
        from skillcodes
        where skill_code &code and  category='Front End')>=1 then 'A'
    when skill_code &(
    select code
    from skillcodes
    where name='C#')>=1 then 'B'
    when (
        select count(*)
        from skillcodes
        where skill_code &code and category='Front End')>=1 then 'C'
    else 'D'
    end grade
    from developers
)

select g.grade, g.id, d.email from grade as g join developers as d on g.id=d.id where g.grade!= 'D' order by 1,2 asc