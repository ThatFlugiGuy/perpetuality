package net.flugi.perpetuality;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class PerpetualityConfig {

    public static PerpetualityConfig INSTANCE;

    public boolean vanilla_stew_rebalance = true;

    public static void load() {
        File configFile = FabricLoader.getInstance().getConfigDir().resolve("perpetuality.json").toFile();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        if (configFile.exists()) {
            try (FileReader reader = new FileReader(configFile)) {
                INSTANCE = gson.fromJson(reader, PerpetualityConfig.class);
            } catch (IOException e) {
                INSTANCE = new PerpetualityConfig();
            }
        } else {
            INSTANCE = new PerpetualityConfig();
            save();
        }
    }

    public static void save() {
        File configFile = FabricLoader.getInstance().getConfigDir().resolve("perpetuality.json").toFile();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(configFile)) {
            writer.write(gson.toJson(INSTANCE));
        } catch (IOException e) {
            Perpetuality.LOGGER.error("Config not saved: ", e);
        }
    }

}
