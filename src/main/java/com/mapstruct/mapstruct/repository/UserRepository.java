package com.mapstruct.mapstruct.repository;

import com.mapstruct.mapstruct.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findUserByNameAndPass(String name, String pass);

    User findUserByName(String name);
}
