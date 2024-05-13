
# Hue4j
A simple jvm wrapper for philips hue bridge integrations.

Currently, only reading devices exposing a light service and updating those devices are supported.

**Notes**

This project is in its infancy

***
### Sample Usage
below is a short example of how to use use the library to 
send updates to your bridge. For example - turning all on lights off.
```java
public class Main {
  
  public static void main(String[] args) {
    HueClient client = new HueClient("your_api_key", "https://<bridge_ip_address>");
    client.getLights().stream()
        .filter(HueLight::isOn)
        .forEach(hueLight -> {
          client.updateLight(new HueLightUpdate.Builder()
              .on(false)
              .build(), hueLight.getId());
        });
  }
}
```

to find a light by its name and update its brightness and color you can do the below
```kotlin
fun main() {
    val client = HueClient("...", "https://192.168.1.28")
    val kitchLight: HueLight? = client.lights.find { it.name == "Kitchen"}

    val newColor = ColorXY().apply {
            x = 4.50
            y = 5.45
        }
    val brightness = Dimming(0.50)

    val update = HueLightUpdate.Builder()
        .dimming(brightness)
        .color(Color().apply { xy = newColor })
        .build()

    client.updateLight(update, kitchLight?.id)
}
```
***


#### TODOS

- determine whether this should or shouldn't bundle a http client
- remove reliance on a json parsing lib
- rgb <> hue conversions
- error enumeration