package sn.isi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isi.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
