package io.xorltd.hue.hue4j;

import java.util.List;
import java.util.UUID;

public interface HueHttpClient {
  List<HueLight> getLights();
  void updateLight(HueLightUpdate lightUpdate, UUID rid);
}
