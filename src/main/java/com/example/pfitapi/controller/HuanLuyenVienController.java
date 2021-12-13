package com.example.pfitapi.controller;

import com.example.pfitapi.dto.TheTrangDTO;
import com.example.pfitapi.entity.HuanLuyenVien;
import com.example.pfitapi.service.HuanLuyenVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/huanluyenvien")
public class HuanLuyenVienController {
    @Autowired
    private HuanLuyenVienService huanLuyenVienService;

    @GetMapping("")
    public ResponseEntity<List<HuanLuyenVien>> getAllBrand() {
        List<HuanLuyenVien> huanLuyenVienList = huanLuyenVienService.getHLVList();
        return new ResponseEntity<>(huanLuyenVienList, HttpStatus.OK);
    }

    @GetMapping(value = "/tthlv")
    public ResponseEntity<HuanLuyenVien> getHLV(@RequestParam(value = "mahuanluyenvien") String maHLV){
        try {
            return new ResponseEntity<>(huanLuyenVienService.getHLV(maHLV), HttpStatus.OK) ;
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
    }
}
