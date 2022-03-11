package me.lewin.dellunametro.data;

import me.lewin.dellunametro.gui.NewMetroGUI;
import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import net.citizensnpcs.api.npc.NPC;
import net.citizensnpcs.trait.LookClose;
import net.citizensnpcs.trait.SkinTrait;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class MetroNPC implements Listener {
    //npc 생성
    public static void createNPC(String name, Player player) {
        NPC npc = CitizensAPI.getNPCRegistry().createNPC(EntityType.PLAYER, name);

        FileConfiguration config = MetroFile.getConfig(name);
        config.set("npc", true);
        config.set("npcID", npc.getId());
        MetroFile.saveFile(config, MetroFile.getDataFile(name));

        //npc 스킨 설정 (기차역 몽키씨)
        //https://minesk.in/bfef263f7e4a457d83a4253ed2ed289a
        npc.getOrAddTrait(SkinTrait.class).setSkinPersistent("bfef263f7e4a457d83a4253ed2ed289a", "HTeYjeRaWMew7vOHaqL8u+M26G4XMwBbofCifbRtHCHYMGU7etl1p12MiPvXiNU8IcdjwDXGglPKNnoKNHictFBeQPZTDrgg5lYCX2WiSCg6dRofkKFqI8siFUVnJEkcCgI25qEgO7agpFafyZc7lUAPR6+4xvbREDZ6imFPpHm/ruW93P+AXGVmOdx+oK5OngkfyYyRscXjoWmtbpEv29TObMm17h3am49QcYlXuf//jXy4krQRjGKJoDN7HPULDt2ZTgC0bolyv1+9QlaRJKWUsjcwxA1TJ4i7t6k8Mu5rawhPyJSTWT8yl0+bGq5KySbNp746OeC3Cv424q1osAKvwIJxveMfS3ZB+6ogxWlIv58s/U4WxBVmYCdxiuz70rY//HaYUC/AXjRxUKYCzHf7afocHhp7JjuX9p142rTtplEbGszeK5J6YTeIfDKgfeapo5C5jtJWAl1bEggLx/kgSjIUYiWB7BOnSGiWlHfN9GXTVefNS+AFIosF8AwVloKK0EA9bWkkvonhvy/WS9DZbA20wqxHn4WtvsLhQROuycKNU2cuGarDSUx8Q7KFbmA1EMfS39n3yal0vJUUqrviJ9svPCM5RbPpigCUXTu6jfwjbsIH/+gN6HF1Kr/8+Jl4xusPzj9WQg9N47HWYulglZe2eNLfWPQ7QdoUa4s=", "ewogICJ0aW1lc3RhbXAiIDogMTYyODA1ODI1MTg5NywKICAicHJvZmlsZUlkIiA6ICI4MWU4ZWU1MTE1ZmE0NzU5OTU1YTAzMThkNTNhNjViYyIsCiAgInByb2ZpbGVOYW1lIiA6ICJDb25zaWRlclRoYXQiLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjlmZTA5ZTZiYWMzODM2NDQ4MDE2OWU2MmQ1ZmEyMTJiYWI3YmZkNzY3NDJiZmQwMGQwYjJiYjg1MmJiZjU1OSIsCiAgICAgICJtZXRhZGF0YSIgOiB7CiAgICAgICAgIm1vZGVsIiA6ICJzbGltIgogICAgICB9CiAgICB9CiAgfQp9");
        npc.getOrAddTrait(LookClose.class).lookClose(true);

        npc.spawn(player.getLocation());
    }

    //npc 제거
    public static void removeNPC(String name, Player player){
        //기차역 파일 불러오기
        FileConfiguration config = MetroFile.getConfig(name);

        //만약 npc가 존재하지 않으면 메세지 출력
        if (!(config.getBoolean("npc"))) {
            player.sendMessage("npc가 존재하지 않습니다.");
            return;
        }

        //수정할 npc 아이디 가져오기
        NPC npc = CitizensAPI.getNPCRegistry().getById(config.getInt("npcID"));

        //npc 삭제
        npc.destroy();

        //기차역 파일에 npc 정보 삭제
        config.set("npc", false);
        config.set("npcID", 0);

        //기차역 파일 저장
        MetroFile.saveFile(config, MetroFile.getDataFile(name));
    }

    @EventHandler
    public static void onInteractNPCEvent(NPCRightClickEvent event){
        Player player = event.getClicker();

        if ((MetroFile.getDataFile(event.getNPC().getName())).canRead()){
            switch (event.getNPC().getName()){
                case "중앙역":
                    player.openInventory(new NewMetroGUI().getInventory(0, 0));
                    break;
                case "장미역":
                    player.openInventory(new NewMetroGUI().getInventory(11, 0));
                    break;
                case "동백역":
                    player.openInventory(new NewMetroGUI().getInventory(12, 0));
                    break;
                case "수국역":
                    player.openInventory(new NewMetroGUI().getInventory(21, 0));
                    break;
                case "물망초역":
                    player.openInventory(new NewMetroGUI().getInventory(22, 0));
                    break;
                case "국화역":
                    player.openInventory(new NewMetroGUI().getInventory(31, 0));
                    break;
                case "진달래역":
                    player.openInventory(new NewMetroGUI().getInventory(32, 0));
                    break;
                case "개나리역":
                    player.openInventory(new NewMetroGUI().getInventory(41, 0));
                    break;
                case "해바라기역":
                    player.openInventory(new NewMetroGUI().getInventory(42, 0));
                    break;
            }
        }
    }
}
