package com.vetyo.v1controller;

import com.vetyo.model.Ad;
import com.vetyo.service.AdService;
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
public class AdController {
    @Autowired
    AdService adService;

    @RequestMapping(value = "/ad",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Ad> addNewAd (@RequestBody Ad ad){
        return adService.addNewAd(ad);
    }

    @RequestMapping(value = "/ad",method = RequestMethod.GET)
    public ResponseEntity<Page<Ad>> getAllAd (Pageable pageable){
        return adService.getAllAd(pageable);
    }

    @RequestMapping(value = "/ad/{id}",method = RequestMethod.GET)
    public ResponseEntity<Ad> getAdById(@PathVariable Long id){
        return adService.getAdById(id);
    }
}
