package com.example.pfitapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "HOADON")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HoaDon {
    @Id
    @Column(name = "MaHoaDon", nullable = false)
    private String maHoaDon;

    @Column(name = "NgayGioThanhToan",nullable = false)
    private Date ngayGioThanhToan;

    @Column(name = "HinhMinhHoa",nullable = false)
    private String hinhMinhHoa;

    @Column(name = "TongThanhToan",nullable = false)
    private Float tongThanhToan;

    @Column(name = "HinhThucThanhToan",nullable = false)
    private Integer hinhThucThanhToan;

    @Column(name = "GhiChu")
    private String ghiChu;

    @Column(name = "TrangThai",nullable = false)
    private String trangThai;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="MaHocVien",nullable = false)
    private HocVien hocVien;

    @JsonIgnore
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OneToMany(mappedBy = "hoaDon")
    List<GiaKhoaTap> giaKhoaTapList;
}
