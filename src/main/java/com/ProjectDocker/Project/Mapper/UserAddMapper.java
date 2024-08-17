package com.ProjectDocker.Project.Mapper;

import com.ProjectDocker.Project.Dto.UserAddDto;
import com.ProjectDocker.Project.Dto.UserDto;
import com.ProjectDocker.Project.Model.User;

public class UserAddMapper {

    public static UserDto toDto(User user){
        UserDto userdto = new UserDto();
        userdto.setId(user.getId());
        userdto.setEmail(user.getEmail());
        userdto.setCategories(user.getCategories());
        userdto.setUsername(user.getUsername());
        userdto.setTasks(user.getTasks());
        return userdto;
    }

    public static User toEntity(UserAddDto userAddDtod){
        User user = new User();
        user.setPassword(userAddDtod.getPassword());
        user.setId(userAddDtod.getId());
        user.setUsername(userAddDtod.getUsername());
        user.setEmail(userAddDtod.getEmail());
        user.setCategories(userAddDtod.getCategories());
        user.setTasks(userAddDtod.getTasks());
        return user;
    }
}


