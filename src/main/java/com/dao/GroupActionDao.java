package com.dao;

import com.pojo.GroupAction;

import java.util.List;

public interface GroupActionDao {
    int deleteByGroupId(Long id);

    int insertBatch(List<GroupAction> list);
}
