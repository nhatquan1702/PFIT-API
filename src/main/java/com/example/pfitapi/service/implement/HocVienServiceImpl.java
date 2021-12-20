package com.example.pfitapi.service.implement;

import com.example.pfitapi.dto.HocVienDTO;
import com.example.pfitapi.dto.HocVienKTDTO;
import com.example.pfitapi.entity.*;
import com.example.pfitapi.repository.HocVienRepository;
import com.example.pfitapi.repository.KhoaTapRepository;
import com.example.pfitapi.service.in.HocVienInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class HocVienServiceImpl implements HocVienInterface {
    @Autowired
    private HocVienRepository hocVienRepository;

    @Autowired
    private KhoaTapRepository khoaTapRepository;

    @Override
    public HocVienKTDTO getMaKhoaTapTheoHocVien(String maHocVien) {
        HocVien hocVien = hocVienRepository.findByMaHocVien(maHocVien);
        return new HocVienKTDTO().convertToDto(hocVien);
    }

    @Override
    public HocVienDTO getHocVienTheoTrangThai(String maHocVien, Integer trangThai) {
        HocVien hocVien = hocVienRepository.findByMaHocVienAndTrangThai(maHocVien, trangThai);
        return new HocVienDTO().convertToDto(hocVien);
    }

    @Override
    public Integer insertHocVien(HocVienDTO hocVienDTO) {
        boolean check = false;
        KhoaTap khoaTap = khoaTapRepository.findByMaKhoaTap(hocVienDTO.getMaKhoaTap());
        if(hocVienRepository.existsById(hocVienDTO.getMaHocVien()) && hocVienDTO.getTrangThai()==1){
            return 2; //đã tồn tại học viên này
        }
        else {
            try {
                HocVien hocVien = new HocVienDTO().convertToEntity(hocVienDTO, khoaTap);
                hocVienRepository.save(hocVien);
                check = true;
            }
            catch (Exception e){
               check = false;
            }
        }
        if(check){
            return 1; //insert thành công
        }
        else {
            return 0; //insert k thành công
        }
    }

    @Override
    public Integer updateTrangThaiHocVien(String maHocVien, Integer trangThai) {
        boolean check = false;
        if(!hocVienRepository.existsById(maHocVien)){
            return 2; //k tồn tại học viên này
        }
        if(hocVienRepository.existsById(maHocVien)){
            try {
                HocVien hvTam = hocVienRepository.findByMaHocVien(maHocVien);
                HocVien hocVien = new HocVien();
                hocVien = hocVienRepository.save(hvTam);
                hocVien.setTrangThai(trangThai);
                hocVienRepository.save(hocVien);
                check = true;
            }
            catch (Exception e){
                check = false;
            }
        }
        if(check){
            return 1; //update thành công
        }
        else {
            return 0; //update k thành công
        }
    }

    @Override
    public Integer updateKhoaTapChoHocVien(String maHocVien, String maKhoaTap) {
        boolean check = false;
        KhoaTap khoaTap = khoaTapRepository.findByMaKhoaTap(maKhoaTap);
        if(!hocVienRepository.existsById(maHocVien)){
            return 2; //k tồn tại học viên này
        }
        if(hocVienRepository.existsById(maHocVien)){
            try {
                HocVien hvTam = hocVienRepository.findByMaHocVien(maHocVien);
                HocVien hocVien = new HocVien();
                hocVien = hocVienRepository.save(hvTam);
                hocVien.setKhoaTap(khoaTap);
                hocVienRepository.save(hocVien);
                check = true;
            }
            catch (Exception e){
                check = false;
            }
        }
        if(check){
            return 1; //update thành công
        }
        else {
            return 0; //update k thành công
        }
    }

    @Override
    public HocVienDTO getTTHocVien(String maHocVien) {
        HocVien hocVien = hocVienRepository.findByMaHocVien(maHocVien);
        return new HocVienDTO().convertToDto(hocVien);
    }

}
