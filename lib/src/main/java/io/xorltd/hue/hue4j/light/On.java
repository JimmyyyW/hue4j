package io.xorltd.hue.hue4j.light;

import java.util.StringJoiner;

public class On {
  Boolean on;

  public On(Boolean on) {
    this.on = on;
  }

  public Boolean getOn() {
    return on;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", On.class.getSimpleName() + "[", "]")
        .add("on=" + on)
        .toString();
  }
}
