package ru.mmo.database.hibernatetypes.vector;

import java.io.Serializable;

public class Vector implements Serializable {

    public double x = 0;
    public double y = 0;
    public double z = 0;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector(double x) {
        this.x = x;
    }

    public Vector(Vector vector){
        x = vector.x;
        y = vector.y;
        z = vector.z;
    }

    public Vector() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        Double hc = this.x;
        hash = 31 * hash + hc.hashCode();
        hc = this.y;
        hash = 31 * hash + hc.hashCode();
        hc = this.z;
        hash = 31 * hash + hc.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Vector)) {
            return false;
        }
        Vector v = (Vector) obj;
        return this.x == v.x && this.y == v.y && this.z == v.z;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}