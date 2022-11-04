package sn.isi.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sn.isi.dto.RoleDto;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class RoleServiceImplTest {

    @Autowired
    private RoleService roleService;

    @Test
    void create() {
        RoleDto roleDto = new RoleDto();
        roleDto.setName("ADMIN");

        Assertions.assertNotNull(roleService.create(roleDto));
    }

    @Test
    void update() {
        RoleDto roleDto = roleService.get(1);
        roleDto.setName("SUPER_ADMIN");

        Assertions.assertNotNull(roleService.update(1, roleDto));
    }

    @Test
    void remove() {
        roleService.remove(1);
        Assertions.assertTrue(true);
    }

    @Test
    void get() {
        Assertions.assertNotNull(roleService.get(1));
    }

    @Test
    void getAll() {
        Assertions.assertEquals(1, roleService.getAll().size());
    }
}