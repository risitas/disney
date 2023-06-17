package com.alkemy.disney.mapper.get;

import com.alkemy.disney.dto.get.RolGetDto;
import com.alkemy.disney.model.Rol;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RolGetMapper {
    @Mapping(source = "rolName", target = "rolName")
    RolGetDto toRolGetDto(Rol rol);
    List<RolGetDto> rolGetDtos(List<Rol> roles);
    @InheritInverseConfiguration
    @Mapping(target = "users", ignore = true)
    Rol  toRol(RolGetDto rolGetDto);


}
