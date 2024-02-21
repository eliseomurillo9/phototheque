package fr.epsi.project.phototheque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
public class PhotothequeApplication {

	public static void main(String[] args) {

		SpringApplication.run(PhotothequeApplication.class, args);
	}

}
