package io.xorltd.hue.hue4j.device;

import java.util.UUID;

public class Service {
  UUID rid;
  ServiceType rtype;

  public Service() {
  }

  public UUID getRid() {
    return rid;
  }

  public void setRid(UUID rid) {
    this.rid = rid;
  }

  public ServiceType getRtype() {
    return rtype;
  }

  public void setRtype(ServiceType rtype) {
    this.rtype = rtype;
  }
}
