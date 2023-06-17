package com.alkemy.disney.service;

import com.alkemy.disney.dto.get.RolGetDto;
import com.alkemy.disney.dto.post.RolPostDto;

import java.util.List;

public interface RolService {

    List<RolGetDto> findAll();

    Long findIdByName(String rolName) throws Exception;

    Boolean create(RolPostDto rolPostDto) throws Exception;
    Boolean update(RolPostDto rolPostDto) throws Exception;
    void delete(String rolName) throws Exception;
}
