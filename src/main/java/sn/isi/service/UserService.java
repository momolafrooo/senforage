package sn.isi.service;

import sn.isi.dto.UserDto;

import java.util.List;

public interface UserService {

    public UserDto create(UserDto userDto);
    public UserDto update(int id, UserDto userDto);
    public void remove(int id);
    public UserDto get(int id);
    public List<UserDto> getAll();
}
