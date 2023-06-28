package com.alkemy.disney.serviceImpl;

import com.alkemy.disney.dto.get.RolGetDto;
import com.alkemy.disney.dto.get.UserGetDto;
import com.alkemy.disney.dto.post.RolPostDto;
import com.alkemy.disney.dto.post.UserPostDto;
import com.alkemy.disney.exception.AttributeException;
import com.alkemy.disney.mapper.get.RolGetMapper;
import com.alkemy.disney.mapper.get.UserGetMapper;
import com.alkemy.disney.mapper.post.RolPostMapper;
import com.alkemy.disney.mapper.post.UserPostMapper;
import com.alkemy.disney.model.Rol;
import com.alkemy.disney.model.User;
import com.alkemy.disney.repository.RolRepository;
import com.alkemy.disney.repository.UserRepository;
import com.alkemy.disney.service.RolService;
import com.alkemy.disney.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserGetMapper userGetMapper;
    private final UserPostMapper userPostMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<UserGetDto> findAll() {
        return userGetMapper.userGetDtos((List<User>) userRepository.findAll());
    }

    @Override
    public Optional<UserGetDto> findUserByIdentification(Long identification) throws Exception {
        if (!isExist(identification))
            throw new AttributeException("The user with identification " + identification + " does not exist");
        return Optional.ofNullable(userGetMapper.toUserGetDto(userRepository.findById(identification).get()));
    }

    @Override
    public Optional<UserGetDto> findUserByEmail(String email) throws Exception {
        Optional<User> rol = userRepository.findByEmail(email);

        if (!rol.isPresent())
            throw new AttributeException("The user with email " + email + " does not exist");
        return Optional.ofNullable(userGetMapper.toUserGetDto(rol.get()));
    }

    @Override
    public Boolean create(UserPostDto userPostDto) throws Exception {

        if (isExist(userPostDto.getIdentification()))
            throw new AttributeException("The user already exists");

        userPostDto.setPassword(passwordEncoder.encode(userPostDto.getPassword()));
        userRepository.save(userPostMapper.toUser(userPostDto));

        return true;
    }

    @Override
    public Boolean update(UserPostDto userPostDto) throws Exception {

        if (!isExist(userPostDto.getIdentification()))
            throw new AttributeException("The user does not exist");

        userPostDto.setPassword(passwordEncoder.encode(userPostDto.getPassword()));
        userRepository.save(userPostMapper.toUser(userPostDto));

        return true;
    }

    @Override
    @Transactional
    public void delete(Long identification) throws Exception {
        if (!isExist(identification))
            throw new AttributeException("The user with identification " + identification + " does not exist");

        userRepository.deleteById(identification);
    }

    public boolean isExist(Long identification) {

        boolean isPresent = userRepository.findById(identification).isPresent();

        if (!isPresent) {
            return false;
        }
        return true;
    }
}
