package top.z1shu.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import top.z1shu.Main;

public class HelpCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        sender.sendMessage(Main.HelpPrefix + "如果你需要新手教程请打开下面的地址");
        sender.sendMessage(Main.HelpPrefix + "https://shimo.im/docs/JvDpjHTd6pyvprW6/");
        return true;
    }
}