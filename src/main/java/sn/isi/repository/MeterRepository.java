package sn.isi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isi.entities.Meter;

public interface MeterRepository extends JpaRepository<Meter, Integer> {
}
