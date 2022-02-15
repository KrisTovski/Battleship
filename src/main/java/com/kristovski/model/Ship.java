package com.kristovski.model;


public class Ship {

    private int size;
    private Point startPoint;
    private boolean isHorizontal;
    private boolean isDestroyed;

    public Ship(int size, Point startPoint, boolean isHorizontal, boolean isDestroyed) {
        this.size = size;
        this.startPoint = startPoint;
        this.isHorizontal = isHorizontal;
        this.isDestroyed = isDestroyed;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
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

    @Override
    public String toString() {
        return "Ship{" +
                "size=" + size +
                ", startPoint=" + startPoint +
                ", isHorizontal=" + isHorizontal +
                ", isDestroyed=" + isDestroyed +
                '}';
    }
}
