package myfristpluging.myfristplugin.command;

import myfristpluging.myfristplugin.MyFristPlugin;
import myfristpluging.myfristplugin.events.clickevents;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import static org.bukkit.Bukkit.getServer;

public class menuCommand implements CommandExecutor,Listener{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if(sender instanceof Player){
            Player p = (Player) sender;
            Inventory menu = Bukkit.createInventory(p,9,"§6MENU");
            ItemStack spawn = new ItemStack(Material.BEACON);

            ItemMeta spawn_meta = spawn.getItemMeta();
            spawn_meta.setDisplayName("§bSpawn");
            spawn.setItemMeta(spawn_meta);
            ItemStack[] menu_item = {null,spawn};
            menu.setContents(menu_item);
            p.openInventory(menu);

            return true;


        }


        return false;
    }

}

