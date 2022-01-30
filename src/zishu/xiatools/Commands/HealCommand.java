package zishu.xiatools.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import zishu.xiatools.XIATools;

public class HealCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if(sender instanceof Player){
            Player player=(Player) sender;
            if (command.getName().equalsIgnoreCase("heal")){
                if (player.isOp()) {
                    if (args.length == 0) {
                        Player p = (Player) sender;
                        p.setFoodLevel(20);
                        p.setHealth(20.0D);
                        sender.sendMessage(XIATools.prefix + " 已恢复");
                    }
                } else {
                    sender.sendMessage(XIATools.prefix + XIATools.noPermission);
                    return true;

                }
                return true;
            }
        }return false;
    }



}