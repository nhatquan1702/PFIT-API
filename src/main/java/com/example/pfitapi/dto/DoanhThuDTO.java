package com.example.pfitapi.dto;

import com.example.pfitapi.entity.KhoaTap;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.hibernate.mapping.Any;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DoanhThuDTO {
    private String ngay;

    private int tongTien;

    public DoanhThuDTO(String ngay, int tong_tien) {
        this.ngay = ngay;
        this.tongTien = tong_tien;
    }

    public DoanhThuDTO() {

    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public int getTong_tien() {
        return tongTien;
    }

    public void setTong_tien(int tong_tien) {
        this.tongTien = tong_tien;
    }

    public DoanhThuDTO ConvertToDTO(Object[] object){
        DoanhThuDTO doanhThuDTO=new DoanhThuDTO();
        doanhThuDTO.setNgay(object[0].toString());
        doanhThuDTO.setTong_tien((int)Float.parseFloat(object[1].toString()));
        return doanhThuDTO;
        //ok chua  ok
    }

    public List<DoanhThuDTO> toListTheTrangDto(List<Object[]> listEntity) {
        List<DoanhThuDTO> listDto = new ArrayList<>();
        listEntity.forEach(e->{
            listDto.add(this.ConvertToDTO(e));
        });
        return listDto;
    }
}
