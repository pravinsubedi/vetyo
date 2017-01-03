package com.vetyo.dto;

import com.vetyo.model.Ad;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Admin on 1/3/2017.
 */
public interface AdRepository extends PagingAndSortingRepository<Ad,Long> {
}
