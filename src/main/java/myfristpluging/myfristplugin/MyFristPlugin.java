package myfristpluging.myfristplugin;

import myfristpluging.myfristplugin.command.*;
import myfristpluging.myfristplugin.events.clickevents;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import static org.bukkit.Bukkit.getServer;


public final class MyFristPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("firstPlugin插件已啟動");
        getServer().getPluginManager().registerEvents(this,this);
        getServer().getPluginManager().registerEvents(new freezeCommand(),this);
        getServer().getPluginManager().registerEvents(new spawnCommand(this),this);
        getCommand("die").setExecutor(new dieCommand());
        getCommand("god").setExecutor(new godCommand());
        getCommand("feed").setExecutor(new feedCommand());
        getCommand("healing").setExecutor(new healingCommand());
        getCommand("freeze").setExecutor(new freezeCommand());
        getCommand("freezeList").setExecutor(new freezeCommand());
        getCommand("setspawn").setExecutor(new spawnCommand(this));
        getCommand("spawn").setExecutor(new spawnCommand(this));
        getCommand("flylist").setExecutor(new flycommand());
        getCommand("fly").setExecutor(new flycommand());
        getCommand("menu").setExecutor(new menuCommand());
        getServer().getPluginManager().registerEvents(new clickevents(),this);

        getConfig().options().copyDefaults();
        saveDefaultConfig();


    }

    @Override
    public void onDisable() {


        // Plugin shutdown logic
        System.out.println("firstPlugin插件已關閉");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent other){

        Player player = other.getPlayer();

        if(!(player.hasPlayedBefore())){
            Location location = getConfig().getLocation("spawn");
            if(location != null){
                other.getPlayer().teleport(location);
                other.setJoinMessage("§d"+player.getDisplayName()+ "§3第一次加入伺服器,歡迎他！！");
            }



        }else {
            other.setJoinMessage("§d"+player.getDisplayName()+ "§3歡迎加入伺服器");
        }

    }
    @EventHandler
    public void onLeave(PlayerQuitEvent other){
        Player players = other.getPlayer();
        other.setQuitMessage(players.getDisplayName()+"§3離開了伺服器 不優秀");
    }



}
