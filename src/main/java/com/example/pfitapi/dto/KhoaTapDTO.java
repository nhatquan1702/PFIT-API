package com.example.pfitapi.dto;

import com.example.pfitapi.entity.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class KhoaTapDTO {
    private String maKhoaTap;

    private String tenKhoaTap;

    private String hinhQuangCao;

    private Integer giaTheoThang;

    private Integer choDoiTuong;

    private Integer trangThai;

    private String maNhanVien;

    private String maHuanLuyenVien;

    public KhoaTapDTO convertToDto(KhoaTap khoaTap) {
        KhoaTapDTO khoaTapDTO = new KhoaTapDTO();
        khoaTapDTO.setMaKhoaTap(khoaTap.getMaKhoaTap());
        khoaTapDTO.setTenKhoaTap(khoaTap.getTenKhoaTap());
        khoaTapDTO.setChoDoiTuong(khoaTap.getChoDoiTuong());
        khoaTapDTO.setGiaTheoThang(khoaTap.getGiaTheoThang());
        khoaTapDTO.setHinhQuangCao(khoaTap.getHinhQuangCao());
        khoaTapDTO.setMaHuanLuyenVien(khoaTap.getHuanLuyenVien().getMaHLV());
        khoaTapDTO.setMaNhanVien(khoaTap.getNhanVien().getMaNhanVien());
        khoaTapDTO.setTrangThai(khoaTap.getTrangThai());
        return khoaTapDTO;
    }

    public List<KhoaTapDTO> toListTheTrangDto(List<KhoaTap> listEntity) {
        List<KhoaTapDTO> listDto = new ArrayList<>();
        listEntity.forEach(e->{
            listDto.add(this.convertToDto(e));
        });
        return listDto;
    }

    public KhoaTap convertToEntity(KhoaTapDTO khoaTapDTO, NhanVien nhanVien, HuanLuyenVien hlv){
        KhoaTap khoaTap = new KhoaTap();
        khoaTap.setMaKhoaTap(khoaTapDTO.getMaKhoaTap());
        khoaTap.setTenKhoaTap(khoaTapDTO.getTenKhoaTap());
        khoaTap.setHinhQuangCao(khoaTapDTO.getHinhQuangCao());
        khoaTap.setGiaTheoThang(khoaTapDTO.getGiaTheoThang());
        khoaTap.setChoDoiTuong(khoaTapDTO.getChoDoiTuong());
        khoaTap.setTrangThai(khoaTapDTO.getTrangThai());
        khoaTap.setNhanVien(nhanVien);
        khoaTap.setHuanLuyenVien(hlv);
        return khoaTap;

    }
}
