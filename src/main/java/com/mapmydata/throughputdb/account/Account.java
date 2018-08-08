package com.mapmydata.throughputdb.account;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mapmydata.throughputdb.annotation.Annotation;
import com.mapmydata.throughputdb.person.Person;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

import java.net.URI;
import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    @JsonIgnore
    private String password;

    private Person person;

    private Set<Annotation> annotations = new HashSet<>();

    public Account() {}

    public Account(final String username, final String password, final String orcid) {
        this.username = username;
        this.password = password;
        this.person = new Person(URI.create(orcid), username);
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Set<Annotation> getAnnotations() {
        return annotations;
    }

    public URI getOrcid() {
        return person.getOrcid();
    }
}