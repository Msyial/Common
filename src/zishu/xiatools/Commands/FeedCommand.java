package zishu.xiatools.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import zishu.xiatools.XIATools;

public class FeedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        Player p = (Player) sender;
        if (!p.hasPermission("XIATools.Feed")) {
            p.sendMessage(XIATools.prefix +  XIATools.noPermission);
            return true;
        }
        if ((p.hasPermission("XIATools.Feed")) && (args.length == 0)) {
            p.setFoodLevel(100);
            p.sendMessage(XIATools.prefix + " 你现在饱了");
            return true;
        }
        return false;
    }
}
