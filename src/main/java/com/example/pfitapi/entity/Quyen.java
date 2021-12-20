package com.example.pfitapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "QUYEN")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Quyen {
    @Id
    @Column(name = "MaQuyen", nullable = false)
    private int maQuyen;

    @Column(name = "TenQuyen", nullable = false)
    private String tenQuyen;

}
