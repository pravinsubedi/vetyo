package com.vetyo.service;

import com.vetyo.dto.SpecRepository;
import com.vetyo.exception.ResourceNotFoundException;
import com.vetyo.model.Ad;
import com.vetyo.model.Specification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Created by Admin on 1/16/2017.
 */
@Service
public class SpecService {
    @Autowired
    SpecRepository specRepository;

    public ResponseEntity<Specification> addNewSpec(Specification specification){
        specRepository.save(specification);
        return new ResponseEntity<Specification>(specRepository.findOne(specification.getSpec_id()),HttpStatus.OK);
    }
    public ResponseEntity<Page<Specification>> getAllSpec(Pageable pageable){
        return new ResponseEntity<Page<Specification>>(specRepository.findAll(pageable),HttpStatus.OK);
    }

    public ResponseEntity<Specification> getSpecById(Long id){
        if (specRepository.findOne(id)==null){
            throw new ResourceNotFoundException("Spec with ad id"+id+"not found");
        }
        return new ResponseEntity<Specification>(specRepository.findOne(id),HttpStatus.OK);
    }
}
