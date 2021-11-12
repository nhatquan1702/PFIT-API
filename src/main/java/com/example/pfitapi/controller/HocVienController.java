package com.example.pfitapi.controller;

import com.example.pfitapi.dto.HocVienKTDTO;
import com.example.pfitapi.dto.KhachHangDTO;
import com.example.pfitapi.service.implement.HocVienServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hocvien")
public class HocVienController {
    @Autowired
    private HocVienServiceImpl hocVienServiceImpl;

    @GetMapping(value = "/makhoatap")
    public ResponseEntity<HocVienKTDTO> getKhachHangDTO(@RequestParam(value = "mahocvien") String taiKhoan){
        return new ResponseEntity<>(hocVienServiceImpl.getMaKhoaTapTheoHocVien(taiKhoan), HttpStatus.OK) ;
    }
}
