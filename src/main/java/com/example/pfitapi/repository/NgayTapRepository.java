package com.example.pfitapi.repository;

import com.example.pfitapi.entity.NgayTap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NgayTapRepository extends JpaRepository <NgayTap, Integer> {
    @Override
    List<NgayTap> findAll();
}
