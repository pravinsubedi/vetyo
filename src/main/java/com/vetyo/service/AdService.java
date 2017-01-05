package com.vetyo.service;

import com.vetyo.dto.AdRepository;
import com.vetyo.exception.ResourceNotFoundException;
import com.vetyo.model.Ad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Created by Admin on 1/3/2017.
 */
@Service
public class AdService {
    @Autowired
    AdRepository adRepository;

    public ResponseEntity<Ad> addNewAd(Ad ad){
        adRepository.save(ad);
        return new ResponseEntity<Ad>(adRepository.findOne(ad.getId()), HttpStatus.CREATED);
    }

    public ResponseEntity<Page<Ad>> getAllAd(Pageable pageable){
        return new ResponseEntity<Page<Ad>>(adRepository.findAll(pageable),HttpStatus.OK);
    }

    public ResponseEntity<Ad> getAdById(Long id){
        if (adRepository.findOne(id)==null){
            throw new ResourceNotFoundException("Ad with ad id"+id+"not found");
        }
        return new ResponseEntity<Ad>(adRepository.findOne(id),HttpStatus.OK);
    }

}
