package com.alkemy.disney.service;

import com.alkemy.disney.dto.get.UserGetDto;
import com.alkemy.disney.dto.post.UserPostDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserGetDto> findAll();

    Optional<UserGetDto> findUserByIdentification(Long identification) throws Exception;
    Object findUserByEmail(String email) throws Exception;

    Boolean create(UserPostDto userPostDto) throws Exception;
    Boolean update(UserPostDto userPostDto) throws Exception;
    void delete(Long identification) throws Exception;
}
