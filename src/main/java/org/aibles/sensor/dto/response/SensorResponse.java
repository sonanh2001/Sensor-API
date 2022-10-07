package org.aibles.sensor.dto.response;

import lombok.Data;
import org.aibles.sensor.entity.Sensor;
import org.aibles.sensor.util.DateUtil;

@Data
public class SensorResponse {
  private String sensorId;
  private float temperature;
  private float humidity;
  private String createdAt;

  public static SensorResponse from(Sensor sensor) {
    SensorResponse response = new SensorResponse();
    response.setSensorId(sensor.getSensorId());
    response.setTemperature(sensor.getTemperature());
    response.setHumidity(sensor.getHumidity());
    response.setCreatedAt(DateUtil.convertEpochToString(sensor.getCreatedAt()));
    return response;
  }
}
