package com.zisal.learn.vaadin.data;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.math.BigInteger;

/**
 * Created by Ladies Man on 4/22/2016.
 */
public interface RepoEmployee  extends PagingAndSortingRepository<EntityEmployee, BigInteger>{

}
