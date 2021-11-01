package com.example.pfitapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "KHOATAP")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KhoaTap {
    @Id
    @Column(name = "MaKhoaTap", nullable = false)
    private String maKhoaTap;

    @Column(name = "TenKhoaTap",nullable = false)
    private String tenKhoaTap;

    @Column(name = "HinhQuangCao",nullable = false)
    private String hinhQuangCao;

    @Column(name = "GiaTheoThang",nullable = false)
    private Integer giaTheoThang;

    @Column(name = "ChoDoiTuong",nullable = false)
    private Integer choDoiTuong;

    @Column(name = "TrangThai",nullable = false)
    private Integer trangThai;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="MaNhanVien",nullable = false)
    private NhanVien nhanVien;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="MaHLV",nullable = false)
    private HuanLuyenVien huanLuyenVien;

    @JsonIgnore
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "khoaTap")
    List<GiaKhoaTap> giaKhoaTapList;
}
