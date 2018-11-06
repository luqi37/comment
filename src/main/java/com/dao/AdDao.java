package com.dao;

import com.pojo.Ad;

import java.util.List;

public interface AdDao {
    List<Ad> searchByPage(Ad adForSelect);

    Ad selectById(Long id);

    int update(Ad ad);

    int delete(Ad ad);

    int insert(Ad ad);
}
