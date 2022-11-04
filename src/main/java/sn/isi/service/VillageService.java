package sn.isi.service;

import sn.isi.dto.VillageDto;

import java.util.List;

public interface VillageService {

    public VillageDto create(VillageDto villageDto);
    public VillageDto update(int id, VillageDto villageDto);
    public void remove(int id);
    public VillageDto get(int id);
    public List<VillageDto> getAll();
}
