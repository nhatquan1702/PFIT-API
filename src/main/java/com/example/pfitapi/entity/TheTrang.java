package com.example.pfitapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "THETRANG")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TheTrang {
    @Id
    @Column(name = "MaHocVien", nullable = false)
    private String maHocVien;

    @Column(name = "Ngay",nullable = false)
    private Date ngay;

    @Column(name = "ChieuCao")
    private float chieuCao;

    @Column(name = "CanNang")
    private float canNang;

    @Column(name = "Vong1")
    private float vong1;

    @Column(name = "Vong2")
    private float vong2;

    @Column(name = "Vong3")
    private float vong3;

    @Column(name = "VongTay")
    private float vongTay;

    @Column(name = "VongDui")
    private float vongDui;

    @Column(name = "LuongNuoc")
    private float luongNuoc;
}
