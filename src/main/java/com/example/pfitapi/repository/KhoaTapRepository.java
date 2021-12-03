package com.example.pfitapi.repository;

import com.example.pfitapi.entity.KhoaTap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KhoaTapRepository extends JpaRepository<KhoaTap, String> {
    KhoaTap findByMaKhoaTapAndTrangThai(String maKhoaTap, Integer trangThai);

    List<KhoaTap> findAllByTrangThai(Integer trangThai);
}
