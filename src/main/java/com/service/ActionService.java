package com.service;

import com.dto.ActionDto;

public interface ActionService {
    boolean add(ActionDto actionDto);

    boolean remove(Long id);

    boolean modify(ActionDto actionDto);

    ActionDto getById(Long id);
}
