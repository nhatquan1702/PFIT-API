package com.example.pfitapi.service.in;

import com.example.pfitapi.dto.KhachHangDTO;

public interface KhachHangInterface {
    KhachHangDTO getKHByMaHocVien(String maHocVien);
}
