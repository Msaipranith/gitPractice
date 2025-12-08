CREATE TABLE employee (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    emp_name VARCHAR(100) NOT NULL,
    emp_location VARCHAR(100) NOT NULL,
    emp_email VARCHAR(150) NOT NULL,
    salary DECIMAL(10,2),
    created_at DATE,
    updated_at DATE
);
