package com.banking.customer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.mysql.MySQLContainer;

@SpringBootTest
@Testcontainers
class CustomerServiceApplicationTests {

	@Container
	@ServiceConnection
	static MySQLContainer mysql =
			new MySQLContainer("mysql:8.4")
					.withDatabaseName("customer_test_db")
					.withUsername("testuser")
					.withPassword("testpass");

	@Test
	void contextLoads() {
	}
}
