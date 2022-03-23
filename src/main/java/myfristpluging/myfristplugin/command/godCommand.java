package myfristpluging.myfristplugin.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class godCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


            Player p = ((Player) sender).getPlayer();
            if(!(p.hasPermission("commands.god"))){
                p.sendMessage("§4你沒有此指令權限(commands.god)");
                return true;
            }
            if(args.length == 0){
                if (p.isInvulnerable()) {
                    p.setInvulnerable(false);
                    p.sendMessage("§c你已變回一般人");
                    return true;

                } else {
                    p.setInvulnerable(true);
                    p.sendMessage("§6你已成為神!");
                    return true;
                }

            }else if(args.length == 1){
                Player tagPlayer  = Bukkit.getPlayerExact(args[0].toString());
                if(tagPlayer instanceof Player){
                    if (tagPlayer.isInvulnerable()) {
                        p.sendMessage("§c已更改玩家為一般人");
                        tagPlayer.setInvulnerable(false);
                        p.sendMessage("§c你已變回一般人");
                        return true;

                    } else {
                        p.sendMessage("§c已更改玩家為神");
                        p.setInvulnerable(true);
                        p.sendMessage("§6你已成為神!");
                        return true;
                    }

                }else {
                    p.sendMessage("§4此玩家不存在");
                    return false;
                }


            }else{
                return false;
            }





    }
}
