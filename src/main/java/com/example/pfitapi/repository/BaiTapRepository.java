package com.example.pfitapi.repository;

import com.example.pfitapi.entity.BaiTap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaiTapRepository extends JpaRepository<BaiTap, String> {
    @Override
    List<BaiTap> findAll();

    @Override
    List<BaiTap> findAllById(Iterable<String> strings);
}
