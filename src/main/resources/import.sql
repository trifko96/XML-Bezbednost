--insert into users (username, password) values ('admin', 'admin');
--insert into users (username, password) values ('admin2', 'admin2');

--insert into certificates (korenski, datum_izdavanja, datum_isteka, dozvola_za_izdavanje, povucen) values (true, '2019-02-15', '2030-06-15', true, false);
--insert into certificates (korenski, datum_izdavanja, datum_isteka, dozvola_za_izdavanje, povucen, id_nad_sertifikata) values (false, '2019-02-15', '2020-11-05', false, false, 1);
--insert into certificates (korenski, datum_izdavanja, datum_isteka, dozvola_za_izdavanje, povucen, id_nad_sertifikata) values (false, '2019-03-15', '2020-04-15', false, false, 1);
--insert into certificates (korenski, datum_izdavanja, datum_isteka, dozvola_za_izdavanje, povucen, ime_aplikacije) values (true, '2019-02-15', '2030-06-15', true, false, 'aplikacija1');
--insert into certificates (korenski, datum_izdavanja, datum_isteka, dozvola_za_izdavanje, povucen, id_nad_sertifikata, ime_aplikacije) values (false, '2019-02-15', '2020-11-05', false, false, 1, 'aplikacija2');
--insert into certificates (korenski, datum_izdavanja, datum_isteka, dozvola_za_izdavanje, povucen, id_nad_sertifikata, ime_aplikacije) values (false, '2019-03-15', '2020-04-15', false, false, 1, 'aplikacija3');


insert into users (name, surname, password, phone_number, email) values ('Admin', 'Admin', '$2a$10$MTQHmq61pABuQ0tMc8FD8OSQwyIW8DKw4yIrum4B8yJvcTb8rDhYS', '062/111-1111', 'admin@gmail.com');
insert into users (name, surname, password, phone_number, email) values ('Agent', 'Agent', '$2a$10$8vRroz7zH8ntJUy96iytbOnwXcKge9WcQw4ZFxB5j/1MEbM0pibky', '063/222-2222', 'agent@gmail.com');
insert into users (name, surname, password, phone_number, email) values ('User', 'User', '$2a$10$rXESfhzPmCmKBFYu/4IP6OjxIeXgpI0JnbHBgpmMLdS9BHKG7PX/a', '064/111-1111', 'user@gmail.com');

insert into user_roles(id,name) values (1, 'ROLE_ADMIN');
insert into user_roles(id,name) values (2, 'ROLE_AGENT');
insert into user_roles(id,name) values (3, 'ROLE_USER');

insert into users_roles(user_id, role_id) values (1, 1);
insert into users_roles(user_id, role_id) values (1, 3);

insert into users_roles(user_id, role_id) values (2, 2);
insert into users_roles(user_id, role_id) values (2, 3);

insert into users_roles(user_id, role_id) values (3, 3);