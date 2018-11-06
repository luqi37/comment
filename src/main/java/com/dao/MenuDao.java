package com.dao;

import com.pojo.Menu;

import java.util.List;

public interface MenuDao {
    List<Menu> selectWithAction(Menu menu);

    int insert(Menu menu);

    int delete(Long id);

    Menu selectById(Long id);

    int update(Menu menu);

    int updateOrderNumByParentId(Long targetNodeId);

    int updateOrderNumByIdInclude(Long targetNodeId);

    List<Menu> select(Menu menuForSelect);
}
