package com.dao;

import com.pojo.Dic;

import java.util.List;

public interface DicDao {
    List<Dic> select(Dic dic);
}
