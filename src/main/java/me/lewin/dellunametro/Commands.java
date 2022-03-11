package me.lewin.dellunametro;

import me.lewin.dellunametro.gui.MetroManagementGUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String args[]){
        Player player = (Player) sender;

        //플레이어 입력이 아닌경우 리턴
        if (!(sender instanceof Player)) return true;

        //오피가 아닌경우 리턴
        if (!(player.isOp())) return true;

        //명령어의 원소 개수가 0이 아닌경우 리턴
        if (args.length != 0) return true;

        //메트로 관리 페이지 열기
        player.openInventory(new MetroManagementGUI().getInventory());
        return true;
    }
}
