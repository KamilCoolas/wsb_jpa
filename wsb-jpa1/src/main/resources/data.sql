insert into address (id, address_line1, address_line2, city, postal_code)
            values (901, 'xx', 'yy', 'city', '60-400');
insert into address (id, address_line1, address_line2, city, postal_code)
            values (902, 'abc', 'def', 'city', '60-401');
insert into doctor (id, address_entity, doctor_number, email, first_name, last_name, telephone_number, specialization)
            values (1, 901, '5', 'email@email', 'Adam', 'Johnson', '1234', 'SURGEON');
insert into patient (id, address_entity, date_of_birth, patient_number, email, first_name, last_name, telephone_number, external_id)
            values (1, 902, '1998-12-31', 5, 'email@email', 'John', 'Adamson', '54321', 15);
insert into visit (time, description, patient_entity_id, doctor_entity_id)
            values ('2022-12-31 23.59.59', 'Just Visit', 1, 1);
insert into visit (time, description, patient_entity_id, doctor_entity_id)
            values ('2023-12-31 23.59.59', 'Just Visit2', 1, 1);
insert into visit (time, description, patient_entity_id, doctor_entity_id)
            values ('2024-12-31 23.59.59', 'Just Visit3', 1, 1);
insert into visit (time, description, patient_entity_id, doctor_entity_id)
            values ('2020-12-31 23.59.59', 'Just Visit4',1 ,1);
insert into medical_treatment (id, visit_entity_id, description, type)
            values (1,1,'EKG Treatment','EKG');
insert into medical_treatment (id, visit_entity_id, description, type)
            values (2,1,'USG Treatment','USG');
insert into medical_treatment (id, visit_entity_id, description, type)
            values (3,2,'RTG Treatment','RTG');
insert into medical_treatment (id, visit_entity_id, description, type)
            values (4,2,'USG Treatment','USG');
insert into medical_treatment (id, visit_entity_id, description, type)
            values (5,3,'USG Treatment','USG');
insert into medical_treatment (id, visit_entity_id, description, type)
            values (6,4,'RTG Treatment','RTG');
insert into medical_treatment (id, visit_entity_id, description, type)
            values (7,4,'EKG Treatment','EKG');
insert into medical_treatment (id, visit_entity_id, description, type)
            values (8,4,'USG Treatment','USG');
-- Adresy
insert into address (id, address_line1, address_line2, city, postal_code)
values (903, 'main st', 'apt 1', 'city', '60-402'),
       (904, 'oak st', 'apt 2', 'city', '60-403'),
       (905, 'pine st', 'apt 3', 'city', '60-404'),
       (906, 'elm st', 'apt 4', 'city', '60-405');

-- Lekarze (z nowymi imionami i specjalizacjami)
insert into doctor (id, address_entity, doctor_number, email, first_name, last_name, telephone_number, specialization)
values (2, 903, '6', 'dr.marta@hospital', 'Marta', 'Nowak', '1001', 'GP'),
       (3, 904, '7', 'dr.tomasz@hospital', 'Tomasz', 'Kowalski', '1002', 'DERMATOLOGIST');

-- Pacjenci (z nowymi imionami)
insert into patient (id, address_entity, date_of_birth, patient_number, email, first_name, last_name, telephone_number, external_id)
values (2, 905, '1985-05-20', 6, 'ewa@example.com', 'Ewa', 'Kaczmarek', '2222', 16),
       (3, 906, '1970-11-15', 7, 'jan@example.com', 'Jan', 'Wiśniewski', '3333', 17);

-- Wizyty
insert into visit (time, description, patient_entity_id, doctor_entity_id)
values ('2023-01-10 10:00:00', 'Routine Check', 2, 2),
       ('2023-06-20 14:00:00', 'Follow-up', 2, 2),
       ('2024-03-05 09:00:00', 'Consultation', 3, 3),
       ('2024-07-15 16:30:00', 'Initial Visit', 3, 3);

-- Leczenia (tylko USG, EKG, RTG)
insert into medical_treatment (id, visit_entity_id, description, type)
values (9, 5, 'USG Treatment', 'USG'),
       (10, 5, 'EKG Treatment', 'EKG'),
       (11, 6, 'RTG Treatment', 'RTG'),
       (12, 7, 'USG Treatment', 'USG'),
       (13, 8, 'EKG Treatment', 'EKG');
