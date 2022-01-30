package zishu.xiatools.Listener;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import zishu.xiatools.XIATools;

import java.util.HashMap;
import java.util.Map;

public class BackListener implements Listener {
    public Map<String,Location> locationMap=new  HashMap<>();

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        locationMap.put(e.getEntity().getName(),e.getEntity().getLocation());
        e.getEntity().sendMessage(XIATools.prefix + " 输入§b/back§f返回死亡地点");
    }
}