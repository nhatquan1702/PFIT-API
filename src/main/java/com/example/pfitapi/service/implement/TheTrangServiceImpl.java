package com.example.pfitapi.service.implement;

import com.example.pfitapi.dto.TheTrangDTO;
import com.example.pfitapi.entity.HocVien;
import com.example.pfitapi.entity.TheTrang;
import com.example.pfitapi.entity.TheTrangKey;
import com.example.pfitapi.repository.HocVienRepository;
import com.example.pfitapi.repository.TheTrangRepository;
import com.example.pfitapi.service.in.TheTrangInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

@Service
@Transactional
public class TheTrangServiceImpl implements TheTrangInterface {
    @Autowired
    private TheTrangRepository theTrangRepository;

    @Autowired
    private HocVienRepository hocVienRepository;


    @Override
    public TheTrangDTO getTheTrangTheoMaHVvaNgay(String maHocVien, Date ngay) {
        TheTrang theTrang = theTrangRepository.findByMaHocVienAndNgay(maHocVien, ngay);
        TheTrangDTO theTrangDTO =  new TheTrangDTO().convertToDto(theTrang);
        return theTrangDTO;
    }

    @Override
    public List<TheTrangDTO> getTheTrangTheoThang(String maHV, String thang, String nam) {
        List<TheTrang> theTrangList = theTrangRepository.findByMaHocVienAndThang(maHV, thang, nam);
        List<TheTrangDTO> theTrangDTOList =  new TheTrangDTO().toListTheTrangDto(theTrangList);
        return theTrangDTOList;
    }

    @Override
    public List<TheTrangDTO> getTheTrangTheoNam(String maHV, String nam) {
        List<TheTrang> theTrangList = theTrangRepository.findByMaHocVienAndNam(maHV, nam);
        List<TheTrangDTO> theTrangDTOList =  new TheTrangDTO().toListTheTrangDto(theTrangList);
        return theTrangDTOList;
    }

    @Override
    public TheTrangDTO getTheTrangGanNhat(String maHocVien) {
        TheTrang theTrang = theTrangRepository.thTrangGanNhat(maHocVien);
        TheTrangDTO theTrangDTO =  new TheTrangDTO().convertToDto(theTrang);
        return theTrangDTO;
    }

//    @Override
//    public Integer insertTheTrang(TheTrang theTrang) {
//        boolean check = false;
//        if(theTrangRepository.existsById(theTrang.getTheTrangKey())){
//            return 2; //đã tồn tại thể trạng hôm nay
//        }
//        if(!theTrangRepository.existsById(theTrang.getTheTrangKey())){
//            theTrangRepository.save(theTrang);
//            check = true;
//        }
//        if(check == true){
//            return 1; //insert thành công
//        }
//        else {
//            return 0; //insert k thành công
//        }
//    }

    @Override
    public Integer insertTT(TheTrangDTO theTrangDTO) {
        boolean check = false;
        HocVien hocVien = hocVienRepository.findByMaHocVien(theTrangDTO.getMaHocVien());
        TheTrangKey theTrangKey = new TheTrangKey(theTrangDTO.getNgay(), hocVien);
        if(theTrangRepository.existsById(theTrangKey)){
            return 2; //đã tồn tại thể trạng hôm nay
        }
        if(!theTrangRepository.existsById(theTrangKey)){
            try {
                TheTrang theTrang = new TheTrangDTO().convertToEntity(theTrangDTO, hocVien);
                theTrang.setTheTrangKey(theTrangKey);
                theTrangRepository.save(theTrang);
                check = true;
            }
            catch (Exception e){
                check = false;
            }
        }
        if(check == true){
            return 1; //insert thành công
        }
        else {
            return 0; //insert k thành công
        }
    }

    @Override
    public Integer updateLuongNuoc(Date ngay, String maHocVien, Float luongNuoc) {
        HocVien hocVien = hocVienRepository.findByMaHocVien(maHocVien);
        TheTrangKey theTrangKey = new TheTrangKey(ngay, hocVien);
        boolean check = false;
        if(theTrangRepository.existsById(theTrangKey)){
            try {
                TheTrang tmpTT = theTrangRepository.findByTheTrangKeyNgay(ngay);
                TheTrang theTrang = new TheTrang();
                theTrang = theTrangRepository.save(tmpTT);
                Float luongNuocTmp = tmpTT.getLuongNuoc();
                Float tmp = luongNuocTmp + luongNuoc;
                if(tmp > 3500){
                    return 2; //lượng nước đã vượt tối đa
                }
                if(tmp < 0){
                    return 3; //lượng nước không hợp lệ
                }
                if(tmp > 0 && (tmp < 3500 || tmp == 3500)){
                    theTrang.setLuongNuoc(tmp);
                }
                theTrangRepository.save(theTrang);
                check = true;
            }
            catch (Exception e){
                check = false;
            }
        }
        else {
            return 4; // không tìm thấy thể trạng ngày này
        }
        if(check == true){
            return 1; //update thành công
        }
        else {
            return 0; //update không thành công
        }
    }

    @Override
    public Integer updateTheTrang(TheTrangDTO theTrangDTO) {
        boolean check = false;
        HocVien hocVien = hocVienRepository.findByMaHocVien(theTrangDTO.getMaHocVien());
        TheTrangKey theTrangKey = new TheTrangKey(theTrangDTO.getNgay(), hocVien);
        if(theTrangRepository.existsById(theTrangKey)){
            try {
                TheTrang tmpTT = theTrangRepository.findByTheTrangKeyNgay(theTrangDTO.getNgay());
                TheTrang theTrang = new TheTrang();
                theTrang = new TheTrangDTO().convertToEntity(theTrangDTO, hocVien);
                theTrang.setLuongNuoc(tmpTT.getLuongNuoc());
                theTrangRepository.save(theTrang);
                check = true;
            }
            catch (Exception e){
                check = false;
            }
        }
        else {
            return 2; // không tìm thấy thể trạng ngày này
        }
        if(check == true){
            return 1; //update thành công
        }
        else {
            return 0; //update không thành công
        }
    }


}
