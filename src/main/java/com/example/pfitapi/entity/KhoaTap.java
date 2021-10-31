package com.example.pfitapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

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
    private int giaTheoThang;

    @Column(name = "ChoDoiTuong",nullable = false)
    private int choDoiTuong;

    @Column(name = "TrangThai",nullable = false)
    private int trangThai;

    private NhanVien nhanVien;

    private HuanLuyenVien huanLuyenVien;

//    @JsonIgnore
//    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
//    @OneToMany(mappedBy = "khoaTap")
//    List<GiaKhoaTap> giaKhoaTapList;
}
