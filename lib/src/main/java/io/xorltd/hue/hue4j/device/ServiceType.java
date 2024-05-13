package io.xorltd.hue.hue4j.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ServiceType {
  ZIGBEE("zigbee_connectivity"),
  ZIGBEE_SERVICE_DISCOVERY("zigbee_service_discovery"),
  ZIGBEE_DEVICE_DISCOVERY("zigbee_device_discovery"),
  ENTERTAINMENT("entertainment"),
  TAURUS_7455("taurus_7455"),
  SOFTWARE_UPDATE("device_software_update"),
  BRIDGE("bridge"),
  LIGHT("light");

  private final String name;

  ServiceType(String name) {
    this.name = name;
  }

  @JsonCreator
  ServiceType fromName(@JsonProperty("rtype") String name) {
    for (ServiceType type : ServiceType.values()) {
      if (type.name().equals(name)) {
        return type;
      }
    }
    return null;
  }

  @JsonValue
  public String getName() {
    return name;
  }
}
