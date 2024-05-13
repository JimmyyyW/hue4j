package io.xorltd.hue.hue4j.light;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Effect {
  PRISM("prism"),
  OPAL("opal"),
  GLISTEN("glisten"),
  SPARKLE("sparkle"),
  FIRE("fire"),
  CANDLE("candle"),
  NO_EFFECT("no_effect");

  private final String name;

  Effect(String name) {
    this.name = name;
  }

  @JsonCreator
  Effect forName(String name) {
    for (Effect effect : Effect.values()) {
      if (effect.name.equals(name)) {
        return effect;
      }
    }
    return null;
  }

  @JsonValue
  String getName() {
    return name;
  }
}
