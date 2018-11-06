package com.service;

import com.pojo.Dic;

import java.util.List;

public interface DicService {
    List<Dic> getListByType(String type);
}
