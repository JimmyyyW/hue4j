package io.xorltd.hue.hue4j;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

abstract class TrustAllHueHttpClient implements HueHttpClient {

  SSLContext sslContext;
  TrustEverything allTrust = new TrustEverything();
  public TrustAllHueHttpClient() {
    try {
      sslContext = SSLContext.getInstance("TLS");
      var trustManagers = new TrustManager[]{allTrust};
      sslContext.init(null, trustManagers, null);
    } catch (NoSuchAlgorithmException | KeyManagementException e) {
      throw new RuntimeException(e);
    }
  }
  static class TrustEverything implements X509TrustManager {

    @Override
    public void checkClientTrusted(X509Certificate[] chain, String authType)
        throws CertificateException {
    }

    @Override
    public void checkServerTrusted(X509Certificate[] chain, String authType)
        throws CertificateException {

    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
      return new X509Certificate[]{};
    }
  }

}
