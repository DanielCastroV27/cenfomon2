package com.cenfo.cenfomon.deskModule.desktop.Entidades;

public enum DIRECCION {

    NORTE(0,1),
    ESTE(1,0),
    OESTE(-1,0),
    SUR(0,-1),;

    private int dx,dy;

    DIRECCION(int dx ,int dy) {
        this.dx=dx;
        this.dy=dy;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }
}

