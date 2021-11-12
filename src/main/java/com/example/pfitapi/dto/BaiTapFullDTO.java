package com.example.pfitapi.dto;

import com.example.pfitapi.entity.BaiTap;
import com.example.pfitapi.entity.DungCu;
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
public class BaiTapFullDTO {
    @NotNull
    private String maBaiTap;

    @NotNull
    private String tenBaiTap;

    private String video;

    private String moTa;

    private String tenDungCu;

    public BaiTapFullDTO(String maBaiTap, String tenBaiTap, String video, String moTa, String tenDungCu) {
        this.maBaiTap = maBaiTap;
        this.tenBaiTap = tenBaiTap;
        this.video = video;
        this.moTa = moTa;
        this.tenDungCu = tenDungCu;
    }
    public BaiTapFullDTO convertToDto(BaiTap baiTap) {
        BaiTapFullDTO baiTapDTO = new BaiTapFullDTO();
        baiTapDTO.setMaBaiTap(baiTap.getMaBaiTap());
        baiTapDTO.setTenBaiTap(baiTap.getTenBaiTap());
        baiTapDTO.setVideo(baiTap.getVideo());
        baiTapDTO.setMoTa(baiTap.getMoTa());
        baiTapDTO.setTenDungCu(baiTap.getDungCu().getTenDungCu());
        return baiTapDTO;
    }

    public List<BaiTapFullDTO> toListBaiTapDto(List<BaiTap> listEntity) {
        List<BaiTapFullDTO> listDto = new ArrayList<>();
        listEntity.forEach(e->{
            listDto.add(this.convertToDto(e));
        });
        return listDto;
    }
}
