package com.example.pfitapi.dto;

import com.example.pfitapi.entity.KhachHang;
import com.example.pfitapi.entity.TheTrang;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    public TheTrangDTO(String maHocVien, Float chieuCao, Float canNang, Float vong1, Float vong2, Float vong3, Float vongTay, Float vongDui, Float luongNuoc) {
        this.maHocVien = maHocVien;
        this.chieuCao = chieuCao;
        this.canNang = canNang;
        this.vong1 = vong1;
        this.vong2 = vong2;
        this.vong3 = vong3;
        this.vongTay = vongTay;
        this.vongDui = vongDui;
        this.luongNuoc = luongNuoc;
    }

    public TheTrangDTO convertToDto(TheTrang theTrang) {
        TheTrangDTO theTrangDTO = new TheTrangDTO();
        theTrangDTO.setMaHocVien(theTrang.getMaHocVien());
        theTrangDTO.setCanNang(theTrang.getCanNang());
        theTrangDTO.setChieuCao(theTrang.getChieuCao());
        theTrangDTO.setVong1(theTrang.getVong1());
        theTrangDTO.setVong2(theTrang.getVong2());
        theTrangDTO.setVong3(theTrang.getVong3());
        theTrangDTO.setVongTay(theTrang.getVongTay());
        theTrangDTO.setVongDui(theTrang.getVongDui());
        theTrangDTO.setLuongNuoc(theTrang.getLuongNuoc());
        return theTrangDTO;
    }

    public List<TheTrangDTO> toListKhachHangDto(List<TheTrang> listEntity) {
        List<TheTrangDTO> listDto = new ArrayList<>();
        listEntity.forEach(e->{
            listDto.add(this.convertToDto(e));
        });
        return listDto;
    }
}
