
INSERT INTO autores (nombre, nacionalidad) VALUES ('Miguel de Cervantes', 'Española');
INSERT INTO autores (nombre, nacionalidad) VALUES ('J.K. Rowling', 'Británica');
INSERT INTO autores (nombre, nacionalidad) VALUES ('J.R.R. Tolkien', 'Británica');

INSERT INTO categorias (nombre) VALUES ('Novela de Caballería');
INSERT INTO categorias (nombre) VALUES ('Fantasía');
INSERT INTO categorias (nombre) VALUES ('Ciencia Ficción');

INSERT INTO libros (titulo, autor_id, categoria_id) VALUES ('Don Quijote de la Mancha', 1, 1);
INSERT INTO libros (titulo, autor_id, categoria_id) VALUES ('Harry Potter y la Piedra Filosofal', 2, 2);
INSERT INTO libros (titulo, autor_id, categoria_id) VALUES ('El Señor de los Anillos', 3, 3);