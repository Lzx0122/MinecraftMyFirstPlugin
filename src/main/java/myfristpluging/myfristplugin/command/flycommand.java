package myfristpluging.myfristplugin.command;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class flycommand implements CommandExecutor{

    public static final  ArrayList<String> flylist= new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;

        if(!sender.hasPermission("commands.fly")){
            p.sendMessage("§4你沒有此指令權限(commands.fly)");
            return true;
        }
        if(!command.getName().equalsIgnoreCase("flylist")){
            if(flylist.size() == 0){
                sender.sendMessage("§b飛行中名單為空。");
                return true;

            }
            sender.sendMessage("§b飛行中名單：" + "§f" + StringUtils.join(flylist, ",") + "§b。");
            return true;

        }
        if(args.length == 0){
            if(flylist.contains(p.getName().toString())){

                while (true) {
                    if (flylist.contains(p.getName().toString())) {
                        flylist.remove(p.getName().toString());
                    } else {
                        break;
                    }

                }
                p.setAllowFlight(false);
                p.sendMessage("§b飛行模式關閉");
                return true;

            }
            flylist.add(p.getName().toString());
            p.setAllowFlight(true);
            p.sendMessage("§b飛行模式開啟");
            return true;
        }
        if(args.length == 1){
            Player tagPlayer =  Bukkit.getPlayerExact(args[0]);


            if(flylist.contains(tagPlayer.getName().toString())){

                while (true) {
                    if (flylist.contains(tagPlayer.getName().toString())) {
                        flylist.remove(tagPlayer.getName().toString());
                    } else {
                        break;
                    }

                }
                tagPlayer.setAllowFlight(false);
                tagPlayer.sendMessage("§b飛行模式關閉");
                return true;

            }
            flylist.add(tagPlayer.getName().toString());
            tagPlayer.setAllowFlight(true);
            tagPlayer.sendMessage("§b飛行模式開啟");
            return true;
        }



        return false;
    }
}
