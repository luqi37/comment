package com.dao;

import com.pojo.Group;

import java.util.List;

public interface GroupDao {
    Group selectByIdWithMenuAction(Long groupId);

    List<Group> select(Group group);

    int insert(Group group);

    Group selectById(Long id);

    int update(Group group);

    int delete(Long id);

    Group selectMenuListById(Long id);
}
