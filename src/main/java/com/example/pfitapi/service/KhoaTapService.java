package com.example.pfitapi.service;

import com.example.pfitapi.entity.KhoaTap;
import com.example.pfitapi.repository.KhoaTapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class KhoaTapService {
    @Autowired
    private KhoaTapRepository khoaTapRepository;

    public List<KhoaTap> getListKhoaTap(){
        List<KhoaTap> khoaTapList = khoaTapRepository.findAll();
        return khoaTapList;
    }

    public KhoaTap getKhoaTap(String maKhoaTap){
        KhoaTap khoaTap = khoaTapRepository.findByMaKhoaTapAndTrangThai(maKhoaTap, 1);
        return khoaTap;
    }
}
