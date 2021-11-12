package com.example.pfitapi.controller;

import com.example.pfitapi.entity.NgayTap;
import com.example.pfitapi.service.NgayTapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ngaytap")
public class NgayTapController {
    @Autowired
    private NgayTapService ngayTapService;

    @GetMapping("")
    public ResponseEntity<List<NgayTap>> getAllNgayTap() {
        List<NgayTap> ngayTapList = ngayTapService.getListNgayTap();
        return new ResponseEntity<>(ngayTapList, HttpStatus.OK);
    }

}
