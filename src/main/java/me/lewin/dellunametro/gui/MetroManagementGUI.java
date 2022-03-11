package me.lewin.dellunametro.gui;

import me.lewin.dellunametro.data.MetroEvent;
import me.lewin.dellunametro.data.MetroFile;
import me.lewin.dellunametro.data.MetroNPC;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class MetroManagementGUI implements Listener {
    public Inventory getInventory(){
        //인벤토리 객체 생성
        Inventory inv = Bukkit.getServer().createInventory(null, 54, "§x§0§0§b§3§b§6 Delluna Train 관리 페이지");

        //기차역 설정
        inv.setItem(13, train());

        inv.setItem(22, station("중앙역"));

        inv.setItem(28, station("장미역"));
        inv.setItem(37, station("동백역"));

        inv.setItem(30, station("수국역"));
        inv.setItem(39, station("물망초역"));

        inv.setItem(32, station("국화역"));
        inv.setItem(41, station("진달래역"));

        inv.setItem(34, station("개나리역"));
        inv.setItem(43, station("해바라기역"));

        //빈곳 iconNull로 채우기
        for (int i = 0; i < inv.getSize(); i++) {
            if (inv.getItem(i) == null)
                inv.setItem(i, IconDefault.iconNull());
        }

        //인벤토리 반환
        return inv;
    }

    private ItemStack train(){
        if (!(MetroFile.getDataFile("기차").canRead())) {
            List<String> lore = new ArrayList<>();
            lore.add("§7 클릭 시 기차 좌표가 설정됩니다");
            return IconDefault.iconDefault(Material.COAL_BLOCK, "기차", lore);
        }

        FileConfiguration config = MetroFile.getConfig("기차");

        List<String> lore = new ArrayList<>();
        lore.add("§7 좌클릭: 좌표로 텔레포트");
        lore.add("§7 우클릭: 설정 삭제");
        lore.add("§7 -------------------");
        lore.add("§7 X: " + config.get("x"));
        lore.add("§7 Y: " + config.get("y"));
        lore.add("§7 Z: " + config.get("z"));

        return IconDefault.iconDefault(Material.DIAMOND_BLOCK, "기차", lore);
    }

    private ItemStack station(String name){
        if (!(MetroFile.getDataFile(name).canRead())){
            List<String> lore = new ArrayList<>();
            lore.add("§7 클릭 시 기차역 좌표가 설정됩니다");
            return IconDefault.iconDefault(Material.COAL_BLOCK, name, lore);
        }

        List<String> lore = new ArrayList<>();
        lore.add("§7 좌클릭: 좌표로 텔레포트");
        lore.add("§7 우클릭: 설정 삭제");
        lore.add("§7 쉬프트+좌클릭: npc 생성");
        lore.add("§7 쉬프트+우클릭: npc 삭제");
        lore.add("§7 -------------------");
        lore.add("§7 X: " + MetroFile.getConfig(name).getString("x"));
        lore.add("§7 Y: " + MetroFile.getConfig(name).getString("y"));
        lore.add("§7 Z: " + MetroFile.getConfig(name).getString("z"));
        return IconDefault.iconDefault(Material.EMERALD_BLOCK, name, lore, MetroFile.getConfig(name).getBoolean("npc"));
    }

    @EventHandler
    private void onInventoryClickEvent(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        if (event.getView().getTitle().contains("§x§0§0§b§3§b§6 Delluna Train 관리 페이지")){
            event.setCancelled(true);

            if (event.getClickedInventory() == event.getView().getBottomInventory()) return;
            if (event.getCurrentItem() == null) return;

            String name = event.getCurrentItem().getItemMeta().getDisplayName();

            switch ((event.getCurrentItem()).getType()) {
                case COAL_BLOCK:
                    MetroFile.creatDataFile(name, player);
                    break;
                case EMERALD_BLOCK:
                    switch (event.getClick()){
                        case LEFT:
                            MetroEvent.teleport(name, player);
                            break;
                        case RIGHT:
                            MetroNPC.removeNPC(name, player);
                            MetroFile.removeFile(name);
                            break;
                        case SHIFT_LEFT:
                            MetroNPC.createNPC(name, player);
                            break;
                        case SHIFT_RIGHT:
                            MetroNPC.removeNPC(name, player);
                            break;
                    }
                    break;

                case DIAMOND_BLOCK:
                    switch (event.getClick()){
                        case LEFT:
                            MetroEvent.teleport(name, player);
                            break;
                        case RIGHT:
                            MetroFile.removeFile(name);
                            break;
                    }
                    break;
            }
            player.openInventory(new MetroManagementGUI().getInventory());
            return;
        }
    }
}
