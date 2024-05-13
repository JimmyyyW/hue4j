package io.xorltd.hue.hue4j.light;

import java.util.StringJoiner;

public class Dimming {
  Double brightness;

  public Dimming(Double brightness) {
    this.brightness = brightness;
  }

  public Double getBrightness() {
    return brightness;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Dimming.class.getSimpleName() + "[", "]")
        .add("brightness=" + brightness)
        .toString();
  }
}
