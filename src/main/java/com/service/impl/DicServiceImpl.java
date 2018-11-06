package com.service.impl;

import com.dao.DicDao;
import com.pojo.Dic;
import com.service.DicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DicServiceImpl implements DicService {

    @Autowired
    private DicDao dicDao;

    @Override
    public List<Dic> getListByType(String type) {
        Dic dic = new Dic();
        dic.setType(type);
        return dicDao.select(dic);
    }
}
