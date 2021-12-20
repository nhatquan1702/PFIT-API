package com.example.pfitapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "NHANVIEN")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NhanVien {
    @Id
    @Column(name = "MaNhanVien", nullable = false)
    private String maNhanVien;

    @OneToOne
    @MapsId
    @JoinColumn(name = "MaNhanVien", unique = true)
    private TaiKhoan taiKhoan;


    @Column(name = "TrangThai",nullable = false)
    private Integer trangThai;
}
