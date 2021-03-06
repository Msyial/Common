package top.z1shu.Commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import top.z1shu.Main;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        Player p = (Player) sender;
        if (!p.hasPermission("XIATools.Fly")) {
            p.sendMessage(Main.WarnPrefix +  Main.NoPermission);
            return true;
        }
        if (p.getAllowFlight()) {
            p.setAllowFlight(false);
            p.setFlying(false);
            p.sendMessage(Main.TipPerfix+ "飞行模式已禁用。");
            p.playSound(p.getLocation(), Sound.ENTITY_BAT_DEATH, 3.0F, 2.0F);
        } else {
            p.setAllowFlight(true);
            p.setFlying(true);
            p.sendMessage(Main.TipPerfix + "飞行模式已启用。");
            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 3.0F,2.0F);
        }
        return true;
    }
}

