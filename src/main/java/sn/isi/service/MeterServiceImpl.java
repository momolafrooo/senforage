package sn.isi.service;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import sn.isi.dto.MeterDto;
import sn.isi.exception.EntityNotFoundException;
import sn.isi.exception.RequestException;
import sn.isi.mapper.MeterMapper;
import sn.isi.repository.MeterRepository;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MeterServiceImpl implements MeterService {
    
    private final MeterRepository meterRepository;
    private final MeterMapper meterMapper;
    private final MessageSource messageSource;
    
    @Override
    public MeterDto create(MeterDto meterDto) {
        return meterMapper.toDto(meterRepository.save(meterMapper.toEntity(meterDto)));
    }

    @Override
    public MeterDto update(int id, MeterDto meterDto) {
        return meterRepository.findById(id)
                .map(entity -> {
                    meterDto.setId(id);
                    return meterMapper.toDto(
                            meterRepository.save(meterMapper.toEntity(meterDto)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("meter.notfound", new Object[]{id},
                        Locale.getDefault())));
    }

    @Override
    public void remove(int id) {
        try {
            meterRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("meter.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }

    @Override
    public MeterDto get(int id) {
        return meterMapper.toDto(meterRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(messageSource.getMessage("meter.notfound", new Object[]{id},
                                Locale.getDefault()))));
    }

    @Override
    public List<MeterDto> getAll() {
        return meterRepository.findAll()
                .stream()
                .map(meterMapper::toDto)
                .collect(Collectors.toList());
    }
}
