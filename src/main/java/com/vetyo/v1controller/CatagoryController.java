package com.vetyo.v1controller;

import com.vetyo.model.Catagory;
import com.vetyo.service.CatagoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Created by Admin on 1/3/2017.
 */
@RestController
@RequestMapping("/v1")
public class CatagoryController {

    @Autowired
    CatagoryService catagoryService;
    @RequestMapping(method = RequestMethod.POST,value = "/catagory")
    @ResponseBody
    public ResponseEntity<Catagory> addCatagory(@RequestBody Catagory catagory){
        return catagoryService.addCatagory(catagory);
    }
    @RequestMapping(method = RequestMethod.GET,value = "/catagory")
    public ResponseEntity<Page<Catagory>> getAllCatagory(Pageable pageable){
        return catagoryService.getAllCatagory(pageable);
    }
    @RequestMapping(method = RequestMethod.GET,value = "/catagory/{id}")
    public ResponseEntity<Catagory> getCatagoryById(@PathVariable Long id){
        return catagoryService.getCatagoryById(id);
    }

}
