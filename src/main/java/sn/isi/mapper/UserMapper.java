package sn.isi.mapper;

import org.mapstruct.Mapper;
import sn.isi.dto.UserDto;
import sn.isi.entities.User;

@Mapper
public interface UserMapper {

    User toEntity(UserDto userDto);
    UserDto toDto(User user);
}
