package com.service;

import com.dto.AdDto;
import org.apache.commons.fileupload.util.LimitedInputStream;

import java.util.List;

public interface AdService {
    List<AdDto> searchByPage(AdDto adDto);

    AdDto selectByid(Long id);

    boolean modify(AdDto adDto);

    boolean remove(Long id);

    boolean add(AdDto adDto);
}
