package sn.isi.service;

import sn.isi.dto.InvoiceDto;

import java.util.List;

public interface InvoiceService {

    public InvoiceDto create(InvoiceDto invoiceDto);
    public InvoiceDto update(int id, InvoiceDto invoiceDto);
    public void remove(int id);
    public InvoiceDto get(int id);
    public List<InvoiceDto> getAll();
}
