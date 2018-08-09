package com.mapmydata.throughputdb;

import com.mapmydata.throughputdb.account.Account;
import com.mapmydata.throughputdb.account.AccountRepository;
import com.mapmydata.throughputdb.annotation.AnnotationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableOAuth2Sso
public class ThroughputdbApplication {
	Logger logger = LoggerFactory.getLogger("com.mapmydata.throughputdb.ThroughputdbApplication");

	public static void main(String[] args) {
		SpringApplication.run(ThroughputdbApplication.class, args);
	}

	@Bean
	CommandLineRunner init(AccountRepository accountRepository, AnnotationRepository annotationRepository) {
		return args -> {
			accountRepository.deleteAll();
			annotationRepository.deleteAll();

			Account account = new Account("daisieh", "sidwell", "https://orcid.org/0000-0002-1497-1284");

			accountRepository.save(account);
		};
	}
}
