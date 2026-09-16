# Write your MySQL query statement below
with duplicateEmails as (
    select p1.id from Person p1
    Join Person p2
    on p1.email = p2.email
    where p1.id >p2.id
)
delete from Person where id in (select id from duplicateEmails);