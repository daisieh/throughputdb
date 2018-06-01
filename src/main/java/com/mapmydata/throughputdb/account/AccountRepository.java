package com.mapmydata.throughputdb.account;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {
    Optional<Account> findByUsername(String username);

}