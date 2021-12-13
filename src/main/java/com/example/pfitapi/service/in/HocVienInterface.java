package com.example.pfitapi.service.in;

import com.example.pfitapi.dto.HocVienDTO;
import com.example.pfitapi.dto.HocVienKTDTO;
import com.example.pfitapi.dto.KhoaTapDTO;
import com.example.pfitapi.entity.HocVien;

public interface HocVienInterface {
    HocVienKTDTO getMaKhoaTapTheoHocVien(String maHocVien);

    HocVienDTO getHocVienTheoTrangThai(String maHocVien, Integer trangThai);

    Integer insertHocVien(HocVienDTO hocVienDTO);

    Integer updateTrangThaiHocVien (String maHocVien, Integer trangThai);

    Integer updateKhoaTapChoHocVien (String maHocVien, String maKhoaTap);

    Integer dangNhap(String maHocVien, String pass);

    HocVienDTO getTTHocVien(String maHocVien);
}
