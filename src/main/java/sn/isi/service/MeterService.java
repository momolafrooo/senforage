package sn.isi.service;

import sn.isi.dto.MeterDto;

import java.util.List;

public interface MeterService {

    public MeterDto create(MeterDto meterDto);
    public MeterDto update(int id, MeterDto meterDto);
    public void remove(int id);
    public MeterDto get(int id);
    public List<MeterDto> getAll();
}
