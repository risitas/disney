package com.alkemy.disney.serviceImpl;

import com.alkemy.disney.dto.get.RolGetDto;
import com.alkemy.disney.dto.post.RolPostDto;
import com.alkemy.disney.exception.AttributeException;
import com.alkemy.disney.mapper.get.RolGetMapper;
import com.alkemy.disney.mapper.post.RolPostMapper;
import com.alkemy.disney.model.Rol;
import com.alkemy.disney.repository.RolRepository;
import com.alkemy.disney.service.RolService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RolServiceImpl implements RolService {

    private final RolRepository rolRepository;
    private final RolGetMapper rolGetMapper;
    private final RolPostMapper rolPostMapper;

    @Override
    public List<RolGetDto> findAll() {

        return rolGetMapper.rolGetDtos((List<Rol>) rolRepository.findAll());
    }

    @Override
    public Long findIdByName(String rolName) throws Exception {

        if (!isExist(rolName))
            throw new AttributeException("The role " + rolName + " does not exist");
        return rolRepository.findByRolName(rolName).get().getId();
    }

    @Override
    public Boolean create(RolPostDto rolPostDto) throws Exception {

        if (isExist(rolPostDto.getRolName()))
            throw new AttributeException("The role " + rolPostDto.getRolName() + " already exists");

        rolRepository.save(rolPostMapper.toRol(rolPostDto));
        return true;
    }

    @Override
    public Boolean update(RolPostDto rolPostDto) throws Exception {

        if (!rolRepository.findById(rolPostDto.getId()).isPresent())
            throw new AttributeException("The role " + rolPostDto.getRolName() + " does not exist");

        rolRepository.save(rolPostMapper.toRol(rolPostDto));
        return true;
    }


    @Override
    @Transactional
    public void delete(String rolName) throws Exception {

        if (!isExist(rolName))
            throw new AttributeException("The role " + rolName + " does not exist");

        rolRepository.deleteByRolName(rolName);
    }

    public boolean isExist(String rolName) {

        boolean isPresent = rolRepository.findByRolName(rolName).isPresent();

        if (!isPresent) {
            return false;
        }
        return true;
    }
}
