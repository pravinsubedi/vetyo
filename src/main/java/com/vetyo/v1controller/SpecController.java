package com.vetyo.v1controller;

import com.vetyo.model.Ad;
import com.vetyo.model.Specification;
import com.vetyo.service.SpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Admin on 1/16/2017.
 */
@RestController
@RequestMapping("/v1")
public class SpecController {
    @Autowired
    SpecService specService;

    @RequestMapping(value = "/spec",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Specification> addNewAd (@RequestBody Specification specification){
        return specService.addNewSpec(specification);
    }

    @RequestMapping(value = "/spec",method = RequestMethod.GET)
    public ResponseEntity<Page<Specification>> getAllSpec (Pageable pageable){
        return specService.getAllSpec(pageable);
    }

    @RequestMapping(value = "/spec/{id}",method = RequestMethod.GET)
    public ResponseEntity<Specification> getSpecById(@PathVariable Long id){
        return specService.getSpecById(id);
    }
}
