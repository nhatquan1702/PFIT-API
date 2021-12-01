package com.example.pfitapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Embeddable
@Getter
@Setter
public class TheTrangKey implements Serializable {
    @Column(name = "Ngay", nullable = false)
    private Date ngay;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="MaHocVien",referencedColumnName = "MaHocVien",nullable = false)
    private HocVien hocVien;

    public TheTrangKey(Date ngay, HocVien hocVien) {
        this.ngay = ngay;
        this.hocVien = hocVien;
    }

    public TheTrangKey() {

    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public HocVien getHocVien() {
        return hocVien;
    }

    public void setHocVien(HocVien hocVien) {
        this.hocVien = hocVien;
    }
}
