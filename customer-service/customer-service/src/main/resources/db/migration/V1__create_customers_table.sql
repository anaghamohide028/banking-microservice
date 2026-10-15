CREATE TABLE customers (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           customer_number VARCHAR(20) NOT NULL UNIQUE,
                           first_name VARCHAR(100) NOT NULL,
                           last_name VARCHAR(100) NOT NULL,
                           email VARCHAR(150) NOT NULL UNIQUE,
                           phone_number VARCHAR(20) NOT NULL,
                           status VARCHAR(30) NOT NULL,
                           created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                           updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
                               ON UPDATE CURRENT_TIMESTAMP
);