package sn.isi.mapper;

import org.mapstruct.Mapper;
import sn.isi.dto.InvoiceDto;
import sn.isi.entities.Invoice;

@Mapper
public interface InvoiceMapper {

    Invoice toEntity(InvoiceDto invoiceDto);
    InvoiceDto toDto(Invoice invoice);
}
