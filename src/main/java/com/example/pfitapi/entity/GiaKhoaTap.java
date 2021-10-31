package com.example.pfitapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "GIAKHOATAP")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GiaKhoaTap {
    @EmbeddedId
    private GiaKhoaTapKey giaKhoaTapKey;

    @ManyToOne
    @MapsId("maKhoaTap")
    @JoinColumn(name = "MaKhoaTap")
    KhoaTap khoaTap;

    @ManyToOne
    @MapsId("maHoaDon")
    @JoinColumn(name = "MaHoaDon")
    HoaDon hoaDon;

    @Column(name = "SoLuongThang",nullable = false)
    private Integer soLuongThang;
}
