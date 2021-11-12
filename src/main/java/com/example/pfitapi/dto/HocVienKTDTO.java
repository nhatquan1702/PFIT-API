package com.example.pfitapi.dto;

import com.example.pfitapi.entity.HocVien;
import com.example.pfitapi.entity.KhachHang;
import com.example.pfitapi.entity.KhoaTap;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class HocVienKTDTO {
    @NotNull
    private String maHocVien;

    private String maKhoaTap;

    public HocVienKTDTO(String maHocVien, String maKhoaTap) {
        maHocVien = maHocVien;
        this.maKhoaTap = maKhoaTap;
    }

    public HocVienKTDTO convertToDto(HocVien hocVien) {
        HocVienKTDTO hocVienKTDTO = new HocVienKTDTO();
        hocVienKTDTO.setMaHocVien(hocVien.getMaHocVien());
        hocVienKTDTO.setMaKhoaTap(hocVien.getKhoaTap().getMaKhoaTap());
        return hocVienKTDTO;
    }

    public List<HocVienKTDTO> toListKhachHangDto(List<HocVien> listEntity) {
        List<HocVienKTDTO> listDto = new ArrayList<>();
        listEntity.forEach(e->{
            listDto.add(this.convertToDto(e));
        });
        return listDto;
    }
}
