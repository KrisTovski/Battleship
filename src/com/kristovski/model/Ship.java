package com.kristovski.model;

public class Ship {

    private int size;
    private boolean isHorizontal;
    private boolean isDestroyed;

    public Ship(int size, boolean isHorizontal, boolean isDestroyed) {
        this.size = size;
        this.isHorizontal = isHorizontal;
        this.isDestroyed = isDestroyed;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isHorizontal() {
        return isHorizontal;
    }

    public void setHorizontal(boolean horizontal) {
        isHorizontal = horizontal;
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }

    public void setDestroyed(boolean destroyed) {
        isDestroyed = destroyed;
    }
}
