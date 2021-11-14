package com.example.pfitapi.repository;

import com.example.pfitapi.entity.TheTrang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface TheTrangRepository extends JpaRepository<TheTrang, String> {
    @Query("SELECT t FROM TheTrang AS t WHERE t.maHocVien = :mahocvien AND t.ngay = :ngay ")
    TheTrang findByMaHocVienAndNgay(@Param("mahocvien") String maHocVien, @Param("ngay") Date ngay);

    @Query(value = "{CALL SP_TheTrangHVTheoThang(:mahocvien, :thang, :nam)}", nativeQuery = true)
    TheTrang findByMaHocVienAndThang (@Param("mahocvien") String maHV, @Param("thang") String thang, @Param("nam") String nam);

    @Query(value = "{CALL SP_TheTrangHVTheoNam(:mahocvien, :nam)}", nativeQuery = true)
    TheTrang findByMaHocVienAndNam(@Param("mahocvien") String maHV, @Param("nam") String nam);
}
