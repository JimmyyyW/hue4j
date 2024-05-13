package io.xorltd.hue.hue4j;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import io.xorltd.hue.hue4j.light.Color;
import io.xorltd.hue.hue4j.light.Dimming;
import io.xorltd.hue.hue4j.light.On;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPOJOBuilder(withPrefix = "")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HueLightUpdate {
  private String name;
  private Color color;
  private Dimming dimming;
  private On on;

  public HueLightUpdate() {}

  public HueLightUpdate(String name, Color color, Dimming dimming, On on) {
    this.name = name;
    this.color = color;
    this.dimming = dimming;
    this.on = on;
  }

  public String getName() {
    return name;
  }

  public Color getColor() {
    return color;
  }

  public Dimming getDimming() {
    return dimming;
  }

  public On getOn() {
    return on;
  }

  public static class Builder {
    private String name;
    private Color color;
    private Dimming dimming;
    private On on;

    public HueLightUpdate.Builder name(String name) {
      this.name = name;
      return this;
    }

    public HueLightUpdate.Builder color(Color color) {
      this.color = color;
      return this;
    }

    public HueLightUpdate.Builder dimming(Dimming dimming) {
      this.dimming = dimming;
      return this;
    }

    public HueLightUpdate.Builder on(boolean on) {
      this.on = new On(on);
      return this;
    }

    public HueLightUpdate build() {
      return new HueLightUpdate(
          this.name,
          this.color,
          this.dimming,
          this.on
      );
    }
  }
}
