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

    @Column(name = "NgayTao",nullable = false)
    private LocalDate ngayTao;

    @Column(name = "NgayHetHan",nullable = false)
    private Date ngayHetHan;

    @Column(name = "CapDo")
    private Integer capDo;

    @Column(name = "TrangThai")
    private Integer trangThai;

    @Column(name = "GhiChu")
    private String ghiChu;

    @OneToOne
    @MapsId
    @JoinColumn(name = "MaHocVien", unique = true)
    private KhachHang khachHang;

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
