package zishu.xiatools.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class HelpCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        sender.sendMessage("§8§m--------§b服务器指令合集§8§m--------");
        sender.sendMessage("§b/tpa 玩家名 §8- §3可以向玩家发送传送请求");
        sender.sendMessage("§b/sethome    §8- §3可以设置当前位置为家");
        sender.sendMessage("§b/home       §8- §3可以传送至家位置");
        sender.sendMessage("§b/fly        §8- §3可以开启飞行模式");
        sender.sendMessage("§b/suicide    §8- §3自杀指令，可以脱离卡死");
        sender.sendMessage("§b/tpr        §8- §3可以进行随机传送");
        sender.sendMessage("§b/back       §8- §3可以返回上次死亡地点");








        return true;
    }
}