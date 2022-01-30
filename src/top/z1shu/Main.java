package top.z1shu;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import top.z1shu.Commands.*;
import top.z1shu.Commands.Home.HomeCommand;
import top.z1shu.Commands.Home.SetHomeCommand;
import top.z1shu.Listener.BackListener;
import top.z1shu.Listener.CommandDelay;

public class Main extends JavaPlugin implements Listener {
    private static Main ins;
    public static Main getIns() {
        return ins;
    }

        public top.z1shu.Listener.BackListener BackListener=new BackListener();
        public static String TipPerfix = "§8[§c§l!§8]§7";
        public static String HelpPrefix = "§8[§a§l?§8]§7";
        public static String WarnPrefix = "§8[§4⚠§8]§7";
        public static String NoPermission = "你没有权限这么做。";

        @Override
        public void onEnable () {
            ins=this;
            getLogger().info("已加载");
            getCommand("fly").setExecutor(new FlyCommand());
            getCommand("feed").setExecutor(new FeedCommand());
            getCommand("sethome").setExecutor(new SetHomeCommand());
            getCommand("home").setExecutor(new HomeCommand());
            getCommand("back").setExecutor(new BackCommand(this));
            getCommand("tpr").setExecutor(new RandomTpCommand());
            getCommand("help").setExecutor(new HelpCommand());
            getCommand("heal").setExecutor(new HealCommand());
            Bukkit.getPluginManager().registerEvents(BackListener, this);
            Bukkit.getPluginManager().registerEvents(new CommandDelay(), this);
            Plugin protocolLib=Bukkit.getPluginManager().getPlugin("ProtocolLib");
        }
        public void onDisable () {
            saveConfig();
        }
    }


