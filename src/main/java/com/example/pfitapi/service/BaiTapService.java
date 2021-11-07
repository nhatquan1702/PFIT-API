package com.example.pfitapi.service;

import com.example.pfitapi.entity.BaiTap;
import com.example.pfitapi.repository.BaiTapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BaiTapService {
    @Autowired
    private BaiTapRepository baiTapRepository;

    public List<BaiTap> getBaiTapList() {
        List<BaiTap> baiTapList = baiTapRepository.findAll();
        return baiTapList;
    }

    public List<BaiTap> getBaiTapByMaNhomCo(String maNhomCo){
        List<BaiTap> baiTapList = baiTapRepository.findAllByNhomCoMaNhomCo(maNhomCo);
        return baiTapList;
    }
}
