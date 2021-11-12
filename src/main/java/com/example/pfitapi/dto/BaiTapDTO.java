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

    public BaiTapDTO(String maBaiTap, String tenBaiTap, String hinhMinhHoa) {
        this.maBaiTap = maBaiTap;
        this.tenBaiTap = tenBaiTap;
        this.hinhMinhHoa = hinhMinhHoa;
    }

    public BaiTapDTO convertToDto(BaiTap baiTap) {
        BaiTapDTO baiTapDTO = new BaiTapDTO();
        baiTapDTO.setMaBaiTap(baiTap.getMaBaiTap());
        baiTapDTO.setTenBaiTap(baiTap.getTenBaiTap());
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
