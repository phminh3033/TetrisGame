CREATE TABLE player_name
(
	id int IDENTITY(1,1) PRIMARY KEY,  
	name varchar (20),   
	score int,
); 

drop table player_name;


select * from player_name;

delete from player_name where id = 3

