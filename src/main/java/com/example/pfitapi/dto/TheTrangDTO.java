package com.example.pfitapi.dto;

import com.example.pfitapi.entity.HocVien;
import com.example.pfitapi.entity.KhachHang;
import com.example.pfitapi.entity.TheTrang;
import com.example.pfitapi.repository.HocVienRepository;
import com.example.pfitapi.service.implement.HocVienServiceImpl;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TheTrangDTO {

    @NotNull
    private String maHocVien;

    private Float chieuCao;

    private Float canNang;

    private Float vong1;

    private Float vong2;

    private Float vong3;

    private Float vongTay;

    private Float vongDui;

    private Float luongNuoc;

    private Date ngay;

    public Date getNgay() {
        return ngay;
    }

    public TheTrangDTO(Date ngay, String maHocVien, Float chieuCao, Float canNang, Float vong1, Float vong2, Float vong3, Float vongTay, Float vongDui, Float luongNuoc) {
        this.maHocVien = maHocVien;
        this.chieuCao = chieuCao;
        this.canNang = canNang;
        this.vong1 = vong1;
        this.vong2 = vong2;
        this.vong3 = vong3;
        this.vongTay = vongTay;
        this.vongDui = vongDui;
        this.luongNuoc = luongNuoc;
        this.ngay = ngay;
    }

    public TheTrangDTO convertToDto(TheTrang theTrang) {
        TheTrangDTO theTrangDTO = new TheTrangDTO();
        theTrangDTO.setMaHocVien(theTrang.getHocVien().getMaHocVien());
        theTrangDTO.setCanNang(theTrang.getCanNang());
        theTrangDTO.setChieuCao(theTrang.getChieuCao());
        theTrangDTO.setVong1(theTrang.getVong1());
        theTrangDTO.setVong2(theTrang.getVong2());
        theTrangDTO.setVong3(theTrang.getVong3());
        theTrangDTO.setVongTay(theTrang.getVongTay());
        theTrangDTO.setVongDui(theTrang.getVongDui());
        theTrangDTO.setLuongNuoc(theTrang.getLuongNuoc());
        theTrangDTO.setNgay(theTrang.getNgay());
        return theTrangDTO;
    }

    public List<TheTrangDTO> toListTheTrangDto(List<TheTrang> listEntity) {
        List<TheTrangDTO> listDto = new ArrayList<>();
        listEntity.forEach(e->{
            listDto.add(this.convertToDto(e));
        });
        return listDto;
    }

    public TheTrang convertToEntity(TheTrangDTO theTrangDTO){
        TheTrang theTrang = new TheTrang();
        theTrang.setCanNang(theTrangDTO.getCanNang());
        theTrang.setChieuCao(theTrangDTO.getChieuCao());
        theTrang.setNgay(theTrangDTO.getNgay());
        theTrang.setLuongNuoc(theTrangDTO.getLuongNuoc());
        theTrang.setVong1(theTrangDTO.getVong1());
        theTrang.setVong2(theTrangDTO.getVong2());
        theTrang.setVong3(theTrangDTO.getVong3());
        theTrang.setVongTay(theTrangDTO.getVongTay());
        theTrang.setVongDui(theTrangDTO.getVongDui());
        return theTrang;

    }
}
