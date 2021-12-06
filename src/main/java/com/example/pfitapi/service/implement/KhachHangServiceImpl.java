package com.example.pfitapi.service.implement;

import com.example.pfitapi.dto.KhachHangDTO;
import com.example.pfitapi.entity.KhachHang;
import com.example.pfitapi.entity.TheTrang;
import com.example.pfitapi.repository.KhachHangRepository;
import com.example.pfitapi.service.in.KhachHangInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class KhachHangServiceImpl implements KhachHangInterface {
    @Autowired
    private KhachHangRepository khachHangRepository;

    @Override
    public KhachHangDTO getKHByMaHocVien(String maHocVien) {
        KhachHang khachHang = khachHangRepository.findByTaiKhoan(maHocVien);
        KhachHangDTO khachHangDTO = new KhachHangDTO();
        khachHangDTO = khachHangDTO.convertToDto(khachHang);
        return khachHangDTO;
    }
}
