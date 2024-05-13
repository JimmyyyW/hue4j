package io.xorltd.hue.hue4j.device;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Device {
  UUID id;
  @JsonProperty("id_v1")
  String idV1;
  @JsonProperty("product_data")
  ProductData productData;
  DeviceMetadata metadata;
  Object identify;
  DeviceType type;
  List<Service> services = new ArrayList<>();

  public Device() {}

  public List<Service> getServices() {
    return services;
  }

  public void setServices(List<Service> services) {
    this.services = services;
  }

  public DeviceType getType() {
    return type;
  }

  public void setType(DeviceType type) {
    this.type = type;
  }

  public Object getIdentify() {
    return identify;
  }

  public void setIdentify(Object identify) {
    this.identify = identify;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getIdV1() {
    return idV1;
  }

  public void setIdV1(String idV1) {
    this.idV1 = idV1;
  }

  public ProductData getProductData() {
    return productData;
  }

  public void setProductData(ProductData productData) {
    this.productData = productData;
  }

  public DeviceMetadata getMetadata() {
    return metadata;
  }

  public void setMetadata(DeviceMetadata metadata) {
    this.metadata = metadata;
  }
}
