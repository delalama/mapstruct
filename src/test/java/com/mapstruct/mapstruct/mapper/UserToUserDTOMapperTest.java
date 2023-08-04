package com.mapstruct.mapstruct.mapper;

import com.mapstruct.mapstruct.model.User;
import com.mapstruct.mapstruct.model.UserDTO;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserToUserDTOMapperTest {

    private final UserToUserDTOMapper mapper
            = Mappers.getMapper(UserToUserDTOMapper.class);

    @Test
    public void givenPersonList_whenMapsList_thenCorrect() {
        List<User> personsFrom  = Instancio.ofList(User.class).size(2).create();

        List<UserDTO> userDTOListMapped = mapper.map(personsFrom);

        for (UserDTO userDTO : userDTOListMapped) {
            User userFrom = personsFrom
                    .stream().filter(p -> p.getName().equals(userDTO.getName()))
                            .findAny().get();

            assertAll("Verify Person properties",
                    () -> assertEquals(userDTO.getName()
                            , userFrom.getName()),
                    () -> assertEquals(userDTO.getPass()
                            , userFrom.getPass())
            );

        }

    }
}