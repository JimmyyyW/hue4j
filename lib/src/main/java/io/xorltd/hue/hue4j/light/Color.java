package io.xorltd.hue.hue4j.light;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.StringJoiner;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Color {
  public ColorXY xy;
  public Gamut gamut;
  public GamutType gamutType;

  public Color() {}

  public Color(GamutType gamutType, Gamut gamut, ColorXY xy) {
    this.gamutType = gamutType;
    this.gamut = gamut;
    this.xy = xy;
  }

  public ColorXY getXy() {
    return xy;
  }

  public void setXy(ColorXY xy) {
    this.xy = xy;
  }

  public Gamut getGamut() {
    return gamut;
  }

  public void setGamut(Gamut gamut) {
    this.gamut = gamut;
  }

  public GamutType getGamutType() {
    return gamutType;
  }

  public void setGamutType(GamutType gamutType) {
    this.gamutType = gamutType;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Color.class.getSimpleName() + "[", "]")
        .add("xy=" + xy)
        .add("gamut=" + gamut)
        .add("gamutType=" + gamutType)
        .toString();
  }
}
