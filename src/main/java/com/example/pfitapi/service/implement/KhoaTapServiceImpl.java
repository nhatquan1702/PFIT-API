package com.example.pfitapi.service.implement;

import com.example.pfitapi.dto.KhoaTapDTO;
import com.example.pfitapi.dto.TheTrangDTO;
import com.example.pfitapi.entity.*;
import com.example.pfitapi.repository.HuanLuyenVienRepository;
import com.example.pfitapi.repository.KhoaTapRepository;
import com.example.pfitapi.repository.NhanVienRepository;
import com.example.pfitapi.service.in.KhoaTapInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class KhoaTapServiceImpl implements KhoaTapInterface {
    @Autowired
    private KhoaTapRepository khoaTapRepository;

    @Autowired
    private HuanLuyenVienRepository huanLuyenVienRepository;

    @Autowired
    private NhanVienRepository nhanVienRepository;


    @Override
    public KhoaTapDTO getKhoaTap(String maKhoaTap) {
        KhoaTap khoaTap = khoaTapRepository.findByMaKhoaTapAndTrangThai(maKhoaTap, 1);
        KhoaTapDTO khoaTapDTO = new KhoaTapDTO().convertToDto(khoaTap);
        return khoaTapDTO;
    }

    @Override
    public List<KhoaTapDTO> getListAllKhoaTap() {
        List<KhoaTap> khoaTapList = khoaTapRepository.findAllByTrangThai(1);
        List<KhoaTapDTO> khoaTapDTOList = new KhoaTapDTO().toListTheTrangDto(khoaTapList);
        return khoaTapDTOList;
    }

    @Override
    public Integer insertKhoaTap(KhoaTapDTO khoaTapDTO) {
        boolean check = false;
        NhanVien nhanVien = nhanVienRepository.findByMaNhanVien(khoaTapDTO.getMaNhanVien());
        HuanLuyenVien huanLuyenVien = huanLuyenVienRepository.findByMaHLV(khoaTapDTO.getMaHuanLuyenVien());
        if(khoaTapRepository.existsById(khoaTapDTO.getMaKhoaTap())){
            return 2; //đã tồn tại khóa tập này
        }
        if(!khoaTapRepository.existsById(khoaTapDTO.getMaKhoaTap())){
            try {
                KhoaTap khoaTap = new KhoaTapDTO().convertToEntity(khoaTapDTO, nhanVien, huanLuyenVien);
                khoaTapRepository.save(khoaTap);
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
    public Integer updateKhoaTap(KhoaTapDTO khoaTapDTO) {
        boolean check = false;
        NhanVien nhanVien = nhanVienRepository.findByMaNhanVien(khoaTapDTO.getMaNhanVien());
        HuanLuyenVien huanLuyenVien = huanLuyenVienRepository.findByMaHLV(khoaTapDTO.getMaHuanLuyenVien());
        if(!khoaTapRepository.existsById(khoaTapDTO.getMaKhoaTap())){
            return 2; //k tồn tại khóa tập này
        }
        if(khoaTapRepository.existsById(khoaTapDTO.getMaKhoaTap())){
            try {
                KhoaTap khoaTap = new KhoaTapDTO().convertToEntity(khoaTapDTO, nhanVien, huanLuyenVien);
                khoaTapRepository.save(khoaTap);
                check = true;
            }
            catch (Exception e){
                check = false;
            }
        }
        if(check == true){
            return 1; //up thành công
        }
        else {
            return 0; //up k thành công
        }
    }

    @Override
    public Integer updateTrangThaiKhoaTap(String maKhoaTap, Integer trangThai) {
        boolean check = false;
        if(!khoaTapRepository.existsById(maKhoaTap)){
            return 2; //k tồn tại khóa tập này
        }
        if(khoaTapRepository.existsById(maKhoaTap)){
            try {
                KhoaTap tam = khoaTapRepository.findByMaKhoaTapAndTrangThai(maKhoaTap, 1);
                KhoaTap khoaTap = new KhoaTap();
                khoaTap = khoaTapRepository.save(tam);
                khoaTap.setTrangThai(trangThai);
                khoaTapRepository.save(khoaTap);
                check = true;
            }
            catch (Exception e){
                check = false;
            }
        }
        if(check == true){
            return 1; //up thành công
        }
        else {
            return 0; //up k thành công
        }
    }
}
