package com.mapmydata.throughputdb.annotation;

import java.util.List;

import com.mapmydata.throughputdb.annotation.Annotation;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "annotations", path = "annotations")
public interface AnnotationRepository extends PagingAndSortingRepository<Annotation, Long> {

    List<Annotation> findAnnotationByTarget(@Param("target") String target);

}