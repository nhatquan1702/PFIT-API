package com.example.pfitapi.controller;

import com.example.pfitapi.dto.HocVienDTO;
import com.example.pfitapi.dto.TaiKhoanDTO;
import com.example.pfitapi.entity.Status;
import com.example.pfitapi.service.implement.TaiKhoanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/taikhoan")
public class TaiKhoanController {
    @Autowired
    private TaiKhoanServiceImpl taiKhoanServiceImpl;

    @PostMapping("/dangnhap")
    public ResponseEntity<Status> authenticateUser(
            @RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password){
        int check = taiKhoanServiceImpl.dangNhap(email, password);
        Status status = new Status(check);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @GetMapping(value = "/tttaikhoan")
    public ResponseEntity<TaiKhoanDTO>  getKhachHangDTOO(@RequestParam(value = "taikhoan") String taiKhoan){
        return new ResponseEntity<>(taiKhoanServiceImpl.getTTTaiKhoan(taiKhoan), HttpStatus.OK) ;
    }
}
