package sn.isi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isi.entities.Village;

public interface VillageRepository extends JpaRepository<Village, Integer> {
}
