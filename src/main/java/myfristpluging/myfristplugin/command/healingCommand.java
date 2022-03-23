package myfristpluging.myfristplugin.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class healingCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

            Player p = (Player) sender;
            if (!(p.hasPermission("commands.healing"))) {
                p.sendMessage("§4你沒有此指令權限(commands.healing)");
                return true;
            }


            if (args.length == 0) {
                p.setHealth(20);
                p.sendMessage("§d你已治癒");
                return true;

            } else if (args.length == 1) {
                Player tagPlayer = Bukkit.getPlayerExact(args[0]);
                if (tagPlayer instanceof Player) {
                    tagPlayer.setHealth(20);
                    p.sendMessage("§d已將" + tagPlayer.getName().toString() + "§d治癒");
                    tagPlayer.sendMessage(p.getName().toString() + "§d將你治癒");
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
