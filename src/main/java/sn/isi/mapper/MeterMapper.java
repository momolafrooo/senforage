package sn.isi.mapper;

import org.mapstruct.Mapper;
import sn.isi.dto.MeterDto;
import sn.isi.entities.Meter;

@Mapper
public interface MeterMapper {

    Meter toEntity(MeterDto meterDto);
    MeterDto toDto(Meter meter);
}
