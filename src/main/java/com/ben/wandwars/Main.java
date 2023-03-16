package com.ben.wandwars;

import com.ben.wandwars.commands.DiscordCommand;
import com.ben.wandwars.commands.WandCommand;
import com.ben.wandwars.commands.wandsCommand.WandsCommand;
import com.ben.wandwars.commands.wandsCommand.WandsInventoryListener;
import com.ben.wandwars.spell.managers.SpellManager;
import com.ben.wandwars.stateManagers.ManaManager;
import com.ben.wandwars.stateManagers.PlayerBarsManager;
import com.ben.wandwars.wands.listeners.ShiftManager;
import com.ben.wandwars.wands.listeners.WandListener;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

/*
todo:
    finish the cooldown manager callback system
    add the death message logic


needed classes:

    todo:
    wands
    finish the stats screen
    redo part of the moving particle list interface



    todo:
        shift dash detection
        double jump detection
        shift click ground detection
        shift click air detection
        shift right click ground detection
        shift right click air detection
        drop detection
        left click detection
        right click detection


        FILE PATH: C:\Users\jobar\IdeaProjects\Wand Wars
 */
public final class Main extends JavaPlugin {

    private static Main instance;


    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;

        Bukkit.getPluginManager().registerEvents(ManaManager.getInstance(), this);
        Bukkit.getPluginManager().registerEvents(DeathMessageHandling.getInstance(), this);
        Bukkit.getPluginManager().registerEvents(new MiscListener(), this);
        Bukkit.getPluginManager().registerEvents(new WandsInventoryListener(), this);
        Bukkit.getPluginManager().registerEvents(ShiftManager.getInstance(), this);
        Bukkit.getPluginManager().registerEvents(new WandListener(), this);

        getCommand("wand").setExecutor(new WandCommand());
        getCommand("wands").setExecutor(new WandsCommand());
        getCommand("discord").setExecutor(new DiscordCommand());

        DelayedMessages delayedMessages = new DelayedMessages(60 * 5 * 20);
        delayedMessages.start();

        SpellManager.getInstance().initialize();
        PlayerBarsManager.initialize();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

    }

    public static boolean isTransparent(Material material) {
        List<Material> transparentBlocks = new ArrayList<>();
        transparentBlocks.add(Material.CAVE_AIR);
        transparentBlocks.add(Material.AIR);
        transparentBlocks.add(Material.WATER);
        transparentBlocks.add(Material.VINE);
        transparentBlocks.add(Material.CAVE_VINES);
        transparentBlocks.add(Material.CAVE_VINES_PLANT);
        transparentBlocks.add(Material.TALL_GRASS);
        transparentBlocks.add(Material.TALL_SEAGRASS);
        transparentBlocks.add(Material.DEAD_BUSH);
        transparentBlocks.add(Material.ROSE_BUSH);
        transparentBlocks.add(Material.SWEET_BERRY_BUSH);
        transparentBlocks.add(Material.GRASS);
        transparentBlocks.add(Material.LARGE_FERN);
        transparentBlocks.add(Material.DANDELION);
        transparentBlocks.add(Material.POPPY);
        transparentBlocks.add(Material.SEAGRASS);
        transparentBlocks.add(Material.LADDER);

        return transparentBlocks.contains(material);
    }

    public static Main getInstance() {return instance;}

}
