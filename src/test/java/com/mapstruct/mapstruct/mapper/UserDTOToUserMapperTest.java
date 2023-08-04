package com.mapstruct.mapstruct.mapper;

import com.mapstruct.mapstruct.model.User;
import com.mapstruct.mapstruct.model.UserDTO;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class UserDTOToUserMapperTest {

    private final UserDTOToUserMapper mapper
            = Mappers.getMapper(UserDTOToUserMapper.class);

    @Test
    public void givenPersonDTOList_whenMapsList_thenCorrect() {
        List<UserDTO> personsFrom  = Instancio.ofList(UserDTO.class).size(2).create();

        List<User> userListMapped = mapper.map(personsFrom);

        for (User userTo : userListMapped) {
            UserDTO personToAssert = personsFrom.stream()
                    .filter(p -> p.getName().equals(userTo.getName()))
                    .findAny().get();

            assertAll("Verify Person properties",
                    () -> assertEquals(personToAssert.getName()
                            , userTo.getName()),
                    () -> assertEquals(personToAssert.getPass()
                            , userTo.getPass())
            );
        }
    }
}