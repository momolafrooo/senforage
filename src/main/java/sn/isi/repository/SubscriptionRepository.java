package sn.isi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isi.entities.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {
}
