package com.example.pfitapi.repository;

import com.example.pfitapi.entity.NhomCo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhomCoRepository extends JpaRepository<NhomCo, String> {
    @Override
    List<NhomCo> findAll();

    @Override
    List<NhomCo> findAllById(Iterable<String> strings);
}
