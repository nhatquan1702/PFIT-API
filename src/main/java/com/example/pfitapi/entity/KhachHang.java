package com.example.pfitapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Table(name = "KHACHHANG")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KhachHang {
    @Id
    @Column(name = "TaiKhoan", nullable = false)
    private String taiKhoan;

    @Column(name = "MatKhau", nullable = false)
    private String matKhau;

    @Column(name = "HoTen",nullable = false)
    private String hoTen;

    @Column(name = "Tuoi",nullable = false)
    private int tuoi;

    @Column(name = "GioiTinh",nullable = false)
    private int gioiTinh;

    @Column(name = "NgayThamGia",nullable = false)
    private Date ngayThamGia;

    @Column(name = "SoDienThoai",nullable = false)
    private String soDienThoai;

    @Column(name = "DiaChi",nullable = false)
    private String diaChi;

    @Column(name = "GhiChu")
    private String ghiChu;

    @Column(name = "TrangThai",nullable = false)
    private int trangThai;

//    @OneToOne(mappedBy = "MaHocVien", cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn
//    private HocVien hocVien;
}
