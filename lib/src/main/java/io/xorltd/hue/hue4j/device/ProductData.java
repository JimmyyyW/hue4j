package io.xorltd.hue.hue4j.device;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductData {
  @JsonProperty("model_id")
  String modelId;
  @JsonProperty("manufacturer_name")
  String manufacturerName;
  @JsonProperty("product_name")
  String productName;
  @JsonProperty("product_archetype")
  Archetype productArchetype;
  Boolean certified;
  @JsonProperty("software_version")
  String softwareVersion;
  @JsonProperty("hardware_platform_type")
  String hardwarePlatformType;

  public ProductData() {}

  public String getModelId() {
    return modelId;
  }

  public void setModelId(String modelId) {
    this.modelId = modelId;
  }

  public String getManufacturerName() {
    return manufacturerName;
  }

  public void setManufacturerName(String manufacturerName) {
    this.manufacturerName = manufacturerName;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public Archetype getProductArchetype() {
    return productArchetype;
  }

  public void setProductArchetype(Archetype productArchetype) {
    this.productArchetype = productArchetype;
  }

  public Boolean getCertified() {
    return certified;
  }

  public void setCertified(Boolean certified) {
    this.certified = certified;
  }

  public String getSoftwareVersion() {
    return softwareVersion;
  }

  public void setSoftwareVersion(String softwareVersion) {
    this.softwareVersion = softwareVersion;
  }

  public String getHardwarePlatformType() {
    return hardwarePlatformType;
  }

  public void setHardwarePlatformType(String hardwarePlatformType) {
    this.hardwarePlatformType = hardwarePlatformType;
  }
}
