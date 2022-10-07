package org.aibles.sensor.repository;

import java.util.Optional;
import org.aibles.sensor.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {
  @Query("select count(s) from Sensor s")
  Long countAll();

  @Query(
      nativeQuery = true,
      value = "select * from sensor s order by s.created_at desc fetch first 1 row only")
  Optional<Sensor> findTopByCreatedAt();
}
