package com.example.pfitapi.service.in;

import com.example.pfitapi.dto.TheTrangDTO;

import java.sql.Date;

public interface TheTrangInterface {
    TheTrangDTO getTheTrangTheoMaHVvaNgay(String maHocVien, Date ngay);

    TheTrangDTO getTheTrangTheoThang (String maHV, String thang, String nam);

    TheTrangDTO getTheTrangTheoNam (String maHV, String nam);
}
