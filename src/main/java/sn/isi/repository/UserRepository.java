package sn.isi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isi.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
