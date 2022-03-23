package myfristpluging.myfristplugin.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class feedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

            Player p = (Player) sender;
            if (!(p.hasPermission("commands.feed"))){
                p.sendMessage("§4你沒有此指令權限(commands.feed)");
                return true;
            }
            if(args.length == 0){
                p.setFoodLevel(20);
                p.sendMessage("§4你已填飽肚子");
                return true;
            }else if(args.length ==1){
                Player tagPlayer = Bukkit.getPlayerExact(args[0].toString());
                if(tagPlayer instanceof Player){
                    tagPlayer.setFoodLevel(20);
                    sender.sendMessage("§4已成功餵食" + args[0]);
                    tagPlayer.sendMessage(sender.getName().toString()+ "§4已餵食你");
                    return true;


                }else{
                    p.sendMessage("§4此玩家不存在");
                    return true;
                }
            }else{
                return false;
            }





    }
}
