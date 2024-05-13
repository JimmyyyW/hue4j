package io.xorltd.hue.hue4j;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Optional;
import java.util.logging.Logger;

class SerdeUtils {
  private static final Logger logger = Logger.getLogger(SerdeUtils.class.getName());

  private static final ObjectMapper MAPPER = new ObjectMapper();

  static Optional<byte[]> toJsonBytes(HueLightUpdate hueLightUpdate) {
    try {
      return Optional.of(MAPPER.writeValueAsBytes(hueLightUpdate));
    } catch (JsonProcessingException e) {
      logger.info("failed to serialize hue light update: " + hueLightUpdate);
      return Optional.empty();
    }
  }

}
