package com.example.pfitapi.service.in;

import com.example.pfitapi.dto.ChiTietBaiTapChoHVDTO;
import com.example.pfitapi.dto.ChiTietBaiTapDTO;

public interface ChiTietBaiTapInterface {
    ChiTietBaiTapDTO getChiTietBT(String maBaiTap);

    ChiTietBaiTapChoHVDTO getChiTietBTChoHV(String maBaiTap, String maHocVien);

    Integer updateTrangThaiBTChoHV(String maBaiTap, String maHocVien, Integer trangThai);

    Integer updateGhiChuBTChoHV(String maBaiTap, String maHocVien, String ghiChu);

    Integer getPTHTBTTrongNgay(String maKhoaTap, String maHocVien , Integer ngay);

    Integer getPTHTBTTrongKhoa(String maKhoaTap, String maHocVien);
}
