

Confirmation Rate - leetcode 1934

select s.user_id, 
    round (case 
        when count(c.action) = 0 then 0
        else 
            count(case when c.action = 'confirmed' then 1 end) * 1.0 /
            ( count(case when c.action = 'timeout' then 1 end) + 
              count(case when c.action = 'confirmed' then 1 end)
             )
    end ,2 ) as confirmation_rate
 from signups s 
left join confirmations c on s.user_id = c.user_id
group by s.user_id;


Monthly Transactions I------------------

SELECT 
    date_format(t.trans_date, '%Y-%m') AS month,  -- for clarity, group by year+month
    t.country, 
    COUNT(*) AS trans_count,  
    SUM(t.amount) AS trans_total_amount,
    SUM(CASE WHEN t.state = 'approved' THEN 1 ELSE 0 END) AS approved_count,
    SUM(CASE WHEN t.state = 'approved' THEN t.amount ELSE 0 END) AS approved_total_amount
FROM 
    transactions t 
GROUP BY 
    month(t.trans_date),
    t.country;


----------------------------------------