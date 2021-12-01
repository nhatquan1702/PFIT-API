package com.example.pfitapi.dto;

import com.example.pfitapi.entity.ChiTietBaiTap;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChiTietBaiTapChoHVDTO {
    @NonNull
    private String maHocVien;

    @NonNull
    private  String maBaiTap;

    private String ghiChu;

    private Integer trangThai;

    public ChiTietBaiTapChoHVDTO(@NonNull String maHocVien,@NonNull String maBaiTap, String ghiChu, Integer trangThai) {
        this.maHocVien = maHocVien;
        this.maBaiTap = maBaiTap;
        this.ghiChu = ghiChu;
        this.trangThai = trangThai;
    }

    public ChiTietBaiTapChoHVDTO convertToDto(ChiTietBaiTap baiTap) {
        ChiTietBaiTapChoHVDTO baiTapDTO = new ChiTietBaiTapChoHVDTO();
        baiTapDTO.setMaHocVien(baiTap.getHocVien().getMaHocVien());
        baiTapDTO.setMaBaiTap(baiTap.getBaiTap().getMaBaiTap());
        baiTapDTO.setGhiChu(baiTap.getGhiChu());
        baiTapDTO.setTrangThai(baiTap.getTrangThai());
        return baiTapDTO;
    }
}
