package zishu.xiatools.Listener;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AtListener implements Listener {
    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        if (e.getMessage().contains("@")){
            if (e.getMessage().contains("@全体成员")){
                if (e.getPlayer().hasPermission("utils.atAll")){
                    for (Player player:Bukkit.getOnlinePlayers()){
                        player.sendMessage("§3"+e.getPlayer().getName()+"§b提到了你");
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP,1.0F,1.0F);
                        e.getMessage().replace("@全体成员"," §b@全体成员§f ");
                        return;
                    }
                }
            }else {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    if (e.getMessage().contains("@" + player.getName())) {
                        player.sendMessage("§3" + e.getPlayer().getName() + "§b提到了你");
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
                        e.getMessage().replace("@" + player.getName(), " §b@" + player.getName() + "§f ");
                        break;
                    }
                }
            }
        }
    }
}