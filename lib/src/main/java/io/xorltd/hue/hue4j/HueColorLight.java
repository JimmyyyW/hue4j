package io.xorltd.hue.hue4j;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.xorltd.hue.hue4j.light.Color;

import java.util.StringJoiner;
import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HueColorLight implements HueLight {
  private final UUID uuid;
  private final String name;
  private final boolean isOn;
  private final Color color;
  private final String archetype;

  public HueColorLight(UUID uuid, String name, boolean isOn, Color color, String archetype) {
    this.uuid = uuid;
    this.name = name;
    this.isOn = isOn;
    this.color = color;
    this.archetype = archetype;
  }

  @Override
  public boolean isOn() {
    return false;
  }

  public Color getColor() {
    return this.color;
  }

  @Override
  public UUID getId() {
    return uuid;
  }

  public String getName() {
    return name;
  }

  @Override
  public String getArchetype() {
    return this.archetype;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", HueColorLight.class.getSimpleName() + "[", "]")
        .add("uuid=" + uuid)
        .add("name=" + name)
        .add("isOn=" + isOn)
        .add("color=" + color)
        .add("archetype=" + archetype)
        .toString();
  }
}
