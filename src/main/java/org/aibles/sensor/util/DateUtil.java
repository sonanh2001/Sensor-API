package org.aibles.sensor.util;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class DateUtil {
  public static String convertEpochToString(Long epochTime) {
    LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(epochTime, 0, ZoneOffset.UTC);
    return localDateTime.toString();
  }
}
