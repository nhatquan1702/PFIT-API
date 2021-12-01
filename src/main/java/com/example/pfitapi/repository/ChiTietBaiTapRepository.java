package com.example.pfitapi.repository;

import com.example.pfitapi.entity.ChiTietBaiTap;
import com.example.pfitapi.entity.ChiTietBaiTapKey;
import com.example.pfitapi.entity.TheTrang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface ChiTietBaiTapRepository extends JpaRepository<ChiTietBaiTap, ChiTietBaiTapKey> {
    ChiTietBaiTap findChiTietBaiTapByBaiTapMaBaiTap(String maBaiTap);

    ChiTietBaiTap findByChiTietBaiTapKey(ChiTietBaiTapKey chiTietBaiTapKey);

    @Query(value = "SELECT COUNT(ct.baiTap.maBaiTap) FROM ChiTietBaiTap AS ct WHERE ct.baiTap.khoaTap.maKhoaTap = :maKhoaTap AND ct.baiTap.ngayTap.ngayTap = :ngayTap AND ct.trangThai=1 AND ct.hocVien.maHocVien = :maHocVien")
    Integer soBTHTTrongNgay(@Param("maKhoaTap") String maKhoaTap, @Param("maHocVien") String maHocVien, @Param("ngayTap") Integer ngayTap);

    @Query(value = "SELECT COUNT(ct.baiTap.maBaiTap) FROM ChiTietBaiTap AS ct WHERE ct .baiTap.khoaTap.maKhoaTap = :maKhoaTap AND ct.baiTap.ngayTap.ngayTap = :ngayTap AND ct.hocVien.maHocVien = :maHocVien")
    Integer allBTTrongNgay(@Param("maKhoaTap") String maKhoaTap, @Param("maHocVien") String maHocVien, @Param("ngayTap") Integer ngayTap);
    //M truyen param sai kia null

    @Query( value = "SELECT COUNT(ct.baiTap.maBaiTap) FROM ChiTietBaiTap AS ct WHERE ct.baiTap.khoaTap.maKhoaTap = :makhoatap AND ct.hocVien.maHocVien = :mahocvien AND ct.trangThai = 1 ")
    Integer soBTHTTrongKhoa(@Param("makhoatap") String maKhoaTap, @Param("mahocvien") String maHocVien);

    @Query( value = "SELECT COUNT(ct.baiTap.maBaiTap) FROM ChiTietBaiTap AS ct WHERE ct.baiTap.khoaTap.maKhoaTap = :makhoatap AND ct.hocVien.maHocVien = :mahocvien ")
    Integer allBTHTTrongKhoa(@Param("makhoatap") String maKhoaTap, @Param("mahocvien") String maHocVien);
}
