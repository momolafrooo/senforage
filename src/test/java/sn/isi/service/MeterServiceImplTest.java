package sn.isi.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sn.isi.dto.MeterDto;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class MeterServiceImplTest {

    @Autowired
    private MeterService meterService;

    @Test
    void create() {
        MeterDto meterDto = new MeterDto();
        meterDto.setCumul(12000);
        meterDto.setNumber(5522);

        Assertions.assertNotNull(meterService.create(meterDto));
    }

    @Test
    void update() {
        MeterDto meterDto = meterService.get(1);
        meterDto.setNumber(1111);
        Assertions.assertNotNull(meterService.update(1, meterDto));
    }

    @Test
    void remove() {
        meterService.remove(1);
        Assertions.assertTrue(true);
    }

    @Test
    void get() {
        Assertions.assertNotNull(meterService.get(1));
    }

    @Test
    void getAll() {
        Assertions.assertEquals(1, meterService.getAll().size());
    }
}