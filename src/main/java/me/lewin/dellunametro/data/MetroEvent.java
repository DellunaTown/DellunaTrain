package me.lewin.dellunametro.data;

import me.lewin.dellunametro.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Timer;
import java.util.TimerTask;

public class MetroEvent {
    public static boolean hasTicket(Player player) {
        //인벤에 있는 아이템 감지
        for (ItemStack item : player.getInventory().getContents()){
            //null 제외
            if (item == null) { continue; }

            //기차표인지 감지
            if (item.getType() == Material.PAPER) {
                if (item.getItemMeta().hasCustomModelData()) {
                    if (item.getItemMeta().getCustomModelData() == 1003) {
                        if (item.getItemMeta().getDisplayName().contains("CBT")) continue;
                        if (!(item.getItemMeta().getDisplayName().contains("§"))) continue;
                        item.setAmount(item.getAmount() - 1);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    //기차역으로 이동
    public static void teleport(String name, Player player) {
        //기차역 파일 가져오기
        FileConfiguration config = MetroFile.getConfig(name);

        //기차역 위치 가져오기
        Location location = config.getLocation("location");

        if (!(location.getChunk().isLoaded())){
            location.getChunk().load(true);
        }

        //플레이어 이동
        player.teleport(location);

        //메세지 출력력
        player.sendMessage("샤랄라 뿅!");
    }

    private static void delay(){
        Plugin plugin = JavaPlugin.getPlugin(Main.class);
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            return;
        }, 20L);
    }
    private static void bossBar(BossBar bossBar){
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            double cnt = 300;
            double percentage;
            @Override
            public void run() {
                percentage = cnt / 300;
                if(cnt-- >= 0){
                    bossBar.setProgress(percentage);
                }else{
                    timer.cancel();
                }
            }
        };
        timer.schedule(timerTask,0,100);
    }
    //기차를 통해 기차역 이동
    public static void teleportMetro(String station, Player player){
        //플러그인 선언
        Plugin plugin = JavaPlugin.getPlugin(Main.class);

        BossBar bossBar = Bukkit.createBossBar(station+"으로 이동중입니다", BarColor.BLUE, BarStyle.SOLID, BarFlag.CREATE_FOG);


        //기차로 이동
        teleport("기차", player);

        bossBar.addPlayer(player);
        bossBar(bossBar);

        //30초 딜레이
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            teleport(station, player);
            FileConfiguration config = MetroFile.getConfig(station);
            player.sendTitle(station, "(" + config.getString("x") + ", " + config.getString("y") + ", " + config.getString("z") + ")");
            bossBar.removePlayer(player);
        }, 606L);
    }
}
