package sn.isi.mapper;

import org.mapstruct.Mapper;
import sn.isi.dto.SubscriptionDto;
import sn.isi.entities.Subscription;

@Mapper
public interface SubscriptionMapper {

    Subscription toEntity(SubscriptionDto subscriptionDto);
    SubscriptionDto toDto(Subscription subscription);
}
