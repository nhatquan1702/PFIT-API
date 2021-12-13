package com.example.pfitapi.service.implement;

import com.example.pfitapi.dto.DoanhThuDTO;
import com.example.pfitapi.dto.HoaDonDTO;
import com.example.pfitapi.entity.HoaDon;
import com.example.pfitapi.repository.HoaDonRepository;
import com.example.pfitapi.service.in.HoaDonInterface;
import org.hibernate.mapping.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class HoaDonServiceImpl implements HoaDonInterface {
    @Autowired
    private HoaDonRepository hoaDonRepository;

    @Override
    public  List<Object[]> getDoanhThuTheoNgay(String ngay) {
//        System.out.println(hoaDonRepository.doanhThuTheoNgay(ngay).size());
//        System.out.println(hoaDonRepository.doanhThuTheoNgay(ngay).get(0)[0].toString());
//        System.out.println(hoaDonRepository.doanhThuTheoNgay(ngay).get(0)[1].toString());
//        System.out.println(hoaDonRepository.doanhThuTheoNgay(ngay)[1]);
        return hoaDonRepository.doanhThuTheoNgay(ngay);
    }

    @Override
    public List<Object[]> getDoanhThuTheoThang(String thang, String nam) {
        return hoaDonRepository.doanhThuTheoThang(thang, nam);
    }

    @Override
    public List<Object[]> getDoanhThuTheoNam(String nam) {
        return hoaDonRepository.doanhThuTheoNam(nam);
    }

    @Override
    public List<HoaDonDTO> getListHoaDonTrongTheoNgay(Date ngay) {
        List<HoaDon> hoaDonList = hoaDonRepository.getListHoaDonTrongNgay(ngay);
        List<HoaDonDTO> hoaDonDTOList = new HoaDonDTO().toListTheTrangDto(hoaDonList);
        return hoaDonDTOList;
    }
}
