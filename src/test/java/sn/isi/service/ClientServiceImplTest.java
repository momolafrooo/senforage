package sn.isi.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sn.isi.dto.ClientDto;
import sn.isi.entities.Client;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ClientServiceImplTest {

    @Autowired
    private ClientService clientService;

    @Test
    void create() {
        ClientDto client = new ClientDto();
        client.setAddress("Golf");
        client.setName("Moussa");
        client.setPhone("00221435653");

        Assertions.assertNotNull(clientService.create(client));
    }

    @Test
    void update() {
        ClientDto client = clientService.get(1);
        client.setAddress("Hamo");

        Assertions.assertNotNull(clientService.update(1, client));
    }

    @Test
    void remove() {
        clientService.remove(1);
        Assertions.assertTrue(true);
    }

    @Test
    void get() {
        ClientDto clientDto = clientService.get(1);

        Assertions.assertNotNull(clientDto);
    }

    @Test
    void getAll() {
        List<ClientDto> clientDtos = clientService.getAll();

        Assertions.assertEquals(1, clientDtos.size());
    }
}