package com.mapstruct.mapstruct.mapper;

import com.mapstruct.mapstruct.model.User;
import com.mapstruct.mapstruct.model.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface UserDTOToUserMapper {
    List<User> map(List<UserDTO> user);

    @Mapping(target = "name", source = "name")
    @Mapping(target = "pass", source = "pass")
    User userDTOToUser(UserDTO userDTO);
}
