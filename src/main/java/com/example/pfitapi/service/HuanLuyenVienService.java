package com.example.pfitapi.service;

import com.example.pfitapi.entity.HuanLuyenVien;
import com.example.pfitapi.entity.NhomCo;
import com.example.pfitapi.repository.HuanLuyenVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class HuanLuyenVienService {
    @Autowired
    private HuanLuyenVienRepository huanLuyenVienRepository;

    public List<HuanLuyenVien> getHLVList(){
        List<HuanLuyenVien> huanLuyenVienList = huanLuyenVienRepository.findAll();
        return huanLuyenVienList;
    }

    public HuanLuyenVien getHLV (String maHLV){
        HuanLuyenVien huanLuyenVien = huanLuyenVienRepository.findByMaHLV(maHLV);
        return huanLuyenVien;
    }
}
