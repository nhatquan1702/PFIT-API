package com.example.pfitapi.dto;
import com.example.pfitapi.entity.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class HocVienDTO {

    private String maHocVien;

    private Integer tuoi;

    private Integer gioiTinh;

    private Date ngayThamGia;

    private Integer capDo;

    private Integer trangThai;

    private String maKhoaTap;

    public HocVienDTO(String maHocVien, Integer tuoi, Integer gioiTinh, Date ngayThamGia, Integer capDo, Integer trangThai, String maKhoaTap) {
        this.maHocVien = maHocVien;
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
        this.ngayThamGia = ngayThamGia;
        this.capDo = capDo;
        this.trangThai = trangThai;
        this.maKhoaTap = maKhoaTap;
    }

    public HocVienDTO convertToDto(HocVien hocVien) {
        HocVienDTO hocVienDTO = new HocVienDTO();
        hocVienDTO.setMaHocVien(hocVien.getMaHocVien());
        hocVienDTO.setCapDo(hocVien.getCapDo());
        hocVienDTO.setMaKhoaTap(hocVien.getKhoaTap().getMaKhoaTap());
        hocVienDTO.setTrangThai(hocVien.getTrangThai());
        hocVienDTO.setGioiTinh(hocVien.getGioiTinh());
        hocVienDTO.setNgayThamGia(hocVien.getNgayThamGia());
        hocVienDTO.setTuoi(hocVien.getTuoi());
        return hocVienDTO;
    }

    public List<HocVienDTO> toListHocVienDto(List<HocVien> listEntity) {
        List<HocVienDTO> listDto = new ArrayList<>();
        listEntity.forEach(e->{
            listDto.add(this.convertToDto(e));
        });
        return listDto;
    }

    public HocVien convertToEntity(HocVienDTO hocVienDTO, KhoaTap khoaTap){
        HocVien hocVien = new HocVien();
        hocVien.setMaHocVien(hocVienDTO.getMaHocVien());
        hocVien.setCapDo(hocVienDTO.getCapDo());
        hocVien.setTrangThai(hocVienDTO.getTrangThai());
        hocVien.setKhoaTap(khoaTap);
        hocVien.setTuoi(hocVienDTO.getTuoi());
        hocVien.setGioiTinh(hocVienDTO.getGioiTinh());
        hocVien.setNgayThamGia(hocVienDTO.getNgayThamGia());
        return hocVien;

    }
}
