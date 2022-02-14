# zTranslator

## Maven
```xml
<repositories>
  <repository>
      <id>jitpack.io</id>
      <url>https://jitpack.io</url>
  </repository>
</repositories>

<dependency>
    <groupId>com.github.Maxlego08</groupId>
    <artifactId>zTranslator</artifactId>
    <version>1.0.0.0</version>
</dependency>
```

## Gradle
```gradle
allprojects {
  repositories {
    maven { url 'https://jitpack.io' }
  }
}
dependencies {
  implementation 'com.github.Maxlego08:zTranslator:1.0.0.0'
}
```

## How to translate an ItemStack

You need to get the Translator class using the spigot service provider.
Here is an example:

```java
public void example(){
	Translator translator = this.getProvider(Translator.class);
	translator.translate(new ItemStack(Material.STONE));
}

public <T> T getProvider(Class<T> classz) {
  RegisteredServiceProvider<T> provider = getServer().getServicesManager().getRegistration(classz);
  if (provider == null) {
    this.getLogger().warning("Unable to retrieve the provider " + classz.toString());
    return null;
  }
  return provider.getProvider() != null ? (T) provider.getProvider() : null;
}
```
