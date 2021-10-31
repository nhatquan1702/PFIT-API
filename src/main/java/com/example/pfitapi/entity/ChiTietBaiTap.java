package com.example.pfitapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "CHITIETBAITAP")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietBaiTap {
    @EmbeddedId
    private ChiTietBaiTapKey chiTietBaiTapKey;

    @ManyToOne
    @MapsId("maBaiTap")
    @JoinColumn(name = "MaBaiTap")
    private BaiTap baiTap;

    @ManyToOne
    @MapsId("maHocVien")
    @JoinColumn(name = "MaHocVien")
    private HocVien hocVien;

    @Column(name = "KhoiLuong")
    private Float khoiLuong;

    @Column(name = "SoHiep")
    private String soHiep;

    @Column(name = "SoLanLap")
    private String soLanLap;

    @Column(name = "TocDo")
    private String tocDo;

    @Column(name = "ThoiGianNghi")
    private String thoiGianNghi;

    @Column(name = "GhiChu")
    private String ghiChu;

    @Column(name = "TrangThai",nullable = false)
    private Integer trangThai;
}
