package com.example.pfitapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class ChiTietBaiTapKey implements Serializable {
    @Column(name = "MaBaiTap", nullable = false)
    private String maBaiTap;

    @Column(name = "MaHocVien", nullable = false)
    private String maHocVien;

    public ChiTietBaiTapKey() {

    }

    public String getMaBaiTap() {
        return maBaiTap;
    }

    public void setMaBaiTap(String maBaiTap) {
        this.maBaiTap = maBaiTap;
    }

    public String getMaHocVien() {
        return maHocVien;
    }

    public void setMaHocVien(String maHocVien) {
        this.maHocVien = maHocVien;
    }

    public ChiTietBaiTapKey(String maBaiTap, String maHocVien) {
        this.maBaiTap = maBaiTap;
        this.maHocVien = maHocVien;
    }
}
