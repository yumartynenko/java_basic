-- Clear the students table before adding new data
DELETE FROM students;

-- Create the students table if it does not exist
CREATE TABLE IF NOT EXISTS students (
                                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                                        last_name TEXT NOT NULL,
                                        first_name TEXT NOT NULL,
                                        patronymic TEXT NOT NULL,
                                        birth_date DATE NOT NULL,
                                        record_book_number TEXT NOT NULL
);

-- Add students
INSERT INTO students (last_name, first_name, patronymic, birth_date, record_book_number)
VALUES
    ('Petrenko', 'Ivan', 'Serhiyovych', '2001-05-15', '12345'),
    ('Ivanov', 'Oleksandr', 'Viktorovych', '2000-03-12', '54321'),
    ('Shevchenko', 'Taras', 'Hryhorovych', '1999-07-10', '67890'),
    ('Kovalenko', 'Olena', 'Volodymyrivna', '2002-11-22', '11223'),
    ('Bondarenko', 'Mykola', 'Petrovych', '2001-05-05', '44556'),
    ('Sydorenko', 'Andriy', 'Ivanovych', '2000-01-17', '78901'),
    ('Kravchenko', 'Daryna', 'Serhiivna', '1998-04-29', '22334'),
    ('Bohdanov', 'Denys', 'Pavlovych', '1999-09-01', '33445'),
    ('Lysenko', 'Kateryna', 'Borysivna', '2000-12-15', '55667'),
    ('Maksymenko', 'Yulia', 'Andriyivna', '2002-03-03', '77889'),
    ('Vasyliev', 'Serhiy', 'Oleksandrovych', '2001-02-20', '99887'),
    ('Melnyk', 'Volodymyr', 'Vasylovych', '2001-08-25', '66778'),
    ('Khmara', 'Iryna', 'Yuriyivna', '2002-10-10', '33456'),
    ('Tkachenko', 'Yevhen', 'Mykhailovych', '1999-05-06', '11234'),
    ('Petrychenko', 'Roman', 'Oleksandrovych', '2000-07-19', '55688'),
    ('Moroz', 'Natalia', 'Leonidivna', '2001-01-09', '77890'),
    ('Zhuk', 'Vitalii', 'Anatoliiovych', '2002-02-28', '33467'),
    ('Poliakov', 'Kira', 'Oleksandrivna', '2001-01-13', '22345'),
    ('Hrebeniuk', 'Maxym', 'Oleksandrovych', '2000-09-17', '88990'),
    ('Zaychuk', 'Anastasia', 'Bohdanivna', '1999-12-12', '66799');
