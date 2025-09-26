INSERT INTO vehicle_type (id, name) VALUES (1, 'CAR');
INSERT INTO vehicle_type (id, name) VALUES (2, 'MOTORCYCLE');

INSERT INTO parking (id,address, carcapacity, motorcapacity, availcarspot, availmotorspot ) VALUES(1, 'MENARA FIF' , 100 ,50,80,40);

INSERT INTO auth (id, username, password, role) VALUES (1, 'admin', '$2a$12$h.Va1nYgw/5nit7cZVJ.QOdchRz3jSroyiPgrjcNGBUSZl/eIbfMq' , 'ROLE_ADMIN');