package com.example.pfitapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "NGAYTAP")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NgayTap {
    @Id
    @Column(name = "NgayTap",nullable = false)
    private int ngayTap;
}
