package io.datcord;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main class for the Spring Boot application.
 *
 * This is the entry point of the Datcord backend application, which is
 * annotated with @SpringBootApplication to mark it as a Spring Boot application.
 * The main method uses Spring Boot's SpringApplication.run() method to launch the application.
 */
@SpringBootApplication
public class Application {

	/**
	 * The main method which serves as the entry point for the application.
	 *
	 * @param args Command line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
