package sn.isi.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sn.isi.dto.SubscriptionDto;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class SubscriptionServiceImplTest {

    @Autowired
    private SubscriptionService subscriptionService;

    @Test
    void create() {
        SubscriptionDto subscriptionDto = new SubscriptionDto();
        subscriptionDto.setDate(new Date());
        subscriptionDto.setDescription("Abonnement de compteur");
        subscriptionDto.setNumber(1234);

        Assertions.assertNotNull(subscriptionService.create(subscriptionDto));
    }

    @Test
    void update() {
        SubscriptionDto subscriptionDto = subscriptionService.get(1);
        subscriptionDto.setNumber(2233);

        Assertions.assertNotNull(subscriptionService.update(1, subscriptionDto));
    }

    @Test
    void remove() {
        subscriptionService.remove(1);
        Assertions.assertTrue(true);
    }

    @Test
    void get() {
        Assertions.assertNotNull(subscriptionService.get(1));
    }

    @Test
    void getAll() {
        Assertions.assertEquals(1, subscriptionService.getAll().size());
    }
}