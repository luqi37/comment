package com.service;

import com.dto.MenuDto;
import com.dto.MenuForMoveDto;
import com.dto.MenuForZtreeDto;

import java.util.List;

public interface MenuService {
    List<MenuForZtreeDto> getZtreeList();

    boolean add(MenuDto menuDto);

    boolean order(MenuForMoveDto menuForMoveDto);

    MenuDto getById(Long id);

    boolean modify(MenuDto menuDto);

    List<MenuDto> getList(MenuDto menuDto);

    boolean remove(Long id);
}
