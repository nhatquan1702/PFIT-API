package com.example.pfitapi.repository;

import com.example.pfitapi.entity.HuanLuyenVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HuanLuyenVienRepository extends JpaRepository<HuanLuyenVien, String> {
    @Override
    List<HuanLuyenVien> findAll();

    @Override
    List<HuanLuyenVien> findAllById(Iterable<String> strings);
}
