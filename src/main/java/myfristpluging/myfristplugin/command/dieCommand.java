package myfristpluging.myfristplugin.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.serialization.DelegateDeserialization;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class dieCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        System.out.println(sender);


        Player p = (Player) sender;
        if (!(p.hasPermission("commands.die"))) {
            p.sendMessage("§4你沒有此指令權限(commands.die)");
            return true;
        }
        if (args.length == 0) {
            p.setHealth(0.0);
            p.sendMessage("§c你媽死了");
            return true;
        } else if (args.length == 1) {
            Player tagPlayer = Bukkit.getPlayerExact(args[0]);

            if (tagPlayer instanceof Player) {
                p.sendMessage("§c你殺死了" + args[0]);
                tagPlayer.setHealth(0.0);
                tagPlayer.sendMessage(sender.getName().toString() + "§c將你殺死");
                return true;
            } else {
                p.sendMessage("§4此玩家不存在");
                return true;
            }
        } else {
            return false;
        }



    }
}
