package org.aibles.sensor.scheduler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aibles.sensor.service.SensorService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Slf4j
public class DeleteTableScheduler {
  private final SensorService service;
  @Value("application.sensor_delete.enable:true")
  private Boolean enable;
  @Scheduled(fixedRateString = "${application.sensor_delete.fixedRate:1000}")
  @Transactional
  public void execute() {
    log.info("(execute)enable : {}", enable);
    if (!enable) {
      return;
    }
    try {
      service.deleteAll();
    } catch (Exception exception) {
      log.error("exception : {}", exception.getClass().getName());
    }
  }
}
