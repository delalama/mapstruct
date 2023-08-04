package com.mapstruct.mapstruct.service;

import com.mapstruct.mapstruct.mapper.UserToUserDTOMapper;
import com.mapstruct.mapstruct.model.User;
import com.mapstruct.mapstruct.model.UserDTO;
import com.mapstruct.mapstruct.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserToUserDTOMapper userToUserDTOMapper;

    public List<UserDTO> getAllPerson() {
        return userToUserDTOMapper.map(userRepository.findAll());
    }

    public UserDTO getPersonById(int id) {
        return userToUserDTOMapper.userToUserDTO(userRepository.findById(id).get());
    }

    public void delete(int id) {
        Optional<User> personToDelete = userRepository.findById(id);

        if( personToDelete != null) {
            userRepository.delete(personToDelete.get());
        }

    }

    public long saveOrUpdate(User user) {
        User save = userRepository.save(user);
        return save.getId();
    }

    public Iterable<UserDTO> saveOrUpdateList(List<User> users) {
        return userToUserDTOMapper.map(userRepository.saveAll(users));
    }
}
