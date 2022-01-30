package top.z1shu.Commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import top.z1shu.Main;


public class BackCommand implements CommandExecutor {
    Main javaPlugin;
    public BackCommand(Main javaPlugin){
        this.javaPlugin=javaPlugin;
    }


    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if (command.getName().equalsIgnoreCase("back")){
            if (sender instanceof Player) {
                if (args.length == 0) {
                    Player player=(Player) sender;
                    if (javaPlugin.BackListener.locationMap.get(player.getName())!=null) {
                        Location location = javaPlugin.BackListener.locationMap.get(player.getName());
                        player.teleport(location);
                        player.sendMessage(Main.TipPerfix+ "已传送至死亡点。");
                    }else {
                        player.sendMessage(Main.TipPerfix + "未找到死亡点。");
                    }
                }
            }
        }
        return true;
    }
}