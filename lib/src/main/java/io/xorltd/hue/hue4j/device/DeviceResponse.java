package io.xorltd.hue.hue4j.device;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.StringJoiner;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceResponse<T> {
  List<Object> errors;
  List<T> data;
  DeviceMetadata metadata;

  public DeviceResponse() {
  }

  public List<Object> getErrors() {
    return errors;
  }

  public void setErrors(List<Object> errors) {
    this.errors = errors;
  }

  public List<T> getData() {
    return data;
  }

  public void setData(List<T> data) {
    this.data = data;
  }

  public DeviceMetadata getMetadata() {
    return metadata;
  }

  public void setMetadata(DeviceMetadata metadata) {
    this.metadata = metadata;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", DeviceResponse.class.getSimpleName() + "[", "]")
        .add("errors=" + errors)
        .add("data=" + data)
        .add("metadata=" + metadata)
        .toString();
  }
}
