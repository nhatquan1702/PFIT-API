package com.example.pfitapi.repository;

import com.example.pfitapi.entity.ChiTietBaiTap;
import com.example.pfitapi.entity.ChiTietBaiTapKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiTietBaiTapRepository extends JpaRepository<ChiTietBaiTap, ChiTietBaiTapKey> {
    ChiTietBaiTap findChiTietBaiTapByBaiTapMaBaiTap(String maBaiTap);
}
