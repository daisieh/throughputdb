package com.mapmydata.throughputdb.annotation;

import java.net.URI;
import java.util.List;

import com.mapmydata.throughputdb.account.Account;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "annotations", path = "annotations")
public interface AnnotationRepository extends PagingAndSortingRepository<Annotation, Long> {

    List<Annotation> findAnnotationByTarget(@Param("target") URI target);

    List<Annotation> findAnnotationsByBody(@Param("body") String body);

    List<Annotation> findAnnotationsByCreator(@Param("orcid") Account creator);

}