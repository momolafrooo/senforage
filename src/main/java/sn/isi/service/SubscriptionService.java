package sn.isi.service;

import sn.isi.dto.SubscriptionDto;

import java.util.List;

public interface SubscriptionService {

    public SubscriptionDto create(SubscriptionDto subscriptionDto);
    public SubscriptionDto update(int id, SubscriptionDto subscriptionDto);
    public void remove(int id);
    public SubscriptionDto get(int id);
    public List<SubscriptionDto> getAll();
}
