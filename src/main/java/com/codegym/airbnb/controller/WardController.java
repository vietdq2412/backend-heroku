package com.codegym.airbnb.controller;

import com.codegym.airbnb.model.District;
import com.codegym.airbnb.model.Ward;
import com.codegym.airbnb.service.district.DistrictService;
import com.codegym.airbnb.service.ward.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/wards")
public class WardController {
    @Autowired
    private WardService wardService;

    @Autowired
    private DistrictService districtService;

    @GetMapping
    public ResponseEntity<Iterable<Ward>> getAllWards(){
        return new ResponseEntity<>(wardService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ward> getApartmentById(@PathVariable Long id) {
        Optional<Ward> wardOptional = wardService.findById(id);
        return wardOptional.map(ward -> new ResponseEntity<>(ward, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/districts/{id}")
    public ResponseEntity<Iterable<Ward>> getAllWardsByDistricts(@PathVariable Long id){
        District district = districtService.findById(id).get();
        return new ResponseEntity<>(wardService.findAllByDistrict(district), HttpStatus.OK);
    }
}
