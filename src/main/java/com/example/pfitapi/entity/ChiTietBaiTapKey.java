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
}
