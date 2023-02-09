package com.ben.wandwars.game.maps;

import com.ben.wandwars.game.GameType;
import com.ben.wandwars.game.util.LocationUtil;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;


import java.util.List;

public class MapTemplate {

    private List<Location> redSpawns;
    private List<Location> blueSpawns;
    private Location cornerLocation;
    private GameType gameType;
    private int id;

    public MapTemplate(List<Location> redSpawns, List<Location> blueSpawns, Location location, GameType gameType, int id) {
        this.redSpawns = redSpawns;
        this.blueSpawns = blueSpawns;
        this.id = id;
        this.gameType = gameType;

        cornerLocation = LocationUtil.convertToMapLoc(location);
    }

    public Block getBlock(int xOffset, int yOffset, int zOffset) {
        return cornerLocation.add(xOffset, yOffset, zOffset).getBlock();
    }

    public List<Location> getRedSpawns() {
        return redSpawns;
    }

    public List<Location> getBlueSpawns() {
        return blueSpawns;
    }

    public Location getCornerLocation() {return cornerLocation;}
    public int getId() {return id;}
    public GameType getGameType() {return gameType;}
}
