package zishu.xiatools;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import zishu.xiatools.Commands.*;
import zishu.xiatools.Commands.Home.HomeCommand;
import zishu.xiatools.Commands.Home.SetHomeCommand;
import zishu.xiatools.Listener.*;

import java.util.HashMap;
import java.util.Map;

public class XIATools extends JavaPlugin implements Listener {
    private static XIATools ins;
    public static XIATools getIns() {
        return ins;
    }

        public BackListener BackListener=new BackListener();
        public static String prefix = "§7[§bXIA§3Tools§7]";
        public static String noPermission = "§你没有使用该命令的权限";


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
            Bukkit.getPluginManager().registerEvents(new AtListener(), this);
            Bukkit.getPluginManager().registerEvents(new DropClearListener(), this);
            Bukkit.getPluginManager().registerEvents(BackListener, this);
            Bukkit.getPluginManager().registerEvents(new CommandDelay(), this);
        }
        public void onDisable () {
            saveConfig();
        }
    }


