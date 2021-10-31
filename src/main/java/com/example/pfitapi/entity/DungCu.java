package com.example.pfitapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DUNGCU")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DungCu {
    @Id
    @Column(name = "MaDungCu", nullable = false)
    private String maDungCu;

    @Column(name = "TenDungCu",nullable = false)
    private String tenDungCu;

    @Column(name = "HinhMinhHoa",nullable = false)
    private String hinhMinhHoa;

    @Column(name = "KhoiLuong")
    private float khoiLuong;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "GhiChu")
    private String ghiChu;
}
