package myfristpluging.myfristplugin.utils;

import myfristpluging.myfristplugin.MyFristPlugin;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import  java.util.List;


public class Vaultutils {

    public static void storeItem(List<ItemStack> item, Player p){
        PersistentDataContainer data = p.getPersistentDataContainer();

        if(item.size() == 0){
            data.set(new NamespacedKey(MyFristPlugin.getPlugin(),"vault"), PersistentDataType.STRING,"");
        }else{

            try{
                ByteArrayOutputStream io = new ByteArrayOutputStream();
                BukkitObjectOutputStream os = new BukkitObjectOutputStream(io);
                os.writeInt(item.size());

                for(int i=0 ; i < item.size();i++){
                    os.writeObject(item.get(i));
                }

                os.flush();

                byte[] rawData = io.toByteArray();
                String encodeData = Base64.getEncoder().encodeToString(rawData);
                data.set(new NamespacedKey(MyFristPlugin.getPlugin(),"vault"), PersistentDataType.STRING,encodeData);
                os.close();

            }catch(IOException ex){
                System.out.println(ex);

            }


        }


    }

    public static ArrayList<ItemStack> getItem(Player p){
        PersistentDataContainer data = p.getPersistentDataContainer();
        ArrayList<ItemStack> item = new ArrayList<>();

        String encodeItem =  data.get(new NamespacedKey(MyFristPlugin.getPlugin(),"valut"),PersistentDataType.STRING);

        if(!encodeItem.isEmpty()){
            byte[] rawData = Base64.getDecoder().decode(encodeItem);
            try{
                ByteArrayInputStream io =  new ByteArrayInputStream(rawData);
                BukkitObjectInputStream inpu = new BukkitObjectInputStream(io);

                int itemCount = inpu.readInt();;
                for(int i = 0 ; i<itemCount ;i++){
                    item.add((ItemStack) inpu.readObject());
                }

                inpu.close();


            }catch (IOException ex){
                System.out.println(ex);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }




        }
        return item;

    }
}
