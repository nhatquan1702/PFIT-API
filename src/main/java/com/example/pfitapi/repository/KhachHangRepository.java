package com.example.pfitapi.repository;

import com.example.pfitapi.entity.KhachHang;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, String> {


    @Override
    List<KhachHang> findAllById(Iterable<String> strings);

    Boolean existsKhachHangByMaHocVien(String taiKhoan);

    KhachHang findByMaHocVien(String maHocVien);
}