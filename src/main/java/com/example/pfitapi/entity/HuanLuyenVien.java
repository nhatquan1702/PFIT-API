package com.example.pfitapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

    @OneToOne
    @MapsId
    @JoinColumn(name = "MaHLV", unique = true)
    private TaiKhoan taiKhoan;

    @Column(name = "TrangThai",nullable = false)
    private Integer trangThai;
}
