package com.example.pfitapi.dto;

import com.example.pfitapi.entity.ChiTietBaiTap;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class ChiTietBaiTapDTO {
    @NonNull
    private String maBaiTap;

    private Float khoiLuong;

    private String soHiep;

    private String soLanLap;

    private String tocDo;

    private String thoiGianNghi;

    private String ghiChu;

    private Integer trangThai;

    public ChiTietBaiTapDTO(@NonNull String maBaiTap, Float khoiLuong, String soHiep, String soLanLap, String tocDo, String thoiGianNghi, String ghiChu, Integer trangthai) {
        this.maBaiTap = maBaiTap;
        this.khoiLuong = khoiLuong;
        this.soHiep = soHiep;
        this.soLanLap = soLanLap;
        this.tocDo = tocDo;
        this.thoiGianNghi = thoiGianNghi;
        this.ghiChu = ghiChu;
        this.trangThai = trangthai;
    }

    public ChiTietBaiTapDTO convertToDto(ChiTietBaiTap baiTap) {
        ChiTietBaiTapDTO baiTapDTO = new ChiTietBaiTapDTO();
        baiTapDTO.setMaBaiTap(baiTap.getBaiTap().getMaBaiTap());
        baiTapDTO.setGhiChu(baiTap.getGhiChu());
        baiTapDTO.setKhoiLuong(baiTap.getKhoiLuong());
        baiTapDTO.setSoHiep(baiTap.getSoHiep());
        baiTapDTO.setSoLanLap(baiTap.getSoLanLap());
        baiTapDTO.setTocDo(baiTap.getTocDo());
        baiTapDTO.setThoiGianNghi(baiTap.getThoiGianNghi());
        baiTapDTO.setTrangThai(baiTap.getTrangThai());
        return baiTapDTO;
    }
}
