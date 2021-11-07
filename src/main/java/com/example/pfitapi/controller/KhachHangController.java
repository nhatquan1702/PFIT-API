package com.example.pfitapi.controller;

import com.example.pfitapi.dto.KhachHangDTO;
import com.example.pfitapi.entity.KhachHang;
import com.example.pfitapi.entity.Status;
import com.example.pfitapi.service.KhachHangService;
import com.example.pfitapi.service.implement.KhachHangServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/khachhang")
public class KhachHangController {
    @Autowired
    private KhachHangService khachHangService;

    @Autowired
    private KhachHangServiceImpl khachHangServiceImple;

    @PostMapping("/dangnhap")
    public ResponseEntity<Status> authenticateUser(
            @RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password){
        int check = khachHangService.dangNhap(email, password);
        Status status = new Status(check);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @GetMapping(value = "/ttkhachhang")
    public ResponseEntity<KhachHangDTO>  getKhachHangDTO(@RequestParam(value = "taikhoan") String taiKhoan){
        return new ResponseEntity<>(khachHangServiceImple.getKHByMaHocVien(taiKhoan), HttpStatus.OK) ;
    }

    @GetMapping(value = "/ttkhachhangheader", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public KhachHang getKH(@RequestHeader(value = "taikhoan") String taiKhoan){
        return khachHangService.getKhachHang(taiKhoan);
    }

}
