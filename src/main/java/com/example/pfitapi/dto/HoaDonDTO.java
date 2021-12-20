package com.example.pfitapi.dto;

import com.example.pfitapi.entity.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class HoaDonDTO {
    private String maHoaDon;

    private Date ngayGioThanhToan;

    private Float tongThanhToan;

    private Integer hinhThucThanhToan;

    private String ghiChu;

    private Integer trangThai;

    private String maHocVien;

    private String hoTen;

    private String maKhoaTap;

    private String tenKhoaTap;

    public HoaDonDTO convertToDto(HoaDon hoaDon) {
        HoaDonDTO hoaDonDTO = new HoaDonDTO();
        hoaDonDTO.setMaHoaDon(hoaDon.getMaHoaDon());
        hoaDonDTO.setNgayGioThanhToan(hoaDon.getNgayGioThanhToan());
        hoaDonDTO.setTongThanhToan(hoaDon.getTongThanhToan());
        hoaDonDTO.setHinhThucThanhToan(hoaDon.getHinhThucThanhToan());
        hoaDonDTO.setGhiChu(hoaDon.getGhiChu());
        hoaDonDTO.setTrangThai(hoaDon.getTrangThai());
        hoaDonDTO.setMaHocVien(hoaDon.getHocVien().getMaHocVien());
        hoaDonDTO.setMaKhoaTap(hoaDon.getHocVien().getKhoaTap().getMaKhoaTap());
        hoaDonDTO.setTenKhoaTap(hoaDon.getHocVien().getKhoaTap().getTenKhoaTap());
        return hoaDonDTO;
    }

    public List<HoaDonDTO> toListTheTrangDto(List<HoaDon> listEntity) {
        List<HoaDonDTO> listDto = new ArrayList<>();
        listEntity.forEach(e->{
            listDto.add(this.convertToDto(e));
        });
        return listDto;
    }

    public HoaDon convertToEntity(HoaDonDTO hoaDonDTO, HocVien hocVien, List<GiaKhoaTap> giaKhoaTap){
        HoaDon hoaDon = new HoaDon();
        hoaDon.setMaHoaDon(hoaDonDTO.getMaHoaDon());
        hoaDon.setGhiChu(hoaDonDTO.getGhiChu());
        hoaDon.setNgayGioThanhToan(hoaDonDTO.getNgayGioThanhToan());
        hoaDon.setHinhThucThanhToan(hoaDonDTO.getHinhThucThanhToan());
        hoaDon.setTongThanhToan(hoaDonDTO.getTongThanhToan());
        hoaDon.setHocVien(hocVien);
        hoaDon.setTrangThai(hoaDonDTO.getTrangThai());
        hoaDon.setGiaKhoaTapList(giaKhoaTap);
        return hoaDon;

    }
}
