package com.vetyo.service;

import com.vetyo.dto.CatagoryRepository;
import com.vetyo.exception.ResourceNotFoundException;
import com.vetyo.model.Catagory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Created by Admin on 1/3/2017.
 */
@Service
public class CatagoryService {
    @Autowired
    CatagoryRepository catagoryRepository;
    public ResponseEntity<Catagory> addCatagory(Catagory catagory){
        catagoryRepository.save(catagory);
        return new ResponseEntity<Catagory>(catagoryRepository.findOne(catagory.getCid()), HttpStatus.CREATED);
    }

    public ResponseEntity<Iterable<Catagory>> getAllCatagory(){
        return new ResponseEntity<Iterable<Catagory>>(catagoryRepository.findAll(),HttpStatus.OK);
    }

    public ResponseEntity<Catagory> getCatagoryById(Long id){
        if (catagoryRepository.findOne(id)==null){
            throw  new ResourceNotFoundException("catagory with id"+id+"not found");
        }
        return new ResponseEntity<Catagory>(catagoryRepository.findOne(id),HttpStatus.OK);
    }
}
