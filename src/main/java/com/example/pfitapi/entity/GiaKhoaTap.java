package com.example.pfitapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

    @Column(name = "TrangThai",nullable = false)
    private Integer trangThai;
}
