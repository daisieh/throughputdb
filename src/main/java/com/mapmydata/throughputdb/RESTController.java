package com.mapmydata.throughputdb;

import com.mapmydata.throughputdb.account.Account;
import com.mapmydata.throughputdb.account.AccountRepository;
import com.mapmydata.throughputdb.annotation.Annotation;
import com.mapmydata.throughputdb.annotation.AnnotationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;
import java.util.NoSuchElementException;

@RestController
public class RESTController {
    private final AnnotationRepository annotationRepository;
    private final AccountRepository accountRepository;

    @Autowired
    RESTController(AnnotationRepository annotationRepository, AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
        this.annotationRepository = annotationRepository;
    }

    @RequestMapping(value = "/{userId}/annotations", method = RequestMethod.GET)
    Collection<Annotation> readAnnotations(@PathVariable String userId) {
        System.out.println("hello");
        Account account = this.validateUser(userId);
        return this.annotationRepository.findAnnotationsByCreator(account);
    }

    @RequestMapping(value = "/{userId}/annotations", method = RequestMethod.POST)
    ResponseEntity<?> add(@PathVariable String userId, @RequestBody Annotation input) {
        System.out.println("hello");
        Account account = this.validateUser(userId);
        if (account != null) {
            try {
                Annotation result = new Annotation(input.getTarget(), input.getBody(), account);
                annotationRepository.save(result);
                URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId()).toUri();
                return ResponseEntity.created(location).build();
            } catch (NoSuchElementException e) {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.noContent().build();
    }

    private Account validateUser(String userId) {
        return this.accountRepository.findByUsername(userId).orElseThrow(
                () -> new UserNotFoundException(userId));
    }
}
