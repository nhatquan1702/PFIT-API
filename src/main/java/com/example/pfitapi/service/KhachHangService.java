package com.example.pfitapi.service;

import com.example.pfitapi.dto.KhachHangDTO;
import com.example.pfitapi.entity.KhachHang;
import com.example.pfitapi.repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class KhachHangService {
    @Autowired
    private KhachHangRepository khachHangRepository;

    public Integer dangNhap(String email, String password) {
        KhachHang khachHang = khachHangRepository.findByMaHocVien(email);
        if(!khachHangRepository.existsKhachHangByMaHocVien(email)){
            return 0; //tài khoản k tồn tại
        }
        if (!password.equals(khachHang.getMatKhau())) {
            return 0; //sai mk
        }
        if (khachHang.getTrangThai() != -1 && khachHang.getMatKhau().equals(password) ){
            return 1; // tk khác tt xóa và đúng pass
        }
        else {
            return -1; //k dn dc
        }
    }

    public KhachHang getKhachHang(String taiKhoan){
        return khachHangRepository.findByMaHocVien(taiKhoan);
    }

}
