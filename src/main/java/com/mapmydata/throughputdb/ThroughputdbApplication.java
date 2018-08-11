package com.mapmydata.throughputdb;

import com.mapmydata.throughputdb.account.Account;
import com.mapmydata.throughputdb.account.AccountRepository;
import com.mapmydata.throughputdb.annotation.AnnotationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

@SpringBootApplication
public class ThroughputdbApplication extends WebSecurityConfigurerAdapter {
	Logger logger = LoggerFactory.getLogger("com.mapmydata.throughputdb.ThroughputdbApplication");

	public static void main(String[] args) {
		SpringApplication.run(ThroughputdbApplication.class, args);
	}

	@Bean("authenticationManager")
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	CommandLineRunner init(AccountRepository accountRepository, AnnotationRepository annotationRepository) {
		return args -> {
			accountRepository.deleteAll();
			annotationRepository.deleteAll();

			Account account = new Account("daisieh", "sidwell", "https://orcid.org/0000-0002-1497-1284");

			accountRepository.save(account);

			UsernamePasswordAuthenticationToken authReq
					= new UsernamePasswordAuthenticationToken("daisieh", "sidwell");
			Authentication auth = authenticationManager().authenticate(authReq);
			SecurityContext sc = SecurityContextHolder.getContext();
			sc.setAuthentication(auth);
		};
	}
}
