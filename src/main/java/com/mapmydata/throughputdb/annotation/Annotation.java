package com.mapmydata.throughputdb.annotation;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mapmydata.throughputdb.person.Person;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Annotation {
    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnore

    @Relationship(type="CREATED_BY")
    private Person creator;

    private String target;
    private String body;

    public Annotation() {}

    public Annotation(String target, String body, Person creator) {
        this.target = target;
        this.body = body;
        this.creator = creator;
    }

    public Long getId() {
        return id;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Person getCreator() {
        return creator;
    }

    public void setCreator(Person person) {
        this.creator = person;
    }
}