package com.example.pfitapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "TAIKHOAN")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaiKhoan {
    @Id
    @Column(name = "TaiKhoan", nullable = false)
    private String taiKhoan;

    @Column(name = "MatKhau", nullable = false)
    private String matKhau;

    @Column(name = "HoTen",nullable = false)
    private String hoTen;

    @Column(name = "SoDienThoai",nullable = false)
    private String soDienThoai;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "GhiChu")
    private String ghiChu;

    @Column(name = "TrangThai",nullable = false)
    private Integer trangThai;

    @OneToOne(mappedBy = "taiKhoan", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private HocVien hocVien;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="MaQuyen",nullable = false)
    private Quyen quyen;
}
