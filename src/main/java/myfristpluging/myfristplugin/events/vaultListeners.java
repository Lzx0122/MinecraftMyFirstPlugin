package myfristpluging.myfristplugin.events;

import myfristpluging.myfristplugin.MyFristPlugin;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class vaultListeners implements Listener {
    @EventHandler
    public void PlayerJoinServer(PlayerJoinEvent other){

        Player p = other.getPlayer();
        PersistentDataContainer data = p.getPersistentDataContainer();
        if(!data.has(new NamespacedKey(MyFristPlugin.getPlugin(),"vault"),PersistentDataType.STRING)){
            data.set(new NamespacedKey(MyFristPlugin.getPlugin(),"vault"),PersistentDataType.STRING,"");

        }


    }
}
