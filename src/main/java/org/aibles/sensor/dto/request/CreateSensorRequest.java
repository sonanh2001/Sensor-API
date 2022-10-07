package org.aibles.sensor.dto.request;

import lombok.Data;
import org.aibles.sensor.entity.Sensor;

@Data
public class CreateSensorRequest {
  private Float temperature;
  private Float humidity;

  public Sensor toSensor() {
    Sensor sensor = new Sensor();
    sensor.setTemperature(this.getTemperature());
    sensor.setHumidity(this.getHumidity());
    return sensor;
  }
}
