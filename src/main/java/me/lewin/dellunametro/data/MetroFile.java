package me.lewin.dellunametro.data;

import me.lewin.dellunametro.Main;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public class MetroFile {
    public static final Plugin PLUGIN = JavaPlugin.getPlugin(Main.class);
    public static void creatDataFile(String name, Player player){

        FileConfiguration config = getConfig(name);
        Location location = player.getLocation();

        config.set("name", name);

        config.set("location", location);
        config.set("x", (int) location.getX());
        config.set("y", (int) location.getY());
        config.set("z", (int) location.getZ());

        config.set("npc", false);
        config.set("npcID", 0);

        saveFile(config, getDataFile(name));
    }
    //기차역 파일 가져오기
    public static java.io.File getDataFile(String name) {
        return new java.io.File(PLUGIN.getDataFolder(), name + ".dat");
    }
    //기차역 콘피그 파일 가져오기
    public static FileConfiguration getConfig(String name) {
        return YamlConfiguration.loadConfiguration(getDataFile(name));
    }
    //기차역 파일 저장
    public static void saveFile(FileConfiguration config, java.io.File file) {
        try {
            config.save(file);
        } catch (IOException e) {
            System.out.println("§cFile I/O Error!!");
        }
    }
    //기차역 파일 삭제
    public static void removeFile(String name){
        getDataFile(name).delete();
    }
}
