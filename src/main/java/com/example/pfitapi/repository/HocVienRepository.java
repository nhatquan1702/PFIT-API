package com.example.pfitapi.repository;

import com.example.pfitapi.entity.HocVien;
import com.example.pfitapi.entity.KhoaTap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HocVienRepository extends JpaRepository<HocVien, String> {
    HocVien findByMaHocVien(String maHocVien);

    HocVien findByMaHocVienAndTrangThai(String maHocVien, Integer trangThai);
}
