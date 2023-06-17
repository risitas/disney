package com.alkemy.disney.mapper.post;

import com.alkemy.disney.dto.post.RolPostDto;
import com.alkemy.disney.model.Rol;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RolPostMapper {
    @Mapping(source = "rolName", target = "rolName")
    RolPostDto toRolPostDto(Rol rol);
    List<RolPostDto> rolPostDtos(List<Rol> roles);
    @InheritInverseConfiguration
    @Mapping(target = "users", ignore = true)
    Rol  toRol(RolPostDto rolPostDto);


}
