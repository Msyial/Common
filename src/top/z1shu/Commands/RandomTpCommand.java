package top.z1shu.Commands;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import top.z1shu.Listener.CommandDelay;
import top.z1shu.Main;

import java.util.Random;

public class RandomTpCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){

        if (command.getName().equalsIgnoreCase("tpr")){
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (!sender.isOp()) {
                    if (!player.getWorld().getName().equalsIgnoreCase("world_nether")&&!player.getWorld().getName().equalsIgnoreCase("world_the_end")){
                        if (CommandDelay.commandDelay.get(player.getName())==null||(System.currentTimeMillis())-(CommandDelay.commandDelay.get(player.getName()))>=300000) {
                            player.teleport(getTeleportLocation(player.getWorld()));
                            PotionEffect potion1 = new PotionEffect(PotionEffectType.BLINDNESS, 40, 5);
                            PotionEffect potion2 = new PotionEffect(PotionEffectType.SPEED, 40, -10);
                            PotionEffect potion3 = new PotionEffect(PotionEffectType.JUMP, 40, -10);
                            potion1.apply(player);
                            potion2.apply(player);
                            potion3.apply(player);
                            player.sendMessage(Main.TipPerfix + "正在传送... 请稍等。");
                            CommandDelay.commandDelay.put(player.getName(), System.currentTimeMillis());
                        }

                    } else {
                        sender.sendMessage(Main.WarnPrefix + "随机传送时间冷却时间为5分钟!");
                    }
                }else{if (!player.getWorld().getName().equalsIgnoreCase("world_nether")&&!player.getWorld().getName().equalsIgnoreCase("world_the_end")) {
                    Player p = (Player) sender;
                    p.teleport(getTeleportLocation(p.getWorld()));
                    PotionEffect potion1 = new PotionEffect(PotionEffectType.BLINDNESS, 40, 5);
                    PotionEffect potion2 = new PotionEffect(PotionEffectType.SPEED, 40, -10);
                    PotionEffect potion3 = new PotionEffect(PotionEffectType.JUMP, 40, -10);
                    potion1.apply(p);
                    potion2.apply(p);
                    potion3.apply(p);
                    player.sendMessage(Main.TipPerfix+ "正在传送... 请稍等。");
                }
                }
            }
        }









        return false;
    }
    public Location getTeleportLocation(World world){
        Random random=new Random();
        int x =random.nextInt(5000)+500;
        int z =random.nextInt(5000)+500;
        int y =world.getHighestBlockYAt(x,z) + 2;

        return new Location(world,x,y,z);
    }


}