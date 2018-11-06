package com.dao;

import com.pojo.GroupMenu;

import java.util.List;

public interface GroupMenuDao {
    int deleteByGroupId(Long id);

    int insertBatch(List<GroupMenu> list);
}
