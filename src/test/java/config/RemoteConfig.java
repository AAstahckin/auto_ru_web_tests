package config;

import org.aeonbits.owner.Config;

public interface RemoteConfig extends Config{

    @Config.Key("url")
    String url();

    @Config.Key("login")
    String login();

    @Config.Key("password")
    String password();
}