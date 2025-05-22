-- Conserjes (10)
INSERT INTO conserje (id, nombre, email, password, identificacion) VALUES
                                                                       (1, 'Juan Pérez', 'juan@uni.edu', '1234', '10001'),
                                                                       (2, 'Ana Gómez', 'ana@uni.edu', '5678', '10002'),
                                                                       (3, 'Luis Martínez', 'luis@uni.edu', 'pass123', '10003'),
                                                                       (4, 'Sofía Ramírez', 'sofia@uni.edu', 'sofiapass', '10004'),
                                                                       (5, 'Diego Herrera', 'diego@uni.edu', 'diegopass', '10005'),
                                                                       (6, 'Carla Fernández', 'carla@uni.edu', 'carlapass', '10006'),
                                                                       (7, 'Andrés Morales', 'andres@uni.edu', 'andres123', '10007'),
                                                                       (8, 'Mariana Ruiz', 'mariana@uni.edu', 'mari1234', '10008'),
                                                                       (9, 'Ricardo Torres', 'ricardo@uni.edu', 'rico456', '10009'),
                                                                       (10, 'Patricia Vega', 'patricia@uni.edu', 'patvega', '10010');

-- Estudiantes (10)
INSERT INTO estudiante (id, nombre, email, password, identificacion, codigo) VALUES
                                                                                 (1, 'María López', 'maria@uni.edu', 'abcd', '20001', 'EST123'),
                                                                                 (2, 'Pedro Sánchez', 'pedro@uni.edu', 'xyz789', '20002', 'EST124'),
                                                                                 (3, 'Laura Torres', 'laura@uni.edu', 'abcd123', '20003', 'EST125'),
                                                                                 (4, 'Ana Beltrán', 'ana.b@uni.edu', 'anapass', '20004', 'EST126'),
                                                                                 (5, 'Javier Gómez', 'javier@uni.edu', 'javier123', '20005', 'EST127'),
                                                                                 (6, 'Lucía Mendoza', 'lucia@uni.edu', 'luciapass', '20006', 'EST128'),
                                                                                 (7, 'Carlos Medina', 'carlos@uni.edu', 'carlospass', '20007', 'EST129'),
                                                                                 (8, 'Sofía Castro', 'sofia.c@uni.edu', 'sofiapass', '20008', 'EST130'),
                                                                                 (9, 'Andrés Ríos', 'andres@uni.edu', 'andres123', '20009', 'EST131'),
                                                                                 (10, 'Valeria Sánchez', 'valeria@uni.edu', 'vale123', '20010', 'EST132');

-- Profesores (10)
INSERT INTO profesor (id, nombre, email, password, identificacion) VALUES
                                                                       (1, 'Carlos Ruiz', 'carlos@uni.edu', 'qwerty', '30001'),
                                                                       (2, 'Marta Díaz', 'marta@uni.edu', 'asdfg', '30002'),
                                                                       (3, 'Jorge Castillo', 'jorge@uni.edu', 'zxcvb', '30003'),
                                                                       (4, 'Elena Pérez', 'elena@uni.edu', 'elena123', '30004'),
                                                                       (5, 'David López', 'david@uni.edu', 'davidpass', '30005'),
                                                                       (6, 'María Torres', 'maria.t@uni.edu', 'maria2025', '30006'),
                                                                       (7, 'Andrés Gómez', 'andresg@uni.edu', 'andrespass', '30007'),
                                                                       (8, 'Sofía Martínez', 'sofia.m@uni.edu', 'sofiapass', '30008'),
                                                                       (9, 'Pablo Herrera', 'pablo@uni.edu', 'pablo123', '30009'),
                                                                       (10, 'Lucía Fernández', 'luciaf@uni.edu', 'lucia456', '30010');

-- Espacios (15)
INSERT INTO espacio (id, nombre, capacidad, tipo) VALUES
                                                      (1, 'Aula 101', 40, 'Aula'),
                                                      (2, 'Auditorio Principal', 150, 'Auditorio'),
                                                      (3, 'Laboratorio 202', 30, 'Laboratorio'),
                                                      (4, 'Sala de Conferencias', 60, 'Sala'),
                                                      (5, 'Aula 102', 45, 'Aula'),
                                                      (6, 'Aula 103', 35, 'Aula'),
                                                      (7, 'Laboratorio 203', 25, 'Laboratorio'),
                                                      (8, 'Biblioteca Principal', 80, 'Biblioteca'),
                                                      (9, 'Sala de Estudio', 50, 'Sala'),
                                                      (10, 'Auditorio Secundario', 100, 'Auditorio'),
                                                      (11, 'Aula 104', 40, 'Aula'),
                                                      (12, 'Laboratorio 204', 28, 'Laboratorio'),
                                                      (13, 'Sala de Proyección', 70, 'Sala'),
                                                      (14, 'Auditorio Pequeño', 60, 'Auditorio'),
                                                      (15, 'Aula Magna', 200, 'Aula');

-- Horarios (10)
INSERT INTO horario (id, hora_inicio, hora_fin, espacio_id) VALUES
                                                                (1, '2025-05-22 08:00:00', '2025-05-22 10:00:00', 1),
                                                                (2, '2025-05-22 10:00:00', '2025-05-22 12:00:00', 2),
                                                                (3, '2025-05-22 12:00:00', '2025-05-22 14:00:00', 3),
                                                                (4, '2025-05-22 14:00:00', '2025-05-22 16:00:00', 4),
                                                                (5, '2025-05-22 16:00:00', '2025-05-22 18:00:00', 5),
                                                                (6, '2025-05-23 08:00:00', '2025-05-23 10:00:00', 6),
                                                                (7, '2025-05-23 10:00:00', '2025-05-23 12:00:00', 7),
                                                                (8, '2025-05-23 12:00:00', '2025-05-23 14:00:00', 8),
                                                                (9, '2025-05-23 14:00:00', '2025-05-23 16:00:00', 9),
                                                                (10, '2025-05-23 16:00:00', '2025-05-23 18:00:00', 10);

-- Reportes (10)
INSERT INTO reporte (id, descripcion, conserje_id, espacio_id) VALUES
                                                                   (1, 'Proyector dañado', 1, 1),
                                                                   (2, 'Aire acondicionado no funciona', 2, 3),
                                                                   (3, 'Sillas rotas', 3, 4),
                                                                   (4, 'Luz parpadea', 4, 5),
                                                                   (5, 'Puerta atascada', 5, 6),
                                                                   (6, 'Falta de limpieza', 6, 7),
                                                                   (7, 'Sistema de sonido averiado', 7, 8),
                                                                   (8, 'Ventanas rotas', 8, 9),
                                                                   (9, 'Calefacción no enciende', 9, 10),
                                                                   (10, 'Pared con humedad', 10, 11);

-- Reservas (10)
INSERT INTO reserva (id, estudiante_id, espacio_id, horario_id) VALUES
                                                                    (1, 1, 1, 1),
                                                                    (2, 2, 3, 3),
                                                                    (3, 3, 4, 4),
                                                                    (4, 4, 5, 5),
                                                                    (5, 5, 6, 6);

INSERT INTO reserva (id, profesor_id, espacio_id, horario_id) VALUES
                                                                  (6, 6, 7, 7),
                                                                  (7, 7, 8, 8),
                                                                  (8, 8, 9, 9),
                                                                  (9, 9, 10, 10),
                                                                  (10, 10, 11, 2);
