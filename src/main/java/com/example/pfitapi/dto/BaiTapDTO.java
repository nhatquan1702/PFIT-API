package com.example.pfitapi.dto;

import com.example.pfitapi.entity.BaiTap;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BaiTapDTO {
    @NotNull
    private String maBaiTap;

    @NotNull
    private String tenBaiTap;

    private String hinhMinhHoa;

    private String video;

    private String moTa;

    private Integer capDo;

    public BaiTapDTO(String maBaiTap, String tenBaiTap, String hinhMinhHoa, String video, String moTa, Integer capDo) {
        this.maBaiTap = maBaiTap;
        this.tenBaiTap = tenBaiTap;
        this.hinhMinhHoa = hinhMinhHoa;
        this.video = video;
        this.moTa = moTa;
        this.capDo = capDo;
    }

    public BaiTapDTO convertToDto(BaiTap baiTap) {
        BaiTapDTO baiTapDTO = new BaiTapDTO();
        baiTapDTO.setMaBaiTap(baiTap.getMaBaiTap());
        baiTapDTO.setTenBaiTap(baiTap.getTenBaiTap());
        baiTapDTO.setCapDo(baiTap.getCapDo());
        baiTapDTO.setVideo(baiTap.getVideo());
        baiTapDTO.setMoTa(baiTap.getMoTa());
        baiTapDTO.setHinhMinhHoa(baiTap.getHinhMinhHoa());
        return baiTapDTO;
    }

    public List<BaiTapDTO> toListBaiTapDto(List<BaiTap> listEntity) {
        List<BaiTapDTO> listDto = new ArrayList<>();
        listEntity.forEach(e->{
            listDto.add(this.convertToDto(e));
        });
        return listDto;
    }
}
