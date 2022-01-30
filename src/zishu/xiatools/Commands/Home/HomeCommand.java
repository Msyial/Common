package zishu.xiatools.Commands.Home;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import zishu.xiatools.XIATools;

public class HomeCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("home")) {
            if (sender instanceof Player) {
                Player player=(Player) sender;
                if (!player.getWorld().getName().equalsIgnoreCase("world_nether")&&!player.getWorld().getName().equalsIgnoreCase("world_the_end")) {
                    if (args.length==0) {

                        FileConfiguration config = XIATools.getIns().getConfig();
                        if (getLocation(player, player.getWorld(), "Default")==null){
                            player.sendMessage(XIATools.prefix + " 没有找到这个家的标记点");
                            return true;
                        }else {
                            player.teleport(getLocation(player, player.getWorld(), "Default"));
                            PotionEffect potion1 = new PotionEffect(PotionEffectType.BLINDNESS, 20, 5);
                            PotionEffect potion2 = new PotionEffect(PotionEffectType.SPEED, 20, -10);
                            PotionEffect potion3 = new PotionEffect(PotionEffectType.JUMP, 20, -10);
                            potion1.apply(player);
                            potion2.apply(player);
                            potion3.apply(player);
                            player.sendMessage(XIATools.prefix + " 已传送至家");
                        }
                    }else {
                        if (args.length == 1) {
                            FileConfiguration config = XIATools.getIns().getConfig();
                            if (getLocation(player, player.getWorld(), args[0])==null) {
                                player.sendMessage(XIATools.prefix + " 没有找到这个家的标记点");
                                return true;
                            }else {
                                player.teleport(getLocation(player, player.getWorld(), args[0]));
                                player.sendMessage(XIATools.prefix + " 已传送至"+args[0]);
                                PotionEffect potion1 = new PotionEffect(PotionEffectType.BLINDNESS, 100, 5);
                                PotionEffect potion2 = new PotionEffect(PotionEffectType.SPEED, 100, -10);
                                PotionEffect potion3 = new PotionEffect(PotionEffectType.JUMP, 100, -10);
                                potion1.apply(player);
                                potion2.apply(player);
                                potion3.apply(player);
                            }
                        }
                    }
                }
            }
        }


        return false;
    }
    public Location getLocation(Player player,World world,String Type){
        FileConfiguration config=XIATools.getIns().getConfig();
        double x=config.getDouble(player.getName()+".x."+Type);
        double y=config.getDouble(player.getName()+".y."+Type);
        double z=config.getDouble(player.getName()+".z."+Type);
        if(x==0&&y==0&&z==0){
            return null;
        }
        return new Location(world,x,y,z);
    }



}
