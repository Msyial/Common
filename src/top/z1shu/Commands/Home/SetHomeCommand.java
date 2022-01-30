package top.z1shu.Commands.Home;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import top.z1shu.Main;

public class SetHomeCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if (command.getName().equalsIgnoreCase("sethome")){
            if (sender instanceof Player) {
                if (args.length == 0) {
                    Player player = (Player) sender;
                    Main.getIns().saveDefaultConfig();
                    FileConfiguration config = Main.getIns().getConfig();
                    config.set(player.getName() + ".x."+"Default", player.getLocation().getX());
                    config.set(player.getName() + ".y."+"Default", player.getLocation().getY());
                    config.set(player.getName() + ".z."+"Default", player.getLocation().getZ());
                    Main.getIns().saveConfig();
                    player.sendMessage(Main.TipPerfix + "§7已设置家，你可以输入§f/home§7回到此处，你也可以输入§f/sethome§7地名，保存多个传送地址");
                }else if (args.length==1){
                    Player player=(Player) sender;
                    Main.getIns().saveDefaultConfig();
                    FileConfiguration config = Main.getIns().getConfig();
                    config.set(player.getName() + ".x."+args[0], player.getLocation().getX());
                    config.set(player.getName() + ".y."+args[0], player.getLocation().getY());
                    config.set(player.getName() + ".z."+args[0], player.getLocation().getZ());
                    Main.getIns().saveConfig();
                    player.sendMessage(Main.TipPerfix + "§7已设置"+args[0]+"处为家，传送请输入§f/home "+args[0]);

                }
            }
        }
        return false;
    }
}