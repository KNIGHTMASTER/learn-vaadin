package com.zisal.learn.vaadin.data;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

/**
 * Created by Ladies Man on 5/18/2016.
 */
@Repository
public interface RepoBarcode extends PagingAndSortingRepository<EntityBarcode, BigInteger> {
}
