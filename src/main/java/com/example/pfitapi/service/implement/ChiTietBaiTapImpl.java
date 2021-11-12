package com.example.pfitapi.service.implement;

import com.example.pfitapi.dto.ChiTietBaiTapDTO;
import com.example.pfitapi.entity.ChiTietBaiTap;
import com.example.pfitapi.repository.ChiTietBaiTapRepository;
import com.example.pfitapi.service.in.ChiTietBaiTapInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ChiTietBaiTapImpl implements ChiTietBaiTapInterface {
    @Autowired
    private ChiTietBaiTapRepository chiTietBaiTapRepository;
    @Override
    public ChiTietBaiTapDTO getChiTietBT(String maBaiTap) {
        ChiTietBaiTap chiTietBaiTap = chiTietBaiTapRepository.findChiTietBaiTapByBaiTapMaBaiTap(maBaiTap);
        ChiTietBaiTapDTO chiTietBaiTapDTO = new ChiTietBaiTapDTO().convertToDto(chiTietBaiTap);
        return chiTietBaiTapDTO;
    }
}
