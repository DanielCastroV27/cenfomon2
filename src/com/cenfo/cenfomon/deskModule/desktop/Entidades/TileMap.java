package com.cenfo.cenfomon.deskModule.desktop.Entidades;

import java.lang.Math;
public class TileMap {
    private Tile[][] tiles;
    private int width,height;


    public TileMap(int width, int height){
        this.width=width;
        this.height=height;
        tiles=new Tile[width][height];
        for(int x=0;x<width;x++){
            for(int y=0;y<height;y++){
                if(Math.random()>0.5d){
                    tiles[x][y]=new Tile(TERRENO.GRASS_1);
                }else{
                    tiles[x][y]=new Tile(TERRENO.GRASS_2);
                }

            }

        }
    }
    public Tile getTile(int x, int y){
        return tiles[x][y];
    }
    public int getWidth(){
        return  width;
    }
    public int getHeight(){
        return height;
    }
}