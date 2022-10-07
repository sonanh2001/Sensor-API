package org.aibles.sensor.entity;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "sensor")
public class Sensor {
  @Id
  private String sensorId;
  private Float temperature;
  private Float humidity;
  private Long createdAt;
  @PrePersist
  private void init() {
    this.sensorId = UUID.randomUUID().toString();
    this.createdAt = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    Sensor sensor = (Sensor) o;
    return sensorId != null && Objects.equals(sensorId, sensor.sensorId);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
