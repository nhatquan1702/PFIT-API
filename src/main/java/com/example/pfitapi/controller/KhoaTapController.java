package com.example.pfitapi.controller;

import com.example.pfitapi.dto.KhoaTapDTO;
import com.example.pfitapi.dto.TheTrangDTO;
import com.example.pfitapi.entity.KhoaTap;
import com.example.pfitapi.entity.Status;
import com.example.pfitapi.service.KhoaTapService;
import com.example.pfitapi.service.implement.KhoaTapServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/khoatap")
public class KhoaTapController {
    @Autowired
    private KhoaTapService khoaTapService;

    @Autowired
    private KhoaTapServiceImpl khoaTapServiceImpl;

    @GetMapping("ttkhoatap")
    public ResponseEntity<KhoaTapDTO> getKhoaTap(@RequestParam(value = "makhoatap") String maKhoaTap) {
        KhoaTapDTO khoaTap = khoaTapServiceImpl.getKhoaTap(maKhoaTap);
        return new ResponseEntity<>(khoaTap, HttpStatus.OK);
    }

    @GetMapping("allkhoatap")
    public ResponseEntity<List<KhoaTapDTO>> getAllKhoaTap() {
        List<KhoaTapDTO> khoaTapDTOArrayList = khoaTapServiceImpl.getListAllKhoaTap();
        return new ResponseEntity<>(khoaTapDTOArrayList, HttpStatus.OK);
    }

    @PostMapping(value = "/insert", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<Status> insertKT(@RequestBody KhoaTapDTO khoaTapDTO){
        int check = khoaTapServiceImpl.insertKhoaTap(khoaTapDTO);
        Status status = new Status(check);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PostMapping(value = "/update", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<Status> updateKT(@RequestBody KhoaTapDTO khoaTapDTO){
        int check = khoaTapServiceImpl.updateKhoaTap(khoaTapDTO);
        Status status = new Status(check);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PostMapping(value = "/updatettkt", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Status> updateLuongNuoc(@RequestParam (value = "makhoatap") String maKhoaTap, @RequestParam (value = "trangthai") Integer trangThai){
        int check = khoaTapServiceImpl.updateTrangThaiKhoaTap(maKhoaTap, trangThai);
        Status status = new Status(check);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
