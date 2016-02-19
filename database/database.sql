create table diary (
  id 				BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
  title 			varchar(50) NOT NULL,
  post  			varchar(2000) NOT NULL,
  create_date 		timestamp NOT NULL,
  last_update_date	timestamp NOT NULL,
  PRIMARY KEY (id)
);