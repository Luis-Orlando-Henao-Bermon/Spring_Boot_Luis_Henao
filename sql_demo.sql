use jpademo;
insert into roles(name) values('User'),('Admin');
insert into personas(full_name, lastname, programing_language, role_id) values
('Maria', 'Lizarazo', 'Javascript',1),
('Yurley', 'Botello', 'Java', 2),
('Wilmer', 'Rojas', 'Java', 1),
('Adrian', 'Ruiz', 'Kotlin', 2);
insert into passport() values('2018-10-02',1,1,"NUM12345"),('2029-10-02',2,2,"NUM6789");
insert into project(name) values("proyecto Java");
insert into personas_proyects() values(1,1),(2,1);
