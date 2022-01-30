package zishu.xiatools.Listener;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;
import zishu.xiatools.XIATools;

public class DropClearListener implements Listener {
    public void run(){
        new BukkitRunnable() {
            @Override
            public void run() {
                int clearNum=0;
                for (World w: Bukkit.getWorlds()){
                    for ( Entity e:w.getEntities()){
                        if (e instanceof Item){
                            Item item=(Item) e;
                            item.remove();
                            clearNum++;
                        }
                    }
                }
                Bukkit.broadcastMessage("§b抱走了了§9"+clearNum+"§b个掉落物  by 可爱又迷人的Pas");

            }
        }.runTaskTimer(XIATools.getIns(),24000,24000);

    }
    public void broadcastIn60Second(){
        new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage("§b60秒后Pas将来捡垃圾，请做好准备");
            }
        }.runTaskTimer(XIATools.getIns(),22800,24000);

    }
    public void broadcastIn30Second(){
        new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage("§b30秒后Pas将来捡垃圾，请做好准备");
            }
        }.runTaskTimer(XIATools.getIns(),23400,24000);

    }
    public void broadcastIn10Second(){
        new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage("§b10秒后Pas将来捡垃圾，请做好准备");
            }
        }.runTaskTimer(XIATools.getIns(),23800,24000);

    }

}