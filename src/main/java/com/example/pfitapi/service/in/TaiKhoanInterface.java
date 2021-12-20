package com.example.pfitapi.service.in;

import com.example.pfitapi.dto.HocVienDTO;
import com.example.pfitapi.dto.TaiKhoanDTO;

public interface TaiKhoanInterface {
    Integer dangNhap(String maHocVien, String pass);

    TaiKhoanDTO getTTTaiKhoan(String taiKhoan);
}
