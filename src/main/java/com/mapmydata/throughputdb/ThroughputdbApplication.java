package com.mapmydata.throughputdb;

import com.mapmydata.throughputdb.account.Account;
import com.mapmydata.throughputdb.account.AccountRepository;
import com.mapmydata.throughputdb.annotation.AnnotationRepository;
import com.mapmydata.throughputdb.person.Person;
import com.mapmydata.throughputdb.person.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ThroughputdbApplication {
	Logger logger = LoggerFactory.getLogger("com.mapmydata.throughputdb.ThroughputdbApplication");

	public static void main(String[] args) {
		SpringApplication.run(ThroughputdbApplication.class, args);
	}

	@Bean
	CommandLineRunner init(AccountRepository accountRepository, PersonRepository personRepository, AnnotationRepository annotationRepository) {
		return args -> {
			personRepository.deleteAll();
			accountRepository.deleteAll();
			annotationRepository.deleteAll();

			if (personRepository.findByFirstName("Daisie").size() == 0) {
				Person daisie = new Person("Daisie");
				daisie.setLastName("Huang");
				daisie.setOrcid("0000-0002-1497-1284");

				Account account = new Account("daisieh", "sidwell");
				account.setOrcid(daisie.getOrcid());

				personRepository.save(daisie);
				accountRepository.save(account);
			}
		};
	}
}
