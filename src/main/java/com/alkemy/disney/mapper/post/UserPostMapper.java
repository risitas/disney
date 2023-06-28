package com.alkemy.disney.mapper.post;

import com.alkemy.disney.dto.get.RolGetDto;
import com.alkemy.disney.dto.get.UserGetDto;
import com.alkemy.disney.dto.post.UserPostDto;
import com.alkemy.disney.model.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {RolGetDto.class})
public interface UserPostMapper {
    @Mappings({
            @Mapping(source = "identification", target = "identification"),
            @Mapping(source = "username", target = "username"),
            @Mapping(source = "password", target = "password"),
            @Mapping(source = "email", target = "email")
    })
    UserPostDto toUserPostDto(User user);
    List<UserPostDto> userPostDtos(List<User> users);
    @InheritInverseConfiguration
    @Mapping(target = "rol", ignore = true)
    User  toUser(UserPostDto userPostDto);


}
