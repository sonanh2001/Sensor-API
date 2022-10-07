package org.aibles.sensor.configuration;

import org.aibles.sensor.repository.SensorRepository;
import org.aibles.sensor.service.SensorService;
import org.aibles.sensor.service.impl.SensorServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableJpaRepositories(basePackages = {"org.aibles.sensor.repository"})
@EnableScheduling
@ComponentScan(basePackages = {"org.aibles.sensor.repository"})
public class SensorConfiguration {
  @Bean
  public SensorService sensorService(SensorRepository repository) {
    return new SensorServiceImpl(repository);
  }
}
