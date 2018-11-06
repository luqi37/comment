package com.dao;

import com.pojo.Action;

public interface ActionDao {
    int insert(Action actionDto);

    int deleteById(Long id);

    int update(Action action);

    Action selectById(Long id);

    int deleteByMenuId(Long id);
}
