
CREATE TABLE accounts (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,

                          account_number VARCHAR(30) NOT NULL UNIQUE,

                          customer_number VARCHAR(50) NOT NULL,

                          account_type VARCHAR(20) NOT NULL,

                          balance DECIMAL(19,2) NOT NULL DEFAULT 0.00,

                          status VARCHAR(20) NOT NULL,

                          created_at TIMESTAMP(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6),

                          updated_at TIMESTAMP(6) NOT NULL
                              DEFAULT CURRENT_TIMESTAMP(6)
                              ON UPDATE CURRENT_TIMESTAMP(6)
);

CREATE INDEX idx_accounts_customer_number
    ON accounts(customer_number);
