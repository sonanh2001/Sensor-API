package org.aibles.sensor.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aibles.sensor.dto.request.CreateSensorRequest;
import org.aibles.sensor.dto.response.SensorResponse;
import org.aibles.sensor.service.SensorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sensors")
@RequiredArgsConstructor
@Slf4j
public class SensorController {
  private final SensorService service;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public SensorResponse create(@RequestBody CreateSensorRequest request) {
    log.info("(create)request : {}", request.toString());
    return service.create(request);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public SensorResponse get() {
    log.info("(get)");
    return service.get();
  }
}
