package io.xorltd.hue.hue4j.light;

public class Effects {
  Effect effect;

  public Effects(Effect effect) {
   this.effect = effect;
  }
  public Effects() {}

  public Effect getEffect() {
    return effect;
  }

  public void setEffect(Effect effect) {
    this.effect = effect;
  }
}
