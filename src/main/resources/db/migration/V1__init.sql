CREATE TABLE IF NOT EXISTS worker (
    id SERIAL PRIMARY KEY,
    worker_name VARCHAR(100) NOT NULL,
    position VARCHAR(100),
    age INT,
    salary DECIMAL(10, 2)
    );

CREATE TABLE IF NOT EXISTS animal (
    id SERIAL PRIMARY KEY,
    animal_type VARCHAR(100) NOT NULL,
    breed VARCHAR(100),
    age INT,
    gender VARCHAR(10),
    caretaker_id INT,
    FOREIGN KEY (caretaker_id) REFERENCES worker(id)
    );
