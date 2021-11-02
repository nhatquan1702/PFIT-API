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
@Table(name = "NHOMCO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NhomCo {
    @Id
    @Column(name = "MaNhomCo", nullable = false)
    private String maNhomCo;

    @Column(name = "TenNhomCo",nullable = false)
    private String tenNhomCo;

    @Column(name = "HinhMinhHoa")
    private String hinhMinhHoa;
}
