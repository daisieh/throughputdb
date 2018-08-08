package com.mapmydata.throughputdb.annotation;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mapmydata.throughputdb.account.Account;
import com.mapmydata.throughputdb.person.Person;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.net.URI;

@NodeEntity
public class Annotation {
    @Id
    @GeneratedValue
    protected Long id;

    @JsonIgnore

    @Relationship(type="CREATED_BY")
    protected Account creator;

    protected URI target;
    protected String body;

    public Annotation() {}

    public Annotation(URI target, String body, Account creator) {
        this.target = target;
        this.body = body;
        this.creator = creator;
    }

    public Long getId() {
        return id;
    }

    public URI getTarget() {
        return target;
    }

    public void setTarget(URI target) {
        this.target = target;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Account getCreator() {
        return creator;
    }

    public void setCreator(Account person) {
        this.creator = person;
    }
}