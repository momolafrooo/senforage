package sn.isi.service;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.isi.dto.VillageDto;
import sn.isi.exception.EntityNotFoundException;
import sn.isi.exception.RequestException;
import sn.isi.mapper.VillageMapper;
import sn.isi.repository.VillageRepository;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VillageServiceImpl implements VillageService {
    
    private final VillageRepository villageRepository;
    private final VillageMapper villageMapper;
    private final MessageSource messageSource;

    @Transactional
    @Override
    public VillageDto create(VillageDto villageDto) {
        return villageMapper.toDto(villageRepository.save(villageMapper.toEntity(villageDto)));
    }

    @Transactional
    @Override
    public VillageDto update(int id, VillageDto villageDto) {
        return villageRepository.findById(id)
                .map(entity -> {
                    villageDto.setId(id);
                    return villageMapper.toDto(
                            villageRepository.save(villageMapper.toEntity(villageDto)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("village.notfound", new Object[]{id},
                        Locale.getDefault())));
    }

    @Transactional
    @Override
    public void remove(int id) {
        try {
            villageRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("village.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public VillageDto get(int id) {
        return villageMapper.toDto(villageRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(messageSource.getMessage("village.notfound", new Object[]{id},
                                Locale.getDefault()))));
    }

    @Transactional(readOnly = true)
    @Override
    public List<VillageDto> getAll() {
        return villageRepository.findAll()
                .stream()
                .map(villageMapper::toDto)
                .collect(Collectors.toList());
    }
}
