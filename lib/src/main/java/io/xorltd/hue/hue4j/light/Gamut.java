package io.xorltd.hue.hue4j.light;

public class Gamut {
  ColorXY red;
  ColorXY green;
  ColorXY blue;

  public Gamut(ColorXY red, ColorXY green, ColorXY blue) {
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  public Gamut() {}

  public ColorXY getRed() {
    return red;
  }

  public void setRed(ColorXY red) {
    this.red = red;
  }

  public ColorXY getGreen() {
    return green;
  }

  public void setGreen(ColorXY green) {
    this.green = green;
  }

  public ColorXY getBlue() {
    return blue;
  }

  public void setBlue(ColorXY blue) {
    this.blue = blue;
  }
}
