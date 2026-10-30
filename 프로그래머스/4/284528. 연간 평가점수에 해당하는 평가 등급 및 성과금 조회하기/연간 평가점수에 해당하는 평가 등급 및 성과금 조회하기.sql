select e.emp_no, e.emp_name, 
    case 
        when avg(g.score)>=96 then 'S'
        when 96>avg(g.score) and avg(g.score)>=90 then 'A'
        when 90>avg(g.score) and avg(g.score)>=80 then 'B'
        else 'C'
    end as GRADE,
    case
        when avg(g.score)>=96 then SAL*0.2
        when 96>avg(g.score) and avg(g.score)>=90 then SAL*0.15
        when 90>avg(g.score) and avg(g.score)>=80 then SAL*0.1
        else 0
    end as BONUS
from HR_EMPLOYEES e join HR_GRADE g
    on e.emp_no = g.emp_no
group by e.emp_no
order by e.emp_no asc
