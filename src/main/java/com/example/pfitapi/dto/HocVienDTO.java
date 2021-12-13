package com.example.pfitapi.dto;
import com.example.pfitapi.entity.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class HocVienDTO {

    private String maHocVien;

    private Integer capDo;

    private Integer trangThai;

    private String ghiChu;

    private String maKhoaTap;

    private String matKhau;

    private String hoTen;

    private Integer tuoi;

    private Integer gioiTinh;

    private Date ngayThamGia;

    private String soDienThoai;

    private String diaChi;

    public HocVienDTO(String maHocVien, Integer capDo, Integer trangThai, String ghiChu, String maKhoaTap, String matKhau, String hoTen, Integer tuoi, Integer gioiTinh, Date ngayThamGia, String soDienThoai, String diaChi) {
        this.maHocVien = maHocVien;
        this.capDo = capDo;
        this.trangThai = trangThai;
        this.ghiChu = ghiChu;
        this.maKhoaTap = maKhoaTap;
        this.matKhau = matKhau;
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
        this.ngayThamGia = ngayThamGia;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
    }

    public HocVienDTO convertToDto(HocVien hocVien) {
        HocVienDTO hocVienDTO = new HocVienDTO();
        hocVienDTO.setMaHocVien(hocVien.getMaHocVien());
        hocVienDTO.setCapDo(hocVien.getCapDo());
        hocVienDTO.setGhiChu(hocVien.getGhiChu());
        hocVienDTO.setMaKhoaTap(hocVien.getKhoaTap().getMaKhoaTap());
        hocVienDTO.setTrangThai(hocVien.getTrangThai());
        hocVienDTO.setMaKhoaTap(hocVien.getKhoaTap().getMaKhoaTap());
        hocVienDTO.setDiaChi(hocVien.getDiaChi());
        hocVienDTO.setSoDienThoai(hocVien.getSoDienThoai());
        hocVienDTO.setGioiTinh(hocVien.getGioiTinh());
        hocVienDTO.setNgayThamGia(hocVien.getNgayThamGia());
        hocVienDTO.setHoTen(hocVien.getHoTen());
        hocVienDTO.setTuoi(hocVien.getTuoi());
        hocVienDTO.setMatKhau(hocVien.getMatKhau());
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
        hocVien.setGhiChu(hocVienDTO.getGhiChu());
        hocVien.setTrangThai(hocVienDTO.getTrangThai());
        hocVien.setKhoaTap(khoaTap);
        hocVien.setHoTen(hocVienDTO.getHoTen());
        hocVien.setTuoi(hocVienDTO.getTuoi());
        hocVien.setGioiTinh(hocVienDTO.getGioiTinh());
        hocVien.setDiaChi(hocVienDTO.getDiaChi());
        hocVien.setSoDienThoai(hocVienDTO.getSoDienThoai());
        hocVien.setNgayThamGia(hocVienDTO.getNgayThamGia());
        hocVien.setMatKhau(hocVienDTO.getMatKhau());
        return hocVien;

    }
}
