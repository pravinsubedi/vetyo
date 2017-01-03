package com.vetyo.service;

import com.vetyo.dto.AdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Admin on 1/3/2017.
 */
@Service
public class AdService {
    @Autowired
    AdRepository adRepository;

}
