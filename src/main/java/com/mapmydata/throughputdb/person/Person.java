package com.mapmydata.throughputdb.person;


import com.mapmydata.throughputdb.annotation.Annotation;
import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.net.URI;

// A Person is a special class of Annotation that uses ORCIDs for the targets.

@NodeEntity
public class Person extends Annotation {
    public Person() {};
    public Person(URI orcid, String body) {
        if (isValidOrcid(orcid)) {
            this.target = orcid;
            this.body = body;
        } else {
            throw new UsernameNotFoundException("invalid ORCID format");
        }
    }

    public URI getOrcid() {
        return target;
    }

    public void setOrcid(URI orcid) {
        this.target = orcid;
    }

    public static Boolean isValidOrcid(URI orcid) {
        return true;
    }
}