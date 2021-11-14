package com.example.pfitapi.service.implement;

import com.example.pfitapi.dto.TheTrangDTO;
import com.example.pfitapi.entity.TheTrang;
import com.example.pfitapi.repository.TheTrangRepository;
import com.example.pfitapi.service.in.TheTrangInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;

@Service
@Transactional
public class TheTrangServiceImpl implements TheTrangInterface {
    @Autowired
    private TheTrangRepository theTrangRepository;


    @Override
    public TheTrangDTO getTheTrangTheoMaHVvaNgay(String maHocVien, Date ngay) {
        TheTrang theTrang = theTrangRepository.findByMaHocVienAndNgay(maHocVien, ngay);
        TheTrangDTO theTrangDTO =  new TheTrangDTO().convertToDto(theTrang);
        return theTrangDTO;
    }

    @Override
    public TheTrangDTO getTheTrangTheoThang(String maHV, String thang, String nam) {
        TheTrang theTrang = theTrangRepository.findByMaHocVienAndThang(maHV, thang, nam);
        TheTrangDTO theTrangDTO =  new TheTrangDTO().convertToDto(theTrang);
        return theTrangDTO;
    }

    @Override
    public TheTrangDTO getTheTrangTheoNam(String maHV, String nam) {
        TheTrang theTrang = theTrangRepository.findByMaHocVienAndNam(maHV, nam);
        TheTrangDTO theTrangDTO =  new TheTrangDTO().convertToDto(theTrang);
        return theTrangDTO;
    }
}
