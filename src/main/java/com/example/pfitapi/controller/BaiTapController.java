package com.example.pfitapi.controller;

import com.example.pfitapi.entity.BaiTap;
import com.example.pfitapi.entity.NhomCo;
import com.example.pfitapi.service.BaiTapService;
import com.example.pfitapi.service.NhomCoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/baitap")
public class BaiTapController {
    @Autowired
    private BaiTapService baiTapService;

    @GetMapping("")
    public ResponseEntity<List<BaiTap>> getAllBrand() {
        List<BaiTap> baiTapList = baiTapService.getBaiTapList();
        return new ResponseEntity<>(baiTapList, HttpStatus.OK);
    }
}
