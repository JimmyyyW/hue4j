package io.xorltd.hue.hue4j;

import java.util.UUID;

public interface HueLight {
  UUID getId();
  String getName();
  boolean isOn();
  String getArchetype();
}
