package com.example.pfitapi.controller;

import com.example.pfitapi.entity.BaiTap;
import com.example.pfitapi.entity.NhomCo;
import com.example.pfitapi.entity.Status;
import com.example.pfitapi.service.BaiTapService;
import com.example.pfitapi.service.NhomCoService;
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
}
