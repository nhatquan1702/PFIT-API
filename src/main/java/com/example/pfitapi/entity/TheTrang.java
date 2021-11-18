package com.example.pfitapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "THETRANG")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TheTrang {
    @Id
    @Column(name = "Ngay",nullable = false)
    private Date ngay;

    @Column(name = "ChieuCao")
    private Float chieuCao;

    @Column(name = "CanNang")
    private Float canNang;

    @Column(name = "Vong1")
    private Float vong1;

    @Column(name = "Vong2")
    private Float vong2;

    @Column(name = "Vong3")
    private Float vong3;

    @Column(name = "VongTay")
    private Float vongTay;

    @Column(name = "VongDui")
    private Float vongDui;

    @Column(name = "LuongNuoc")
    private Float luongNuoc;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="MaHocVien",nullable = false)
    private HocVien hocVien;

}
