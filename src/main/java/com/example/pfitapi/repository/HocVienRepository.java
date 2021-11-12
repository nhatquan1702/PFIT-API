package com.example.pfitapi.repository;

import com.example.pfitapi.entity.HocVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HocVienRepository extends JpaRepository<HocVien, String> {
    HocVien findByMaHocVien(String maHocVien);
}
