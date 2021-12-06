package com.example.pfitapi.service.implement;

import com.example.pfitapi.dto.HocVienDTO;
import com.example.pfitapi.dto.HocVienKTDTO;
import com.example.pfitapi.dto.KhoaTapDTO;
import com.example.pfitapi.entity.*;
import com.example.pfitapi.repository.HocVienRepository;
import com.example.pfitapi.repository.KhachHangRepository;
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

    @Autowired
    private KhachHangRepository khachHangRepository;


    @Override
    public HocVienKTDTO getMaKhoaTapTheoHocVien(String maHocVien) {
        HocVien hocVien = hocVienRepository.findByMaHocVien(maHocVien);
        HocVienKTDTO hocVienKTDTO = new HocVienKTDTO().convertToDto(hocVien);
        return hocVienKTDTO;
    }

    @Override
    public HocVienDTO getHocVienTheoTrangThai(String maHocVien, Integer trangThai) {
        HocVien hocVien = hocVienRepository.findByMaHocVienAndTrangThai(maHocVien, trangThai);
        return new HocVienDTO().convertToDto(hocVien);
    }

    @Override
    public Integer insertHocVien(HocVienDTO hocVienDTO) {
        boolean check = false;
        System.out.println("looix");
        KhoaTap khoaTap = khoaTapRepository.findByMaKhoaTap(hocVienDTO.getMaKhoaTap());
        System.out.println("aaaaaa "+khoaTap.toString());
        KhachHang khachHang = khachHangRepository.findByTaiKhoan(hocVienDTO.getTaiKhoan());
        if(hocVienRepository.existsById(hocVienDTO.getMaHocVien()) && hocVienDTO.getTrangThai()==1){
            return 2; //đã tồn tại học viên này
        }
        else {
            try {
                HocVien hocVien = new HocVienDTO().convertToEntity(hocVienDTO, khoaTap, khachHang);
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
        if(check == true){
            return 1; //update thành công
        }
        else {
            return 0; //update k thành công
        }
    }

}
