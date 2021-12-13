package com.example.pfitapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "HOCVIEN")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HocVien {
    @Id
    @Column(name = "MaHocVien", nullable = false)
    private String maHocVien;

    @Column(name = "MatKhau", nullable = false)
    private String matKhau;

    @Column(name = "HoTen",nullable = false)
    private String hoTen;

    @Column(name = "Tuoi",nullable = false)
    private Integer tuoi;

    @Column(name = "GioiTinh",nullable = false)
    private Integer gioiTinh;

    @Column(name = "NgayThamGia",nullable = false)
    private Date ngayThamGia;

    @Column(name = "SoDienThoai",nullable = false)
    private String soDienThoai;

    @Column(name = "DiaChi", nullable = false)
    private String diaChi;

    @Column(name = "CapDo")
    private Integer capDo;

    @Column(name = "TrangThai")
    private Integer trangThai;

    @Column(name = "GhiChu")
    private String ghiChu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="MaKhoaTap",nullable = false)
    private KhoaTap khoaTap;

    @JsonIgnore
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "hocVien")
    List<ChiTietBaiTap> chiTietBaiTapList;

//    @JsonIgnore
//    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
//    @OneToMany(mappedBy = "hocVien", fetch = FetchType.LAZY)
//    private List<TheTrangKey> theTrangList;
}
