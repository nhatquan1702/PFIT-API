package com.example.pfitapi.controller;

import com.example.pfitapi.dto.TheTrangDTO;
import com.example.pfitapi.entity.HocVien;
import com.example.pfitapi.entity.Status;
import com.example.pfitapi.entity.TheTrang;
import com.example.pfitapi.service.HocVienService;
import com.example.pfitapi.service.implement.HocVienServiceImpl;
import com.example.pfitapi.service.implement.TheTrangServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/thetrang")
public class TheTrangController {
    @Autowired
    private TheTrangServiceImpl theTrangService;

    @Autowired
    private HocVienService hocVienService;

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

    @PostMapping(value = "/insert",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<Status> insertTT(@RequestBody TheTrangDTO theTrangDTO){
        int check = theTrangService.insertTT(theTrangDTO);
        Status status = new Status(check);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
    @GetMapping("/insertT")
    public ResponseEntity<Status> insertTheTrangTT(@RequestParam(value = "ngay") Date ngay, @RequestParam(value = "maHocVien") String maHocVien,
                                                   @RequestParam(value = "chieuCao") Float chieuCao, @RequestParam(value = "canNang") Float canNang,
                                                   @RequestParam(value = "vong1") Float vong1, @RequestParam(value = "vong2") Float vong2,
                                                   @RequestParam(value = "vongTay") Float vongTay, @RequestParam(value = "vongDui") Float vongDui,
                                                   @RequestParam(value = "vong3") Float vong3, @RequestParam(value = "luongNuoc") Float luongNuoc){

        HocVien hocVien = hocVienService.getHocVien(maHocVien);
        TheTrang theTrang = new TheTrang(ngay, chieuCao, canNang, vong1, vong2, vong3, vongTay, vongDui, luongNuoc, hocVien);
        int check = theTrangService.insertTheTrang(theTrang);
        Status status = new Status(check);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
