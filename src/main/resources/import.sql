# Books
insert into book(title, author, isbn, version) values('Nineteen Eighty Four', 'George Orwell', '0000000000-001', 1);
insert into book(title, author, isbn, version) values('Uncle Tom''s Cabin', 'Harriet Beecher Stowe', '0000000000-002', 1);
insert into book(title, author, isbn, version) values('Moby Dick or The Whale', 'Hermann Melville', '0000000000-003', 1);

# Passengers
insert into passenger(id, firstName, lastName, type, dateOfBirth) values(1, 'Buddy', 'Holly', 'REGULAR', '1983-07-15');
insert into passenger(id, firstName, lastName, type, dateOfBirth) values(2, 'Richie', 'Vallens', 'OCCASIONAL', '1973-05-26');

# Films
insert into director(id, name) values(1, 'Edward Zwick');

insert into film(id, title, length, genre, director_id) values(1, 'Legends of the Fall', 133, 'drama', 1);

insert into actor(id, firstName, gender, lastName, age) values(1, 'Brad', 'male', 'Pitt', 45);
insert into actor(id, firstName, gender, lastName, age) values(2, 'Anthony', 'female', 'Hopkins', 67);

insert into film_actor(film_id, actor_id) values(1, 1);
insert into film_actor(film_id, actor_id) values(1, 2);