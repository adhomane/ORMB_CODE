select NVL(sum(tot_amt),0) from ci_ft 
where parent_id=bill_id and  parent_id='346311949257' ;
/*used to get bill amount here parent_id=bill_id is neccessary 
since when we cancel bill segment and regenrate bill segment rthen earlier bill seg gets delinked from biill_id in ct_ft mean to say for that bill seg row bill id 
column gets blank but parent id for that bill seg remains same even if bill_id column gets blank*/

select NVL(sum(tot_amt),0) from ci_ft where PARENT_ID <> BILL_ID AND BILL_ID='346311949257' ; /*used to get adjustment on bill*/

select * from ci_per;