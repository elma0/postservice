package model;

import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;

public class Parallelepiped implements Edges, MainDiagonals {
    private final Vector3D a;
    private final Vector3D b;
    private final Vector3D c;

    public Parallelepiped(Vector3D a, Vector3D b, Vector3D c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double[] edges() {
        return new double[]{a.getNorm(), b.getNorm(), c.getNorm()};
    }

    public double[] diags() {
        return new double[]{a.add(b).add(c).getNorm(), a.add(b.negate()).add(c).getNorm()};
    }

    @Override
    public String toString() {
        return "Parallelepiped{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
