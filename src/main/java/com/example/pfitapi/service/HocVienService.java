package com.example.pfitapi.service;

import com.example.pfitapi.entity.HocVien;
import com.example.pfitapi.repository.HocVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class HocVienService {
    @Autowired
    private HocVienRepository hocVienRepository;

    public HocVien getHocVien(String maHocVien){
        return hocVienRepository.findByMaHocVien(maHocVien);
    }
}
