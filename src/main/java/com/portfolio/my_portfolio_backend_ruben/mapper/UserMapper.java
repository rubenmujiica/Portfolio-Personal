package com.portfolio.my_portfolio_backend_ruben.mapper;

import com.portfolio.my_portfolio_backend_ruben.dto.UserDto;
import com.portfolio.my_portfolio_backend_ruben.model.User;

public class UserMapper {
    public static UserDto toDto(User user){
        if(user==null){
            return null;
        }
        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        return userDto;
    }

    public static User toEntity(UserDto dto){
        if(dto==null){
            return null;
        }
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        return user;
    }
}
