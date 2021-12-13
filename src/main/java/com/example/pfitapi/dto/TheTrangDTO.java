package com.example.pfitapi.dto;

import com.example.pfitapi.entity.HocVien;
import com.example.pfitapi.entity.TheTrang;
import com.example.pfitapi.entity.TheTrangKey;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TheTrangDTO {
    private String maHocVien;

    private Date ngay;

    private Float chieuCao;

    private Float canNang;

    private Float vong1;

    private Float vong2;

    private Float vong3;

    private Float vongTay;

    private Float vongDui;

    private Float luongNuoc;


    public Float getChieuCao() {
        return chieuCao;
    }

    public void setChieuCao(Float chieuCao) {
        this.chieuCao = chieuCao;
    }

    public Float getCanNang() {
        return canNang;
    }

    public void setCanNang(Float canNang) {
        this.canNang = canNang;
    }

    public Float getVong1() {
        return vong1;
    }

    public void setVong1(Float vong1) {
        this.vong1 = vong1;
    }

    public Float getVong2() {
        return vong2;
    }

    public void setVong2(Float vong2) {
        this.vong2 = vong2;
    }

    public Float getVong3() {
        return vong3;
    }

    public void setVong3(Float vong3) {
        this.vong3 = vong3;
    }

    public Float getVongTay() {
        return vongTay;
    }

    public void setVongTay(Float vongTay) {
        this.vongTay = vongTay;
    }

    public Float getVongDui() {
        return vongDui;
    }

    public void setVongDui(Float vongDui) {
        this.vongDui = vongDui;
    }

    public Float getLuongNuoc() {
        return luongNuoc;
    }

    public void setLuongNuoc(Float luongNuoc) {
        this.luongNuoc = luongNuoc;
    }

    public TheTrangDTO convertToDto(TheTrang theTrang) {
        TheTrangDTO theTrangDTO = new TheTrangDTO();
        theTrangDTO.setMaHocVien(theTrang.getTheTrangKey().getHocVien().getMaHocVien());
        theTrangDTO.setNgay(theTrang.getTheTrangKey().getNgay());
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

    public List<TheTrangDTO> toListTheTrangDto(List<TheTrang> listEntity) {
        List<TheTrangDTO> listDto = new ArrayList<>();
        listEntity.forEach(e->{
            listDto.add(this.convertToDto(e));
        });
        return listDto;
    }

    public TheTrang convertToEntity(TheTrangDTO theTrangDTO, HocVien hocVien){
        TheTrang theTrang = new TheTrang();
        TheTrangKey theTrangKey = new TheTrangKey(theTrangDTO.getNgay(), hocVien);
        theTrang.setCanNang(theTrangDTO.getCanNang());
        theTrang.setChieuCao(theTrangDTO.getChieuCao());
        theTrang.setTheTrangKey(theTrangKey);
        theTrang.setLuongNuoc(theTrangDTO.getLuongNuoc());
        theTrang.setVong1(theTrangDTO.getVong1());
        theTrang.setVong2(theTrangDTO.getVong2());
        theTrang.setVong3(theTrangDTO.getVong3());
        theTrang.setVongTay(theTrangDTO.getVongTay());
        theTrang.setVongDui(theTrangDTO.getVongDui());
        return theTrang;

    }
}
