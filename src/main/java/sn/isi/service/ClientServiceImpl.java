package sn.isi.service;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.isi.dto.ClientDto;
import sn.isi.exception.EntityNotFoundException;
import sn.isi.exception.RequestException;
import sn.isi.mapper.ClientMapper;
import sn.isi.repository.ClientRepository;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private final MessageSource messageSource;

    @Transactional
    @Override
    public ClientDto create(ClientDto clientDto) {
        return clientMapper.toDto(clientRepository.save(clientMapper.toEntity(clientDto)));
    }

    @Transactional
    @Override
    public ClientDto update(int id, ClientDto clientDto) {
        return clientRepository.findById(id)
                .map(entity -> {
                    clientDto.setId(id);
                    return clientMapper.toDto(
                            clientRepository.save(clientMapper.toEntity(clientDto)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("client.notfound", new Object[]{id},
                        Locale.getDefault())));
    }

    @Transactional
    @Override
    public void remove(int id) {
        try {
            clientRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("client.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public ClientDto get(int id) {
        return clientMapper.toDto(clientRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(messageSource.getMessage("client.notfound", new Object[]{id},
                                Locale.getDefault()))));
    }

    @Transactional(readOnly = true)
    @Override
    public List<ClientDto> getAll() {
        return clientRepository.findAll()
                .stream()
                .map(clientMapper::toDto)
                .collect(Collectors.toList());
    }
}
