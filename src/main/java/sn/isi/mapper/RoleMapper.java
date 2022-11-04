package sn.isi.mapper;

import org.mapstruct.Mapper;
import sn.isi.dto.RoleDto;
import sn.isi.entities.Role;

@Mapper
public interface RoleMapper {

    Role toEntity(RoleDto roleDto);
    RoleDto toDto(Role role);
}
