package com.alkemy.disney.mapper.get;

import com.alkemy.disney.dto.get.RolGetDto;
import com.alkemy.disney.dto.get.UserGetDto;
import com.alkemy.disney.model.Rol;
import com.alkemy.disney.model.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {RolGetDto.class})
public interface UserGetMapper {
    @Mappings({
            @Mapping(source = "identification", target = "identification"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "rol.rolName", target = "rolName")
    })
    UserGetDto toUserGetDto(User user);
    List<UserGetDto> userGetDtos(List<User> users);
    @InheritInverseConfiguration
    @Mapping(target = "rol", ignore = true)
    User  toUser(UserGetDto userGetDto);


}
