package com.example.pfitapi.service.in;

import com.example.pfitapi.dto.TheTrangDTO;
import com.example.pfitapi.entity.TheTrang;

import java.sql.Date;
import java.util.List;

public interface TheTrangInterface {
    TheTrangDTO getTheTrangTheoMaHVvaNgay(String maHocVien, Date ngay);

    List<TheTrangDTO> getTheTrangTheoThang (String maHV, String thang, String nam);

    List<TheTrangDTO> getTheTrangTheoNam (String maHV, String nam);

    TheTrangDTO getTheTrangGanNhat(String maHocVien);

    Integer insertTheTrang (TheTrang theTrang);

    Integer insertTT (TheTrangDTO theTrangDTO);
}
