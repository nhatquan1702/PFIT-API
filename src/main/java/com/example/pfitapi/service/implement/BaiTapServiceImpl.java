package com.example.pfitapi.service.implement;

import com.example.pfitapi.dto.BaiTapDTO;
import com.example.pfitapi.dto.BaiTapFullDTO;
import com.example.pfitapi.entity.BaiTap;
import com.example.pfitapi.repository.BaiTapRepository;
import com.example.pfitapi.service.in.BaiTapInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BaiTapServiceImpl implements BaiTapInterface {
    @Autowired
    private BaiTapRepository baiTapRepository;

    @Override
    public List<BaiTapDTO> getBaiTapTheoNhomCo(String maNhomCo) {
        List<BaiTap> baiTapList = baiTapRepository.findAllByNhomCoMaNhomCo(maNhomCo);
        List<BaiTapDTO> baiTapDTOList = new ArrayList<>();
        baiTapDTOList = new BaiTapDTO().toListBaiTapDto(baiTapList);
        return baiTapDTOList;
    }

    @Override
    public BaiTapFullDTO getBaiTapFullDTO(String maBaiTap) {
        BaiTap baiTap = baiTapRepository.findByMaBaiTap(maBaiTap);
        BaiTapFullDTO baiTapFullDTO = new BaiTapFullDTO().convertToDto(baiTap);
        return baiTapFullDTO;
    }

    @Override
    public List<BaiTapDTO> getBaiTapTheoKhoaVaNgayTap(String maKhoaTap, Integer ngayTap) {
        List<BaiTap> baiTapList = baiTapRepository.findAllByKhoaTapMaKhoaTapAndNgayTapNgayTap(maKhoaTap, ngayTap);
        List<BaiTapDTO> baiTapDTOList = new BaiTapDTO().toListBaiTapDto(baiTapList);
        return baiTapDTOList;
    }
}
