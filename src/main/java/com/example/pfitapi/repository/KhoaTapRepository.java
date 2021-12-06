package com.example.pfitapi.repository;

import com.example.pfitapi.dto.KhoaTapDTO;
import com.example.pfitapi.entity.KhoaTap;
import com.example.pfitapi.entity.TheTrang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface KhoaTapRepository extends JpaRepository<KhoaTap, String> {
    KhoaTap findByMaKhoaTapAndTrangThai(String maKhoaTap, Integer trangThai);

    List<KhoaTap> findAllByTrangThai(Integer trangThai);

    KhoaTap findByMaKhoaTap(String maKT);
}
