package com.contacts;

import com.contacts.dependency.DaggerServiceComponent;
import com.contacts.dependency.ServiceComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContactBookApplication {
	public static final ServiceComponent component = DaggerServiceComponent.create();

	public static void main(String[] args) {
		SpringApplication.run(ContactBookApplication.class, args);

	}

}
