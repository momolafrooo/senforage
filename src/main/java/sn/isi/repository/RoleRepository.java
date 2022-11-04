package sn.isi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isi.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
