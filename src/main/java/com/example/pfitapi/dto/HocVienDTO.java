package com.example.pfitapi.dto;
import com.example.pfitapi.entity.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class HocVienDTO {

    private String maHocVien;

    private LocalDate ngayTao;

    private Date ngayHetHan;

    private Integer capDo;

    private Integer trangThai;

    private String ghiChu;

    private String maKhoaTap;

    private String taiKhoan;

    public HocVienDTO(String maHocVien, LocalDate ngayTao, Date ngayHetHan, Integer capDo, Integer trangThai, String ghiChu, String maKhoaTap, String taiKhoan) {
        this.maHocVien = maHocVien;
        this.ngayTao = ngayTao;
        this.ngayHetHan = ngayHetHan;
        this.capDo = capDo;
        this.trangThai = trangThai;
        this.ghiChu = ghiChu;
        this.maKhoaTap = maKhoaTap;
        this.taiKhoan = taiKhoan;
    }

    public HocVienDTO convertToDto(HocVien hocVien) {
        HocVienDTO hocVienDTO = new HocVienDTO();
        hocVienDTO.setMaHocVien(hocVien.getMaHocVien());
        hocVienDTO.setCapDo(hocVien.getCapDo());
        hocVienDTO.setGhiChu(hocVien.getGhiChu());
        hocVienDTO.setNgayHetHan(hocVien.getNgayHetHan());
        hocVienDTO.setNgayTao(hocVien.getNgayTao());
        hocVienDTO.setMaKhoaTap(hocVien.getKhoaTap().getMaKhoaTap());
        hocVienDTO.setTrangThai(hocVien.getTrangThai());
        hocVienDTO.setTaiKhoan(hocVien.getKhachHang().getTaiKhoan());
        return hocVienDTO;
    }

    public List<HocVienDTO> toListHocVienDto(List<HocVien> listEntity) {
        List<HocVienDTO> listDto = new ArrayList<>();
        listEntity.forEach(e->{
            listDto.add(this.convertToDto(e));
        });
        return listDto;
    }

    public HocVien convertToEntity(HocVienDTO hocVienDTO, KhoaTap khoaTap, KhachHang khachHang){
        HocVien hocVien = new HocVien();
        hocVien.setMaHocVien(hocVienDTO.getMaHocVien());
        hocVien.setCapDo(hocVienDTO.getCapDo());
        hocVien.setGhiChu(hocVienDTO.getGhiChu());
        hocVien.setNgayTao(hocVienDTO.getNgayTao());
        hocVien.setNgayHetHan(hocVienDTO.getNgayHetHan());
        hocVien.setTrangThai(hocVienDTO.getTrangThai());
        hocVien.setKhoaTap(khoaTap);
        hocVien.setKhachHang(khachHang);
        return hocVien;

    }
}
