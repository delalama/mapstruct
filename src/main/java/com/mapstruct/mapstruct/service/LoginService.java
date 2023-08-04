package com.mapstruct.mapstruct.service;

import com.mapstruct.mapstruct.mapper.UserDTOToUserMapper;
import com.mapstruct.mapstruct.model.User;
import com.mapstruct.mapstruct.model.UserDTO;
import com.mapstruct.mapstruct.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.validation.Validator;
import java.util.List;

@Service
public class LoginService {

    @Autowired
    UserDTOToUserMapper userDTOToUserMapper;

    @Autowired
    UserRepository userRepository;

    public Boolean login(UserDTO userDTO) {
        User userByNameAndPass = userRepository.findUserByNameAndPass(userDTO.getName(), userDTO.getPass());

        return userByNameAndPass != null;
    }

    public String create(UserDTO userDTO) {
        User userByName = userRepository.findUserByName(userDTO.getName());


        if(userDTO.getName().equals("") || userDTO.getPass().equals("")){
            return "Username o pass vacío";
        }
        if(userByName != null){
            return "Ya existe otro usuario con ese nombre";
        }else{
            User user = userDTOToUserMapper.userDTOToUser(userDTO);

            User savedUser = userRepository.save(user);

            return String.valueOf(savedUser.getId());
        }

    }
}
