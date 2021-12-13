package com.example.pfitapi.controller;

import com.example.pfitapi.dto.DoanhThuDTO;
import com.example.pfitapi.dto.HoaDonDTO;
import com.example.pfitapi.dto.TheTrangDTO;
import com.example.pfitapi.service.implement.HoaDonServiceImpl;
import org.aspectj.weaver.patterns.DeclareTypeErrorOrWarning;
import org.hibernate.mapping.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/hoadon")
public class HoaDonController {
    @Autowired
    private HoaDonServiceImpl hoaDonService;

    @GetMapping(value = "/dttheothang")
    public ResponseEntity<Object> getDTTheoThang(@RequestParam(value = "thang") String thang, @RequestParam (value = "nam") String nam){
        List<Object[]> tmp = hoaDonService.getDoanhThuTheoThang(thang, nam);
        List<DoanhThuDTO> doanhThuDTOS=tmp.stream().map(objects ->new DoanhThuDTO().ConvertToDTO(objects)).collect(Collectors.toList());
        return new ResponseEntity<>(doanhThuDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/dttheonam")
    public ResponseEntity<Object> getDTTheoNam(@RequestParam (value = "nam") String nam){
        List<Object[]> tmp = hoaDonService.getDoanhThuTheoNam(nam);
        List<DoanhThuDTO> doanhThuDTOS=tmp.stream().map(objects ->new DoanhThuDTO().ConvertToDTO(objects)).collect(Collectors.toList());
        return new ResponseEntity<>(doanhThuDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/dttheongay")
    public ResponseEntity<Object> getDTTheoNgay(@RequestParam(value = "ngay") String ngay){
        List<Object[]> tmp = hoaDonService.getDoanhThuTheoNgay(ngay);
        //Map danh object[] thanh DoanhThuDTO su dung ConvertToDto, t tat day
        List<DoanhThuDTO> doanhThuDTOS=tmp.stream().map(objects ->new DoanhThuDTO().ConvertToDTO(objects)).collect(Collectors.toList());
//        System.out.println(tmp.toString());
        //
        // DoanhThuDTO doanhThuDTO = new DoanhThuDTO().ConvertToDTO(tmp);
        return new ResponseEntity<>(doanhThuDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/dshoadontrongngay")
    public ResponseEntity<Object> getDsHDTheoNgay(@RequestParam(value = "ngay") Date ngay){
        return new ResponseEntity<>(hoaDonService.getListHoaDonTrongTheoNgay(ngay), HttpStatus.OK);
    }
}
