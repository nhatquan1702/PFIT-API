package com.example.pfitapi.service.in;

import com.example.pfitapi.dto.BaiTapDTO;

import java.util.ArrayList;
import java.util.List;

public interface BaiTapInterface {
    List<BaiTapDTO> getBaiTapTheoNhomCo(String maNhomCo);
}
