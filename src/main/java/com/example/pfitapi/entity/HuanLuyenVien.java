package com.example.pfitapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HUANLUYENVIEN")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HuanLuyenVien {
    @Id
    @Column(name = "MaHLV", nullable = false)
    private String maHLV;

    @Column(name = "HoTen",nullable = false)
    private String hoTen;

    @Column(name = "SoDienThoai",nullable = false)
    private String soDienThoai;

    @Column(name = "DiaChi",nullable = false)
    private String diaChi;

    @Column(name = "GhiChu")
    private String ghiChu;

    @Column(name = "TrangThai",nullable = false)
    private Integer trangThai;
}
