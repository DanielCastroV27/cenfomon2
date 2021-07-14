package com.cenfo.cenfomon.deskModule.desktop.utilities;


import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.cenfo.cenfomon.deskModule.desktop.Entidades.DIRECCION;


import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;


public class AnimationSet {
    private Map<DIRECCION,Animation>walking;
    private Map<DIRECCION,TextureRegion> standing;

    public AnimationSet(Animation walkNorth,
                        Animation walkSouth,
                        Animation walkEast,
                        Animation walkWest,
                        TextureRegion standNorth,
                        TextureRegion standSouth,
                        TextureRegion standEast,
                        TextureRegion standWest ) {
        walking = new HashMap<DIRECCION, Animation>();
        walking.put(DIRECCION.NORTE, walkNorth);
        walking.put(DIRECCION.SUR, walkSouth);
        walking.put(DIRECCION.ESTE, walkEast);
        walking.put(DIRECCION.OESTE, walkWest);
        standing = new Hashtable<DIRECCION, TextureRegion>();
        standing.put(DIRECCION.NORTE, standNorth);
        standing.put(DIRECCION.SUR, standSouth);
        standing.put(DIRECCION.ESTE, standEast);
        standing.put(DIRECCION.OESTE, standWest);
    }



    public Animation getWalking(DIRECCION dir){
        return walking.get(dir);

    }
    public TextureRegion getStanding(DIRECCION dir){
        return standing.get(dir);

    }


}
