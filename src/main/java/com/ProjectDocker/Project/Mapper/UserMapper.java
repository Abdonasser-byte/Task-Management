package com.ProjectDocker.Project.Mapper;

import com.ProjectDocker.Project.Dto.UserDto;
import com.ProjectDocker.Project.Model.User;

public class UserMapper {

    public static UserDto toDto(User user){
        UserDto userdto = new UserDto();
        userdto.setId(user.getId());
        userdto.setEmail(user.getEmail());
        userdto.setCategories(user.getCategories());
        userdto.setUsername(user.getUsername());
        return userdto;
    }

    public static User toEntity(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setEmail(userDto.getEmail());
        user.setCategories(userDto.getCategories());
        user.setTasks(userDto.getTasks());
        return user;
    }
}
