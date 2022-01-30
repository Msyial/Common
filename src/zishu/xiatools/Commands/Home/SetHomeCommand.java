package zishu.xiatools.Commands.Home;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import zishu.xiatools.XIATools;

public class SetHomeCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if (command.getName().equalsIgnoreCase("sethome")){
            if (sender instanceof Player) {
                if (args.length == 0) {
                    Player player = (Player) sender;
                    XIATools.getIns().saveDefaultConfig();
                    FileConfiguration config = XIATools.getIns().getConfig();
                    config.set(player.getName() + ".x."+"Default", player.getLocation().getX());
                    config.set(player.getName() + ".y."+"Default", player.getLocation().getY());
                    config.set(player.getName() + ".z."+"Default", player.getLocation().getZ());
                    XIATools.getIns().saveConfig();
                    player.sendMessage(XIATools.prefix + " 已设置家，你可以输入§b/home§f回到此处，你也可以输入§b/sethome §f地名，保存多个传送地址");
                }else if (args.length==1){
                    Player player=(Player) sender;
                    XIATools.getIns().saveDefaultConfig();
                    FileConfiguration config = XIATools.getIns().getConfig();
                    config.set(player.getName() + ".x."+args[0], player.getLocation().getX());
                    config.set(player.getName() + ".y."+args[0], player.getLocation().getY());
                    config.set(player.getName() + ".z."+args[0], player.getLocation().getZ());
                    XIATools.getIns().saveConfig();
                    player.sendMessage(XIATools.prefix + " 已设置"+args[0]+"处为家，传送请输入§b/home "+args[0]);

                }
            }
        }
        return false;
    }
}