package me.lewin.dellunametro.gui;

import me.lewin.dellunametro.data.MetroEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class NewMetroGUI implements Listener {
    public Inventory getInventory(Integer line, Integer mode){
        Inventory inv = Bukkit.getServer().createInventory(null, 54, nameSet(line));

        inv.setItem(6, signSet(line));

        if (mode == 0){

            inv.setItem(1, NullIcon("§7[ §x§6§f§c§5§e§f§l중앙역 §7]"));
            inv.setItem(3, NullIcon("§7[ §x§6§f§c§5§e§f§l중앙역 §7]"));
            inv.setItem(2, center());

            inv.setItem(10, NullIcon("§7[ §x§e§9§3§a§5§8§l1호선 §7]"));
            inv.setItem(12, NullIcon("§7[ §x§e§9§3§a§5§8§l1호선 §7]"));
            inv.setItem(11, line1());

            inv.setItem(19, NullIcon("§7[ §x§3§7§5§d§d§9§l2호선 §7]"));
            inv.setItem(21, NullIcon("§7[ §x§3§7§5§d§d§9§l2호선 §7]"));
            inv.setItem(20, line2());

            inv.setItem(28, NullIcon("§7[ §x§2§7§c§e§4§e§l3호선 §7]"));
            inv.setItem(30, NullIcon("§7[ §x§2§7§c§e§4§e§l3호선 §7]"));
            inv.setItem(29, line3());

            inv.setItem(37, NullIcon("§7[ §x§f§4§c§6§2§d§l4호선 §7]"));
            inv.setItem(39, NullIcon("§7[ §x§f§4§c§6§2§d§l4호선 §7]"));
            inv.setItem(38, line4());
        }

        else if (mode == 1){
            inv.setItem(1, NullIcon("§7[ §x§e§9§3§a§5§8§l장미역 §7]"));
            inv.setItem(3, NullIcon("§7[ §x§e§9§3§a§5§8§l장미역 §7]"));
            inv.setItem(2, line11());

            inv.setItem(10, NullIcon("§7[ §x§e§9§3§a§5§8§l동백역 §7]"));
            inv.setItem(12, NullIcon("§7[ §x§e§9§3§a§5§8§l동백역 §7]"));
            inv.setItem(11, line12());

            inv.setItem(46, NullIcon("§7[ §7§l뒤로가기 §7]"));
            inv.setItem(48, NullIcon("§7[ §7§l뒤로가기 §7]"));
            inv.setItem(47, back());
        }

        else if (mode == 2){
            inv.setItem(1, NullIcon("§7[ §x§3§7§5§d§d§9§l수국역 §7]"));
            inv.setItem(3, NullIcon("§7[ §x§3§7§5§d§d§9§l수국역 §7]"));
            inv.setItem(2, line21());

            inv.setItem(10, NullIcon("§7[ §x§3§7§5§d§d§9§l물망초역 §7]"));
            inv.setItem(12, NullIcon("§7[ §x§3§7§5§d§d§9§l물망초역 §7]"));
            inv.setItem(11, line22());

            inv.setItem(46, NullIcon("§7[ §7§l뒤로가기 §7]"));
            inv.setItem(48, NullIcon("§7[ §7§l뒤로가기 §7]"));
            inv.setItem(47, back());
        }

        else if (mode == 3){
            inv.setItem(1, NullIcon("§7[ §x§2§7§c§e§4§e§l국화역 §7]"));
            inv.setItem(3, NullIcon("§7[ §x§2§7§c§e§4§e§l국화역 §7]"));
            inv.setItem(2, line31());

            inv.setItem(10, NullIcon("§7[ §x§2§7§c§e§4§e§l진달래역 §7]"));
            inv.setItem(12, NullIcon("§7[ §x§2§7§c§e§4§e§l진달래역 §7]"));
            inv.setItem(11, line32());

            inv.setItem(46, NullIcon("§7[ §7§l뒤로가기 §7]"));
            inv.setItem(48, NullIcon("§7[ §7§l뒤로가기 §7]"));
            inv.setItem(47, back());
        }

        else if (mode == 4){
            inv.setItem(1, NullIcon("§7[ §x§f§4§c§6§2§d§l개나리역 §7]"));
            inv.setItem(3, NullIcon("§7[ §x§f§4§c§6§2§d§l개나리역 §7]"));
            inv.setItem(2, line41());

            inv.setItem(10, NullIcon("§7[ §x§f§4§c§6§2§d§l해바라기역 §7]"));
            inv.setItem(12, NullIcon("§7[ §x§f§4§c§6§2§d§l해바라기역 §7]"));
            inv.setItem(11, line42());

            inv.setItem(46, NullIcon("§7[ §7§l뒤로가기 §7]"));
            inv.setItem(48, NullIcon("§7[ §7§l뒤로가기 §7]"));
            inv.setItem(47, back());
        }

        return inv;

    }

    private String nameSet(Integer line){
        switch (line){
            case 0:
                return "§f\uF808ꢰ\uF80C\uF80A\uF809ꢒ";
            case 11:
            case 12:
                return "§f\uF808ꢰ\uF80C\uF80A\uF809ꢓ";
            case 21:
            case 22:
                return "§f\uF808ꢰ\uF80C\uF80A\uF809ꢔ";
            case 31:
            case 32:

                return "§f\uF808ꢰ\uF80C\uF80A\uF809ꢕ";
            case 41:
            case 42:
                return "§f\uF808ꢰ\uF80C\uF80A\uF809ꢖ";
        }
        return "null";
    }
    private ItemStack signSet(Integer line){
        switch (line){
            case 0:
                return IconDefault.iconDefault(Material.BONE, " ", 1014);
            case 11:
                return IconDefault.iconDefault(Material.BONE, " ", 1015);
            case 12:
                return IconDefault.iconDefault(Material.BONE, " ", 1016);
            case 21:
                return IconDefault.iconDefault(Material.BONE, " ", 1017);
            case 22:
                return IconDefault.iconDefault(Material.BONE, " ", 1018);
            case 31:
                return IconDefault.iconDefault(Material.BONE, " ", 1019);
            case 32:
                return IconDefault.iconDefault(Material.BONE, " ", 1020);
            case 41:
                return IconDefault.iconDefault(Material.BONE, " ", 1021);
            case 42:
                return IconDefault.iconDefault(Material.BONE, " ", 1022);
        }
        return NullIcon("null");
    }
    private ItemStack NullIcon(String name){
        return IconDefault.iconDefault(Material.BONE, name, 1023);
    }

    private ItemStack center(){
        return IconDefault.iconDefault(Material.BONE, "§7[ §x§6§f§c§5§e§f§l중앙역 §7]", 1000);
    }
    private ItemStack line1(){
        return IconDefault.iconDefault(Material.BONE, "§7[ §x§e§9§3§a§5§8§l1호선 §7]", 1002);
    }
    private ItemStack line2(){
        return IconDefault.iconDefault(Material.BONE, "§7[ §x§3§7§5§d§d§9§l2호선 §7]", 1005);
    }
    private ItemStack line3(){
        return IconDefault.iconDefault(Material.BONE, "§7[ §x§2§7§c§e§4§e§l3호선 §7]", 1008);
    }
    private ItemStack line4(){
        return IconDefault.iconDefault(Material.BONE, "§7[ §x§f§4§c§6§2§d§l4호선 §7]", 1011);
    }

    private ItemStack back(){
        return IconDefault.iconDefault(Material.BONE, "§7[ §7§l뒤로가기 §7]", 1001);
    }
    private ItemStack line11(){
        return IconDefault.iconDefault(Material.BONE, "§7[ §x§e§9§3§a§5§8§l장미역 §7]", 1003);
    }
    private ItemStack line12(){
        return IconDefault.iconDefault(Material.BONE, "§7[ §x§e§9§3§a§5§8§l동백역 §7]", 1004);
    }
    private ItemStack line21(){
        return IconDefault.iconDefault(Material.BONE, "§7[ §x§3§7§5§d§d§9§l수국역 §7]", 1006);
    }
    private ItemStack line22(){
        return IconDefault.iconDefault(Material.BONE, "§7[ §x§3§7§5§d§d§9§l물망초역 §7]", 1007);
    }
    private ItemStack line31(){
        return IconDefault.iconDefault(Material.BONE, "§7[ §x§2§7§c§e§4§e§l국화역 §7]", 1009);
    }
    private ItemStack line32(){
        return IconDefault.iconDefault(Material.BONE, "§7[ §x§2§7§c§e§4§e§l진달래역 §7]", 1010);
    }
    private ItemStack line41(){
        return IconDefault.iconDefault(Material.BONE, "§7[ §x§f§4§c§6§2§d§l개나리역 §7]", 1012);
    }
    private ItemStack line42(){
        return IconDefault.iconDefault(Material.BONE, "§7[ §x§f§4§c§6§2§d§l해바라기역 §7]", 1013);
    }

    @EventHandler
    private void onInventoryClickEvent(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        Boolean istrain = false;

        if (event.getView().getTitle().contains("§f\uF808ꢰ\uF80C\uF80A\uF809ꢒ")) istrain = true;
        if (event.getView().getTitle().contains("§f\uF808ꢰ\uF80C\uF80A\uF809ꢓ")) istrain = true;
        if (event.getView().getTitle().contains("§f\uF808ꢰ\uF80C\uF80A\uF809ꢔ")) istrain = true;
        if (event.getView().getTitle().contains("§f\uF808ꢰ\uF80C\uF80A\uF809ꢕ")) istrain = true;
        if (event.getView().getTitle().contains("§f\uF808ꢰ\uF80C\uF80A\uF809ꢖ")) istrain = true;

        if (istrain){

            event.setCancelled(true);

            if (event.getClickedInventory() == event.getView().getBottomInventory()) return;
            if (event.getCurrentItem() == null) return;

            Integer line = 0;
            if (event.getClickedInventory().getItem(6).getItemMeta().hasCustomModelData()){
                switch (event.getClickedInventory().getItem(6).getItemMeta().getCustomModelData()){
                    case 1014:
                        line = 0;
                        break;
                    case 1015:
                        line = 11;
                        break;
                    case 1016:
                        line = 12;
                        break;
                    case 1017:
                        line = 21;
                        break;
                    case 1018:
                        line = 22;
                        break;
                    case 1019:
                        line = 31;
                        break;
                    case 1020:
                        line = 32;
                        break;
                    case 1021:
                        line = 41;
                        break;
                    case 1022:
                        line = 42;
                        break;
                }
            }


            String name = event.getCurrentItem().getItemMeta().getDisplayName();
            switch (event.getSlot()) {
                case 1:
                case 2:
                case 3:
                    if (event.getCurrentItem().getItemMeta().getDisplayName().contains("중앙역")) {
                        if (MetroEvent.hasTicket(player)) {
                            MetroEvent.teleportMetro("중앙역", player);
                            break;
                        }
                        player.sendMessage("기차표를 소지하고 있지 않습니다.");
                        break;
                    }
                    else if (event.getCurrentItem().getItemMeta().getDisplayName().contains("장미역")) {
                        if (MetroEvent.hasTicket(player)) {
                            MetroEvent.teleportMetro("장미역", player);
                            break;
                        }
                        player.sendMessage("기차표를 소지하고 있지 않습니다.");
                        break;
                    }
                    else if (event.getCurrentItem().getItemMeta().getDisplayName().contains("수국역")) {
                        if (MetroEvent.hasTicket(player)) {
                            MetroEvent.teleportMetro("수국역", player);
                            break;
                        }
                        player.sendMessage("기차표를 소지하고 있지 않습니다.");
                        break;
                    }
                    else if (event.getCurrentItem().getItemMeta().getDisplayName().contains("국화역")) {
                        if (MetroEvent.hasTicket(player)) {
                            MetroEvent.teleportMetro("국화역", player);
                            break;
                        }
                        player.sendMessage("기차표를 소지하고 있지 않습니다.");
                        break;
                    }
                    else if (event.getCurrentItem().getItemMeta().getDisplayName().contains("개나리역")) {
                        if (MetroEvent.hasTicket(player)) {
                            MetroEvent.teleportMetro("개나리역", player);
                            break;
                        }
                        player.sendMessage("기차표를 소지하고 있지 않습니다.");
                        break;
                    }

                case 10:
                case 11:
                case 12:
                    if (event.getCurrentItem().getItemMeta().getDisplayName().contains("1호선")) {
                        player.openInventory(new NewMetroGUI().getInventory(line, 1));
                        break;
                    }
                    else if (event.getCurrentItem().getItemMeta().getDisplayName().contains("동백역")) {
                        if (MetroEvent.hasTicket(player)) {
                            MetroEvent.teleportMetro("동백역", player);
                            break;
                        }
                        player.sendMessage("기차표를 소지하고 있지 않습니다.");
                        break;
                    }
                    else if (event.getCurrentItem().getItemMeta().getDisplayName().contains("물망초역")) {
                        if (MetroEvent.hasTicket(player)) {
                            MetroEvent.teleportMetro("물망초역", player);
                            break;
                        }
                        player.sendMessage("기차표를 소지하고 있지 않습니다.");
                        break;
                    }
                    else if (event.getCurrentItem().getItemMeta().getDisplayName().contains("진달래역")) {
                        if (MetroEvent.hasTicket(player)) {
                            MetroEvent.teleportMetro("진달래역", player);
                            break;
                        }
                        player.sendMessage("기차표를 소지하고 있지 않습니다.");
                        break;
                    }
                    else if (event.getCurrentItem().getItemMeta().getDisplayName().contains("해바라기역")) {
                        if (MetroEvent.hasTicket(player)) {
                            MetroEvent.teleportMetro("해바라기역", player);
                            break;
                        }
                        player.sendMessage("기차표를 소지하고 있지 않습니다.");
                        break;
                    }
                case 19:
                case 20:
                case 21:
                    if (event.getCurrentItem().getItemMeta().getDisplayName().contains("2호선")) {
                        player.openInventory(new NewMetroGUI().getInventory(line, 2));
                        break;
                    }
                case 28:
                case 29:
                case 30:
                    if (event.getCurrentItem().getItemMeta().getDisplayName().contains("3호선")) {
                        player.openInventory(new NewMetroGUI().getInventory(line, 3));
                        break;
                    }
                case 37:
                case 38:
                case 39:
                    if (event.getCurrentItem().getItemMeta().getDisplayName().contains("4호선")) {
                        player.openInventory(new NewMetroGUI().getInventory(line, 4));
                        break;
                    }
                case 46:
                case 47:
                case 48:
                    if (event.getCurrentItem().getItemMeta().getDisplayName().contains("뒤로가기")){
                        player.openInventory(new NewMetroGUI().getInventory(line, 0));
                        break;
                    }
            }
        }
    }
}
