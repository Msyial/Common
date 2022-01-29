package zishu.xiatools;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class XIATools extends JavaPlugin {

    public static String prefix = "§7[§bXIA&3Tools§7]";
    public static String noPermission = "§你没有使用该命令的权限";


    @Override
    public void onEnable(){
        getLogger().info("已加载");
        FileConfiguration config = getConfig();
    }
}
