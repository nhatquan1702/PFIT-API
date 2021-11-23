package com.example.pfitapi.controller;

import com.example.pfitapi.dto.TheTrangDTO;
import com.example.pfitapi.entity.Status;
import com.example.pfitapi.service.implement.TheTrangServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/thetrang")
public class TheTrangController {
    @Autowired
    private TheTrangServiceImpl theTrangService;

    @GetMapping(value = "/thetranghocvien")
    public ResponseEntity<TheTrangDTO> getTheTrangDTO(@RequestHeader(value = "mahocvien") String maHocVien, @RequestHeader (value = "ngay") Date ngay){
        try {
            return new ResponseEntity<>(theTrangService.getTheTrangTheoMaHVvaNgay(maHocVien, ngay), HttpStatus.OK) ;
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/thetranghocvientheothang")
    public ResponseEntity<List<TheTrangDTO>> getTheTrangTheoThang(@RequestParam(value = "mahocvien") String maHV, @RequestParam (value = "thang") String thang, @RequestParam (value = "nam") String nam){
        return new ResponseEntity<>(theTrangService.getTheTrangTheoThang(maHV, thang, nam), HttpStatus.OK) ;
    }

    @GetMapping(value = "/thetranghocvientheonam")
    public ResponseEntity<List<TheTrangDTO>> getTheTrangTheoNam(@RequestParam(value = "mahocvien") String maHV, @RequestParam (value = "nam") String nam){
        return new ResponseEntity<>(theTrangService.getTheTrangTheoNam(maHV, nam), HttpStatus.OK);
    }

    @GetMapping(value = "/thetranggannhat")
    public ResponseEntity<TheTrangDTO> getTheTrangGanNhat(@RequestParam(value = "mahocvien") String maHV){
        return new ResponseEntity<>(theTrangService.getTheTrangGanNhat(maHV), HttpStatus.OK);
    }
}
