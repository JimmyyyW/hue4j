package io.xorltd.hue.hue4j.device;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Archetype {
  UNKNOWN("unknown_archetype"),
  CLASSIC_BULB("classic_bulb"),
  SULTAN_BULB("sultan_bulb"),
  FLOOD_BULB("flood_bulb"),
  SPOT_BULB("spot_bulb"),
  CANDLE_BULB("candle_bulb"),
  LUSTER_BULB("luster_bulb"),
  PENDANT_ROUND("pendant_round"),
  PENDANT_LONG("pendant_long"),
  CEILING_ROUND("ceiling_round"),
  CEILING_SQUARE("ceiling_square"),
  FLOOR_SHADE("floor_shade"),
  FLOOR_LANTERN("floor_lantern"),
  TABLE_SHADE("table_shade"),
  RECESSED_CEILING("recessed_ceiling"),
  RECESSED_FLOOR("recessed_floor"),
  SINGLE_SPOT("single_spot"),
  DOUBLE_SPOT("double_spot"),
  TABLE_WASH("table_wash"),
  WALL_LANTERN("wall_lantern"),
  WALL_SHADE("wall_shade"),
  FLEXIBLE_LAMP("flexible_lamp"),
  GROUND_SPOT("ground_spot"),
  WALL_SPOT("wall_spot"),
  PLUG("plug"),
  HUE_GO("hue_go"),
  HUE_LIGHTSTRIP("hue_lightstrip"),
  HUE_IRIS("hue_iris"),
  HUE_BLOOM("hue_bloom"),
  BOLLARD("bollard"),
  WALL_WASHER("wall_washer"),
  HUE_PLAY("hue_play"),
  VINTAGE_BULB("vintage_bulb"),
  VINTAGE_CANDLE_BULB("vintage_candle_bulb"),
  ELLIPSE_BULB("ellipse_bulb"),
  TRIANGLE_BULB("triangle_bulb"),
  SMALL_GLOBE_BULB("small_globe_bulb"),
  LARGE_GLOBE_BULB("large_globe_bulb"),
  EDISON_BULB("edison_bulb"),
  CHRISTMAS_TREE("christmas_tree"),
  STRING_LIGHT("string_light"),
  HUE_CENTRIS("hue_centris"),
  HUE_LIGHTSTRIP_TV("hue_lightstrip_tv"),
  HUE_LIGHTSTRIP_PC("hue_lightstrip_pc"),
  HUE_TUBE("hue_tube"),
  HUE_SIGNE("hue_signe"),
  PENDANT_SPOT("pendant_spot"),
  CEILING_HORIZONTAL("ceiling_horizontal"),
  BRIDGE_V2("bridge_v2"),
  CEILING_TUBE("ceiling_tube");

  private final String stringRepresentation;

  Archetype(String stringRepresentation) {
    this.stringRepresentation = stringRepresentation;
  }

  @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
  public Archetype fromString(@JsonProperty("archetype") String stringRepresentation) {
    for (Archetype archetype : Archetype.values()) {
      if (archetype.stringRepresentation.equals(stringRepresentation)) {
        return archetype;
      }
    }
    return null;
  }

  @JsonValue
  public String getStringRepresentation() {
    return stringRepresentation;
  }

}
