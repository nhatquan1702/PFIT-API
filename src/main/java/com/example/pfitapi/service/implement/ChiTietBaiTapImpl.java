package com.example.pfitapi.service.implement;

import com.example.pfitapi.dto.ChiTietBaiTapChoHVDTO;
import com.example.pfitapi.dto.ChiTietBaiTapDTO;
import com.example.pfitapi.entity.*;
import com.example.pfitapi.repository.ChiTietBaiTapRepository;
import com.example.pfitapi.service.in.ChiTietBaiTapInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ChiTietBaiTapImpl implements ChiTietBaiTapInterface {
    @Autowired
    private ChiTietBaiTapRepository chiTietBaiTapRepository;
    @Override
    public ChiTietBaiTapDTO getChiTietBT(String maBaiTap) {
        ChiTietBaiTap chiTietBaiTap = chiTietBaiTapRepository.findChiTietBaiTapByBaiTapMaBaiTap(maBaiTap);
        return new ChiTietBaiTapDTO().convertToDto(chiTietBaiTap);
    }

    @Override
    public ChiTietBaiTapChoHVDTO getChiTietBTChoHV(String maBaiTap, String maHocVien) {
        ChiTietBaiTapKey chiTietBaiTapKey = new ChiTietBaiTapKey(maBaiTap, maHocVien);
        ChiTietBaiTap chiTietBaiTap = chiTietBaiTapRepository.findByChiTietBaiTapKey(chiTietBaiTapKey);
        return new ChiTietBaiTapChoHVDTO().convertToDto(chiTietBaiTap);
    }

    @Override
    public Integer updateTrangThaiBTChoHV(String maBaiTap, String maHocVien, Integer trangThai) {
        ChiTietBaiTapKey chiTietBaiTapKey = new ChiTietBaiTapKey(maBaiTap, maHocVien);
        boolean check = false;
        if(chiTietBaiTapRepository.existsById(chiTietBaiTapKey)){
            try {
                ChiTietBaiTap chiTietBaiTapCu = chiTietBaiTapRepository.findByChiTietBaiTapKey(chiTietBaiTapKey);
                ChiTietBaiTap chiTietBaiTap = new ChiTietBaiTap();
                chiTietBaiTap = chiTietBaiTapRepository.save(chiTietBaiTapCu);
                chiTietBaiTap.setTrangThai(trangThai);
                chiTietBaiTapRepository.save(chiTietBaiTap);
                check = true;
            }
            catch (Exception e){
                check = false;
            }
        }
        else {
            return 4; // không tìm thấy bài tập này
        }
        if(check){
            return 1; //update thành công
        }
        else {
            return 0; //update không thành công
        }
    }

    @Override
    public Integer updateGhiChuBTChoHV(String maBaiTap, String maHocVien, String ghiChu) {
        ChiTietBaiTapKey chiTietBaiTapKey = new ChiTietBaiTapKey(maBaiTap, maHocVien);
        boolean check = false;
        if(chiTietBaiTapRepository.existsById(chiTietBaiTapKey)){
            try {
                ChiTietBaiTap chiTietBaiTapCu = chiTietBaiTapRepository.findByChiTietBaiTapKey(chiTietBaiTapKey);
                ChiTietBaiTap chiTietBaiTap = new ChiTietBaiTap();
                chiTietBaiTap = chiTietBaiTapRepository.save(chiTietBaiTapCu);
                chiTietBaiTap.setGhiChu(ghiChu);
                chiTietBaiTapRepository.save(chiTietBaiTap);
                check = true;
            }
            catch (Exception e){
                check = false;
            }
        }
        else {
            return 4; // không tìm thấy bài tập này
        }
        if(check){
            return 1; //update thành công
        }
        else {
            return 0; //update không thành công
        }
    }

    @Override
    public Integer getPTHTBTTrongNgay( String maKhoaTap, String maHocVien, Integer ngayTap) {
        Integer slHTBTNgay = chiTietBaiTapRepository.soBTHTTrongNgay(maKhoaTap, maHocVien, ngayTap);
        Integer allBTNgay = chiTietBaiTapRepository.allBTTrongNgay(maKhoaTap, maHocVien, ngayTap);
        Integer check1, check2;
        if(slHTBTNgay>0){
            check1 = slHTBTNgay;
        }
        else {
            check1 = 0;
        }
        if(allBTNgay>0){
            check2 = allBTNgay;
        }
        else {
            check2 = 1;
        }
        return check1*100/check2;
    }

    @Override
    public Integer getPTHTBTTrongKhoa(String maKhoaTap, String maHocVien) {
        Integer slHTBTNgay = chiTietBaiTapRepository.soBTHTTrongKhoa(maKhoaTap, maHocVien);
        Integer allBTNgay = chiTietBaiTapRepository.allBTHTTrongKhoa(maKhoaTap, maHocVien);
        Integer check1, check2;
        if(slHTBTNgay>0){
            check1 = slHTBTNgay;
        }
        else {
            check1 = 0;
        }
        if(allBTNgay>0){
            check2 = allBTNgay;
        }
        else {
            check2 = 1;
        }
        return check1*100/check2;
    }

}
