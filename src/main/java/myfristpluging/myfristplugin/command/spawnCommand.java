package myfristpluging.myfristplugin.command;

import myfristpluging.myfristplugin.MyFristPlugin;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;


public class spawnCommand implements CommandExecutor, Listener {




    private final MyFristPlugin plugin;

    public spawnCommand(MyFristPlugin plugin) {
        this.plugin = plugin;
    }



    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {


            Player p = (Player) sender;
            if (command.getName().equalsIgnoreCase("spawn")) {
                if (!(sender.hasPermission("commands.spawn"))) {
                    p.sendMessage("§4你沒有此指令權限(commands.spawn)");
                    return true;

                }
                Location location = plugin.getConfig().getLocation("spawn");
                if (location != null) {
                    p.teleport(location);
                    p.sendMessage("§a傳送至重生點");
                    return true;

                }
                p.sendMessage("§4伺服器目前沒有設置重生點，請使用/setspawn");
                return true;
            }


            if (command.getName().equalsIgnoreCase("setspawn")) {
                if (!(sender.hasPermission("commands.setspawn"))) {
                    p.sendMessage("§4你沒有此指令權限(commands.setspawn)");
                    return true;
                }

                Location location = p.getLocation();

                plugin.getConfig().set("spawn", location);
                plugin.saveConfig();

                p.sendMessage("§a已成功設置伺服器出生點");
                return true;
            }
        }


        return false;
    }


}
