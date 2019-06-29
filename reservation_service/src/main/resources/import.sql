insert into user (user_id, name, surname, email, password, username, role) values (1, 'Petar', 'Petrovic', 'admin@gmail.com', '$2a$10$jChdiiMSaPYPLHj6uMATKO/40fK/xojxb8uzMjc9ACZLG/QC4PpYK', 'admin', 0);
insert into user (user_id, name, surname, email, password, username, role, status) values (2, 'User', 'User', 'user@gmail.com', '$2a$10$jChdiiMSaPYPLHj6uMATKO/40fK/xojxb8uzMjc9ACZLG/QC4PpYK', 'user', 1, 1);
insert into user (user_id, name, surname, email, password, username, role, business_id) values (3, 'Agent', 'Agent', 'agent@gmail.com', '$2a$10$jChdiiMSaPYPLHj6uMATKO/40fK/xojxb8uzMjc9ACZLG/QC4PpYK', 'agent', 2, '4');
insert into accommodation_type (id, name) values (1, 'hotel');
insert into accommodation_service (accommodation_service_id, name) values (1, 'WiFi')
