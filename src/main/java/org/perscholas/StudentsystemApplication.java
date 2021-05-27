package org.perscholas;

import lombok.extern.java.Log;
import org.perscholas.controllers.HomeController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log
public class StudentsystemApplication {

	public static void main(String[] args) {

		SpringApplication.run(StudentsystemApplication.class, args);

	}

}
