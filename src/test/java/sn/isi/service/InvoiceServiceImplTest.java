package sn.isi.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sn.isi.dto.InvoiceDto;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class InvoiceServiceImplTest {

    @Autowired
    private InvoiceService invoiceService;

    @Test
    void create() {
        InvoiceDto invoiceDto = new InvoiceDto();
        invoiceDto.setAmountInNumber(10000);
        invoiceDto.setAmountInLetter("Dix milles");

        Assertions.assertNotNull(invoiceService.create(invoiceDto));
    }

    @Test
    void update() {
        InvoiceDto invoiceDto = invoiceService.get(1);
        invoiceDto.setAmountInLetter("dix milles");

        Assertions.assertNotNull(invoiceService.update(1, invoiceDto));
    }

    @Test
    void remove() {
        invoiceService.remove(1);
        Assertions.assertTrue(true);
    }

    @Test
    void get() {
        Assertions.assertNotNull(invoiceService.get(1));
    }

    @Test
    void getAll() {
        List<InvoiceDto> invoiceDtos = invoiceService.getAll();
        Assertions.assertEquals(1, invoiceDtos.size());
    }
}