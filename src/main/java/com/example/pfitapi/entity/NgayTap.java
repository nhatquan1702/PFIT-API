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
@Table(name = "NGAYTAP")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NgayTap {
    @Id
    @Column(name = "NgayTap",nullable = false)
    private Integer ngayTap;

    @Column(name = "TrangThai", nullable = false)
    private  Integer trangThai;
}
