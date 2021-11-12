package com.example.pfitapi.service.in;

import com.example.pfitapi.dto.BaiTapDTO;
import com.example.pfitapi.dto.BaiTapFullDTO;
import java.util.List;

public interface BaiTapInterface {
    List<BaiTapDTO> getBaiTapTheoNhomCo(String maNhomCo);

    BaiTapFullDTO getBaiTapFullDTO(String maBaiTap);

    List<BaiTapDTO> getBaiTapTheoKhoaVaNgayTap(String maKhoaTap, Integer ngayTap);
}
