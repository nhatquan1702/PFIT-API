package com.example.pfitapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
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
    private Integer tuoi;

    @Column(name = "GioiTinh",nullable = false)
    private Integer gioiTinh;

    @Column(name = "NgayThamGia",nullable = false)
    private LocalDate ngayThamGia;

    @Column(name = "SoDienThoai",nullable = false)
    private String soDienThoai;

    @Column(name = "DiaChi", nullable = false)
    private String diaChi;

    @Column(name = "GhiChu")
    private String ghiChu;

    @Column(name = "TrangThai",nullable = false)
    private Integer trangThai;

}
