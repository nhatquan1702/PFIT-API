package com.example.pfitapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.sql.Date;
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
    private String MaHocVien;

    @Column(name = "NgayTao",nullable = false)
    private Date ngayTao;

    @Column(name = "NgayHetHan",nullable = false)
    private Date ngayHetHan;

    @Column(name = "CapDo")
    private int capDo;

    @Column(name = "TrangThai")
    private int trangThai;

    @Column(name = "GhiChu")
    private String ghiChu;

    @OneToOne
    @MapsId
    @JoinColumn(name = "TaiKhoan")
    private KhachHang khachHang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="MaKhoaTap",nullable = false)
    private KhoaTap khoaTap;

    @JsonIgnore
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "hocVien")
    List<ChiTietBaiTap> chiTietBaiTapList;
}
