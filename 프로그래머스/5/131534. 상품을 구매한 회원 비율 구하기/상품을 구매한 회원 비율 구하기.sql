select year(o.sales_date) as YEAR,
       month(o.sales_date) as MONTH,
       count(distinct u.user_id) as PURCHASED_USERS,
       round(count(distinct u.user_id) / (select count(distinct user_id) from user_info where(year(joined) = 2021)), 1) as PUCHASED_RATIO
from online_sale o join user_info u
    on o.user_id = u.user_id
where year(u.joined) = 2021
group by year(o.sales_date), month(o.sales_date)
order by year asc, month asc