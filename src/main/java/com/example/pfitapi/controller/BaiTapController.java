package com.example.pfitapi.controller;

import com.example.pfitapi.dto.BaiTapDTO;
import com.example.pfitapi.dto.BaiTapFullDTO;
import com.example.pfitapi.entity.BaiTap;
import com.example.pfitapi.entity.NhomCo;
import com.example.pfitapi.entity.Status;
import com.example.pfitapi.service.BaiTapService;
import com.example.pfitapi.service.NhomCoService;
import com.example.pfitapi.service.implement.BaiTapServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/baitap")
public class BaiTapController {
    @Autowired
    private BaiTapService baiTapService;

    @Autowired
    private BaiTapServiceImpl baiTapServiceImpl;

    @GetMapping("tatca")
    public ResponseEntity<List<BaiTap>> getAllBaiTap() {
        List<BaiTap> baiTapList = baiTapService.getBaiTapList();
        return new ResponseEntity<>(baiTapList, HttpStatus.OK);
    }

    @GetMapping("baitaptheonhomco")
    public ResponseEntity<List<BaiTap>> getBaiTapByMaNhomCo(@RequestParam(value = "manhomco") String maNhomCo) {
        List<BaiTap> baiTapList = baiTapService.getBaiTapByMaNhomCo(maNhomCo);
        return new ResponseEntity<>(baiTapList, HttpStatus.OK);
    }

    @GetMapping("baitaptheomanhomco")
    public ResponseEntity<List<BaiTapDTO>> getBaiTapTheoMaNhomCo(@RequestParam(value = "manhomco") String maNhomCo) {
        List<BaiTapDTO> baiTapDTOList = baiTapServiceImpl.getBaiTapTheoNhomCo(maNhomCo);
        return new ResponseEntity<>(baiTapDTOList, HttpStatus.OK);
    }

    @GetMapping("baitaptheomabaitap")
    public ResponseEntity<BaiTapFullDTO> getBaiTapTheoMa(@RequestParam(value = "mabaitap") String maBaiTap) {
        BaiTapFullDTO baiTapFullDTO = baiTapServiceImpl.getBaiTapFullDTO(maBaiTap) ;
        return new ResponseEntity<>(baiTapFullDTO, HttpStatus.OK);
    }

    @GetMapping("baitaptheokhoavangay")
    public ResponseEntity<List<BaiTapDTO>> getBaiTapTheoKhoaVaNgay(@RequestParam(value = "makhoatap") String maKhoaTap,
                                                                   @RequestParam(value = "ngaytap") Integer ngayTap) {
        List<BaiTapDTO> baiTapDTOList = baiTapServiceImpl.getBaiTapTheoKhoaVaNgayTap(maKhoaTap, ngayTap) ;
        return new ResponseEntity<>(baiTapDTOList, HttpStatus.OK);
    }
}
