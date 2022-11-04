package sn.isi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isi.entities.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
}
