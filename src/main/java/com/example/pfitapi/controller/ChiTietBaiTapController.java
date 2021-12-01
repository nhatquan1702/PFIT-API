package com.example.pfitapi.controller;

import com.example.pfitapi.dto.BaiTapFullDTO;
import com.example.pfitapi.dto.ChiTietBaiTapChoHVDTO;
import com.example.pfitapi.dto.ChiTietBaiTapDTO;
import com.example.pfitapi.dto.TheTrangDTO;
import com.example.pfitapi.entity.Status;
import com.example.pfitapi.service.implement.ChiTietBaiTapImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

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

    @GetMapping("chitietbaitapchohv")
    public ResponseEntity<ChiTietBaiTapChoHVDTO> getCTBTCHV(@RequestParam(value = "mabaitap") String maBaiTap, @RequestParam(value = "mahocvien") String maHocVien) {
        ChiTietBaiTapChoHVDTO chiTietBaiTapChoHVDTO = chiTietBaiTapImpl.getChiTietBTChoHV(maBaiTap, maHocVien);
        return new ResponseEntity<>(chiTietBaiTapChoHVDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/updatettbtchohv", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Status> updateTTBTCHV(@RequestParam (value = "mabaitap") String maBaiTap, @RequestParam (value = "mahocvien") String maHocVien, @RequestParam (value = "trangthai") Integer trangThai){
        int check = chiTietBaiTapImpl.updateTrangThaiBTChoHV(maBaiTap, maHocVien, trangThai);
        Status status = new Status(check);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PostMapping(value = "/updategcbtchohv", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Status> updateGCBTCHV(@RequestParam (value = "mabaitap") String maBaiTap, @RequestParam (value = "mahocvien") String maHocVien, @RequestParam (value = "ghichu") String ghiChu){
        int check = chiTietBaiTapImpl.updateGhiChuBTChoHV(maBaiTap, maHocVien, ghiChu);
        Status status = new Status(check);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @GetMapping(value = "/ptbthtngay")
    public ResponseEntity<Status> getSLBTHT(@RequestParam(value = "makhoatap") String maKT, @RequestParam(value = "mahocvien") String maHV, @RequestParam(value = "ngaytap") Integer ngayTap){
        int sl = chiTietBaiTapImpl.getPTHTBTTrongNgay(maKT, maHV , ngayTap);
        Status status = new Status(sl);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @GetMapping(value = "/ptbthtkhoa")
    public ResponseEntity<Status> getSLBTHT(@RequestParam(value = "makhoatap") String maKT, @RequestParam(value = "mahocvien") String maHV){
        int sl = chiTietBaiTapImpl.getPTHTBTTrongKhoa(maKT, maHV);
        Status status = new Status(sl);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
