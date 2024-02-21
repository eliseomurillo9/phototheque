package fr.epsi.project.phototheque;

import fr.epsi.project.phototheque.Configuration.SSLUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Launcher de l'application.
 */
@SpringBootApplication
public class PhotothequeApplication {

	public static void main(String[] args) {
		SSLUtils.disableSSLValidation();
		SpringApplication.run(PhotothequeApplication.class, args);
	}

}
