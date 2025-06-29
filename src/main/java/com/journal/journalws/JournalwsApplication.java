package com.journal.journalws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
		org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class
})
public class JournalwsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JournalwsApplication.class, args);
	}

}
