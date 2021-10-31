package com.example.pfitapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Table(name = "BAITAP")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaiTap {
    @Id
    @Column(name = "MaBaiTap", nullable = false)
    private String maBaiTap;

    @Column(name = "TenBaiTap",nullable = false)
    private String tenBaiTap;

    @Column(name = "HinhMinhHoa",nullable = false)
    private String hinhMinhHoa;

    @Column(name = "Video",nullable = false)
    private String video;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "CapDo",nullable = false)
    private int capDo;

    @Column(name = "NgayTap",nullable = false)
    private int ngayTap;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name ="MaKhoaTap",nullable = false)
//    private KhoaTap khoaTap;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name ="MaNhomCo",nullable = false)
//    private NhomCo nhomCo;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name ="MaDungCu",nullable = false)
//    private DungCu dungCu;

//    @JsonIgnore
//    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
//    @OneToMany(mappedBy = "baiTap")
//    List<ChiTietBaiTap> chiTietBaiTapList;
}
