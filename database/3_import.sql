INSERT INTO public.role (id, name) VALUES (default, 'admin');
INSERT INTO public.role (id, name) VALUES (default, 'customer');

INSERT INTO public."user" (id, role_id, username, password, status) VALUES (default, 1, 'admin', '123', 'A');
INSERT INTO public."user" (id, role_id, username, password, status) VALUES (default, 2, 'rain', '123', 'A');
INSERT INTO public."user" (id, role_id, username, password, status) VALUES (default, 2, 'mitteaktiivne', '123', 'D');



INSERT INTO public.city (id, name) VALUES (default, 'Tartu');
INSERT INTO public.city (id, name) VALUES (default, 'Tallinn');
INSERT INTO public.city (id, name) VALUES (default, 'Pärnu');


INSERT INTO public.location (id, city_id, name, number_of_atms, status) VALUES (default, 2, 'Sikupilli Prisma', 5, 'A');
INSERT INTO public.location (id, city_id, name, number_of_atms, status) VALUES (default, 2, 'Tondi Selver', 3, 'A');
INSERT INTO public.location (id, city_id, name, number_of_atms, status) VALUES (default, 1, 'Sõbra Prisma', 2, 'A');


INSERT INTO public.transaction_type (id, name) VALUES (default, 'sularaha sisse');
INSERT INTO public.transaction_type (id, name) VALUES (default, 'sularaha välja');
INSERT INTO public.transaction_type (id, name) VALUES (default, 'maksed');


INSERT INTO public.location_transaction_type (id, location_id, transaction_type_id) VALUES (default, 1, 1);
INSERT INTO public.location_transaction_type (id, location_id, transaction_type_id) VALUES (default, 1, 2);
INSERT INTO public.location_transaction_type (id, location_id, transaction_type_id) VALUES (default, 1, 3);
INSERT INTO public.location_transaction_type (id, location_id, transaction_type_id) VALUES (default, 2, 2);

