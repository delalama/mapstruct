package com.mapstruct.mapstruct.mapper;

import com.mapstruct.mapstruct.model.Human;
import com.mapstruct.mapstruct.model.User;
import com.mapstruct.mapstruct.model.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(uses = Human.class)
public interface UserToUserDTOMapper {
    List<UserDTO> map(List<User> users);
    List<UserDTO> map(Iterable<User> user);
    @Mapping(target = "name", source = "name")
    @Mapping(target = "pass", source = "pass")
    UserDTO userToUserDTO(User user);
}
