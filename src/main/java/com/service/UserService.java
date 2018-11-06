package com.service;

import com.dto.UserDto;

import java.util.List;

public interface UserService {
    boolean validate(UserDto userDto);

    List<UserDto> getList();

    boolean add(UserDto userDto);

    UserDto getById(Long id);

    boolean modify(UserDto userDto);

    boolean remove(Long id);
}
