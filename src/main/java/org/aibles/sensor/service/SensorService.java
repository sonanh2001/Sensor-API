package org.aibles.sensor.service;

import org.aibles.sensor.dto.request.CreateSensorRequest;
import org.aibles.sensor.dto.response.SensorResponse;

public interface SensorService {

  /**
   * create a sensor data in DB
   * @param request - request from IOT tool
   * @return a response of saved sensor data
   */
  SensorResponse create(CreateSensorRequest request);

  /**
   * get a latest sensor data in DB
   * @return a response of sensor data
   */
  SensorResponse get();

  /**
   * delete a table
   */
  void deleteAll();
}
