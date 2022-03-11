package me.lewin.dellunametro;

import me.lewin.dellunametro.data.MetroNPC;
import me.lewin.dellunametro.gui.MetroManagementGUI;
import me.lewin.dellunametro.gui.NewMetroGUI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        Plugin plugin = JavaPlugin.getPlugin(Main.class);

        // 플러그인 폴더 생성
        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdir();
        }

        //커멘드 이벤트 등록
        this.getCommand("train").setExecutor(new Commands());

        Bukkit.getPluginManager().registerEvents(new MetroManagementGUI(), this);
        Bukkit.getPluginManager().registerEvents(new MetroNPC(), this);
        Bukkit.getPluginManager().registerEvents(new NewMetroGUI(), this);

    }
}
