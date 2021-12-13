package com.example.pfitapi.service.in;

import com.example.pfitapi.dto.DoanhThuDTO;
import com.example.pfitapi.dto.HoaDonDTO;
import com.example.pfitapi.entity.HoaDon;
import org.hibernate.mapping.Any;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

public interface HoaDonInterface {
    Object getDoanhThuTheoNgay(String ngay);

    Object getDoanhThuTheoThang(String thang, String nam);

    Object getDoanhThuTheoNam(String nam);

    List<HoaDonDTO> getListHoaDonTrongTheoNgay(Date ngay);
}
