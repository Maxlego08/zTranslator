# zTranslator

The plugin will allow you to translate the names of minecraft items with your language. You just have to add the lang file of minecraft in the ``zTranslator/langs`` folder and reload the plugin. The file ``bind.json`` will make the link between the item and the translation. Don't hesitate to create an exit if an item is not translated.

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
