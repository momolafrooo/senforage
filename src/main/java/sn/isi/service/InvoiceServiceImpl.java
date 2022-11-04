package sn.isi.service;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.isi.dto.InvoiceDto;
import sn.isi.exception.EntityNotFoundException;
import sn.isi.exception.RequestException;
import sn.isi.mapper.InvoiceMapper;
import sn.isi.repository.InvoiceRepository;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {
    
    private final InvoiceRepository invoiceRepository;
    private final InvoiceMapper invoiceMapper;
    private final MessageSource messageSource;

    @Transactional
    @Override
    public InvoiceDto create(InvoiceDto invoiceDto) {
        return invoiceMapper.toDto(invoiceRepository.save(invoiceMapper.toEntity(invoiceDto)));
    }

    @Transactional
    @Override
    public InvoiceDto update(int id, InvoiceDto invoiceDto) {
        return invoiceRepository.findById(id)
                .map(entity -> {
                    invoiceDto.setId(id);
                    return invoiceMapper.toDto(
                            invoiceRepository.save(invoiceMapper.toEntity(invoiceDto)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("invoice.notfound", new Object[]{id},
                        Locale.getDefault())));
    }

    @Transactional
    @Override
    public void remove(int id) {
        try {
            invoiceRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("invoice.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public InvoiceDto get(int id) {
        return invoiceMapper.toDto(invoiceRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(messageSource.getMessage("invoice.notfound", new Object[]{id},
                                Locale.getDefault()))));
    }

    @Transactional(readOnly = true)
    @Override
    public List<InvoiceDto> getAll() {
        return invoiceRepository.findAll()
                .stream()
                .map(invoiceMapper::toDto)
                .collect(Collectors.toList());
    }
}
