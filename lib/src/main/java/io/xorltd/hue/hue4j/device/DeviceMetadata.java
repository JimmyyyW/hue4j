package io.xorltd.hue.hue4j.device;

public class DeviceMetadata {
  String name;
  Archetype archetype;

  public DeviceMetadata() {}

  public Archetype getArchetype() {
    return archetype;
  }

  public void setArchetype(Archetype archetype) {
    this.archetype = archetype;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
