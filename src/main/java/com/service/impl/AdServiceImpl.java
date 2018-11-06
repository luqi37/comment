package com.service.impl;

import com.dao.AdDao;
import com.dto.AdDto;
import com.pojo.Ad;
import com.service.AdService;
import com.util.FileUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdServiceImpl implements AdService {

    @Autowired
    private AdDao adDao;

    @Value("${adImage.savePath}")
    private String adImageSavePath;

    @Value("${adImage.url}")
    private String adImageUrl;

    @Override
    public List<AdDto> searchByPage(AdDto adDto) {
        List<AdDto> adDtoList = new ArrayList<>();
        Ad adForSelect = new Ad();
        BeanUtils.copyProperties(adDto, adForSelect);
        List<Ad> adList = adDao.searchByPage(adForSelect);
        for (Ad ad : adList) {
            AdDto dto = new AdDto();
            BeanUtils.copyProperties(ad, dto);
            dto.setImg(adImageUrl + ad.getImgFileName());
            adDtoList.add(dto);
        }
        return adDtoList;
    }

    @Override
    public AdDto selectByid(Long id) {
        AdDto adDto = new AdDto();
        Ad ad = adDao.selectById(id);
        BeanUtils.copyProperties(ad, adDto);
        adDto.setImg(adImageUrl + ad.getImgFileName());
        return adDto;
    }

    @Override
    public boolean modify(AdDto adDto) {
        Ad ad = new Ad();
        String fileName = null;
        BeanUtils.copyProperties(adDto, ad);
        if (adDto.getImgFile() != null && adDto.getImgFile().getSize() > 0) {
            try {
                fileName = FileUtil.save(adDto.getImgFile(), adImageSavePath);
                ad.setImgFileName(fileName);
            } catch (IOException e) {

            }
        }
        int updateCount = adDao.update(ad);
        if (updateCount != 1) {
            return false;
        }
        if (fileName != null) {
            return FileUtil.delete(adImageSavePath + adDto.getImgFileName());
        }
        return true;
    }

    @Override
    public boolean remove(Long id) {
        Ad ad = adDao.selectById(id);
        int deleteCount = adDao.delete(ad);
        FileUtil.delete(adImageSavePath + ad.getImgFileName());
        return deleteCount == 1;
    }

    @Override
    public boolean add(AdDto adDto) {
        Ad ad = new Ad();
        BeanUtils.copyProperties(adDto, ad);
        if (adDto.getImgFile() != null && adDto.getImgFile().getSize() > 0) {
            String fileName = System.currentTimeMillis() + "_" + adDto.getImgFile().getOriginalFilename();
            File file = new File(adImageSavePath + fileName);
            File fileFolder = new File(adImageSavePath);
            if (!fileFolder.exists()) {
                fileFolder.mkdirs();
            }
            try {
                adDto.getImgFile().transferTo(file);
                ad.setImgFileName(fileName);
                adDao.insert(ad);
                return true;
            } catch (IllegalStateException | IOException e) {
                // TODO 需要添加日志
                return false;
            }
        } else {
            return false;
        }
    }
}
