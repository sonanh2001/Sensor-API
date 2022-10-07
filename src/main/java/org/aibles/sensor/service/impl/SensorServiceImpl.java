package org.aibles.sensor.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aibles.sensor.dto.request.CreateSensorRequest;
import org.aibles.sensor.dto.response.SensorResponse;
import org.aibles.sensor.exception.InternalServerError;
import org.aibles.sensor.repository.SensorRepository;
import org.aibles.sensor.service.SensorService;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Slf4j
public class SensorServiceImpl implements SensorService {
  private final SensorRepository repository;

  @Override
  @Transactional
  public SensorResponse create(CreateSensorRequest request) {
    log.info("(create)temperature : {}", request.getTemperature());
    return SensorResponse.from(repository.save(request.toSensor()));
  }

  @Override
  @Transactional(readOnly = true)
  public SensorResponse get() {
    log.info("(get)");
    return repository
        .findTopByCreatedAt()
        .map(SensorResponse::from)
        .orElseThrow(InternalServerError::new);
  }

  @Override
  @Transactional
  public void deleteAll() {
    log.info("(deleteAll)");
    repository.deleteAll();
  }


}
