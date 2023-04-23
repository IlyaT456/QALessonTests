package config;

import org.aeonbits.owner.ConfigFactory;

public enum ConfigReader {
    Instance;

    private static final WebDriverConfig webConfig =
            ConfigFactory.create(
                    WebDriverConfig.class,
                    System.getProperties()
            );

    public WebDriverConfig read() {
        return webConfig;
    }
}
