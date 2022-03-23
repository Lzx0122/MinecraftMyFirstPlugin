package myfristpluging.myfristplugin.command;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;

public class freezeCommand implements CommandExecutor, Listener {

    public static final ArrayList<String> FreezePlayerList = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        Player p = (Player) sender;

        if (!(sender.hasPermission("commands.freeze"))) {

            sender.sendMessage("§4你沒有此指令權限(commands.freeze)");
            return true;
        }
        if (command.getName().equalsIgnoreCase("freezeList")) {
            if (!(sender.hasPermission("commands.freezelist"))) {

                sender.sendMessage("§4你沒有此指令權限(commands.freezelist)");
                return true;
            }
            if (FreezePlayerList.size() != 0) {
                sender.sendMessage("§b冷凍名單：" + "§f" + StringUtils.join(FreezePlayerList, ",") + "§b。");
                return true;
            }
            sender.sendMessage("§b冷凍名單為空");
            return true;

        }
        ;
        if (args.length == 1) {
            Player tagPlayer = Bukkit.getPlayerExact(args[0]);
            if (tagPlayer instanceof Player) {
                if (FreezePlayerList.contains(tagPlayer.getName().toString())) {
                    FreezePlayerList.remove(tagPlayer.getName().toString());
                    if (FreezePlayerList.contains(tagPlayer.getName().toString())) {
                        while (true) {
                            if (FreezePlayerList.contains(tagPlayer.getName().toString())) {
                                FreezePlayerList.remove(tagPlayer.getName().toString());
                            } else {
                                break;
                            }

                        }

                    }
                    p.sendMessage(tagPlayer.getName().toString() + "§b玩家已解凍");
                    tagPlayer.sendMessage("§b你已被解凍");
                    return true;
                } else {
                    FreezePlayerList.add(tagPlayer.getName().toString());
                    p.sendMessage(tagPlayer.getName().toString() + "§b玩家已冰凍");
                    tagPlayer.sendMessage("§b你已被冰凍");
                    return true;

                }

            } else {
                p.sendMessage("§4此玩家不存在");
                return true;

            }

        }
            return false;



    }

    @EventHandler
    void onPlayerMove(PlayerMoveEvent other) {


        Player p = other.getPlayer();

        if (FreezePlayerList.contains(p.getName().toString())) {

            other.setCancelled(true);
        }

    }

    @EventHandler
    public void onLeave(PlayerQuitEvent other) {
        Player p = other.getPlayer();
        if (FreezePlayerList.contains(p.getName().toString())) {
            FreezePlayerList.add(p.getName().toString());
        }
    }

    @EventHandler
    public void BlockDamage(BlockDamageEvent other) {
        Player p = other.getPlayer();
        if (FreezePlayerList.contains(p.getName().toString())) {

            other.setCancelled(true);
        }

    }
    //查看freeze 中的玩家清單


}
