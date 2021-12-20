package com.example.pfitapi.dto;

import com.example.pfitapi.entity.HocVien;
import com.example.pfitapi.entity.KhoaTap;
import com.example.pfitapi.entity.Quyen;
import com.example.pfitapi.entity.TaiKhoan;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TaiKhoanDTO {
    private String taiKhoan;

    private String matKhau;

    private String hoTen;

    private String soDienThoai;

    private String diaChi;

    private String ghiChu;

    private Integer trangThai;

    private Integer quyen;

    public TaiKhoanDTO(String taiKhoan, String matKhau, String hoTen, String soDienThoai, String diaChi, String ghiChu, Integer trangThai, Integer quyen) {
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.ghiChu = ghiChu;
        this.trangThai = trangThai;
        this.quyen = quyen;
    }
    public TaiKhoanDTO convertToDto(TaiKhoan taiKhoan) {
        TaiKhoanDTO taiKhoanDTO = new TaiKhoanDTO();
        taiKhoanDTO.setTaiKhoan(taiKhoan.getTaiKhoan());
        taiKhoanDTO.setMatKhau(taiKhoan.getMatKhau());
        taiKhoanDTO.setHoTen(taiKhoan.getHoTen());
        taiKhoanDTO.setTrangThai(taiKhoan.getTrangThai());
        taiKhoanDTO.setSoDienThoai(taiKhoan.getSoDienThoai());
        taiKhoanDTO.setDiaChi(taiKhoan.getDiaChi());
        taiKhoanDTO.setGhiChu(taiKhoan.getGhiChu());
        taiKhoanDTO.setQuyen(taiKhoan.getQuyen().getMaQuyen());
        return taiKhoanDTO;
    }

    public List<TaiKhoanDTO> toListHocVienDto(List<TaiKhoan> listEntity) {
        List<TaiKhoanDTO> listDto = new ArrayList<>();
        listEntity.forEach(e->{
            listDto.add(this.convertToDto(e));
        });
        return listDto;
    }

    public TaiKhoan convertToEntity(TaiKhoanDTO taiKhoanDTO, Quyen quyen, HocVien hocVien){
        TaiKhoan taiKhoan = new TaiKhoan();
        taiKhoan.setTaiKhoan(taiKhoanDTO.getTaiKhoan());
        taiKhoan.setHocVien(hocVien);
        taiKhoan.setTrangThai(taiKhoanDTO.getTrangThai());
        taiKhoan.setDiaChi(taiKhoanDTO.getDiaChi());
        taiKhoan.setGhiChu(taiKhoanDTO.getGhiChu());
        taiKhoan.setMatKhau(taiKhoanDTO.getMatKhau());
        taiKhoan.setHoTen(taiKhoanDTO.getHoTen());
        taiKhoan.setQuyen(quyen);
        taiKhoan.setSoDienThoai(taiKhoanDTO.getSoDienThoai());
        return taiKhoan;

    }
}
