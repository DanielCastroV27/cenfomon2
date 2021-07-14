package com.cenfo.cenfomon.deskModule.desktop.Entidades;


public class Camara {
    private float camaraX=0f;
    private float camaraY=0f;

    public void Actualizar(float newCamX,float newCamY){
        this.camaraY=newCamY;
        this.camaraX=newCamX;
    }

    public float getCamaraX() {
        return camaraX;
    }

    public float getCamaraY() {
        return camaraY;
    }
}
