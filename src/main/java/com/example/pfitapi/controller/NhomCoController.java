package com.example.pfitapi.controller;

import com.example.pfitapi.entity.NhomCo;
import com.example.pfitapi.service.NhomCoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/nhomco")
public class NhomCoController {
    @Autowired
    private NhomCoService nhomCoService;

    @GetMapping("")
    public ResponseEntity<List<NhomCo>> getAllBrand() {
        List<NhomCo> nhomCoList = nhomCoService.getNhomCoList();
        return new ResponseEntity<>(nhomCoList, HttpStatus.OK);
    }
}
