package com.example.pfitapi.controller;

import com.example.pfitapi.entity.Status;
import com.example.pfitapi.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/khachhang")
public class KhachHangController {
    @Autowired
    private KhachHangService khachHangService;

    @PostMapping("/dangnhap")
    public ResponseEntity<Status> authenticateUser(
            @RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password){
        int check = khachHangService.dangNhap(email, password);
        Status status = new Status(check);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
