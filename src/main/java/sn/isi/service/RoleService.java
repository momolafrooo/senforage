package sn.isi.service;

import sn.isi.dto.RoleDto;

import java.util.List;

public interface RoleService {

    public RoleDto create(RoleDto roleDto);
    public RoleDto update(int id, RoleDto roleDto);
    public void remove(int id);
    public RoleDto get(int id);
    public List<RoleDto> getAll();
}
