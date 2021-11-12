package com.example.pfitapi.controller;

import com.example.pfitapi.dto.BaiTapFullDTO;
import com.example.pfitapi.dto.ChiTietBaiTapDTO;
import com.example.pfitapi.service.implement.ChiTietBaiTapImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chitietbaitap")
public class ChiTietBaiTapController {
    @Autowired
    ChiTietBaiTapImpl chiTietBaiTapImpl;

    @GetMapping("chitietbaitaptheomabaitap")
    public ResponseEntity<ChiTietBaiTapDTO> getCTBaiTapTheoMa(@RequestParam(value = "mabaitap") String maBaiTap) {
        ChiTietBaiTapDTO chiTietBaiTapDTO = chiTietBaiTapImpl.getChiTietBT(maBaiTap) ;
        return new ResponseEntity<>(chiTietBaiTapDTO, HttpStatus.OK);
    }
}
