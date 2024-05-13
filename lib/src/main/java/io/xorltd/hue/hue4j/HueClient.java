package io.xorltd.hue.hue4j;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.xorltd.hue.hue4j.light.ColorXY;
import io.xorltd.hue.hue4j.light.GamutType;
import io.xorltd.hue.hue4j.light.Color;
import io.xorltd.hue.hue4j.device.Device;
import io.xorltd.hue.hue4j.device.DeviceResponse;
import io.xorltd.hue.hue4j.device.Service;
import io.xorltd.hue.hue4j.device.ServiceType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class HueClient extends TrustAllHueHttpClient {
  private final Logger logger = Logger.getLogger(HueLight.class.getSimpleName());

  private final Function<UUID, String> LIGHT_URL = s -> "/clip/v2/resource/light/" + s.toString();
  private static final String API_KEY_HEADER = "hue-application-key";

  private final String apiKey;
  private final String baseUrl;
  private final OkHttpClient okHttpClient;
  private final ObjectMapper objectMapper = new ObjectMapper();

  public HueClient(String apiKey, String baseUrl) {
    super();
    this.apiKey = apiKey;
    this.baseUrl = baseUrl;
    okHttpClient = new OkHttpClient.Builder()
        .hostnameVerifier((hostname, session) -> true)
        .sslSocketFactory(this.sslContext.getSocketFactory(), allTrust)
        .build();
  }

  @Override
  public List<HueLight> getLights() {
    String DEVICE_URL = "/clip/v2/resource/device";
    var request = new Request.Builder()
        .url(baseUrl + DEVICE_URL)
        .addHeader(API_KEY_HEADER, apiKey)
        .addHeader("Content-Type", "application/json")
        .get()
        .build();
    try {
      Response response = okHttpClient.newCall(request).execute();
      assert response.body() != null;
      DeviceResponse<Device> deviceResponse = objectMapper.readValue(
          response.body().bytes(),
          new TypeReference<DeviceResponse<Device>>() {
          }
      );
      return getLights(deviceResponse);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void updateLight(HueLightUpdate lightUpdate, UUID rid) {
    Optional<byte[]> body = SerdeUtils.toJsonBytes(lightUpdate);
    body.ifPresent(bytes -> {
      var request = new Builder()
          .url(baseUrl + LIGHT_URL.apply(rid))
          .addHeader(API_KEY_HEADER, apiKey)
          .addHeader("Content-Type", "application/json")
          .put(RequestBody.create(bytes))
          .build();
      try (Response res = okHttpClient.newCall(request).execute()) {
        assert res.body() != null;
        logger.info(res.body().string());
      } catch (IOException e) {
        logger.severe("Failed to update light: " + e.getMessage());
        throw new RuntimeException(e);
      }
    });
  }

  private List<HueLight> getLights(DeviceResponse<Device> deviceResponse) {
    return deviceResponse.getData().stream()
        .flatMap(device ->
            device.getServices()
                .stream()
                .filter(service -> ServiceType.LIGHT.equals(service.getRtype()))
        ).map(this::lightFromService)
        .collect(Collectors.toList());
  }

  private HueLight lightFromService(Service service) {
    UUID rid = service.getRid();
    var request = new Request.Builder()
        .url(baseUrl + LIGHT_URL.apply(rid))
        .addHeader(API_KEY_HEADER, apiKey)
        .addHeader("Content-Type", "application/json")
        .get()
        .build();
    try (Response response = okHttpClient.newCall(request).execute()) {
      assert response.body() != null;
      DeviceResponse<JsonNode> deviceResponse = objectMapper.readValue(response.body().bytes(),
          new TypeReference<DeviceResponse<JsonNode>>() {
          });
      if (!deviceResponse.getErrors().isEmpty()) {
        return null;
      }
      return fromJsonNode(deviceResponse.getData().getFirst());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private HueLight fromJsonNode(JsonNode node) {
    var xyNode = node.get("color").get("xy");
    var colorXY = new ColorXY(xyNode.get("x").asDouble(), xyNode.get("y").asDouble());
    return new HueColorLight(
        UUID.fromString(node.get("id").asText()),
        node.get("metadata").get("name").asText(),
        node.get("on").get("on").asBoolean(),
        new Color(GamutType.other, null, colorXY),
        node.get("metadata").get("archetype").asText()
    );
  }

}
