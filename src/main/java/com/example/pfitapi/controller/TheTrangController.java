package com.example.pfitapi.controller;

import com.example.pfitapi.dto.TheTrangDTO;
import com.example.pfitapi.service.implement.TheTrangServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@RequestMapping("/api/thetrang")
public class TheTrangController {
    @Autowired
    private TheTrangServiceImpl theTrangService;

    @GetMapping(value = "/thetranghocvien")
    public TheTrangDTO getTheTrangDTO(@RequestHeader(value = "mahocvien") String maHocVien, @RequestHeader (value = "ngay") Date ngay){
        return theTrangService.getTheTrangTheoMaHVvaNgay(maHocVien, ngay);
    }

    @GetMapping(value = "/thetranghocvientheothang")
    public TheTrangDTO getTheTrangTheoThang(@RequestParam(value = "mahocvien") String maHV, @RequestParam (value = "thang") String thang, @RequestParam (value = "nam") String nam){
        return theTrangService.getTheTrangTheoThang(maHV, thang, nam);
    }
    @GetMapping(value = "/thetranghocvientheonam")
    public TheTrangDTO getTheTrangTheoNam(@RequestParam(value = "mahocvien") String maHV, @RequestParam (value = "nam") String nam){
        return theTrangService.getTheTrangTheoNam(maHV, nam);
    }
}
