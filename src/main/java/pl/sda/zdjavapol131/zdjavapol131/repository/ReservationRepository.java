package pl.sda.zdjavapol131.zdjavapol131.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.zdjavapol131.zdjavapol131.repository.dao.ReservationEntity;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Integer> {
}
