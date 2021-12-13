package com.example.pfitapi.repository;

import com.example.pfitapi.dto.DoanhThuDTO;
import com.example.pfitapi.entity.HoaDon;
import org.hibernate.mapping.Any;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.HashMap;
import java.util.List;

public interface HoaDonRepository extends JpaRepository<HoaDon, String> {
    @Query(value = "{CALL SP_DT_Ngay(:ngay)}", nativeQuery = true)
    List<Object[]> doanhThuTheoNgay(@Param("ngay") String ngay);

    @Query(value = "{CALL SP_DT_Thang(:thang, :nam)}", nativeQuery = true)
    List<Object[]> doanhThuTheoThang(@Param("thang") String thang, @Param("nam") String nam);

    @Query(value = "{CALL SP_DT_Nam(:nam)}", nativeQuery = true)
    List<Object[]> doanhThuTheoNam(@Param("nam") String nam);
}
