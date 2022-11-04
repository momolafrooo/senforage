package sn.isi.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sn.isi.dto.ClientDto;
import sn.isi.dto.VillageDto;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class VillageServiceImplTest {

    @Autowired
    private VillageService villageService;

    @Test
    void create() {
        VillageDto villageDto = new VillageDto();
        villageDto.setName("Réfane");

        Assertions.assertNotNull(villageService.create(villageDto));
    }

    @Test
    void update() {
        VillageDto villageDto = villageService.get(1);
        villageDto.setName("Diogoy");
        Assertions.assertNotNull(villageService.update(1, villageDto));
    }

    @Test
    void remove() {
        villageService.remove(1);
        Assertions.assertTrue(true);
    }

    @Test
    void get() {
        VillageDto villageDto = villageService.get(1);

        Assertions.assertNotNull(villageDto);
    }

    @Test
    void getAll() {
        List<VillageDto> villageDtos = villageService.getAll();

        Assertions.assertEquals(1, villageDtos.size());
    }
}