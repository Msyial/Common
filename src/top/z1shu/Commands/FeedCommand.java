package top.z1shu.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import top.z1shu.Main;

public class FeedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        Player p = (Player) sender;
        if (!p.hasPermission("XIATools.Feed")) {
            p.sendMessage(Main.WarnPrefix +  Main.NoPermission);
            return true;
        }
        if ((p.hasPermission("XIATools.Feed")) && (args.length == 0)) {
            p.setFoodLevel(100);
            p.sendMessage(Main.TipPerfix + "你现在饱了。");
            return true;
        }
        return false;
    }
}
