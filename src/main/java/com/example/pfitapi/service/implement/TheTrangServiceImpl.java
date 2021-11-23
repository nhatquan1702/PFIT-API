package com.example.pfitapi.service.implement;

import com.example.pfitapi.dto.TheTrangDTO;
import com.example.pfitapi.entity.HocVien;
import com.example.pfitapi.entity.TheTrang;
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
        TheTrang theTrang = theTrangRepository.findByMaHocVien(maHocVien);
        TheTrangDTO theTrangDTO =  new TheTrangDTO().convertToDto(theTrang);
        return theTrangDTO;
    }

    @Override
    public Integer insertTheTrang(TheTrang theTrang) {
        boolean check = false;
        if(theTrangRepository.existsById(theTrang.getNgay())){
            return 2; //đã tồn tại thể trạng hôm nay
        }
        if(!theTrangRepository.existsById(theTrang.getNgay())){
            theTrangRepository.save(theTrang);
            check = true;
        }
        if(check == true){
            return 1; //insert thành công
        }
        else {
            return 0; //insert k thành công
        }
    }

    @Override
    public Integer insertTT(TheTrangDTO theTrangDTO) {
        boolean check = false;

        if(theTrangRepository.existsById(theTrangDTO.getNgay())){
            return 2; //đã tồn tại thể trạng hôm nay
        }
        if(!theTrangRepository.existsById(theTrangDTO.getNgay())){
            try {
                TheTrang theTrang = new TheTrangDTO().convertToEntity(theTrangDTO);
                HocVien hocVien = hocVienRepository.findByMaHocVien(theTrangDTO.getMaHocVien());
                theTrang.setHocVien(hocVien);
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


}
