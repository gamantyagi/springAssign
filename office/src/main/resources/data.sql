
CREATE TABLE IF NOT EXISTS location(
		location_id SERIAL PRIMARY KEY,
 		name VARCHAR(25) NOT NULL
);


CREATE TABLE IF NOT EXISTS department(
		department_id SERIAL PRIMARY KEY,
		name VARCHAR(25) NOT NULL,
		location_id INT,
		
		CONSTRAINT fk_location_id
		FOREIGN KEY(location_id)
		REFERENCES location(location_id)
);


CREATE TABLE IF NOT EXISTS employee(
		employee_id SERIAL PRIMARY KEY,
		name VARCHAR(25) NOT NULL,
		email VARCHAR(40),
		age INT,
		salary INT, 
		manager_id INT DEFAULT NULL, 
		address VARCHAR(100),
		department_id INT,
		
		
		CONSTRAINT min_and_max_age
		CHECK(age>=18 AND age<=60),
		
		CONSTRAINT fk_employee_id
		FOREIGN KEY(manager_id)
		REFERENCES employee(employee_id)
		ON DELETE SET DEFAULT,
		
		CONSTRAINT fk_department_id
		FOREIGN KEY(department_id)
		REFERENCES department(department_id)
);


