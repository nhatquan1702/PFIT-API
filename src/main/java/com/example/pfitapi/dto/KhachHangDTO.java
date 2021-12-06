package com.example.pfitapi.dto;

import com.example.pfitapi.entity.KhachHang;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class KhachHangDTO {
    @NotNull
    private String taiKhoan;

    @NotNull
    private String matKhau;

    private Integer trangThai;

    public KhachHangDTO(String taiKhoan, String matKhau, Integer trangThai) {
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.trangThai = trangThai;
    }

    public KhachHangDTO convertToDto(KhachHang khachHang) {
        KhachHangDTO khachHangDTO = new KhachHangDTO();
        khachHangDTO.setTaiKhoan(khachHang.getTaiKhoan());
        khachHangDTO.setMatKhau(khachHang.getMatKhau());
        khachHangDTO.setTrangThai(khachHang.getTrangThai());
        return khachHangDTO;
    }

    public List<KhachHangDTO> toListKhachHangDto(List<KhachHang> listEntity) {
        List<KhachHangDTO> listDto = new ArrayList<>();
        listEntity.forEach(e->{
            listDto.add(this.convertToDto(e));
        });
        return listDto;
    }
}
