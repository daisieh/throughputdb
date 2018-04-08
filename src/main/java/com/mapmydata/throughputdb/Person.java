package com.mapmydata.throughputdb;


import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Person {

    private Long id;

    private String firstName;
    private String lastName;
    private String orcid;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOrcid() {
        return orcid;
    }

    public void setOrcid(String orcid) {
        this.orcid = orcid;
    }
}