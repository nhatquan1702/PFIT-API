package com.example.pfitapi.service.implement;

import com.example.pfitapi.dto.TheTrangDTO;
import com.example.pfitapi.entity.TheTrang;
import com.example.pfitapi.repository.TheTrangRepository;
import com.example.pfitapi.service.in.TheTrangInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

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
    public List<TheTrangDTO> getTheTrangTheoThang(String maHV, String thang, String nam) {
        List<TheTrang> theTrangList = theTrangRepository.findByMaHocVienAndThang(maHV, thang, nam);
        List<TheTrangDTO> theTrangDTOList =  new TheTrangDTO().toListTheTrangDto(theTrangList);
        return theTrangDTOList;
    }

    @Override
    public List<TheTrangDTO> getTheTrangTheoNam(String maHV, String nam) {
        List<TheTrang> theTrangList = theTrangRepository.findByMaHocVienAndNam(maHV, nam);
        List<TheTrangDTO> theTrangDTOList =  new TheTrangDTO().toListTheTrangDto(theTrangList);
        return theTrangDTOList;
    }

    @Override
    public TheTrangDTO getTheTrangGanNhat(String maHocVien) {
        TheTrang theTrang = theTrangRepository.findByMaHocVien(maHocVien);
        TheTrangDTO theTrangDTO =  new TheTrangDTO().convertToDto(theTrang);
        return theTrangDTO;
    }
}
