package com.example.pfitapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class GiaKhoaTapKey implements Serializable {
    @Column(name = "MaKhoaTap", nullable = false)
    private String maKhoaTap;

    @Column(name = "MaHoaDon", nullable = false)
    private String maHoaDon;
}
