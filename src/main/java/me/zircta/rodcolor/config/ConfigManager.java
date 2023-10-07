package me.zircta.rodcolor.config;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConfigManager {
    private final Gson gson = new Gson();
    private final File configFile = new File(System.getProperty("user.home"), ".weave/xyz/rodcolor.json");
    private JsonObject configData = new JsonObject();

    public ConfigManager() {
        configFile.getParentFile().mkdirs();
        if (configFile.exists()) {
            try {
                String content = new String(Files.readAllBytes(Paths.get(configFile.getPath())));
                configData = gson.fromJson(content, JsonObject.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setRed(int value) {
        configData.addProperty("red", value);
        saveConfig();
    }

    public void setGreen(int value) {
        configData.addProperty("green", value);
        saveConfig();
    }

    public void setBlue(int value) {
        configData.addProperty("blue", value);
        saveConfig();
    }

    public void setChroma(boolean value) {
        configData.addProperty("chroma", value);
        saveConfig();
    }

    public int getRed() {
        return configData.has("red") ? configData.get("red").getAsInt() : 0;
    }

    public int getGreen() {
        return configData.has("green") ? configData.get("green").getAsInt() : 0;
    }

    public int getBlue() {
        return configData.has("blue") ? configData.get("blue").getAsInt() : 0;
    }

    public Boolean getChroma() {
        return configData.has("chroma") && configData.get("chroma").getAsBoolean();
    }


    public void saveConfig() {
        String json = gson.toJson(configData);
        try {
            Files.write(Paths.get(configFile.getPath()), json.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
