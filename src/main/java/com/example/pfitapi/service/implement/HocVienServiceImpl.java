package com.example.pfitapi.service.implement;

import com.example.pfitapi.dto.HocVienKTDTO;
import com.example.pfitapi.entity.HocVien;
import com.example.pfitapi.repository.HocVienRepository;
import com.example.pfitapi.service.in.HocVienInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class HocVienServiceImpl implements HocVienInterface {
    @Autowired
    private HocVienRepository hocVienRepository;

    @Override
    public HocVienKTDTO getMaKhoaTapTheoHocVien(String maHocVien) {
        HocVien hocVien = hocVienRepository.findByMaHocVien(maHocVien);
        HocVienKTDTO hocVienKTDTO = new HocVienKTDTO().convertToDto(hocVien);
        return hocVienKTDTO;
    }
}
