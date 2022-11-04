package sn.isi.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sn.isi.dto.UserDto;
import sn.isi.entities.User;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    void create() {
        UserDto userDto = new UserDto();
        userDto.setActive(true);
        userDto.setEmail("momo@gmail.com");
        userDto.setPassword("password");
        userDto.setFirstName("momo");
        userDto.setLastName("fall");

        Assertions.assertNotNull(userService.create(userDto));
    }

    @Test
    void update() {
        UserDto userDto = userService.get(1);
        userDto.setLastName("diop");

        Assertions.assertNotNull(userService.update(1, userDto));
    }

    @Test
    void remove() {
        userService.remove(1);
        Assertions.assertTrue(true);
    }

    @Test
    void get() {
        UserDto userDto = userService.get(1);
        Assertions.assertNotNull(userDto);
    }

    @Test
    void getAll() {
        List<UserDto> userDtos = userService.getAll();
        Assertions.assertEquals(1, userDtos.size());
    }
}