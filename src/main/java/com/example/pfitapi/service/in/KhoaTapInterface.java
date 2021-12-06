package com.example.pfitapi.service.in;

import com.example.pfitapi.dto.KhoaTapDTO;

import java.util.List;

public interface KhoaTapInterface {
    KhoaTapDTO getKhoaTap(String maKhoaTap);

    List<KhoaTapDTO> getListAllKhoaTap();

    Integer insertKhoaTap(KhoaTapDTO khoaTapDTO);

    Integer updateKhoaTap (KhoaTapDTO khoaTapDTO);

    Integer updateTrangThaiKhoaTap (String maKhoaTap, Integer trangThai);

}
