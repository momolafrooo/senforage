package sn.isi.mapper;

import org.mapstruct.Mapper;
import sn.isi.dto.VillageDto;
import sn.isi.entities.Village;

@Mapper
public interface VillageMapper {

    Village toEntity(VillageDto villageDto);
    VillageDto toDto(Village village);
}
