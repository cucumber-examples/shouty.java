package io.cucumber.shouty;

public class Env {
    public static String getenv(String name, String defaultValue) {
        String value = System.getenv(name);
        return value != null ? value : defaultValue;
    }
}
