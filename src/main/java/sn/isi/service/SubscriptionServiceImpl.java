package sn.isi.service;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.isi.dto.SubscriptionDto;
import sn.isi.exception.EntityNotFoundException;
import sn.isi.exception.RequestException;
import sn.isi.mapper.SubscriptionMapper;
import sn.isi.repository.SubscriptionRepository;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {
    
    private final SubscriptionRepository subscriptionRepository;
    private final SubscriptionMapper subscriptionMapper;
    private final MessageSource messageSource;

    @Transactional
    @Override
    public SubscriptionDto create(SubscriptionDto subscriptionDto) {
        return subscriptionMapper.toDto(subscriptionRepository.save(subscriptionMapper.toEntity(subscriptionDto)));
    }

    @Transactional
    @Override
    public SubscriptionDto update(int id, SubscriptionDto subscriptionDto) {
        return subscriptionRepository.findById(id)
                .map(entity -> {
                    subscriptionDto.setId(id);
                    return subscriptionMapper.toDto(
                            subscriptionRepository.save(subscriptionMapper.toEntity(subscriptionDto)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("subscription.notfound", new Object[]{id},
                        Locale.getDefault())));
    }

    @Transactional
    @Override
    public void remove(int id) {
        try {
            subscriptionRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("subscription.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public SubscriptionDto get(int id) {
        return subscriptionMapper.toDto(subscriptionRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(messageSource.getMessage("subscription.notfound", new Object[]{id},
                                Locale.getDefault()))));
    }

    @Transactional(readOnly = true)
    @Override
    public List<SubscriptionDto> getAll() {
        return subscriptionRepository.findAll()
                .stream()
                .map(subscriptionMapper::toDto)
                .collect(Collectors.toList());
    }
}
