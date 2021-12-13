package com.example.pfitapi.controller;

import com.example.pfitapi.dto.HocVienDTO;
import com.example.pfitapi.dto.HocVienKTDTO;
import com.example.pfitapi.dto.KhachHangDTO;
import com.example.pfitapi.dto.KhoaTapDTO;
import com.example.pfitapi.entity.Status;
import com.example.pfitapi.service.implement.HocVienServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hocvien")
public class HocVienController {
    @Autowired
    private HocVienServiceImpl hocVienServiceImpl;

    @GetMapping(value = "/makhoatap")
    public ResponseEntity<HocVienKTDTO> getKhachHangDTO(@RequestParam(value = "mahocvien") String taiKhoan){
        return new ResponseEntity<>(hocVienServiceImpl.getMaKhoaTapTheoHocVien(taiKhoan), HttpStatus.OK) ;
    }

    @GetMapping(value = "/dadangki")
    public ResponseEntity<HocVienDTO> getHocVienDaDK(@RequestParam(value = "mahocvien") String taiKhoan, @RequestParam(value = "trangthai") Integer trangThai){
        return new ResponseEntity<>(hocVienServiceImpl.getHocVienTheoTrangThai(taiKhoan, trangThai), HttpStatus.OK) ;
    }

    @PostMapping(value = "/insert", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<Status> insertHocVien(@RequestBody HocVienDTO hocVienDTO){
        int check = hocVienServiceImpl.insertHocVien(hocVienDTO);
        Status status = new Status(check);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PostMapping(value = "/updatetthv", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Status> updateTrangThai(@RequestParam (value = "mahocvien") String maHocVien, @RequestParam (value = "trangthai") Integer trangThai){
        int check = hocVienServiceImpl.updateTrangThaiHocVien(maHocVien, trangThai);
        Status status = new Status(check);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PostMapping(value = "/updatekthv", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Status> updateKhoaTap(@RequestParam (value = "mahocvien") String maHocVien, @RequestParam (value = "makhoatap") String maKhoatap){
        int check = hocVienServiceImpl.updateKhoaTapChoHocVien(maHocVien, maKhoatap);
        Status status = new Status(check);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PostMapping("/dangnhap")
    public ResponseEntity<Status> authenticateUser(
            @RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password){
        int check = hocVienServiceImpl.dangNhap(email, password);
        Status status = new Status(check);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @GetMapping(value = "/tthocvien")
    public ResponseEntity<HocVienDTO>  getKhachHangDTOO(@RequestParam(value = "taikhoan") String taiKhoan){
        return new ResponseEntity<>(hocVienServiceImpl.getTTHocVien(taiKhoan), HttpStatus.OK) ;
    }

    @GetMapping(value = "/tthocvienheader", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public HocVienDTO getKH(@RequestHeader(value = "taikhoan") String taiKhoan){
        return hocVienServiceImpl.getTTHocVien(taiKhoan);
    }
}
