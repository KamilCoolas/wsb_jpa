insert into address (id, address_line1, address_line2, city, postal_code)
            values (901, 'xx', 'yy', 'city', '60-400');
insert into address (id, address_line1, address_line2, city, postal_code)
            values (902, 'abc', 'def', 'city', '60-401');
insert into doctor (id, address_entity, doctor_number, email, first_name, last_name, telephone_number, specialization)
            values (1, 901, '5', 'email@email', 'Adam', 'Johnson', '1234', 'SURGEON');
insert into patient (id, address_entity, date_of_birth, patient_number, email, first_name, last_name, telephone_number)
            values (1, 902, '1998-12-31', 5, 'email@email', 'John', 'Adamson', '54321');
insert into visit (id, time, description)
            values (1, '2022-12-31 23.59.59', 'Just Visit');
insert into visit (id, time, description)
            values (2, '2023-12-31 23.59.59', 'Just Visit2');
insert into visit (id, time, description)
            values (3, '2024-12-31 23.59.59', 'Just Visit3');
insert into visit (id, time, description)
            values (4, '2020-12-31 23.59.59', 'Just Visit4');
insert into visit_to_doctor (doctor_id, visit_id)
            values (1,1);
insert into visit_to_doctor (doctor_id, visit_id)
            values (1,2);
insert into visit_to_patient (patient_id, visit_id)
            values (1,3);
insert into visit_to_patient (patient_id, visit_id)
            values (1,4);
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
