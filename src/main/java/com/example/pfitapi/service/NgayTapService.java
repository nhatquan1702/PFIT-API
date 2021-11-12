package com.example.pfitapi.service;

import com.example.pfitapi.entity.NgayTap;
import com.example.pfitapi.repository.NgayTapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class NgayTapService {
    @Autowired
    private NgayTapRepository ngayTapRepository;

    public List<NgayTap> getListNgayTap(){
        List<NgayTap> ngayTapList = ngayTapRepository.findAll();
        return ngayTapList;
    }
}
