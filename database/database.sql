create table diary (
  id 				BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
  title 			varchar(50) NOT NULL,
  post  			varchar(2000) NOT NULL,
  create_date 		timestamp NOT NULL,
  last_update_date	timestamp NOT NULL,
  PRIMARY KEY (id)
);

insert into diary (title, post) values ('My vacations', 'My vacations were boring');
insert into diary (title, post) values ('My Job', 'My job is awesome!');
insert into diary (title, post) values ('Kung Pow', 'You should be able to beat him now!');
insert into diary (title, post) values ('Kung Pow', 'You should be able to beat him now!');

SELECT id, title, post FROM diary ORDER BY id;