package com.example.pfitapi.service.implement;

import com.example.pfitapi.dto.TaiKhoanDTO;
import com.example.pfitapi.entity.TaiKhoan;
import com.example.pfitapi.repository.TaiKhoanRepository;
import com.example.pfitapi.service.in.TaiKhoanInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TaiKhoanServiceImpl implements TaiKhoanInterface {
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    @Override
    public Integer dangNhap(String maHocVien, String pass) {
        TaiKhoan taiKhoan = taiKhoanRepository.findByTaiKhoan(maHocVien);
        if(!taiKhoanRepository.existsById(maHocVien)){
            return 0; //tài khoản k tồn tại
        }
        if (!pass.equals(taiKhoan.getMatKhau())) {
            return 0; //sai mk
        }
        if (taiKhoan.getTrangThai() != -1 && taiKhoan.getMatKhau().equals(pass) ){
            return 1; // tk khác tt xóa và đúng pass
        }
        else {
            return -1; //k dn dc
        }
    }

    @Override
    public TaiKhoanDTO getTTTaiKhoan(String taiKhoan) {
        TaiKhoan taiKhoan1 = taiKhoanRepository.findByTaiKhoan(taiKhoan);
        TaiKhoanDTO taiKhoanDTO = new TaiKhoanDTO().convertToDto(taiKhoan1);
        return  taiKhoanDTO;
    }
}
