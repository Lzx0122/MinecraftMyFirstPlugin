package myfristpluging.myfristplugin.events;


import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.*;

public class clickevents implements Listener {
    @EventHandler
    public void Clickevent(InventoryClickEvent other){
        Player p = (Player) other.getWhoClicked();
        if(other.getView().getTitle().equalsIgnoreCase("§6MENU")){
            other.setCancelled(true);
            if(other.getCurrentItem().getType().equals(Material.BEACON)){
                p.performCommand("spawn");
            }
        };




    };

}
