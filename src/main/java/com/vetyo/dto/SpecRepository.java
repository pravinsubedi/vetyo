package com.vetyo.dto;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.transaction.Transactional;

/**
 * Created by Admin on 1/16/2017.
 */
@Transactional
public interface SpecRepository extends PagingAndSortingRepository<com.vetyo.model.Specification,Long> {

}
