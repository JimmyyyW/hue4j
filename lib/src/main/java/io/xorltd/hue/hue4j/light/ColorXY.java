package io.xorltd.hue.hue4j.light;

import java.util.StringJoiner;

public class ColorXY {
  public Double x;
  public Double y;

  public ColorXY() {}

  public ColorXY(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public Double getX() {
    return x;
  }

  public void setX(Double x) {
    this.x = x;
  }

  public Double getY() {
    return y;
  }

  public void setY(Double y) {
    this.y = y;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", ColorXY.class.getSimpleName() + "[", "]")
        .add("x=" + x)
        .add("y=" + y)
        .toString();
  }
}
